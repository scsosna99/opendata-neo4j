/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.Direction;
import com.google.gson.Gson;
import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.api.LineApi;
import uk.gov.tfl.api.client.client.model.Line;
import uk.gov.tfl.api.client.client.model.Mode;
import uk.gov.tfl.api.client.client.model.RouteSequence;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Run the TFL demo using the actual API calls.
 *
 * @author Scott C Sosna
 */
public class TubeViaApi extends TubeBase {

    final private File resourceDir;

    /**
     * Gson object so everything can be serialized for non-network runs later.
     */
    final private Gson gson;

    /**
     * Implementation for making line API calls.
     */
    final private LineApi apiLine;


    /**
     * Constructor
     */
    public TubeViaApi () {
        super();

        apiLine = new LineApi();
        gson = new Gson();
        resourceDir = new File("tfl/src/main/resources");
    }

    /**
     * Get the lines for a given mode.
     * @param modeName mode name of interest
     * @return list of lines or null if an exception occurred
     */
    protected Collection<Line> getLinesByMode (String modeName) {
        try {
            //  Return all lines for the specified transport mode.
            Collection<Line> toReturn = apiLine.lineGetByMode(Collections.singletonList(modeName));
            writeFile(toReturn, "lineMode-" + modeName + ".json");
            return toReturn;
        } catch (ApiException e) {
            System.out.println ("getLinesByMode Exception: " + e);
            return null;
        }
    }

    /**
     * Get line routes by mode
     * @param mode mode name of interest
     * @return list of lines
     * @throws ApiException thrown when the API fails the call
     */
    protected List<Line> getLineRouteByMode (String mode) throws ApiException {
        List<Line> toReturn = apiLine.lineRouteByMode(Collections.singletonList(mode), SERVICE_TYPE_REGULAR);
        writeFile (toReturn, "lineRouteMode-" + mode + ".json");
        return toReturn;
    }

    /**
     * Get a specific route sequence
     * @param lineName name of the line to get the route sequence
     * @param direction which direction of the route
     * @return RouteSequence information
     * @throws ApiException throws when the API call fails
     */
    protected RouteSequence getLineRouteSequence (String lineName,
                                                  Direction direction) throws ApiException {
        RouteSequence toReturn = apiLine.lineRouteSequence(lineName, direction.getCode(), null, false);
        writeFile (toReturn, "lineRouteSequence-" + lineName + "-" + direction.name() + ".json");
        return apiLine.lineRouteSequence(lineName, direction.getCode(), null, false);
    }

    /**
     * Get the allowable modes.
     * @return list of modes
     */
    protected List<Mode> getLineMetaModes() throws ApiException{
        List<Mode> toReturn = apiLine.lineMetaModes();
        writeFile (toReturn, "lineMetaModes.json");
        return apiLine.lineMetaModes();
    }

    /**
     * Write out file of whatever the objects were
     * @param object the object being serialized
     * @param fileName the destination of the serialization
     */
    private void writeFile (Object object,
                            String fileName) {

        try (FileWriter fw = new FileWriter (new File (resourceDir, fileName))) {
            String json = gson.toJson(object);
            fw.write(json);
        } catch (Exception e) {
            //  Don't care about exceptions, since this is just secondary to the real work being done.
        }
    }

    /**
     * Program main program
     * @param args command line arguments
     */
    public static void main (String[] args) {

        if (args.length > 0) {
            new TubeViaApi().process(args[0]);
        } else {
            System.out.print ("Mode required from command line.");
        }
    }
}
