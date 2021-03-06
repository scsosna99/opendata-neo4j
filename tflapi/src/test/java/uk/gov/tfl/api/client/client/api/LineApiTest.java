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
import uk.gov.tfl.api.client.client.model.Disruption;
import uk.gov.tfl.api.client.client.model.Line;
import uk.gov.tfl.api.client.client.model.Mode;
import org.threeten.bp.OffsetDateTime;
import uk.gov.tfl.api.client.client.model.Prediction;
import uk.gov.tfl.api.client.client.model.RouteSearchResponse;
import uk.gov.tfl.api.client.client.model.RouteSequence;
import uk.gov.tfl.api.client.client.model.StatusSeverity;
import uk.gov.tfl.api.client.client.model.StopPoint;
import uk.gov.tfl.api.client.client.model.TimetableResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.List;

/**
 * API tests for LineApi
 */
@Ignore
public class LineApiTest {

    private final LineApi api = new LineApi();

    
    /**
     * Get the list of arrival predictions for given line ids based at the given stop
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineArrivalsTest() throws ApiException {
        List<String> ids = null;
        String stopPointId = null;
        String direction = null;
        String destinationStationId = null;
        List<Prediction> response = api.lineArrivals(ids, stopPointId, direction, destinationStationId);

        // TODO: test validations
    }
    
    /**
     * Get disruptions for the given line ids
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineDisruptionTest() throws ApiException {
        List<String> ids = null;
        List<Disruption> response = api.lineDisruption(ids);

        // TODO: test validations
    }
    
    /**
     * Get disruptions for all lines of the given modes.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineDisruptionByModeTest() throws ApiException {
        List<String> modes = null;
        List<Disruption> response = api.lineDisruptionByMode(modes);

        // TODO: test validations
    }
    
    /**
     * Gets lines that match the specified line ids.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineGetTest() throws ApiException {
        List<String> ids = null;
        List<Line> response = api.lineGet(ids);

        // TODO: test validations
    }
    
    /**
     * Gets lines that serve the given modes.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineGetByModeTest() throws ApiException {
        List<String> modes = null;
        List<Line> response = api.lineGetByMode(modes);

        // TODO: test validations
    }
    
    /**
     * Get all valid routes for given line ids, including the name and id of the originating and terminating stops for each route.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineLineRoutesByIdsTest() throws ApiException {
        List<String> ids = null;
        List<String> serviceTypes = null;
        List<Line> response = api.lineLineRoutesByIds(ids, serviceTypes);

        // TODO: test validations
    }
    
    /**
     * Gets a list of valid disruption categories
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineMetaDisruptionCategoriesTest() throws ApiException {
        List<String> response = api.lineMetaDisruptionCategories();

        // TODO: test validations
    }
    
    /**
     * Gets a list of valid modes
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineMetaModesTest() throws ApiException {
        List<Mode> response = api.lineMetaModes();

        // TODO: test validations
    }
    
    /**
     * Gets a list of valid ServiceTypes to filter on
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineMetaServiceTypesTest() throws ApiException {
        List<String> response = api.lineMetaServiceTypes();

        // TODO: test validations
    }
    
    /**
     * Gets a list of valid severity codes
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineMetaSeverityTest() throws ApiException {
        List<StatusSeverity> response = api.lineMetaSeverity();

        // TODO: test validations
    }
    
    /**
     * Get all valid routes for all lines, including the name and id of the originating and terminating stops for each route.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineRouteTest() throws ApiException {
        List<String> serviceTypes = null;
        List<Line> response = api.lineRoute(serviceTypes);

        // TODO: test validations
    }
    
    /**
     * Gets all lines and their valid routes for given modes, including the name and id of the originating and terminating stops for each route
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineRouteByModeTest() throws ApiException {
        List<String> modes = null;
        List<String> serviceTypes = null;
        List<Line> response = api.lineRouteByMode(modes, serviceTypes);

        // TODO: test validations
    }
    
    /**
     * Gets all valid routes for given line id, including the sequence of stops on each route.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineRouteSequenceTest() throws ApiException {
        String id = null;
        String direction = null;
        List<String> serviceTypes = null;
        Boolean excludeCrowding = null;
        RouteSequence response = api.lineRouteSequence(id, direction, serviceTypes, excludeCrowding);

        // TODO: test validations
    }
    
    /**
     * Search for lines or routes matching the query string
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineSearchTest() throws ApiException {
        String query = null;
        List<String> modes = null;
        List<String> serviceTypes = null;
        RouteSearchResponse response = api.lineSearch(query, modes, serviceTypes);

        // TODO: test validations
    }
    
    /**
     * Gets the line status for given line ids during the provided dates e.g Minor Delays
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineStatusTest() throws ApiException {
        List<String> ids = null;
        String startDate = null;
        String endDate = null;
        Boolean detail = null;
        OffsetDateTime dateRangeStartDate = null;
        OffsetDateTime dateRangeEndDate = null;
        List<Line> response = api.lineStatus(ids, startDate, endDate, detail, dateRangeStartDate, dateRangeEndDate);

        // TODO: test validations
    }
    
    /**
     * Gets the line status of for given line ids e.g Minor Delays
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineStatusByIdsTest() throws ApiException {
        List<String> ids = null;
        Boolean detail = null;
        List<Line> response = api.lineStatusByIds(ids, detail);

        // TODO: test validations
    }
    
    /**
     * Gets the line status of for all lines for the given modes
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineStatusByModeTest() throws ApiException {
        List<String> modes = null;
        Boolean detail = null;
        List<Line> response = api.lineStatusByMode(modes, detail);

        // TODO: test validations
    }
    
    /**
     * Gets the line status for all lines with a given severity              A list of valid severity codes can be obtained from a call to Line/Meta/Severity
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineStatusBySeverityTest() throws ApiException {
        Integer severity = null;
        List<Line> response = api.lineStatusBySeverity(severity);

        // TODO: test validations
    }
    
    /**
     * Gets a list of the stations that serve the given line id
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineStopPointsTest() throws ApiException {
        String id = null;
        Boolean tflOperatedNationalRailStationsOnly = null;
        List<StopPoint> response = api.lineStopPoints(id, tflOperatedNationalRailStationsOnly);

        // TODO: test validations
    }
    
    /**
     * Gets the timetable for a specified station on the give line
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineTimetableTest() throws ApiException {
        String fromStopPointId = null;
        String id = null;
        TimetableResponse response = api.lineTimetable(fromStopPointId, id);

        // TODO: test validations
    }
    
    /**
     * Gets the timetable for a specified station on the give line with specified destination
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void lineTimetableToTest() throws ApiException {
        String fromStopPointId = null;
        String id = null;
        String toStopPointId = null;
        TimetableResponse response = api.lineTimetableTo(fromStopPointId, id, toStopPointId);

        // TODO: test validations
    }
    
}
