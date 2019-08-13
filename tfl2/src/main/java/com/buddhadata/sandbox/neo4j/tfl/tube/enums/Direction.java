/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.enums;

/**
 * Travel direction
 */
public enum Direction {

    Inbound ("inbound"),
    Outbound ("outbound");

    private final String code;

    /**
     * Constructor
     * @param code the TfL code used when making call or interrogating response
     */
    Direction (String code) {
        this.code = code;
    }

    /**
     * getter
     * @return the code value for the enum
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Given the TfL code, return the corresponding enum
     * @param code TfL code for inbound or outbound
     * @return Direction enum or null if code doesn't match a known direction.
     */
    public static Direction getByCode (String code) {
        for (Direction direction : values()) {
            if (direction.equals(code)) return direction;
        }

        return null;
    }
}
