/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.traffic.relationship;

import com.buddhadata.sandbox.neo4j.traffic.node.StreetNode;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * Neo4j relationship for miscelaneous roads/routes.
 */
@RelationshipEntity(type = "MISCELANEOUS")
public class MiscelaneousRoute extends BaseRoute {

    /**
     * No-args constructor
     */
    public MiscelaneousRoute() {
        super();
    }

    /**
     * Constructor
     * @param routeId uniquely identifies the route
     * @param fromStreet the source street of the route
     * @param toStreet the destination street of the route
     * @param volume the traffic volumes on the route
     * @param truckRoute what type of truck route is it.
     */
    public MiscelaneousRoute(final long routeId,
                             final StreetNode fromStreet,
                             final StreetNode toStreet,
                             final long volume,
                             final TruckRouteEnum truckRoute) {
        super (routeId, fromStreet, toStreet, volume, truckRoute);
    }
}
