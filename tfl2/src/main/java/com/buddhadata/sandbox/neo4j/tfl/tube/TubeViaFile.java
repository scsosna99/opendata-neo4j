/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.model.Line;
import uk.gov.tfl.api.client.client.model.Mode;
import uk.gov.tfl.api.client.client.model.RouteSequence;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

/**
 * Run TFL demo based on local files
 *
 * @author Scott C Sosna
 */
public class TubeViaFile extends TubeBase {

    final private Gson gson;


    /**
     * Constructor
     */
    public TubeViaFile() {
        super();

        gson = new Gson();
    }

    /**
     * Get the lines for a given mode.
     * @param modeName mode name of interest
     * @return list of lines or null if an exception occurred
     */
    protected Collection<Line> getLinesByMode (String modeName) throws IOException {
        String fileName = "lineMode-" + modeName + ".json";
        try (Reader rdr = new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))) {
            return gson.fromJson(rdr, new TypeToken<List<Line>>(){}.getType());
        }
    }

    /**
     * Get line routes by mode
     * @param mode mode name of interest
     * @return list of lines
     * @throws IOException thrown when the API fails the call
     */
    protected List<Line> getLineRouteByMode (String mode) throws IOException {

        String fileName = "lineRouteMode-" + mode + ".json";
        try (Reader rdr = new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))) {
            return gson.fromJson(rdr, new TypeToken<List<Line>>(){}.getType());
        }
    }

    /**
     * Get a specific route sequence
     * @param lineName name of the line to get the route sequence
     * @param direction which direction of the route
     * @return RouteSequence information
     * @throws IOException throws when the API call fails
     */
    protected RouteSequence getLineRouteSequence (String lineName,
                                                  Direction direction) throws IOException {
        String fileName = "lineRouteSequence-" + lineName + "-" + direction.name() + ".json";
        try (Reader rdr = new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))) {
            return gson.fromJson(rdr, new TypeToken<RouteSequence>(){}.getType());
        }
    }

    /**
     * Get the allowable modes.
     * @return list of modes
     */
    protected List<Mode> getLineMetaModes() throws IOException {

        try (Reader rdr = new InputStreamReader(ClassLoader.getSystemResourceAsStream("lineMetaModes.json"))){
            return gson.fromJson(rdr, new TypeToken<List<Mode>>(){}.getType());
        }
    }

    /**
     * Program main program
     * @param args command line arguments
     */
    public static void main (String[] args) {

        if (args.length > 0) {
            new TubeViaFile().process(args[0]);
        } else {
            System.out.print ("Mode required from command line.");
        }
    }
}
