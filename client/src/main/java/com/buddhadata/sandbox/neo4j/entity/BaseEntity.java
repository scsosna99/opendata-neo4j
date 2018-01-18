/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by scsosna on 1/5/18.
 */
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }


    @Labels
    public Collection<String> labels = new ArrayList<>();
}
