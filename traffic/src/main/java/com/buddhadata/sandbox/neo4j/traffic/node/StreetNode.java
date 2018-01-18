package com.buddhadata.sandbox.neo4j.traffic.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * Neo4j node representing a street.
 */
public class StreetNode {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Name of street
     */
    private String streetName;

    /**
     * Constructor
     */
    public StreetNode () {
        return;
    }

    /**
     * Constructor
     * @param streetName name associated with node
     */
    public StreetNode (String streetName) {
        this.streetName = streetName;
    }

    /**
     * Getter
     * @return Neo4j primary key identifying node
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter
     * @return street name associated with node
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Setter
     * @param streetName street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreetNode that = (StreetNode) o;

        return streetName != null ? streetName.equals(that.streetName) : that.streetName == null;

    }

    @Override
    public int hashCode() {
        return streetName != null ? streetName.hashCode() : 0;
    }
}