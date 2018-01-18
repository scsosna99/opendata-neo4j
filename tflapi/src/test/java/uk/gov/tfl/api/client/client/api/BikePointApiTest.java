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
import uk.gov.tfl.api.client.client.model.Place;
import org.junit.Test;
import org.junit.Ignore;

import java.util.List;

/**
 * API tests for BikePointApi
 */
@Ignore
public class BikePointApiTest {

    private final BikePointApi api = new BikePointApi();

    
    /**
     * Gets the bike point with the given id.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bikePointGetTest() throws ApiException {
        String id = null;
        Place response = api.bikePointGet(id);

        // TODO: test validations
    }
    
    /**
     * Gets all bike point locations. The Place object has an addtionalProperties array which contains the nbBikes, nbDocks and nbSpaces              numbers which give the status of the BikePoint. A mismatch in these numbers i.e. nbDocks - (nbBikes + nbSpaces) !&#x3D; 0 indicates broken docks.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bikePointGetAllTest() throws ApiException {
        List<Place> response = api.bikePointGetAll();

        // TODO: test validations
    }
    
    /**
     * Search for bike stations by their name, a bike point&#39;s name often contains information about the name of the street              or nearby landmarks, for example. Note that the search result does not contain the PlaceProperties i.e. the status              or occupancy of the BikePoint, to get that information you should retrieve the BikePoint by its id on /BikePoint/id.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bikePointSearchTest() throws ApiException {
        String query = null;
        List<Place> response = api.bikePointSearch(query);

        // TODO: test validations
    }
    
}
