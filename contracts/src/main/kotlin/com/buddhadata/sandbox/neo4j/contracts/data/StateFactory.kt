/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts.data

import com.buddhadata.sandbox.neo4j.contracts.node.State
import org.neo4j.ogm.session.Session

class StateFactory (var session: Session) {

    /**
     * Exposed function which uses the companion object to maintain a single cache of all States which have been created
     * and added to the Neo4J database
     */
    fun get(stateCode: String?): State? {
        return getOrCreate(stateCode, session)
    }

    companion object {

        //  Cache of create State objects
        val cache: HashMap<String, State> = HashMap()

        //
        var names: HashMap<String, String> = HashMap();
        init {
            populate()
        }

        //  Either return the existing object in the cache or create it and add to database
        fun getOrCreate (stateCode: String?,
                         session: Session): State? {

            var toReturn: State? = null
            if (!stateCode.isNullOrBlank()) {
                //  Does the state exist in the cache?
                toReturn = cache.get(stateCode)
                if (toReturn == null) {
                    toReturn = State(stateCode, names.getOrElse(stateCode, { "UNKNOWN" }))
                    cache.put(stateCode, toReturn)
                    session.save(toReturn)
                }
            }

            return toReturn
        }


        /**
         * An easy way to get the namez of the states, we're not going to pre-create the states but only
         * as they are used will a new one be created; therefore putting this in a temporary collection
         */
        fun populate () {
            names.put ("AA", "Armed Forces America")
            names.put ("AE", "Armed Forces")
            names.put ("AP", "Armed Forces Pacific")
            names.put ("AK", "Alaska")
            names.put ("AL", "Alabama")
            names.put ("AR", "Arkansas")
            names.put ("AZ", "Arizona")
            names.put ("CA", "California")
            names.put ("CO", "Colorado")
            names.put ("CT", "Connecticut")
            names.put ("DC", "District of Columbia ")
            names.put ("Wa", "shington DC")
            names.put ("DE", "Delaware")
            names.put ("FL", "Florida")
            names.put ("GA", "Georgia")
            names.put ("GU", "Guam")
            names.put ("HI", "Hawaii")
            names.put ("IA", "Iowa")
            names.put ("ID", "Idaho")
            names.put ("IL", "Illinois")
            names.put ("IN", "Indiana")
            names.put ("KS", "Kansas")
            names.put ("KY", "Kentucky")
            names.put ("LA", "Louisiana")
            names.put ("MA", "Massachusetts")
            names.put ("MD", "Maryland")
            names.put ("ME", "Maine")
            names.put ("MI", "Michigan")
            names.put ("MN", "Minnesota")
            names.put ("MO", "Missouri")
            names.put ("MS", "Mississippi")
            names.put ("MT", "Montana")
            names.put ("NC", "North Carolina")
            names.put ("ND", "North Dakota")
            names.put ("NE", "Nebraska")
            names.put ("NH", "New Hampshire")
            names.put ("NJ", "New Jersey")
            names.put ("NM", "New Mexico")
            names.put ("NV", "Nevada")
            names.put ("NY", "New York")
            names.put ("OH", "Ohio")
            names.put ("OK", "Oklahoma")
            names.put ("OR", "Oregon")
            names.put ("PA", "Pennsylvania")
            names.put ("PR", "Puerto Rico")
            names.put ("RI", "Rhode Island")
            names.put ("SC", "South Carolina")
            names.put ("SD", "South Dakota")
            names.put ("TN", "Tennessee")
            names.put ("TX", "Texas")
            names.put ("UT", "Utah")
            names.put ("VA", "Virginia")
            names.put ("VI", "Virgin Islands")
            names.put ("VT", "Vermont")
            names.put ("WA", "Washington")
            names.put ("WI", "Wisconsin")
            names.put ("WV", "West Virginia")
            names.put ("WY", "Wyoming")
        }
    }
}