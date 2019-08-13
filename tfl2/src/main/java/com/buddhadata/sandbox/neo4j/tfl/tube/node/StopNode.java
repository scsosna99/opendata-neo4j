/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.node;

import org.neo4j.ogm.annotation.*;

import java.util.*;

/**
 * Neo4j node representing a street.
 *
 * @author Scott C Sosna
 */
@NodeEntity
public class StopNode {

    /**
     * latitude (N/S) portion of WGS84 geographic coordinates
     */
    private Double latitude;

    /**
     * longitude (E/W) portion of WGS84 geographic coordinates
     */
    private Double longitude;

    /**
     * Lines to which passenger can transfer at this stop.
     */
    @Relationship(type = "TRANSFER", direction = "UNDIRECTED")
    private List<LineNode> transfers;

    /**
     * Internal Neo4J id of the node
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Name of stop
     */
    private String name;

    /**
     * TfL id of the stop
     */
    private String stopId;

    /**
     * Travel zone of the specific stop
     */
    private String zone;

    /**
     * Constructor
     */
    public StopNode() {
        return;
    }

    /**
     * Constructor
     * @param stopId TfL identifier of the stop
     * @param stopName name of the stop
     * @param zone zone in which the stop exists
     * @param longitude WGS84 longitude coordinate
     * @param latitude WGS84 latitude coordinate
     */
    public StopNode(String stopId,
                    String stopName,
                    String zone,
                    Double longitude,
                    Double latitude) {
        this.stopId = stopId;
        this.name = stopName;
        this.zone = zone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * getter
     * @return WGS84 latitude coordinate
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * setter
     * @param latitude WGS84 latitude coordinate
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * getter
     * @return WGS84 longitude coordinate
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * setter
     * @param longitude WGS84 longitude coordinate
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * getter
     * @return Neo4J internal id of the node
     */
    public Long getId() {
        return id;
    }

    /**
     * getter
     * @return TfL's name of the stop
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     * @param name TfL's name of the stop
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter
     * @param id Neo4J internal id of the node
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter
     * @return TfL stop id
     */
    public String getStopId() {
        return stopId;
    }

    /**
     * setter
     * @param stopId TfL stop id
     */
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    /**
     * getter
     * @return zone in which the stop is located
     */
    public String getZone() {
        return zone;
    }

    /**
     * setter
     * @param zone zone in which the stop is located
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopNode stop = (StopNode) o;

        return stopId != null ? stopId.equals(stop.stopId) : stop.stopId == null;

    }

    @Override
    public int hashCode() {
        return stopId != null ? stopId.hashCode() : 0;
    }
}