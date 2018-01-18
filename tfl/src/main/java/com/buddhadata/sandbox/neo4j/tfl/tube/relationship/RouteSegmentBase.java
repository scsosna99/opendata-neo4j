/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.relationship;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.Stop;
import org.neo4j.ogm.annotation.*;

/**
 * Created by scsosna on 1/6/18.
 */
public class RouteSegmentBase {

    /**
     * Distance as measured between the two stops
     */
    private Double distance;

    /**
     * Internal Neo4J id of the node
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * start/source of the segment
     */
    @StartNode
    private Stop start;

    /**
     * end/destination of the segment
     */
    @EndNode
    private Stop end;

    /**
     * Direction of the route segment
     */
    private Direction direction;


    /**
     * Constructor
     */
    public RouteSegmentBase() {
        return;
    }

    /**
     * Constructor
     * @param start starting stop (node) of this segment
     * @param end ending stop (node) of this segment
     * @param direction direction of the segment
     * @param distance distance in meters between the two stops
     */
    protected RouteSegmentBase(Stop start,
                               Stop end,
                               Direction direction,
                               Double distance) {
        this.start = start;
        this.end = end;
        this.direction = direction;
        this.distance = distance;
    }

    /**
     * getter
     * @return distance between stops in meters
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * setter
     * @param distance distance between stops in meters
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * getter
     * @return internal Neo4J id of the relationship
     */
    public Long getId() {
        return id;
    }

    /**
     * setter
     * @param id internal Neo4J id of the relationship
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter
     * @return starting stop (node) of the segment
     */
    public Stop getStart() {
        return start;
    }

    /**
     * setter
     * @param start starting stop (node) of the segment
     */
    public void setStart(Stop start) {
        this.start = start;
    }

    /**
     * getter
     * @return ending stop (node) of the segment
     */
    public Stop getEnd() {
        return end;
    }

    /**
     * setter
     * @param end ending stop (node) of the segment
     */
    public void setEnd(Stop end) {
        this.end = end;
    }

    /**
     * getter
     * @return direction of this segment
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * setter
     * @param direction direction of this segment
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteSegmentBase that = (RouteSegmentBase) o;

        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        return direction != null ? direction.equals(that.direction) : that.direction == null;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
