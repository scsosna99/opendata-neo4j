/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j;

import com.buddhadata.sandbox.neo4j.traffic.node.StreetNode;
import com.buddhadata.sandbox.neo4j.traffic.relationship.*;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Loads London Traffic Data into Neo4j map.
 * Source: http://apps.london.ca/opendata/excel_files_latlong/traffic_volumes_rawdata.xls
 */
public class TrafficVolumeLoader {

    /**
     * Session factory for connecting to Neo4j database
     */
    private final SessionFactory sessionFactory;

    //  The position index of each field in the input CSV file.
    static private final int FIELD_ROAD_TYPE = 4;
    static private final int FIELD_ROUTE_ID = 0;
    static private final int FIELD_STREET_FROM = 2;
    static private final int FIELD_STREET_NAME = 1;
    static private final int FIELD_STREET_TO = 3;
    static private final int FIELD_TRUCK_ROUTE = 6;
    static private final int FIELD_VOLUME = 5;

    //  Configuration info for connecting to the Neo4J database
    static private final String SERVER_URI = "bolt://localhost";
    static private final String SERVER_USERNAME = "neo4j";
    static private final String SERVER_PASSWORD = "password";


    /**
     * Constructor
     */
    public TrafficVolumeLoader() {
        //  Define session factory for connecting to Neo4j database
        Configuration configuration = new Configuration.Builder().uri(SERVER_URI).credentials(SERVER_USERNAME, SERVER_PASSWORD).build();
        sessionFactory = new SessionFactory(configuration, "com.buddhadata.sandbox.neo4j.traffic.node", "com.buddhadata.sandbox.neo4j.traffic.relationship");
    }


    /**
     * Main method for starting Java program
     * @param args command line arguments
     */
    public static void main (String[] args) {

        //  Create an instance of the class and process the file.
        new TrafficVolumeLoader().process();
    }


    /**
     * Process the file by reading lines one-by and break into constituent components.
     */
    private void process () {

        //  Raw data available as .csv stored with project.
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(("traffic_volumes_rawdata.csv"));
             BufferedReader br = new BufferedReader(new InputStreamReader(stream))){

            //  Throw away header line.
            br.readLine();

            //  When creating a session, always clean up the database by purging the database.
            Session session = sessionFactory.openSession();
            session.purgeDatabase();
            Transaction txn = session.beginTransaction();

            //  Process the remaining lines.
            while (br.ready()) {
                String line = br.readLine();
                if (line != null && !line.isEmpty()) {
                    //  Split the line read into individual fields.
                    String[] fields = line.split(",");

                    //  Figure out which is "from" street and which is "to" street.
                    String[] toFrom = identifyStreets (fields);
                    if (toFrom != null) {
                        //  Attempt to create a new route for fields read in from CSV.
                        createRoute (session,
                                Long.valueOf(fields[FIELD_ROUTE_ID]),
                                toFrom[0],
                                toFrom[1],
                                fields[FIELD_ROAD_TYPE],
                                Long.valueOf(fields[FIELD_VOLUME]),
                                convertTruckRouteName(fields[FIELD_TRUCK_ROUTE]));
                    }
                }
            }

            //  Commit the transaction.
            txn.commit();
        } catch (IOException ioe) {

        }
    }

    /**
     * Create the street nodes, if not already existing, and create a relationship between the two
     * @param session Neo4j database session
     * @param routeId client-supplied identifier of the route
     * @param fromStreetName the name of the source/beginning street
     * @param toStreetName the name of the destination/ending street
     * @param roadType the type of road being used for the route
     * @param volume the traffic levels on the route
     * @param truckRoute the type of truck route it is.
     */
    private void createRoute (Session session,
                              long routeId,
                              String fromStreetName,
                              String toStreetName,
                              String roadType,
                              long volume,
                              TruckRouteEnum truckRoute) {

        //  Create or find the streets on either end of the route.
        StreetNode from = findOrCreateStreet (session, fromStreetName);
        StreetNode to = findOrCreateStreet (session, toStreetName);

        //  Create the relationship representing the route
        BaseRoute route = createRouteRelationship(from, to, roadType, routeId, volume, truckRoute);

        //  Save the route in the session
        session.save(route);
    }


    /**
     * Either retrieve the existing street from Neo4j or create a new one
     * @param session database session
     * @param streetName the name of the street
     * @return an existing or newly-create StreetNode
     */
    private StreetNode findOrCreateStreet (Session session,
                                           String streetName) {

        StreetNode toReturn;

        //  Create a filter based on the street name and attempt to load the street from the database
        Filter filter = new Filter("streetName", ComparisonOperator.EQUALS, streetName);
        Collection<StreetNode> nodes = session.loadAll(StreetNode.class, filter);
        if (nodes != null && !nodes.isEmpty()) {
            //  At least one node is found, hopefully is only one, that we can use.
            StreetNode[] array = nodes.toArray(new StreetNode[nodes.size()]);
            toReturn = array[0];
        } else {
            //  street doesn't exist so create and save to database;
            toReturn = new StreetNode (streetName);
            session.save(toReturn);
        }


        return toReturn;
    }

    /**
     * Create the route relationship based on the roadType field in the raw data.  It might be better to
     * have a single relationship and use labels to differentiate road type, but that's not support
     * @param from the source/beginning street as a node
     * @param to the destinating/ending street as a node
     * @param roadType the road type of the route being create
     * @param routeId client-specified identifier of the route
     * @param volume volume of the route
     * @param truckRoute identifies the type, if any, of truck route.
     * @return the route relationship object created
     */
    private BaseRoute createRouteRelationship (StreetNode from,
                                               StreetNode to,
                                               String roadType,
                                               long routeId,
                                               long volume,
                                               TruckRouteEnum truckRoute) {

        //  Different road types require different relationships
        switch (roadType) {
            case "Arterial":
                return new ArterialRoute(routeId, from, to, volume, truckRoute);

            case "Expressway":
                return new ExpresswayRoute(routeId, from, to, volume, truckRoute);

            case "Freeway":
                return new FreewayRoute(routeId, from, to, volume, truckRoute);

            case "Local":
                return new LocalRoute(routeId, from, to, volume, truckRoute);

            case "Miscelaneous":
                return new MiscelaneousRoute(routeId, from, to, volume, truckRoute);

            case "Primary":
                return new PrimaryRoute(routeId, from, to, volume, truckRoute);

            case "Private":
                return new PrivateRoute(routeId, from, to, volume, truckRoute);

            case "Ramps":
                return new RampRoute(routeId, from, to, volume, truckRoute);

            case "Secondary":
                return new SecondaryRoute(routeId, from, to, volume, truckRoute);

            default:
                System.out.println ("Unknown route type: " + roadType);
                return new SecondaryRoute(routeId, from, to, volume, truckRoute);
        }
    }

    /**
     * The raw data sometimes has a street name but no from street, no from street, or all three, try and figure out
     * which fields has the information to use
     * @param fields the fields from a single record/line in the CSV
     * @return the from/to street to use, as a two-element array.
     */
    private String[] identifyStreets (String[] fields) {

        String[] toReturn = new String[2];

        String name = fields[FIELD_STREET_NAME];
        String from = fields[FIELD_STREET_FROM];
        String to = fields[FIELD_STREET_TO];

        //  Use case 1: Street Name and To Street only
        if (!name.isEmpty() && from.isEmpty() && !to.isEmpty()) {
            toReturn[0] = name;
            toReturn[1] = to;
        }
        //  Use case 2: Street Name and From Street only
        else if (!name.isEmpty() && !from.isEmpty() && to.isEmpty()) {
            toReturn[0] = name;
            toReturn[1] = from;
        }
        //  Use case 3: no street name, only a from and to
        else if (!name.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
            //  Make sure the to/from streets aren't the same, weird base data.
            if (!from.equals(to)) {
                toReturn[0] = from;
                toReturn[1] = to;
            } else {
                toReturn[0] = name;
                toReturn[1] = to;
            }
        }
        //  Use case 4: garbage data, should never happen, but if it does we'll return null and not process anything.
        else {
            //  Should never happen unless data is garbage, so return null and we'll skip the line.
            toReturn = null;
        }


        return toReturn;
    }


    /**
     * Convert the data for truck route into the corresponding enum value.
     * @param truckRouteField text string defining truck route
     * @return associated enum value or None if it cannot be deteremined.
     */
    private TruckRouteEnum convertTruckRouteName (String truckRouteField) {

        switch (truckRouteField) {

            case "24 hrs":
                return TruckRouteEnum.AllDay;

            case "7am to 6pm":
                return TruckRouteEnum.Daylight;

            case "None":
                return TruckRouteEnum.None;

            default:
                return TruckRouteEnum.None;
        }
    }
}
