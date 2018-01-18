package com.buddhadata.sandbox.neo4j.tfl.tube;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.Stop;
import com.buddhadata.sandbox.neo4j.tfl.tube.relationship.Route;
import com.buddhadata.sandbox.neo4j.tfl.tube.relationship.Segment;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.api.LineApi;
import uk.gov.tfl.api.client.client.model.*;

import java.lang.Object;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by scsosna on 1/5/18.
 */
public class Tube1 {

    /**
     * Implementation for making line API calls.
     */
    final private LineApi apiLine;

    /**
     * Cache of valid modes of transport.
     */
    private Map<String,Mode> modes = null;

    /**
     * Session factory for connecting to Neo4j database
     */
    private final SessionFactory sessionFactory;

    //  Configuration info for connecting to the Neo4J database
    static private final String SERVER_URI = "bolt://localhost";
    static private final String SERVER_USERNAME = "neo4j";
    static private final String SERVER_PASSWORD = "password";

    //  Distance query information
    static private final String DISTANCE_QUERY = "WITH POINT ({latitude:$lat_a,longitude:$lon_a}) AS a, POINT ({latitude:$lat_b,longitude:$lon_b}) AS b RETURN distance(a, b)";
    static private final String DISTANCE_PARAM_LATITUDE_A = "lat_a";
    static private final String DISTANCE_PARAM_LATITUDE_B = "lat_b";
    static private final String DISTANCE_PARAM_LONGITUDE_A = "lon_a";
    static private final String DISTANCE_PARAM_LONGITUDE_B = "lon_b";

    //  Segment query information
    static private final String SEGMENT_QUERY = "match (a {stopId:$orig_stop'}) - [r:Segment {direction:$direction] -> (b {stopId:$dest_stop}) RETURN r";
    static private final String SEGMENT_PARAM_DESTINATION_STOP = "dest_stop";
    static private final String SEGMENT_PARAM_DIRECTION = "direction";
    static private final String SEGMENT_PARAM_ORIGINATION_STOP = "orig_stop";



    //  For the routes, only get regular services, ignore night.
    static private final List<String> SERVICE_TYPE_REGULAR = Collections.singletonList("Regular");


    /**
     * Constructor
     */
    public Tube1 () {
        //  Define session factory for connecting to Neo4j database
        Configuration configuration = new Configuration.Builder().uri(SERVER_URI).credentials(SERVER_USERNAME, SERVER_PASSWORD).build();
        sessionFactory = new SessionFactory(configuration, "com.buddhadata.sandbox.neo4j.tfl.tube.node", "com.buddhadata.sandbox.neo4j.tfl.tube.relationship");

        apiLine = new LineApi();
    }

    /**
     * Do the actual work
     */
    private void process (String mode) {

        Transaction txn = null;
        try {
            //  When creating a session, always clean up the database by purging the database.
            Session session = sessionFactory.openSession();
            session.purgeDatabase();
            txn = session.beginTransaction();

            //  Make sure the mode supplied is valid.
            if (isModeValid(mode, null)) {

                //  Build route segments for all lines of the specified mode.
                getLinesByMode(mode).forEach (line -> {
                    System.out.println ("Building route segments for " + line.getId());
                    buildSegment(line.getId(), Direction.Inbound, session);
                    buildSegment(line.getId(), Direction.Outbound, session);
                });

                //  Now build the routes, using call that retrieves all routes by mode.
                buildRoute(mode, session);


                txn.commit();
                txn = null;
            } else {
                System.out.println ("Invalid mode specified.");
            }
        } finally {
            if (txn != null) {
                txn.rollback();
            }
        }
    }

    /**
     * Identify the routes on a line by identifying the origination and destination of each route.
     * @param mode the transit mode for which we're retrieving/building routes
     * @param session Neo4J database session
     * @return flag indicating success/failure creating the routes
     */
    private boolean buildRoute (String mode,
                                Session session) {

        try {
            // Retrieve the line routes for the line provided
            List<Line> lines = apiLine.lineRouteByMode(Collections.singletonList(mode), SERVICE_TYPE_REGULAR);

            //  Process the lines and create routes for each section.
            Set<Route> cache = new HashSet<>(20);
            lines.forEach (line -> {
                cache.clear();
                line.getRouteSections().forEach (section -> {
                    // The origination and destination stop should already exist, so just retrieve from Neo4j
                    Stop origin = findStopNode(session, section.getOriginator());
                    Stop destination = findStopNode(session, section.getDestination());

                    //   Now create a route relationship between the two.
                    Route route = new Route(line.getId(), section.getName(), origin, destination, Direction.getByCode(section.getDirection()),
                            calcDistanceBetweenStops(session, origin, destination));

                    //  Have we seen this exact route before?
                    if (!cache.contains(route)) {
                        // New route, so save to the database and place in cache.
                        session.save(route);
                        cache.add(route);
                    }
                });
            });
        } catch (ApiException e) {
            System.out.println ("Exception occurred getting route sequence: " + e);
        }


        return true;
    }

    /**
     * Query the line for the given direction and build the object map
     * @param lineId the line's ID which is really the name in lower-case
     * @param direction inbound or outbound
     * @param session Neo4J database session
     * @return flag indicating success/failure in building the map
     */
    private boolean buildSegment(String lineId,
                                 Direction direction,
                                 Session session) {

        try {
            //  Get the stops on the route.
            RouteSequence route  = apiLine.lineRouteSequence(lineId, direction.getCode(), null, false);

            route.getStopPointSequences().forEach (sequence -> {

                final AtomicReference<Stop> start = new AtomicReference<>();
                sequence.getStopPoint().forEach (stop -> {

                    //  The node is always the end of the segment, either find an existing or create a new one
                    Stop end = findOrCreateStopNode(session, stop);
                    end.getLines().add(lineId);

                    //  Needs to be a start node to work with, but the first stop in the sequence of stop points,
                    //  there isn't, so just mark it as the starting point for the next time through, when a
                    //  segment can be created.
                    Stop startNode = start.get();
                    if (startNode == null) {
                        start.set(end);
                    } else {
                        Segment segment = findOrCreateSegment(session, start.get(), end, direction);
                        start.set(end);
                    }
                });
            });
        } catch (ApiException e) {
            System.out.println ("Exception occurred getting route sequence: " + e);
        }


        return true;
    }
    /**
     * Get the lines for a given mode.
     * @param modeName mode name of interest
     * @return list of lines or null if an exception occurred
     */
    private Collection<Line> getLinesByMode (String modeName) {
        try {
            //  Return all lines for the specified transport mode.
            return apiLine.lineGetByMode(Collections.singletonList(modeName));
        } catch (ApiException e) {
            System.out.println ("getLinesByMode Exception: " + e);
            return null;
        }
    }

    /**
     * Return the cache of valid TfL modes or fetch them.  If the TfL API call fails, an empty map is returned.
     * @return map of 0 or more caches.
     */
    private Map<String,Mode> getModes() {

        if (modes == null || modes.isEmpty()) {
            synchronized (this) {
                if (modes == null || modes.isEmpty()) {
                    modes = new HashMap<>();
                    try {
                        apiLine.lineMetaModes().forEach (mode -> modes.put(mode.getModeName(), mode));
                    } catch (ApiException e) {
                        System.out.println ("getModes Exception: " + e);
                    }
                }
            }
        }


        return modes;
    }

    /**
     * Determine if the mode provided by name is valid
     * @param modeName name of the mode
     * @param template characteristics of the mode to make sure it's defined as needed/expected
     * @return
     */
    private boolean isModeValid (String modeName,
                                 Mode template) {

        //  Does the key exist?
        boolean toReturn = getModes().containsKey(modeName);

        //  If the key was found and there's a template, filter by the template.
        if (toReturn && template != null) {
            Mode mode = getModes().get(modeName);
            if (!mode.isIsFarePaying().equals(template.isIsFarePaying()) ||
                !mode.isIsScheduledService().equals(template.isIsScheduledService()) ||
                !mode.isIsTflService().equals(template.isIsTflService())) {
                toReturn = false;
            }
        }


        return toReturn;
    }

    /**
     * Given the constituent parts of the segment, search the database for a corresponding relationship; if
     * not found, create a new one
     * @param session Neo4J database session
     * @param start the starting stop (node) for the segment
     * @param end the ending stop (node) for the segment
     * @param direction which direction is the segment
     * @return a Neo4J segment relationship
     */
    private Segment findOrCreateSegment(Session session,
                                        Stop start,
                                        Stop end,
                                        Direction direction) {

        Segment toReturn = null;

        //  Need to create map to hold parameters.
        Map<String,Object> params = new HashMap<>(3);
        params.put (SEGMENT_PARAM_ORIGINATION_STOP, start.getStopId());
        params.put (SEGMENT_PARAM_DESTINATION_STOP, end.getStopId());
        params.put (SEGMENT_PARAM_DIRECTION, direction);

        //  Execute query and hope for best.
//        toReturn = session.queryForObject (Segment.class, SEGMENT_QUERY, params);

        //  If no segment was found, create a new one.
        if (toReturn == null) {
            //  Nothing found, so a new relationship.
            toReturn = new Segment(start, end, direction, calcDistanceBetweenStops(session, start, end));
            session.save (toReturn);
        }


        return toReturn;
    }
/*


    Segment toReturn = null;

        //  Create a filter based on the nodes and direction.
        Filters composite = new Filters();
        Filter filter = new Filter ("m.stopId", ComparisonOperator.EQUALS, start.getStopId());
        composite.add(filter);
        filter = new Filter ("n.stopId", ComparisonOperator.EQUALS, end.getStopId());
        filter.setBooleanOperator(BooleanOperator.AND);
        composite.add(filter);
        filter = new Filter ("direction", ComparisonOperator.EQUALS, direction);
        filter.setBooleanOperator(BooleanOperator.AND);
        composite.add(filter);

        //  Query database and, hopefully, only find a single relationship.
        Collection<Segment> segments = session.loadAll (Segment.class, composite);
        if (segments != null && !segments.isEmpty()) {

            toReturn = segments.toArray(new Segment[segments.size()])[0];

        } else {

            //  Nothing found, so a new relationship.
            toReturn = new Segment(start, end, direction, calcDistanceBetweenStops(session, start, end));
            session.save (toReturn);
        }

        return toReturn;
    }

*/
    /**
     * Given a matched stop returned from the TfL API, search the database for a corresponding node; if not found,
     * create a new one
     * @param session Neo4J database session
     * @param stop the TfL stop
     * @return a Neo4J stop node
     */
    private Stop findOrCreateStopNode(Session session,
                                      MatchedStop stop) {

        //  First, attempt to find the stop in the database.
        Stop toReturn = findStopNode (session, stop.getId());

        //  Did we find anything?
        if (toReturn == null) {

            //  Stop doesn't exist, so create.
            toReturn = new Stop (stop.getId(), stop.getName(), stop.getZone(), stop.getLon(), stop.getLat());
            session.save(toReturn);
        }


        return toReturn;
    }

    /**
     * Attempt to retrieve a stop from Neo4j using the stop id.
     * @param session Neo4J database session
     * @return a Neo4J stop node if found, otherwise null.
     */
    private Stop findStopNode(Session session,
                              String stopId) {

        Stop toReturn = null;

        //  Create a filter based on the stop ID and attempt to from the database
        Filter filter = new Filter("stopId", ComparisonOperator.EQUALS, stopId);
        Collection<Stop> stops = session.loadAll(Stop.class, filter);
        if (stops != null && !stops.isEmpty()) {

            //  At least one stop was found, should only be one, so return it.
            Stop[] array = stops.toArray(new Stop[stops.size()]);
            toReturn = array[0];
        }


        return toReturn;
    }
    /**
     * Calculate the distance in meters between two stops.
     * @param session Neo4J database session
     * @param stopA stop being for which distance being measured
     * @param stopB other stop for which distance is being measured
     * @return meters between the two stops
     */
    private double calcDistanceBetweenStops (Session session,
                                             Stop stopA,
                                             Stop stopB) {
        return calcDistance (session, stopA.getLatitude(), stopA.getLongitude(), stopB.getLatitude(), stopB.getLongitude());

    }

    /**
     * Calculate the distance in meters between two points, using the built-in Neo4J distance function
     * @param session Neo4J database session
     * @param latitudePointA WGS84 latitude for point A
     * @param longitudePointA WGS84 longitude for point A
     * @param latitudePointB WGS84 latitude for point B
     * @param longitudePointB WGS84 longitude for point B
     * @return meters between the two points
     */
    private double calcDistance(Session session,
                                double latitudePointA,
                                double longitudePointA,
                                double latitudePointB,
                                double longitudePointB) {

        //  Need to create map to hold parameters.
        Map<String,Object> params = new HashMap<>(4);
        params.put (DISTANCE_PARAM_LATITUDE_A, latitudePointA);
        params.put (DISTANCE_PARAM_LONGITUDE_A, longitudePointA);
        params.put (DISTANCE_PARAM_LATITUDE_B, latitudePointB);
        params.put (DISTANCE_PARAM_LONGITUDE_B, longitudePointB);

        //  Execute query and hope for best.
        return session.queryForObject (Double.class, DISTANCE_QUERY, params);
    }

    /**
     * Program main program
     * @param args
     */
    public static void main (String[] args) {

        if (args.length > 0) {
            new Tube1().process(args[0]);
        } else {
            System.out.print ("Mode required from command line.");
        }

    }
}
