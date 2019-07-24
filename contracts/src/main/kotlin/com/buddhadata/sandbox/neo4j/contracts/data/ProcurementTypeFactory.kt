/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.data

import com.buddhadata.sandbox.neo4j.contracts.node.ContractType
import com.buddhadata.sandbox.neo4j.contracts.node.ProcurementType
import com.buddhadata.sandbox.neo4j.contracts.node.State
import org.neo4j.ogm.session.Session

class ProcurementTypeFactory (var session: Session) {

    /**
     * Exposed function which uses the companion object to maintain a single cache of all ContactTypes which have been created
     * and added to the Neo4J database
     */
    fun get(procurementTypeCode: String?): ProcurementType? {
        return getOrCreate(procurementTypeCode, session)
    }

    companion object {

        //  Cache of created ProcurementType nodes
        val cache: HashMap<String, ProcurementType> = HashMap()

        //  Either return the existing object in the cache or create it and add to database
        fun getOrCreate(procurementTypeCode: String?,
                        session: Session): ProcurementType? {

            var toReturn:ProcurementType? = null
            if (!procurementTypeCode.isNullOrBlank()) {
                //  Does the state exist in the cache?
                toReturn = cache.get(procurementTypeCode)
                if (toReturn == null) {
                    toReturn = ProcurementType(procurementTypeCode)
                    cache.put(procurementTypeCode, toReturn)
                    session.save(toReturn)
                }
            }

            return toReturn
        }
    }
}