/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.data

import com.buddhadata.sandbox.neo4j.contracts.node.ContractType
import com.buddhadata.sandbox.neo4j.contracts.node.State
import org.neo4j.ogm.session.Session

class ContractTypeFactory (var session: Session) {

    /**
     * Exposed function which uses the companion object to maintain a single cache of all ContactTypes which have been created
     * and added to the Neo4J database
     */
    fun get(contractTypeCode: String?): ContractType? {
        return getOrCreate(contractTypeCode, session)
    }

    companion object {

        //  Cache of created ContractType nodes
        val cache: HashMap<String, ContractType> = HashMap()

        //  Either return the existing object in the cache or create it and add to database
        fun getOrCreate(contractTypeCode: String?,
                        session: Session): ContractType? {

            var toReturn: ContractType? = null
            if (!contractTypeCode.isNullOrEmpty()) {
                //  Does the state exist in the cache?
                toReturn = cache.get(contractTypeCode)
                if (toReturn == null) {
                    toReturn = ContractType(contractTypeCode)
                    cache.put(contractTypeCode, toReturn)
                    session.save(toReturn)
                }
            }

            return toReturn
        }
    }
}