/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.node

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
data class Vendor (var vendorId: String,
                   var name: String,
                   var address1: String,
                   var address2: String?,
                   var city: String?,
                   @Relationship("LOCATED_IN") var stateParm: State?) {

    /**
     * Internal Neo4J identifier
     */
    @Id
    @GeneratedValue
    var id: Long? = null
}