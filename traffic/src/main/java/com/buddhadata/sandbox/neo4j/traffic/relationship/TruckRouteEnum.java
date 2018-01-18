package com.buddhadata.sandbox.neo4j.traffic.relationship;

/**
 * Different access for trucks on the route.
 */
public enum TruckRouteEnum {

    /**
     * Trucks can use the route 24x7
     */
    AllDay,

    /**
     * Trucks can use the route during daylight hours (7am-6pm)
     */
    Daylight,

    /**
     * No truck access allowed on route.
     */
    None;
}
