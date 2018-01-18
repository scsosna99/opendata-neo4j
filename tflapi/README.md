# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import uk.gov.tfl.api.client.client.*;
import uk.gov.tfl.api.client.client.auth.*;
import uk.gov.tfl.api.client.client.model.*;
import uk.gov.tfl.api.client.client.api.AccidentStatsApi;

import java.io.File;
import java.util.*;

public class AccidentStatsApiExample {

    public static void main(String[] args) {
        
        AccidentStatsApi apiInstance = new AccidentStatsApi();
        Integer year = 56; // Integer | The year for which to filter the accidents on.
        try {
            List<AccidentDetail> result = apiInstance.accidentStatsGet(year);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccidentStatsApi#accidentStatsGet");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.tfl.gov.uk*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccidentStatsApi* | [**accidentStatsGet**](docs/AccidentStatsApi.md#accidentStatsGet) | **GET** /AccidentStats/{year} | Gets all accident details for accidents occuring in the specified year
*AirQualityApi* | [**airQualityGet**](docs/AirQualityApi.md#airQualityGet) | **GET** /AirQuality | Gets air quality data feed
*BikePointApi* | [**bikePointGet**](docs/BikePointApi.md#bikePointGet) | **GET** /BikePoint/{id} | Gets the bike point with the given id.
*BikePointApi* | [**bikePointGetAll**](docs/BikePointApi.md#bikePointGetAll) | **GET** /BikePoint | Gets all bike point locations. The Place object has an addtionalProperties array which contains the nbBikes, nbDocks and nbSpaces              numbers which give the status of the BikePoint. A mismatch in these numbers i.e. nbDocks - (nbBikes + nbSpaces) !&#x3D; 0 indicates broken docks.
*BikePointApi* | [**bikePointSearch**](docs/BikePointApi.md#bikePointSearch) | **GET** /BikePoint/Search | Search for bike stations by their name, a bike point&#39;s name often contains information about the name of the street              or nearby landmarks, for example. Note that the search result does not contain the PlaceProperties i.e. the status              or occupancy of the BikePoint, to get that information you should retrieve the BikePoint by its id on /BikePoint/id.
*CabwiseApi* | [**cabwiseGet**](docs/CabwiseApi.md#cabwiseGet) | **GET** /Cabwise/search | Gets taxis and minicabs contact information
*JourneyApi* | [**journeyJourneyResults**](docs/JourneyApi.md#journeyJourneyResults) | **GET** /Journey/JourneyResults/{from}/to/{to} | Perform a Journey Planner search from the parameters specified in simple types
*JourneyApi* | [**journeyMeta**](docs/JourneyApi.md#journeyMeta) | **GET** /Journey/Meta/Modes | Gets a list of all of the available journey planner modes
*LineApi* | [**lineArrivals**](docs/LineApi.md#lineArrivals) | **GET** /Line/{ids}/Arrivals/{stopPointId} | Get the list of arrival predictions for given lineId ids based at the given stop
*LineApi* | [**lineDisruption**](docs/LineApi.md#lineDisruption) | **GET** /Line/{ids}/Disruption | Get disruptions for the given lineId ids
*LineApi* | [**lineDisruptionByMode**](docs/LineApi.md#lineDisruptionByMode) | **GET** /Line/Mode/{modes}/Disruption | Get disruptions for all lines of the given modes.
*LineApi* | [**lineGet**](docs/LineApi.md#lineGet) | **GET** /Line/{ids} | Gets lines that match the specified lineId ids.
*LineApi* | [**lineGetByMode**](docs/LineApi.md#lineGetByMode) | **GET** /Line/Mode/{modes} | Gets lines that serve the given modes.
*LineApi* | [**lineLineRoutesByIds**](docs/LineApi.md#lineLineRoutesByIds) | **GET** /Line/{ids}/Route | Get all valid routes for given lineId ids, including the name and id of the originating and terminating stops for each route.
*LineApi* | [**lineMetaDisruptionCategories**](docs/LineApi.md#lineMetaDisruptionCategories) | **GET** /Line/Meta/DisruptionCategories | Gets a list of valid disruption categories
*LineApi* | [**lineMetaModes**](docs/LineApi.md#lineMetaModes) | **GET** /Line/Meta/Modes | Gets a list of valid modes
*LineApi* | [**lineMetaServiceTypes**](docs/LineApi.md#lineMetaServiceTypes) | **GET** /Line/Meta/ServiceTypes | Gets a list of valid ServiceTypes to filter on
*LineApi* | [**lineMetaSeverity**](docs/LineApi.md#lineMetaSeverity) | **GET** /Line/Meta/Severity | Gets a list of valid severity codes
*LineApi* | [**lineRoute**](docs/LineApi.md#lineRoute) | **GET** /Line/Route | Get all valid routes for all lines, including the name and id of the originating and terminating stops for each route.
*LineApi* | [**lineRouteByMode**](docs/LineApi.md#lineRouteByMode) | **GET** /Line/Mode/{modes}/Route | Gets all lines and their valid routes for given modes, including the name and id of the originating and terminating stops for each route
*LineApi* | [**lineRouteSequence**](docs/LineApi.md#lineRouteSequence) | **GET** /Line/{id}/Route/Sequence/{direction} | Gets all valid routes for given lineId id, including the sequence of stops on each route.
*LineApi* | [**lineSearch**](docs/LineApi.md#lineSearch) | **GET** /Line/Search/{query} | Search for lines or routes matching the query string
*LineApi* | [**lineStatus**](docs/LineApi.md#lineStatus) | **GET** /Line/{ids}/Status/{StartDate}/to/{EndDate} | Gets the lineId status for given lineId ids during the provided dates e.g Minor Delays
*LineApi* | [**lineStatusByIds**](docs/LineApi.md#lineStatusByIds) | **GET** /Line/{ids}/Status | Gets the lineId status of for given lineId ids e.g Minor Delays
*LineApi* | [**lineStatusByMode**](docs/LineApi.md#lineStatusByMode) | **GET** /Line/Mode/{modes}/Status | Gets the lineId status of for all lines for the given modes
*LineApi* | [**lineStatusBySeverity**](docs/LineApi.md#lineStatusBySeverity) | **GET** /Line/Status/{severity} | Gets the lineId status for all lines with a given severity              A list of valid severity codes can be obtained from a call to Line/Meta/Severity
*LineApi* | [**lineStopPoints**](docs/LineApi.md#lineStopPoints) | **GET** /Line/{id}/StopPoints | Gets a list of the stations that serve the given lineId id
*LineApi* | [**lineTimetable**](docs/LineApi.md#lineTimetable) | **GET** /Line/{id}/Timetable/{fromStopPointId} | Gets the timetable for a specified station on the give lineId
*LineApi* | [**lineTimetableTo**](docs/LineApi.md#lineTimetableTo) | **GET** /Line/{id}/Timetable/{fromStopPointId}/to/{toStopPointId} | Gets the timetable for a specified station on the give lineId with specified destination
*ModeApi* | [**modeArrivals**](docs/ModeApi.md#modeArrivals) | **GET** /Mode/{mode}/Arrivals | Gets the next arrival predictions for all stops of a given mode
*ModeApi* | [**modeGetActiveServiceTypes**](docs/ModeApi.md#modeGetActiveServiceTypes) | **GET** /Mode/ActiveServiceTypes | Returns the service type active for a mode.              Currently only supports tube
*OccupancyApi* | [**occupancyGet**](docs/OccupancyApi.md#occupancyGet) | **GET** /Occupancy/CarPark/{id} | Gets the occupancy for a car park with a given id
*OccupancyApi* | [**occupancyGetAllChargeConnectorStatus**](docs/OccupancyApi.md#occupancyGetAllChargeConnectorStatus) | **GET** /Occupancy/ChargeConnector | Gets the occupancy for all charge connectors
*OccupancyApi* | [**occupancyGetBikePointsOccupancies**](docs/OccupancyApi.md#occupancyGetBikePointsOccupancies) | **GET** /Occupancy/BikePoints/{ids} | Get the occupancy for bike points.
*OccupancyApi* | [**occupancyGetChargeConnectorStatus**](docs/OccupancyApi.md#occupancyGetChargeConnectorStatus) | **GET** /Occupancy/ChargeConnector/{ids} | Gets the occupancy for a charge connectors with a given id (sourceSystemPlaceId)
*OccupancyApi* | [**occupancyGet_0**](docs/OccupancyApi.md#occupancyGet_0) | **GET** /Occupancy/CarPark | Gets the occupancy for all car parks that have occupancy data
*PlaceApi* | [**placeGet**](docs/PlaceApi.md#placeGet) | **GET** /Place/{id} | Gets the place with the given id.
*PlaceApi* | [**placeGetAt**](docs/PlaceApi.md#placeGetAt) | **GET** /Place/{type}/At/{Lat}/{Lon} | Gets any places of the given type whose geography intersects the given latitude and longitude. In practice this means the Place              must be polygonal e.g. a BoroughBoundary.
*PlaceApi* | [**placeGetByGeoBox**](docs/PlaceApi.md#placeGetByGeoBox) | **GET** /Place | Gets the places that lie within the bounding box defined by the lat/lon of its north-west and south-east corners. Optionally filters              on type and can strip properties for a smaller payload.
*PlaceApi* | [**placeGetByType**](docs/PlaceApi.md#placeGetByType) | **GET** /Place/Type/{types} | Gets all places of a given type
*PlaceApi* | [**placeGetOverlay**](docs/PlaceApi.md#placeGetOverlay) | **GET** /Place/{type}/overlay/{z}/{Lat}/{Lon}/{width}/{height} | Gets the place overlay for a given set of co-ordinates and a given width/height.
*PlaceApi* | [**placeGetStreetsByPostCode**](docs/PlaceApi.md#placeGetStreetsByPostCode) | **GET** /Place/Address/Streets/{Postcode} | Gets the set of streets associated with a post code.
*PlaceApi* | [**placeMetaCategories**](docs/PlaceApi.md#placeMetaCategories) | **GET** /Place/Meta/Categories | Gets a list of all of the available place property categories and keys.
*PlaceApi* | [**placeMetaPlaceTypes**](docs/PlaceApi.md#placeMetaPlaceTypes) | **GET** /Place/Meta/PlaceTypes | Gets a list of the available types of Place.
*PlaceApi* | [**placeSearch**](docs/PlaceApi.md#placeSearch) | **GET** /Place/Search | Gets all places that matches the given query
*RoadApi* | [**roadDisruptedStreets**](docs/RoadApi.md#roadDisruptedStreets) | **GET** /Road/all/Street/Disruption | Gets a list of disrupted streets. If no date filters are provided, current disruptions are returned.
*RoadApi* | [**roadDisruption**](docs/RoadApi.md#roadDisruption) | **GET** /Road/{ids}/Disruption | Get active disruptions, filtered by road ids
*RoadApi* | [**roadDisruptionById**](docs/RoadApi.md#roadDisruptionById) | **GET** /Road/all/Disruption/{disruptionIds} | Gets a list of active disruptions filtered by disruption Ids.
*RoadApi* | [**roadGet**](docs/RoadApi.md#roadGet) | **GET** /Road | Gets all roads managed by TfL
*RoadApi* | [**roadGet_0**](docs/RoadApi.md#roadGet_0) | **GET** /Road/{ids} | Gets the road with the specified id (e.g. A1)
*RoadApi* | [**roadMetaCategories**](docs/RoadApi.md#roadMetaCategories) | **GET** /Road/Meta/Categories | Gets a list of valid RoadDisruption categories
*RoadApi* | [**roadMetaSeverities**](docs/RoadApi.md#roadMetaSeverities) | **GET** /Road/Meta/Severities | Gets a list of valid RoadDisruption severity codes
*RoadApi* | [**roadStatus**](docs/RoadApi.md#roadStatus) | **GET** /Road/{ids}/Status | Gets the specified roads with the status aggregated over the date range specified, or now until the end of today if no dates are passed.
*SearchApi* | [**searchBusSchedules**](docs/SearchApi.md#searchBusSchedules) | **GET** /Search/BusSchedules | Searches the bus schedules folder on S3 for a given bus number.
*SearchApi* | [**searchGet**](docs/SearchApi.md#searchGet) | **GET** /Search | Search the site for occurrences of the query string. The maximum number of results returned is equal to the maximum page size              of 100. To return subsequent pages, use the paginated overload.
*SearchApi* | [**searchMetaCategories**](docs/SearchApi.md#searchMetaCategories) | **GET** /Search/Meta/Categories | Gets the available search categories.
*SearchApi* | [**searchMetaSearchProviders**](docs/SearchApi.md#searchMetaSearchProviders) | **GET** /Search/Meta/SearchProviders | Gets the available searchProvider names.
*SearchApi* | [**searchMetaSorts**](docs/SearchApi.md#searchMetaSorts) | **GET** /Search/Meta/Sorts | Gets the available sorting options.
*StopPointApi* | [**stopPointArrivals**](docs/StopPointApi.md#stopPointArrivals) | **GET** /StopPoint/{id}/Arrivals | Gets the list of arrival predictions for the given stop point id
*StopPointApi* | [**stopPointCrowding**](docs/StopPointApi.md#stopPointCrowding) | **GET** /StopPoint/{id}/Crowding/{lineId} | Gets all the Crowding data (static) for the StopPointId, plus crowding data for a given lineId and optionally a particular direction.
*StopPointApi* | [**stopPointDirection**](docs/StopPointApi.md#stopPointDirection) | **GET** /StopPoint/{id}/DirectionTo/{toStopPointId} | Returns the canonical direction, \&quot;inbound\&quot; or \&quot;outbound\&quot;, for a given pair of stop point Ids in the direction from -&amp;gt; to.
*StopPointApi* | [**stopPointDisruption**](docs/StopPointApi.md#stopPointDisruption) | **GET** /StopPoint/{ids}/Disruption | Gets all disruptions for the specified StopPointId, plus disruptions for any child Naptan records it may have.
*StopPointApi* | [**stopPointDisruptionByMode**](docs/StopPointApi.md#stopPointDisruptionByMode) | **GET** /StopPoint/Mode/{modes}/Disruption | Gets a distinct list of disrupted stop points for the given modes
*StopPointApi* | [**stopPointGet**](docs/StopPointApi.md#stopPointGet) | **GET** /StopPoint/{ids} | Gets a list of StopPoints corresponding to the given list of stop ids.
*StopPointApi* | [**stopPointGetByGeoPoint**](docs/StopPointApi.md#stopPointGetByGeoPoint) | **GET** /StopPoint | Gets a list of StopPoints within {radius} by the specified criteria
*StopPointApi* | [**stopPointGetByMode**](docs/StopPointApi.md#stopPointGetByMode) | **GET** /StopPoint/Mode/{modes} | Gets a list of StopPoints filtered by the modes available at that StopPoint.
*StopPointApi* | [**stopPointGetBySms**](docs/StopPointApi.md#stopPointGetBySms) | **GET** /StopPoint/Sms/{id} | Gets a StopPoint for a given sms code.
*StopPointApi* | [**stopPointGetByType**](docs/StopPointApi.md#stopPointGetByType) | **GET** /StopPoint/Type/{types} | Gets all stop points of a given type
*StopPointApi* | [**stopPointGetCarParksById**](docs/StopPointApi.md#stopPointGetCarParksById) | **GET** /StopPoint/{stopPointId}/CarParks | Get car parks corresponding to the given stop point id.
*StopPointApi* | [**stopPointGetServiceTypes**](docs/StopPointApi.md#stopPointGetServiceTypes) | **GET** /StopPoint/ServiceTypes | Gets the service types for a given stoppoint
*StopPointApi* | [**stopPointGetTaxiRanksByIds**](docs/StopPointApi.md#stopPointGetTaxiRanksByIds) | **GET** /StopPoint/{stopPointId}/TaxiRanks | Gets a list of taxi ranks corresponding to the given stop point id.
*StopPointApi* | [**stopPointGet_0**](docs/StopPointApi.md#stopPointGet_0) | **GET** /StopPoint/{id}/placeTypes | Get a list of places corresponding to a given id and place types.
*StopPointApi* | [**stopPointMetaCategories**](docs/StopPointApi.md#stopPointMetaCategories) | **GET** /StopPoint/Meta/Categories | Gets the list of available StopPoint additional information categories
*StopPointApi* | [**stopPointMetaModes**](docs/StopPointApi.md#stopPointMetaModes) | **GET** /StopPoint/Meta/Modes | Gets the list of available StopPoint modes
*StopPointApi* | [**stopPointMetaStopTypes**](docs/StopPointApi.md#stopPointMetaStopTypes) | **GET** /StopPoint/Meta/StopTypes | Gets the list of available StopPoint types
*StopPointApi* | [**stopPointReachableFrom**](docs/StopPointApi.md#stopPointReachableFrom) | **GET** /StopPoint/{id}/CanReachOnLine/{lineId} | Gets Stopoints that are reachable from a station/lineId combination.
*StopPointApi* | [**stopPointRoute**](docs/StopPointApi.md#stopPointRoute) | **GET** /StopPoint/{id}/Route | Returns the route sections for all the lines that service the given stop point ids
*StopPointApi* | [**stopPointSearch**](docs/StopPointApi.md#stopPointSearch) | **GET** /StopPoint/Search | Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.
*StopPointApi* | [**stopPointSearch_0**](docs/StopPointApi.md#stopPointSearch_0) | **GET** /StopPoint/Search/{query} | Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.
*TravelTimeApi* | [**travelTimeGetCompareOverlay**](docs/TravelTimeApi.md#travelTimeGetCompareOverlay) | **GET** /TravelTimes/compareOverlay/{z}/mapcenter/{mapCenterLat}/{mapCenterLon}/pinlocation/{pinLat}/{pinLon}/dimensions/{width}/{height} | Gets the TravelTime overlay.
*TravelTimeApi* | [**travelTimeGetOverlay**](docs/TravelTimeApi.md#travelTimeGetOverlay) | **GET** /TravelTimes/overlay/{z}/mapcenter/{mapCenterLat}/{mapCenterLon}/pinlocation/{pinLat}/{pinLon}/dimensions/{width}/{height} | Gets the TravelTime overlay.
*VehicleApi* | [**vehicleGet**](docs/VehicleApi.md#vehicleGet) | **GET** /Vehicle/{ids}/Arrivals | Gets the predictions for a given list of vehicle Id&#39;s.
*VehicleApi* | [**vehicleGetEmissionsSurchargeCompliance**](docs/VehicleApi.md#vehicleGetEmissionsSurchargeCompliance) | **GET** /Vehicle/EmissionSurcharge | Gets the Emissions Surcharge compliance for the Vehicle
*VehicleApi* | [**vehicleGetUlezCompliance**](docs/VehicleApi.md#vehicleGetUlezCompliance) | **GET** /Vehicle/UlezCompliance | Gets the Ulez Surcharge compliance for the Vehicle


## Documentation for Models

 - [AccidentDetail](docs/AccidentDetail.md)
 - [AccidentStatsOrderedSummary](docs/AccidentStatsOrderedSummary.md)
 - [ActiveServiceType](docs/ActiveServiceType.md)
 - [AdditionalProperties](docs/AdditionalProperties.md)
 - [ApiVersionInfo](docs/ApiVersionInfo.md)
 - [Bay](docs/Bay.md)
 - [BikePointOccupancy](docs/BikePointOccupancy.md)
 - [CarParkOccupancy](docs/CarParkOccupancy.md)
 - [Casualty](docs/Casualty.md)
 - [ChargeConnectorOccupancy](docs/ChargeConnectorOccupancy.md)
 - [Coordinate](docs/Coordinate.md)
 - [Crowding](docs/Crowding.md)
 - [CycleSuperhighway](docs/CycleSuperhighway.md)
 - [DateRange](docs/DateRange.md)
 - [DateRangeNullable](docs/DateRangeNullable.md)
 - [DbGeography](docs/DbGeography.md)
 - [DbGeographyWellKnownValue](docs/DbGeographyWellKnownValue.md)
 - [Disambiguation](docs/Disambiguation.md)
 - [DisambiguationOption](docs/DisambiguationOption.md)
 - [DisruptedPoint](docs/DisruptedPoint.md)
 - [Disruption](docs/Disruption.md)
 - [Fare](docs/Fare.md)
 - [FareBounds](docs/FareBounds.md)
 - [FareDetails](docs/FareDetails.md)
 - [FaresMode](docs/FaresMode.md)
 - [FaresPeriod](docs/FaresPeriod.md)
 - [FaresSection](docs/FaresSection.md)
 - [GeoCodeSearchMatch](docs/GeoCodeSearchMatch.md)
 - [GeoPoint](docs/GeoPoint.md)
 - [GeoPointBBox](docs/GeoPointBBox.md)
 - [Identifier](docs/Identifier.md)
 - [Instruction](docs/Instruction.md)
 - [InstructionStep](docs/InstructionStep.md)
 - [Interval](docs/Interval.md)
 - [ItineraryResult](docs/ItineraryResult.md)
 - [Journey](docs/Journey.md)
 - [JourneyPlannerCycleHireDockingStationData](docs/JourneyPlannerCycleHireDockingStationData.md)
 - [JourneyVector](docs/JourneyVector.md)
 - [JpElevation](docs/JpElevation.md)
 - [KnownJourney](docs/KnownJourney.md)
 - [Leg](docs/Leg.md)
 - [Line](docs/Line.md)
 - [LineGroup](docs/LineGroup.md)
 - [LineModeGroup](docs/LineModeGroup.md)
 - [LineRouteSection](docs/LineRouteSection.md)
 - [LineServiceType](docs/LineServiceType.md)
 - [LineServiceTypeInfo](docs/LineServiceTypeInfo.md)
 - [LineSpecificServiceType](docs/LineSpecificServiceType.md)
 - [LineStatus](docs/LineStatus.md)
 - [MatchedRoute](docs/MatchedRoute.md)
 - [MatchedRouteSections](docs/MatchedRouteSections.md)
 - [MatchedStop](docs/MatchedStop.md)
 - [Message](docs/Message.md)
 - [Mode](docs/Mode.md)
 - [Object](docs/Object.md)
 - [Obstacle](docs/Obstacle.md)
 - [OrderedRoute](docs/OrderedRoute.md)
 - [PassengerFlow](docs/PassengerFlow.md)
 - [PassengerType](docs/PassengerType.md)
 - [Path](docs/Path.md)
 - [PathAttribute](docs/PathAttribute.md)
 - [Period](docs/Period.md)
 - [Place](docs/Place.md)
 - [PlaceCategory](docs/PlaceCategory.md)
 - [PlacePolygon](docs/PlacePolygon.md)
 - [PlannedWork](docs/PlannedWork.md)
 - [Point](docs/Point.md)
 - [PostcodeInput](docs/PostcodeInput.md)
 - [Prediction](docs/Prediction.md)
 - [PredictionTiming](docs/PredictionTiming.md)
 - [Recommendation](docs/Recommendation.md)
 - [RecommendationResponse](docs/RecommendationResponse.md)
 - [Redirect](docs/Redirect.md)
 - [RoadCorridor](docs/RoadCorridor.md)
 - [RoadDisruption](docs/RoadDisruption.md)
 - [RoadDisruptionImpactArea](docs/RoadDisruptionImpactArea.md)
 - [RoadDisruptionLine](docs/RoadDisruptionLine.md)
 - [RoadDisruptionSchedule](docs/RoadDisruptionSchedule.md)
 - [RoadProject](docs/RoadProject.md)
 - [RouteOption](docs/RouteOption.md)
 - [RouteSearchMatch](docs/RouteSearchMatch.md)
 - [RouteSearchResponse](docs/RouteSearchResponse.md)
 - [RouteSection](docs/RouteSection.md)
 - [RouteSectionNaptanEntrySequence](docs/RouteSectionNaptanEntrySequence.md)
 - [RouteSequence](docs/RouteSequence.md)
 - [Schedule](docs/Schedule.md)
 - [SearchCriteria](docs/SearchCriteria.md)
 - [SearchMatch](docs/SearchMatch.md)
 - [SearchResponse](docs/SearchResponse.md)
 - [ServiceFrequency](docs/ServiceFrequency.md)
 - [StationInterval](docs/StationInterval.md)
 - [StatusSeverity](docs/StatusSeverity.md)
 - [StopPoint](docs/StopPoint.md)
 - [StopPointCategory](docs/StopPointCategory.md)
 - [StopPointRouteSection](docs/StopPointRouteSection.md)
 - [StopPointSequence](docs/StopPointSequence.md)
 - [StopPointsResponse](docs/StopPointsResponse.md)
 - [Street](docs/Street.md)
 - [StreetSegment](docs/StreetSegment.md)
 - [Ticket](docs/Ticket.md)
 - [TicketTime](docs/TicketTime.md)
 - [TicketType](docs/TicketType.md)
 - [TimeAdjustment](docs/TimeAdjustment.md)
 - [TimeAdjustments](docs/TimeAdjustments.md)
 - [Timetable](docs/Timetable.md)
 - [TimetableResponse](docs/TimetableResponse.md)
 - [TimetableRoute](docs/TimetableRoute.md)
 - [TrainLoading](docs/TrainLoading.md)
 - [TwentyFourHourClockTime](docs/TwentyFourHourClockTime.md)
 - [ValidityPeriod](docs/ValidityPeriod.md)
 - [Vehicle](docs/Vehicle.md)
 - [VehicleMatch](docs/VehicleMatch.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKey

- **Type**: API key
- **API key parameter name**: app_key
- **Location**: URL query string

### appId

- **Type**: API key
- **API key parameter name**: app_id
- **Location**: URL query string


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



