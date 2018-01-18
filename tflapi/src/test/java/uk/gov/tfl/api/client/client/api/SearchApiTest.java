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
import uk.gov.tfl.api.client.client.model.SearchResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.List;

/**
 * API tests for SearchApi
 */
@Ignore
public class SearchApiTest {

    private final SearchApi api = new SearchApi();

    
    /**
     * Searches the bus schedules folder on S3 for a given bus number.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchBusSchedulesTest() throws ApiException {
        String query = null;
        SearchResponse response = api.searchBusSchedules(query);

        // TODO: test validations
    }
    
    /**
     * Search the site for occurrences of the query string. The maximum number of results returned is equal to the maximum page size              of 100. To return subsequent pages, use the paginated overload.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchGetTest() throws ApiException {
        String query = null;
        SearchResponse response = api.searchGet(query);

        // TODO: test validations
    }
    
    /**
     * Gets the available search categories.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchMetaCategoriesTest() throws ApiException {
        List<String> response = api.searchMetaCategories();

        // TODO: test validations
    }
    
    /**
     * Gets the available searchProvider names.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchMetaSearchProvidersTest() throws ApiException {
        List<String> response = api.searchMetaSearchProviders();

        // TODO: test validations
    }
    
    /**
     * Gets the available sorting options.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchMetaSortsTest() throws ApiException {
        List<String> response = api.searchMetaSorts();

        // TODO: test validations
    }
    
}
