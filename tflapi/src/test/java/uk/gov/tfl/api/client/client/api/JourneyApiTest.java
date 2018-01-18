/*
 * Transport for London Unified API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package uk.gov.tfl.api.client.client.api;

import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.model.ItineraryResult;
import uk.gov.tfl.api.client.client.model.Mode;
import org.junit.Test;
import org.junit.Ignore;

import java.util.List;

/**
 * API tests for JourneyApi
 */
@Ignore
public class JourneyApiTest {

    private final JourneyApi api = new JourneyApi();

    
    /**
     * Perform a Journey Planner search from the parameters specified in simple types
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journeyJourneyResultsTest() throws ApiException {
        String from = null;
        String to = null;
        String via = null;
        Boolean nationalSearch = null;
        String date = null;
        String time = null;
        String timeIs = null;
        String journeyPreference = null;
        List<String> mode = null;
        List<String> accessibilityPreference = null;
        String fromName = null;
        String toName = null;
        String viaName = null;
        String maxTransferMinutes = null;
        String maxWalkingMinutes = null;
        String walkingSpeed = null;
        String cyclePreference = null;
        String adjustment = null;
        List<String> bikeProficiency = null;
        Boolean alternativeCycle = null;
        Boolean alternativeWalking = null;
        Boolean applyHtmlMarkup = null;
        Boolean useMultiModalCall = null;
        Boolean walkingOptimization = null;
        Boolean taxiOnlyTrip = null;
        ItineraryResult response = api.journeyJourneyResults(from, to, via, nationalSearch, date, time, timeIs, journeyPreference, mode, accessibilityPreference, fromName, toName, viaName, maxTransferMinutes, maxWalkingMinutes, walkingSpeed, cyclePreference, adjustment, bikeProficiency, alternativeCycle, alternativeWalking, applyHtmlMarkup, useMultiModalCall, walkingOptimization, taxiOnlyTrip);

        // TODO: test validations
    }
    
    /**
     * Gets a list of all of the available journey planner modes
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journeyMetaTest() throws ApiException {
        List<Mode> response = api.journeyMeta();

        // TODO: test validations
    }
    
}
