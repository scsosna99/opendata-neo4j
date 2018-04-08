/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.filings.node;

import generated.CoveredEnum;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Node representing a lobbyist
 *
 * @author Scott C Sosna
 */
@NodeEntity
public class Lobbyist extends BaseNode {

    /**
     * Internal Neo4J id of the node
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Does the lobbyist hold a government position.
     */
    private boolean govtPositionInd;

    /**
     * Activity Information
     */
    private String activityInfo;

    /**
     * Lobbyist first name
     */
    private String firstName;

    /**
     * The lobbyist's government position, if applicable.
     */
    private String govtPositionDesc;

    /**
     * Lobbyist surname
     */
    private String surname;


    /**
     * Constructor
     * @param firstName lobbyist first name
     * @param surname lobbyist surname
     * @param covered enum indicating whether the lobbyist holds a government position
     * @param govtPositionDesc The lobbyist's government position, if applicable
     * @param activityInfo activity info
     */
    public Lobbyist(final String firstName,
                    final String surname,
                    final CoveredEnum covered,
                    final String govtPositionDesc,
                    final String activityInfo) {

        this.firstName = normalizeString(firstName);
        this.surname = normalizeString(surname);
        this.govtPositionInd = (covered == CoveredEnum.COVERED);
        this.govtPositionDesc = normalizeString(govtPositionDesc);
        this.activityInfo = normalizeString(activityInfo);
    }

    /**
     * getter
     * @return internal Neo4J id of the node
     */
    public Long getId() {
        return id;
    }

    /**
     * setter
     * @param id internal Neo4J id of the node
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter
     * @return does the lobbyist hold a government position
     */
    public boolean isGovtPositionInd() {
        return govtPositionInd;
    }

    /**
     * setter
     * @param govtPositionInd does the lobbyist hold a goverment position
     */
    public void setGovtPositionInd(boolean govtPositionInd) {
        this.govtPositionInd = govtPositionInd;
    }

    /**
     * getter
     * @return activity information
     */
    public String getActivityInfo() {
        return activityInfo;
    }

    /**
     * setter
     * @param activityInfo activity information
     */
    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    /**
     * getter
     * @return Lobbyist first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter
     * @param firstName lobbyist first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter
     * @return government position of lobbyist, when applicable
     */
    public String getGovtPositionDesc() {
        return govtPositionDesc;
    }

    /**
     * Setter
     * @param govtPositionDesc government position of lobbyist, when applicable
     */
    public void setGovtPositionDesc(String govtPositionDesc) {
        this.govtPositionDesc = govtPositionDesc;
    }

    /**
     * getter
     * @return lobbyist surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * setter
     * @param surname lobbyist surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lobbyist lobbyist = (Lobbyist) o;

        if (firstName != null ? !firstName.equals(lobbyist.firstName) : lobbyist.firstName != null) return false;
        return surname != null ? surname.equals(lobbyist.surname) : lobbyist.surname == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}