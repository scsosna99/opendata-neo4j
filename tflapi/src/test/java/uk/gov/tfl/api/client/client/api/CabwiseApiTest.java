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
import org.junit.Test;
import org.junit.Ignore;

/**
 * API tests for CabwiseApi
 */
@Ignore
public class CabwiseApiTest {

    private final CabwiseApi api = new CabwiseApi();

    
    /**
     * Gets taxis and minicabs contact information
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void cabwiseGetTest() throws ApiException {
        Double lat = null;
        Double lon = null;
        String optype = null;
        String wc = null;
        Double radius = null;
        String name = null;
        Integer maxResults = null;
        Boolean legacyFormat = null;
        Boolean forceXml = null;
        Boolean twentyFourSevenOnly = null;
        Object response = api.cabwiseGet(lat, lon, optype, wc, radius, name, maxResults, legacyFormat, forceXml, twentyFourSevenOnly);

        // TODO: test validations
    }
    
}
