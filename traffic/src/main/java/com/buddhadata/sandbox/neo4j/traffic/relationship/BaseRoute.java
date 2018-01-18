package com.buddhadata.sandbox.neo4j.traffic.relationship;

import com.buddhadata.sandbox.neo4j.traffic.node.StreetNode;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Base class for defining a route relationship object
 */
public class BaseRoute {

    /**
     * Neo4j Primary Key
     */
    private Long id;

    /**
     * Uniquely identifies the route, from the raw data.
     */
    private long routeId;

    /**
     * Traffic volume for the road
     */
    private long volume;

    /**
     * Source street, beginning of road
     */
    @StartNode
    private StreetNode fromStreet;

    /**
     * Destination street, end of road
     */
    @EndNode
    private StreetNode toStreet;

    /**
     * If and when can trucks use the route.
     */
    private TruckRouteEnum truckRoute;

    /**
     * No-args constructor
     */
    protected BaseRoute() {
        return;
    }

    /**
     * Constructor
     * @param routeId uniquely identifies the route
     * @param fromStreet the source street of the route
     * @param toStreet the destination street of the route
     * @param volume the traffic volumes on the route
     * @param truckRoute what type of truck route is it.
     */
    protected BaseRoute (final long routeId,
                         final StreetNode fromStreet,
                         final StreetNode toStreet,
                         final long volume,
                         final TruckRouteEnum truckRoute) {
        this.routeId = routeId;
        this.fromStreet = fromStreet;
        this.toStreet = toStreet;
        this.volume = volume;
        this.truckRoute = truckRoute;
    }
}
