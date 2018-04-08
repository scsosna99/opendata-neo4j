/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.filings.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import sun.reflect.generics.visitor.Reifier;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Node representing the overall filing
 *
 * @author Scott C Sosna
 */
@NodeEntity
public class Filing extends BaseNode {

    /**
     * Internal Neo4J id of the node
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Date on which the filing was received.
     */
    private Date receivedOn;

    /**
     * The dollar amount of the filing.
     */
    private int amount;

    /**
     * The year of the filing
     */
    private int year;

    /**
     * Government-issued identifier for the filing
     */
    private String filingId;

    /**
     * The period represented by the filing.
     */
    private String period;

    /**
     * Type of filing
     */
    private String type;

    /**
     * The organization who actually made the filing on behalf of the registrant
     */
    @Relationship (type = "FILED_BY")
    private Client client;

    /**
     * Government entities for whom the lobbying to directed
     */
    @Relationship(type = "LOBBYING")
    private List<GovernmentEntity> entities;

    /**
     * The specific lobbyists identified by the liling
     */
    @Relationship(type = "LOBBIED_BY")
    private List<Lobbyist> lobbyists;

    /**
     * The registered entity for whom the filing was made
     */
    @Relationship(type = "FILED_FOR")
    private Registrant registrant;

    /**
     * Constructopr
     * @param filingId government-issued identifier for the filing
     * @param year the year of the filing
     * @param receivedOn date on which the filing was received
     * @param amount the dollar amount of the filing
     * @param type type of filing
     * @param period the period represented by the filing
     */
    public Filing (final String filingId,
                   final int year,
                   final Date receivedOn,
                   final int amount,
                   final String type,
                   final String period) {

        this.filingId = normalizeString (filingId);
        this.year = year;
        this.receivedOn = receivedOn;
        this.amount = amount;
        this.type = normalizeString (type);
        this.period = normalizeString (period);
        this.entities = new ArrayList<>();
        this.lobbyists = new ArrayList<>();
    }

    /**
     * getter
     * @return Internal Neo4J id of the node
     */
    public Long getId() {
        return id;
    }

    /**
     * setter
     * @param id Internal Neo4J id of the node
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter
     * @return date on which the filing was received
     */
    public Date getReceivedOn() {
        return receivedOn;
    }

    /**
     * setter
     * @param receivedOn date on which the filing was received
     */
    public void setReceivedOn(Date receivedOn) {
        this.receivedOn = receivedOn;
    }

    /**
     * getter
     * @return the dollar amount of the filing
     */
    public int getAmount() {
        return amount;
    }

    /**
     * setter
     * @param amount the dollar amount of the filing
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * getter
     * @return the year of the filing
     */
    public int getYear() {
        return year;
    }

    /**
     * setter
     * @param year the year of the filing
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * getter
     * @return government-issued identifier for the filing
     */
    public String getFilingId() {
        return filingId;
    }

    /**
     * setter
     * @param filingId government-issued identifier for the filing
     */
    public void setFilingId(String filingId) {
        this.filingId = filingId;
    }

    /**
     * getter
     * @return period represented by the filing
     */
    public String getPeriod() {
        return period;
    }

    /**
     * setter
     * @param period period represented by the filing
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * getter
     * @return type of filing
     */
    public String getType() {
        return type;
    }

    /**
     * setter
     * @param type type of filing
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter
     * @return The organization who actually made the filing on behalf of the registrant
     */
    public Client getClient() {
        return client;
    }

    /**
     * setter
     * @param client The organization who actually made the filing on behalf of the registrant
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * getter
     * @return The registered entity for whom the filing was made
     */
    public Registrant getRegistrant() {
        return registrant;
    }

    /**
     * setter
     * @param registrant The registered entity for whom the filing was made
     */
    public void setRegistrant(Registrant registrant) {
        this.registrant = registrant;
    }

    public List<GovernmentEntity> getEntities() {
        return entities;
    }

    public List<Lobbyist> getLobbyists() {
        return lobbyists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filing filing = (Filing) o;

        return filingId != null ? filingId.equals(filing.filingId) : filing.filingId == null;

    }

    @Override
    public int hashCode() {
        return filingId != null ? filingId.hashCode() : 0;
    }
}