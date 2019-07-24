/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.data

import com.buddhadata.sandbox.neo4j.contracts.node.ContractType
import com.buddhadata.sandbox.neo4j.contracts.node.Department
import org.neo4j.ogm.session.Session

class DepartmentFactory (var session: Session) {

    /**
     * Exposed function which uses the companion object to maintain a single cache of all ContactTypes which have been created
     * and added to the Neo4J database
     */
    fun get(dept: String?): Department? {
        return getOrCreate(dept, session)
    }

    companion object {

        //  Cache of created ContractType nodes
        val cache: HashMap<String, Department> = HashMap()

        //  Either return the existing object in the cache or create it and add to database
        fun getOrCreate(dept: String?,
                        session: Session): Department? {

            var toReturn: Department? = null
            if (dept != null) {

                //  Get rid of leading info that's unnecessary
                val deptShort = dept.replace("DEPT OF", "").replace("DEPARTMENT OF", "").trim()

                //  Does the state exist in the cache?
                toReturn = cache.get(deptShort)
                if (toReturn == null) {
                    toReturn = Department(deptShort)
                    cache.put(deptShort, toReturn)
                    session.save(toReturn)
                }
            } else {
                toReturn = getOrCreate("UNKNOWN", session)
            }

            return toReturn
        }
    }
}