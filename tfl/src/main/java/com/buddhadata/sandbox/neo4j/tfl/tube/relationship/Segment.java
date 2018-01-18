package com.buddhadata.sandbox.neo4j.tfl.tube.relationship;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.buddhadata.sandbox.neo4j.tfl.tube.node.Stop;
import org.neo4j.ogm.annotation.*;

/**
 * Created by scsosna on 1/6/18.
 */
@RelationshipEntity(type = "Segment")
public class Segment extends RouteSegmentBase {

    /**
     * Constructor
     */
    public Segment() {
        return;
    }

    /**
     * Constructor
     * @param start starting stop (node) of this segment
     * @param end ending stop (node) of this segment
     * @param direction direction of the segment
     * @param distance distance in meters between the two stops
     */
    public Segment(Stop start,
                   Stop end,
                   Direction direction,
                   Double distance) {
        super (start, end, direction, distance);
    }
}
