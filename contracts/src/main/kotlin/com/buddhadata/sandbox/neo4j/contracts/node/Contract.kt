/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.node

import org.neo4j.ogm.annotation.*
import java.time.LocalDate

@NodeEntity
data class Contract (var contract: String,
                     var name: String?,
                     var revision: String,
                     @Relationship(type = "ADMINISTERS", direction = "INCOMING") var dept: Department?,
                     @Relationship("HOW_OBTAINED") var procurementType: ProcurementType?,
                     @Relationship("IS_A") var contractType: ContractType?,
                     @Relationship(type = "AWARDED", direction = "INCOMING") var vendor: Vendor,
                     var approvedOn: LocalDate?,
                     var startedOn: LocalDate?,
                     var endedOn: LocalDate?,
                     var amt: Float?) {

    /**
     * Internal Neo4J identifier
     */
    @Id
    @GeneratedValue
    var id: Long? = null
}