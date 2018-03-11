/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.enums;

/**
 * When querying the relationship node properties, is the start or end node of interest?
 *
 * @author Scott C Sosna
 */
public enum RelationshipNodeType {

    START ("startNode"),
    END ("endNode");


    /**
     * The Cypher query name associated with the node.
     */
    private final String functionName;

    /**
     * Constructor
     * @param functionName Cypher function name
     */
    RelationshipNodeType (String functionName) {
        this.functionName = functionName;
    }

    /**
     * getter
     * @return the Cypher function name associated with the associated node type
     */
    public String getFunctionName() {
        return this.functionName;
    }
}
