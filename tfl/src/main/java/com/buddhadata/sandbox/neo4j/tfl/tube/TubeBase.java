/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.enums.RelationshipNodeType;
import com.buddhadata.sandbox.neo4j.tfl.tube.filter.RelationshipNodePropertyComparison;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.LineNode;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.StopNode;
import com.buddhadata.sandbox.neo4j.tfl.tube.relationship.Route;
import com.buddhadata.sandbox.neo4j.tfl.tube.relationship.Segment;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.cypher.BooleanOperator;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.model.*;

import java.lang.Object;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Loads stops, routes, transfers, and other interesting data downloaded from the TfL API.
 *
 * @author Scott C Sosna
 */
abstract public class TubeBase {

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

    //  Line node query
    static private final String LINE_QUERY = "MATCH (line:LineNode {name:$name}) RETURN line";
    static private final String LINE_PARAM_NAME = "name";

    //  Segment query information
    static private final String SEGMENT_QUERY = "MATCH (a:StopNode {stopId:$startStopId}) - [r:Segment {direction:$direction] -> (b {stopId:$endStopId}) RETURN r";
    static private final String SEGMENT_PARAM_DESTINATION_STOP = "endStopId";
    static private final String SEGMENT_PARAM_DIRECTION = "direction";
    static private final String SEGMENT_PARAM_ORIGINATION_STOP = "startStopId";



    //  For the routes, only get regular services, ignore night.
    static protected final List<String> SERVICE_TYPE_REGULAR = Collections.singletonList("Regular");


    /**
     * Constructor
     */
    public TubeBase() {
        //  Define session factory for connecting to Neo4j database
        Configuration configuration = new Configuration.Builder().uri(SERVER_URI).credentials(SERVER_USERNAME, SERVER_PASSWORD).build();
        sessionFactory = new SessionFactory(configuration, "com.buddhadata.sandbox.neo4j.tfl.tube.node", "com.buddhadata.sandbox.neo4j.tfl.tube.relationship");
    }

    /**
     * Do the actual work
     */
    protected void process (String mode) {

        Transaction txn = null;
        try {
            //  When creating a session, always clean up the database by purging the database.
            Session session = sessionFactory.openSession();
            session.purgeDatabase();
            txn = session.beginTransaction();


            //  Make sure the mode supplied is valid.
            if (isModeValid(mode, null)) {

                try {
                    //  Build route segments for all lines of the specified mode.
                    getLinesByMode(mode).forEach(line -> {
                        System.out.println("Building route segments for " + line.getId());
                        buildSegment(line.getId(), Direction.Inbound, session);
//                    buildSegment(line.getId(), Direction.Outbound, session);  // no need to do both inbound and outbound, just duplicates relationships
                        buildRouteSequence(line.getId(), Direction.Inbound, session);
//                    buildRouteSequence (line.getId(), Direction.Outbound, session); // no need to do both inbound and outbound, just duplicates relationships
                    });

                    //  Now build the routes, using call that retrieves all routes by mode.
                    buildRoute(mode, session);


                    txn.commit();
                    txn = null;
                } catch (Exception e) {
                    System.out.println ("Something bad happend: " + e);
                }

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
            List<Line> lines = getLineRouteByMode (mode);

            //  Process the lines and create routes for each section.
            Set<Route> cache = new HashSet<>(20);
            lines.forEach (line -> {
                cache.clear();
                line.getRouteSections().forEach (section -> {
                    // The origination and destination stop should already exist, so just retrieve from Neo4j
                    StopNode origin = findStopNode(session, section.getOriginator());
                    StopNode destination = findStopNode(session, section.getDestination());

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
        } catch (Exception e) {
            System.out.println ("Exception occurred getting route sequence: " + e);
        }


        return true;
    }

    private boolean buildRouteSequence (String lineName,
                                        Direction direction,
                                        Session session) {

        try {
            //  Get the route sequence for the line and direction.
            RouteSequence seq = getLineRouteSequence(lineName, direction);

            //  Get or create each stop listed for the line.
            Map<GeoPoint, StopNode> all = new HashMap<>(seq.getStations().size());
            seq.getStations().forEach (stop -> {
                StopNode stopNode = findOrCreateStopNode(session, stop);

                //  Cache the stop so after all stops exist we can create a sequence
                GeoPoint point = new GeoPoint();
                point.setLat(stop.getLat());
                point.setLon(stop.getLon());
                all.put (point, stopNode);

//                //  Add all the known lines as transfers possible from this stop.
//                stop.getLines().forEach (line -> {
//                    LineNode lineNode = findOrCreateLineNode(line, session);
//                    stopNode.getTransfers().add(lineNode);
//                });

                //  Save the lines added to the node.
                session.save(stopNode);
            });

            //  Now that all stations are accounted for, build the complete route segment-by-segment.
/*
            seq.getLineStrings().forEach (lineString -> {
                StopNode start = null;
                int i = 0;
                for (GeoPoint point : convertLineString(lineString)) {
                    StopNode end = all.get(point);
                    if (start != null) {
                        Segment segment = new Segment (start, end, direction,
                            calcDistanceBetweenStops(session, start, end));
                        session.save(segment);
                    }
                    start = end;
                    i++;
                }
            });
*/
        } catch (Exception e) {
            System.out.println ("Exception building route sequence: " + e);
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
            RouteSequence route  = getLineRouteSequence(lineId, direction);

            route.getStopPointSequences().forEach (sequence -> {

                final AtomicReference<StopNode> start = new AtomicReference<>();
                sequence.getStopPoint().forEach (stop -> {

                    //  The node is always the end of the segment, either find an existing or create a new one
                    StopNode end = findOrCreateStopNode(session, stop);
                    end.getLines().add(lineId);

                    //  Needs to be a start node to work with, but the first stop in the sequence of stop points,
                    //  there isn't, so just mark it as the starting point for the next time through, when a
                    //  segment can be created.
                    StopNode startNode = start.get();
                    if (startNode == null) {
                        start.set(end);
                    } else {
                        findOrCreateSegment(session, start.get(), end, direction);
                        start.set(end);
                    }
                });
            });
        } catch (Exception e) {
            System.out.println ("Exception occurred getting route sequence: " + e);
        }


        return true;
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
                        getLineMetaModes().forEach (mode -> modes.put(mode.getModeName(), mode));
                    } catch (Exception e) {
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
     * @return flag indicating if mode is valid or not
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
                                        StopNode start,
                                        StopNode end,
                                        Direction direction) {

        Segment toReturn;

        //  Create a filter based on the nodes and direction.
        Filters composite = new Filters();
        Filter filter = new Filter ("stopId", new RelationshipNodePropertyComparison(RelationshipNodeType.START, ComparisonOperator.EQUALS, start.getStopId()));
        composite.add(filter);
        filter = new Filter ("stopId", new RelationshipNodePropertyComparison(RelationshipNodeType.END, ComparisonOperator.EQUALS, end.getStopId()));
        filter.setBooleanOperator(BooleanOperator.AND);
        composite.add(filter);

        //  It would probably be technically correct to include direction in the query.  However, there are some cases where
        //  you'll end up with four segments between two stations instead of two. For example:
        //      Circle Line:
        //          Monument to Tower Hill, inbound
        //          Tower Hill to Monument, outbound
        //      District Line:
        //          Tower Hill to Monument, inbound
        //          Monument to Tower Hill, outbound
        //  For situations like this, I'm leaving out the direction.
//        filter = new Filter ("direction", ComparisonOperator.EQUALS, direction);
//        filter.setBooleanOperator(BooleanOperator.AND);
//        composite.add(filter);

        //  Query database and, hopefully, only find a single relationship.
        Collection<Segment> segments = session.loadAll (Segment.class, composite);

        //  Was anything found?.
        if (!segments.isEmpty()) {
            //  Segment found, return it.
            toReturn = segments.stream().findFirst().get();
        } else {
            //  Nothing found, so a new relationship.
            toReturn = new Segment(start, end, direction, calcDistanceBetweenStops(session, start, end));
            session.save (toReturn);
        }


        return toReturn;
    }

    /**
     * Given a line object returned from TfL API, attempt to query a corresponding LineNode from Neo4J, if one doesn't
     * exist, create a new one and save to the database
     * @param line TfL Line
     * @param session Neo4J database session
     * @return new or existing LineNode
     */
    private LineNode findOrCreateLineNode (Identifier line,
                                           Session session) {

        LineNode toReturn;

        //  Need to create map to hold parameter
        Map<String,Object> params = new HashMap<>(1);
        params.put (LINE_PARAM_NAME, line.getName());

        //  Execute query and hope for the best
        toReturn = session.queryForObject (LineNode.class, LINE_QUERY, params);

        //  If line node doesn't exist, create a new one.
        if (toReturn == null) {
            toReturn = new LineNode (line.getName());
            session.save(toReturn);
        }


        return toReturn;
    }

    /**
     * Given a matched stop returned from the TfL API, search the database for a corresponding node; if not found,
     * create a new one
     * @param session Neo4J database session
     * @param stop the TfL stop
     * @return a Neo4J stop node
     */
    private StopNode findOrCreateStopNode(Session session,
                                          MatchedStop stop) {

        //  First, attempt to find the stop in the database.
        StopNode toReturn = findStopNode (session, stop.getId());

        //  Did we find anything?
        if (toReturn == null) {

            //  Stop doesn't exist, so create.
            toReturn = new StopNode(stop.getId(), stop.getName(), stop.getZone(), stop.getLon(), stop.getLat());
            session.save(toReturn);
        }


        return toReturn;
    }

    /**
     * Attempt to retrieve a stop from Neo4j using the stop id.
     * @param session Neo4J database session
     * @return a Neo4J stop node if found, otherwise null.
     */
    private StopNode findStopNode(Session session,
                                  String stopId) {

        StopNode toReturn = null;

        //  Create a filter based on the stop ID and attempt to from the database
        Filter filter = new Filter("stopId", ComparisonOperator.EQUALS, stopId);
        Collection<StopNode> stops = session.loadAll(StopNode.class, filter);
        if (stops != null && !stops.isEmpty()) {

            //  At least one stop was found, should only be one, so return it.
            StopNode[] array = stops.toArray(new StopNode[stops.size()]);
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
                                             StopNode stopA,
                                             StopNode stopB) {
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
     * Convert the line string returned for the line, which lists all stations in order by [latitude,longitude] into something usable.
     * @param line line string
     * @return array of 1 or more GeoPoint's
     */
    private GeoPoint[] convertLineString (String line) {

        //  First, tokenize into array of strings with each pair of numbers representing a single geographic point.  Note that
        //  this is specific to the TfL API, with extra []'s on either end that need to be removed.
        String[] points = line.substring(3, line.length() - 3).split("\\]\\,\\[");
        GeoPoint[] toReturn = new GeoPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            String[] values = points[i].split(",");
            GeoPoint geo = new GeoPoint();
            geo.setLon(Double.valueOf(values[0]));
            geo.setLat(Double.valueOf(values[1]));
            toReturn[i] = geo;
        }


        return toReturn;
    }

    /**
     * Get the lines for a given mode.
     * @param modeName mode name of interest
     * @return list of lines or null if an exception occurred
     */
    abstract protected Collection<Line> getLinesByMode (String modeName) throws Exception;

    /**
     * Get line routes by mode
     * @param mode mode name of interest
     * @return list of lines
     * @throws ApiException thrown when the API call fails
     */
    abstract protected List<Line> getLineRouteByMode (String mode) throws Exception;

    /**
     * Get a specific route sequence
     * @param lineName name of the line to get the route sequence
     * @param direction which direction of the route
     * @return RouteSequence information
     * @throws ApiException throws when the API call fails
     */
    abstract protected RouteSequence getLineRouteSequence (String lineName,
                                                           Direction direction) throws Exception;

    /**
     * Get the allowable modes.
     * @return list of modes
     */
    abstract protected List<Mode> getLineMetaModes() throws Exception;
}
