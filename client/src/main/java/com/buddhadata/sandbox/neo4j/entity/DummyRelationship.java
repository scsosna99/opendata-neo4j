package com.buddhadata.sandbox.neo4j.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by scsosna on 1/6/18.
 */
@RelationshipEntity(type = "DUMMY")
public class DummyRelationship {

    Long id;

    @StartNode
    public DummyNode start;

    @EndNode
    public DummyNode end;
}
