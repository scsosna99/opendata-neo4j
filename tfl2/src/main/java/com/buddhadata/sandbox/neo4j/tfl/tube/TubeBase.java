/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.enums.RelationshipNodeType;
import com.buddhadata.sandbox.neo4j.tfl.tube.filter.RelationshipNodePropertyComparison;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.LineNode;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.StopNode;
import com.buddhadata.sandbox.neo4j.tfl.tube.relationship.*;
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
                    });

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

                    //  Needs to be a start node to work with, but the first stop in the sequence of stop points,
                    //  there isn't, so just mark it as the starting point for the next time through, when a
                    //  segment can be created.
                    StopNode startNode = start.get();
                    if (startNode == null) {
                        start.set(end);
                    } else {
                        createSegment(session, lineId, start.get(), end, direction);
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
     * Create a relationship, specific to the line, for the segment between two stops
     * @param session Neo4J database session
     * @param lineName line determines the relationship type
     * @param start the starting stop (node) for the segment
     * @param end the ending stop (node) for the segment
     * @param direction which direction is the segment
     * @return a Neo4J segment relationship
     */
    private RouteSegmentBase createSegment (Session session,
                                            String lineName,
                                            StopNode start,
                                            StopNode end,
                                            Direction direction) {

        RouteSegmentBase toReturn = null;
        switch (lineName) {
            case "bakerloo":
                toReturn = new Bakerloo(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "central":
                toReturn = new Central(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "circle":
                toReturn = new Circle(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "district":
                toReturn = new District(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "hammersmith-city":
                toReturn = new HammersmithCity(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "jubilee":
                toReturn = new Jubilee(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "metropolitan":
                toReturn = new Metropolitan(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "northern":
                toReturn = new Northern(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "piccadilly":
                toReturn = new Piccadilly(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "victoria":
                toReturn = new Victoria(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            case "waterloo-city":
                toReturn = new WaterlooCity(start, end, direction, calcDistanceBetweenStops(session, start, end));
                break;
            default:
                System.out.println ("Unknown line found.");
        }

        session.save (toReturn);
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
