/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.data

import com.buddhadata.sandbox.neo4j.contracts.node.ContractType
import com.buddhadata.sandbox.neo4j.contracts.node.State
import com.buddhadata.sandbox.neo4j.contracts.node.Vendor
import org.neo4j.ogm.session.Session

class VendorFactory (var session: Session) {

    /**
     * Exposed function which uses the companion object to maintain a single cache of all ContactTypes which have been created
     * and added to the Neo4J database
     */
    fun get(id: String,
            name: String,
            addr1: String,
            addr2: String?,
            city: String?,
            state: State?): Vendor {
        return getOrCreate(id, name, addr1, addr2, city, state, session)
    }

    companion object {

        //  Cache of created ContractType nodes
        val cache: HashMap<String, Vendor> = HashMap()

        //  Either return the existing object in the cache or create it and add to database
        fun getOrCreate(id: String,
                        name: String,
                        addr1: String,
                        addr2: String?,
                        city: String?,
                        state: State?,
                        session: Session): Vendor {

            var toReturn = cache.get(id);
            if (toReturn == null) {
                toReturn = Vendor (id, name, addr1, addr2, city, state);
                cache.put(id, toReturn);
                session.save(toReturn);
            }

            return toReturn
        }
    }
}