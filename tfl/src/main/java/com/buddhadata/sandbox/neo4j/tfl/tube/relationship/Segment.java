/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.relationship;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.StopNode;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * Relationship representing a segment/direct connection between two stops of a TfL route, useful for all modes.
 *
 * @author Scott C Sosna
 */
@RelationshipEntity(type = "Segment")
public class Segment extends RouteSegmentBase {

    /**
     * Constructor
     */
    public Segment() {
    }

    /**
     * Constructor
     * @param start starting stop (node) of this segment
     * @param end ending stop (node) of this segment
     * @param direction direction of the segment
     * @param distance distance in meters between the two stops
     */
    public Segment(StopNode start,
                   StopNode end,
                   Direction direction,
                   Double distance) {
        super (start, end, direction, distance);
    }
}
