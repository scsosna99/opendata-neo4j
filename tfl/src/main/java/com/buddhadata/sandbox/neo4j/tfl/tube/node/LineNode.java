/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Node representing a TfL "Line"
 *
 * @author Scott C Sosna
 */
@NodeEntity
public class LineNode implements Comparable<LineNode> {

    /**
     * Internal Neo4J id of the node
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Name of line
     */
    private String name;

    /**
     * getter
     * @return internal Neo4j node id
     */
    public Long getId() {
        return id;
    }

    /**
     * Constructor
     */
    public LineNode() {
        return;
    }

    /**
     * Constructor
     * @param name name of the line
     */
    public LineNode(String name) {
        this.name = name;
    }

    /**
     * setter
     * @param id internal Neo4j node id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter
     * @return name of the line
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     * @param name name of the line
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Implement comparable for sorting the transfers
     * @param other
     * @return
     */
    public int compareTo (LineNode other) {
        return getName().compareTo(other.getName());
    }
}
