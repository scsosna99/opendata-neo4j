/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.node

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class ContractType (var type: String) {

    /**
     * Internal Neo4J identifier
     */
    @Id
    @GeneratedValue
    var id: Long? = null
}
