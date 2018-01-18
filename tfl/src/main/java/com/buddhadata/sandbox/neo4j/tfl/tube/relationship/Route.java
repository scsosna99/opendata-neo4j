/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.relationship;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.Stop;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * Created by scsosna on 1/6/18.
 */
@RelationshipEntity(type = "Route")
public class Route extends RouteSegmentBase {

    /**
     * Id of the lineId associated with the route
     */
    private String lineId;

    /**
     * Name of the route
     */
    private String name;

    /**
     * Constructor
     */
    public Route() {
        return;
    }

    /**
     * Constructor
     * @param lineId id of the lineId associated with the route
     * @param name name of the route
     * @param start starting stop (node) of this segment
     * @param end ending stop (node) of this segment
     * @param direction direction of the segment
     * @param distance distance in meters between the two stops
     */
    public Route(String lineId,
                 String name,
                 Stop start,
                 Stop end,
                 Direction direction,
                 Double distance) {
        super (start, end, direction, distance);
        this.lineId = lineId;
        this.name = name;
    }

    /**
     * getter
     * @return id of the lineId associated with the route
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * setter
     * @param lineId id of the lineId associated with the route
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     * getter
     * @return name of the route
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     * @param name name of the route
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Route route = (Route) o;

        return lineId != null ? lineId.equals(route.lineId) : route.lineId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lineId != null ? lineId.hashCode() : 0);
        return result;
    }
}
