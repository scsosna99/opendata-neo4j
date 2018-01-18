/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.entity;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by scsosna on 1/5/18.
 */
@NodeEntity
public class DummyNode extends BaseEntity {
    public String name;
}
