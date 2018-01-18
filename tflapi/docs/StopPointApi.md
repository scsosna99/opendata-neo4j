# StopPointApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**stopPointArrivals**](StopPointApi.md#stopPointArrivals) | **GET** /StopPoint/{id}/Arrivals | Gets the list of arrival predictions for the given stop point id
[**stopPointCrowding**](StopPointApi.md#stopPointCrowding) | **GET** /StopPoint/{id}/Crowding/{lineId} | Gets all the Crowding data (static) for the StopPointId, plus crowding data for a given lineId and optionally a particular direction.
[**stopPointDirection**](StopPointApi.md#stopPointDirection) | **GET** /StopPoint/{id}/DirectionTo/{toStopPointId} | Returns the canonical direction, \&quot;inbound\&quot; or \&quot;outbound\&quot;, for a given pair of stop point Ids in the direction from -&amp;gt; to.
[**stopPointDisruption**](StopPointApi.md#stopPointDisruption) | **GET** /StopPoint/{ids}/Disruption | Gets all disruptions for the specified StopPointId, plus disruptions for any child Naptan records it may have.
[**stopPointDisruptionByMode**](StopPointApi.md#stopPointDisruptionByMode) | **GET** /StopPoint/Mode/{modes}/Disruption | Gets a distinct list of disrupted stop points for the given modes
[**stopPointGet**](StopPointApi.md#stopPointGet) | **GET** /StopPoint/{ids} | Gets a list of StopPoints corresponding to the given list of stop ids.
[**stopPointGetByGeoPoint**](StopPointApi.md#stopPointGetByGeoPoint) | **GET** /StopPoint | Gets a list of StopPoints within {radius} by the specified criteria
[**stopPointGetByMode**](StopPointApi.md#stopPointGetByMode) | **GET** /StopPoint/Mode/{modes} | Gets a list of StopPoints filtered by the modes available at that StopPoint.
[**stopPointGetBySms**](StopPointApi.md#stopPointGetBySms) | **GET** /StopPoint/Sms/{id} | Gets a StopPoint for a given sms code.
[**stopPointGetByType**](StopPointApi.md#stopPointGetByType) | **GET** /StopPoint/Type/{types} | Gets all stop points of a given type
[**stopPointGetCarParksById**](StopPointApi.md#stopPointGetCarParksById) | **GET** /StopPoint/{stopPointId}/CarParks | Get car parks corresponding to the given stop point id.
[**stopPointGetServiceTypes**](StopPointApi.md#stopPointGetServiceTypes) | **GET** /StopPoint/ServiceTypes | Gets the service types for a given stoppoint
[**stopPointGetTaxiRanksByIds**](StopPointApi.md#stopPointGetTaxiRanksByIds) | **GET** /StopPoint/{stopPointId}/TaxiRanks | Gets a list of taxi ranks corresponding to the given stop point id.
[**stopPointGet_0**](StopPointApi.md#stopPointGet_0) | **GET** /StopPoint/{id}/placeTypes | Get a list of places corresponding to a given id and place types.
[**stopPointMetaCategories**](StopPointApi.md#stopPointMetaCategories) | **GET** /StopPoint/Meta/Categories | Gets the list of available StopPoint additional information categories
[**stopPointMetaModes**](StopPointApi.md#stopPointMetaModes) | **GET** /StopPoint/Meta/Modes | Gets the list of available StopPoint modes
[**stopPointMetaStopTypes**](StopPointApi.md#stopPointMetaStopTypes) | **GET** /StopPoint/Meta/StopTypes | Gets the list of available StopPoint types
[**stopPointReachableFrom**](StopPointApi.md#stopPointReachableFrom) | **GET** /StopPoint/{id}/CanReachOnLine/{lineId} | Gets Stopoints that are reachable from a station/lineId combination.
[**stopPointRoute**](StopPointApi.md#stopPointRoute) | **GET** /StopPoint/{id}/Route | Returns the route sections for all the lines that service the given stop point ids
[**stopPointSearch**](StopPointApi.md#stopPointSearch) | **GET** /StopPoint/Search | Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.
[**stopPointSearch_0**](StopPointApi.md#stopPointSearch_0) | **GET** /StopPoint/Search/{query} | Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.


<a name="stopPointArrivals"></a>
# **stopPointArrivals**
> List&lt;Prediction&gt; stopPointArrivals(id)

Gets the list of arrival predictions for the given stop point id

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | A StopPoint id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
try {
    List<Prediction> result = apiInstance.stopPointArrivals(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointArrivals");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A StopPoint id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |

### Return type

[**List&lt;Prediction&gt;**](Prediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointCrowding"></a>
# **stopPointCrowding**
> List&lt;StopPoint&gt; stopPointCrowding(id, lineId, direction)

Gets all the Crowding data (static) for the StopPointId, plus crowding data for a given lineId and optionally a particular direction.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | The Naptan id of the stop
String lineId = "line_example"; // String | A particular lineId e.g. victoria, circle, northern etc.
String direction = "direction_example"; // String | The direction of travel. Can be inbound or outbound.
try {
    List<StopPoint> result = apiInstance.stopPointCrowding(id, lineId, direction);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointCrowding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The Naptan id of the stop |
 **lineId** | **String**| A particular lineId e.g. victoria, circle, northern etc. |
 **direction** | **String**| The direction of travel. Can be inbound or outbound. | [enum: inbound, outbound, all]

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointDirection"></a>
# **stopPointDirection**
> String stopPointDirection(id, toStopPointId, lineId)

Returns the canonical direction, \&quot;inbound\&quot; or \&quot;outbound\&quot;, for a given pair of stop point Ids in the direction from -&amp;gt; to.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | Originating stop id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
String toStopPointId = "toStopPointId_example"; // String | Destination stop id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
String lineId = "lineId_example"; // String | Optional lineId id filter e.g. victoria
try {
    String result = apiInstance.stopPointDirection(id, toStopPointId, lineId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointDirection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Originating stop id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **toStopPointId** | **String**| Destination stop id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **lineId** | **String**| Optional lineId id filter e.g. victoria | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointDisruption"></a>
# **stopPointDisruption**
> List&lt;DisruptedPoint&gt; stopPointDisruption(ids, getFamily, includeRouteBlockedStops, flattenResponse)

Gets all disruptions for the specified StopPointId, plus disruptions for any child Naptan records it may have.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-seperated list of stop point ids. Max. approx. 20 ids.              You can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name.
Boolean getFamily = true; // Boolean | Specify true to return disruptions for entire family, or false to return disruptions for just this stop point. Defaults to false.
Boolean includeRouteBlockedStops = true; // Boolean | 
Boolean flattenResponse = true; // Boolean | Specify true to associate all disruptions with parent stop point. (Only applicable when getFamily is true).
try {
    List<DisruptedPoint> result = apiInstance.stopPointDisruption(ids, getFamily, includeRouteBlockedStops, flattenResponse);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointDisruption");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-seperated list of stop point ids. Max. approx. 20 ids.              You can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name. |
 **getFamily** | **Boolean**| Specify true to return disruptions for entire family, or false to return disruptions for just this stop point. Defaults to false. | [optional]
 **includeRouteBlockedStops** | **Boolean**|  | [optional]
 **flattenResponse** | **Boolean**| Specify true to associate all disruptions with parent stop point. (Only applicable when getFamily is true). | [optional]

### Return type

[**List&lt;DisruptedPoint&gt;**](DisruptedPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointDisruptionByMode"></a>
# **stopPointDisruptionByMode**
> List&lt;DisruptedPoint&gt; stopPointDisruptionByMode(modes, includeRouteBlockedStops)

Gets a distinct list of disrupted stop points for the given modes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-seperated list of modes e.g. tube,dlr
Boolean includeRouteBlockedStops = true; // Boolean | 
try {
    List<DisruptedPoint> result = apiInstance.stopPointDisruptionByMode(modes, includeRouteBlockedStops);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointDisruptionByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-seperated list of modes e.g. tube,dlr |
 **includeRouteBlockedStops** | **Boolean**|  | [optional]

### Return type

[**List&lt;DisruptedPoint&gt;**](DisruptedPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGet"></a>
# **stopPointGet**
> List&lt;StopPoint&gt; stopPointGet(ids, includeCrowdingData)

Gets a list of StopPoints corresponding to the given list of stop ids.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of stop point ids (station naptan code e.g. 940GZZLUASL). Max. approx. 20 ids.              You can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name.
Boolean includeCrowdingData = true; // Boolean | Include the crowding data (static). To Filter further use: /StopPoint/{ids}/Crowding/{lineId}
try {
    List<StopPoint> result = apiInstance.stopPointGet(ids, includeCrowdingData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of stop point ids (station naptan code e.g. 940GZZLUASL). Max. approx. 20 ids.              You can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name. |
 **includeCrowdingData** | **Boolean**| Include the crowding data (static). To Filter further use: /StopPoint/{ids}/Crowding/{lineId} | [optional]

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetByGeoPoint"></a>
# **stopPointGetByGeoPoint**
> StopPointsResponse stopPointGetByGeoPoint(stopTypes, locationLat, locationLon, radius, useStopPointHierarchy, modes, categories, returnLines)

Gets a list of StopPoints within {radius} by the specified criteria

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> stopTypes = Arrays.asList("stopTypes_example"); // List<String> | a list of stopTypes that should be returned (a list of valid stop types can be obtained from the StopPoint/meta/stoptypes endpoint)
Double locationLat = 3.4D; // Double | 
Double locationLon = 3.4D; // Double | 
Integer radius = 56; // Integer | the radius of the bounding circle in metres (default : 200)
Boolean useStopPointHierarchy = true; // Boolean | Re-arrange the output into a parent/child hierarchy
List<String> modes = Arrays.asList("modes_example"); // List<String> | the list of modes to search (comma separated mode names e.g. tube,dlr)
List<String> categories = Arrays.asList("categories_example"); // List<String> | an optional list of comma separated property categories to return in the StopPoint's property bag. If null or empty, all categories of property are returned. Pass the keyword \"none\" to return no properties (a valid list of categories can be obtained from the /StopPoint/Meta/categories endpoint)
Boolean returnLines = true; // Boolean | true to return the lines that each stop point serves as a nested resource
try {
    StopPointsResponse result = apiInstance.stopPointGetByGeoPoint(stopTypes, locationLat, locationLon, radius, useStopPointHierarchy, modes, categories, returnLines);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetByGeoPoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stopTypes** | [**List&lt;String&gt;**](String.md)| a list of stopTypes that should be returned (a list of valid stop types can be obtained from the StopPoint/meta/stoptypes endpoint) |
 **locationLat** | **Double**|  |
 **locationLon** | **Double**|  |
 **radius** | **Integer**| the radius of the bounding circle in metres (default : 200) | [optional]
 **useStopPointHierarchy** | **Boolean**| Re-arrange the output into a parent/child hierarchy | [optional]
 **modes** | [**List&lt;String&gt;**](String.md)| the list of modes to search (comma separated mode names e.g. tube,dlr) | [optional]
 **categories** | [**List&lt;String&gt;**](String.md)| an optional list of comma separated property categories to return in the StopPoint&#39;s property bag. If null or empty, all categories of property are returned. Pass the keyword \&quot;none\&quot; to return no properties (a valid list of categories can be obtained from the /StopPoint/Meta/categories endpoint) | [optional]
 **returnLines** | **Boolean**| true to return the lines that each stop point serves as a nested resource | [optional]

### Return type

[**StopPointsResponse**](StopPointsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetByMode"></a>
# **stopPointGetByMode**
> StopPointsResponse stopPointGetByMode(modes, page)

Gets a list of StopPoints filtered by the modes available at that StopPoint.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-seperated list of modes e.g. tube,dlr
Integer page = 56; // Integer | The data set page to return. Page 1 equates to the first 1000 stop points, page 2 equates to 1001-2000 etc. Must be entered for bus mode as data set is too large.
try {
    StopPointsResponse result = apiInstance.stopPointGetByMode(modes, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-seperated list of modes e.g. tube,dlr |
 **page** | **Integer**| The data set page to return. Page 1 equates to the first 1000 stop points, page 2 equates to 1001-2000 etc. Must be entered for bus mode as data set is too large. | [optional]

### Return type

[**StopPointsResponse**](StopPointsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetBySms"></a>
# **stopPointGetBySms**
> Object stopPointGetBySms(id, output)

Gets a StopPoint for a given sms code.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | A 5-digit Countdown Bus Stop Code e.g. 73241, 50435, 56334.
String output = "output_example"; // String | If set to \"web\", a 302 redirect to relevant website bus stop page is returned. Valid values are : web. All other values are ignored.
try {
    Object result = apiInstance.stopPointGetBySms(id, output);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetBySms");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A 5-digit Countdown Bus Stop Code e.g. 73241, 50435, 56334. |
 **output** | **String**| If set to \&quot;web\&quot;, a 302 redirect to relevant website bus stop page is returned. Valid values are : web. All other values are ignored. | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetByType"></a>
# **stopPointGetByType**
> List&lt;StopPoint&gt; stopPointGetByType(types)

Gets all stop points of a given type

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
List<String> types = Arrays.asList("types_example"); // List<String> | A comma-separated list of the types to return. Max. approx. 12 types.               A list of valid stop types can be obtained from the StopPoint/meta/stoptypes endpoint.
try {
    List<StopPoint> result = apiInstance.stopPointGetByType(types);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetByType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **types** | [**List&lt;String&gt;**](String.md)| A comma-separated list of the types to return. Max. approx. 12 types.               A list of valid stop types can be obtained from the StopPoint/meta/stoptypes endpoint. |

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetCarParksById"></a>
# **stopPointGetCarParksById**
> List&lt;Place&gt; stopPointGetCarParksById(stopPointId)

Get car parks corresponding to the given stop point id.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String stopPointId = "stopPointId_example"; // String | stopPointId is required to get the car parks.
try {
    List<Place> result = apiInstance.stopPointGetCarParksById(stopPointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetCarParksById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stopPointId** | **String**| stopPointId is required to get the car parks. |

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetServiceTypes"></a>
# **stopPointGetServiceTypes**
> List&lt;LineServiceType&gt; stopPointGetServiceTypes(id, lineIds, modes)

Gets the service types for a given stoppoint

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | The Naptan id of the stop
List<String> lineIds = Arrays.asList("lineIds_example"); // List<String> | The lines which contain the given Naptan id (all lines relevant to the given stoppoint if empty)
List<String> modes = Arrays.asList("modes_example"); // List<String> | The modes which the lines are relevant to (all if empty)
try {
    List<LineServiceType> result = apiInstance.stopPointGetServiceTypes(id, lineIds, modes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetServiceTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The Naptan id of the stop |
 **lineIds** | [**List&lt;String&gt;**](String.md)| The lines which contain the given Naptan id (all lines relevant to the given stoppoint if empty) | [optional]
 **modes** | [**List&lt;String&gt;**](String.md)| The modes which the lines are relevant to (all if empty) | [optional]

### Return type

[**List&lt;LineServiceType&gt;**](LineServiceType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGetTaxiRanksByIds"></a>
# **stopPointGetTaxiRanksByIds**
> List&lt;Place&gt; stopPointGetTaxiRanksByIds(stopPointId)

Gets a list of taxi ranks corresponding to the given stop point id.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String stopPointId = "stopPointId_example"; // String | stopPointId is required to get the taxi ranks.
try {
    List<Place> result = apiInstance.stopPointGetTaxiRanksByIds(stopPointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGetTaxiRanksByIds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stopPointId** | **String**| stopPointId is required to get the taxi ranks. |

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointGet_0"></a>
# **stopPointGet_0**
> List&lt;Place&gt; stopPointGet_0(id, placeTypes)

Get a list of places corresponding to a given id and place types.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | A naptan id for a stop point (station naptan code e.g. 940GZZLUASL).
List<String> placeTypes = Arrays.asList("placeTypes_example"); // List<String> | A comcomma-separated value representing the place types.
try {
    List<Place> result = apiInstance.stopPointGet_0(id, placeTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointGet_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A naptan id for a stop point (station naptan code e.g. 940GZZLUASL). |
 **placeTypes** | [**List&lt;String&gt;**](String.md)| A comcomma-separated value representing the place types. |

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointMetaCategories"></a>
# **stopPointMetaCategories**
> List&lt;StopPointCategory&gt; stopPointMetaCategories()

Gets the list of available StopPoint additional information categories

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
try {
    List<StopPointCategory> result = apiInstance.stopPointMetaCategories();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointMetaCategories");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;StopPointCategory&gt;**](StopPointCategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointMetaModes"></a>
# **stopPointMetaModes**
> List&lt;Mode&gt; stopPointMetaModes()

Gets the list of available StopPoint modes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
try {
    List<Mode> result = apiInstance.stopPointMetaModes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointMetaModes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Mode&gt;**](Mode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointMetaStopTypes"></a>
# **stopPointMetaStopTypes**
> List&lt;String&gt; stopPointMetaStopTypes()

Gets the list of available StopPoint types

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
try {
    List<String> result = apiInstance.stopPointMetaStopTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointMetaStopTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointReachableFrom"></a>
# **stopPointReachableFrom**
> List&lt;StopPoint&gt; stopPointReachableFrom(id, lineId, serviceTypes)

Gets Stopoints that are reachable from a station/lineId combination.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | The id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) of the stop point to filter by
String lineId = "lineId_example"; // String | Line id of the lineId to filter by (e.g. victoria)
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma-separated list of service types to filter on. If not specified. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    List<StopPoint> result = apiInstance.stopPointReachableFrom(id, lineId, serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointReachableFrom");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) of the stop point to filter by |
 **lineId** | **String**| Line id of the lineId to filter by (e.g. victoria) |
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of service types to filter on. If not specified. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointRoute"></a>
# **stopPointRoute**
> List&lt;StopPointRouteSection&gt; stopPointRoute(id, serviceTypes)

Returns the route sections for all the lines that service the given stop point ids

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String id = "id_example"; // String | A stop point id (station naptan codes e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma-separated list of service types to filter on. If not specified. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    List<StopPointRouteSection> result = apiInstance.stopPointRoute(id, serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointRoute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A stop point id (station naptan codes e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of service types to filter on. If not specified. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**List&lt;StopPointRouteSection&gt;**](StopPointRouteSection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointSearch"></a>
# **stopPointSearch**
> SearchResponse stopPointSearch(query, modes, faresOnly, maxResults, lines, includeHubs, tflOperatedNationalRailStationsOnly)

Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String query = "query_example"; // String | The query string, case-insensitive. Leading and trailing wildcards are applied automatically.
List<String> modes = Arrays.asList("modes_example"); // List<String> | An optional, parameter separated list of the modes to filter by
Boolean faresOnly = true; // Boolean | True to only return stations in that have Fares data available for single fares to another station.
Integer maxResults = 56; // Integer | An optional result limit, defaulting to and with a maximum of 50. Since children of the stop point heirarchy are returned for matches,              it is possible that the flattened result set will contain more than 50 items.
List<String> lines = Arrays.asList("lines_example"); // List<String> | An optional, parameter separated list of the lines to filter by
Boolean includeHubs = true; // Boolean | If true, returns results including HUBs.
Boolean tflOperatedNationalRailStationsOnly = true; // Boolean | If the national-rail mode is included, this flag will filter the national rail stations so that only those operated by TfL are returned
try {
    SearchResponse result = apiInstance.stopPointSearch(query, modes, faresOnly, maxResults, lines, includeHubs, tflOperatedNationalRailStationsOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The query string, case-insensitive. Leading and trailing wildcards are applied automatically. |
 **modes** | [**List&lt;String&gt;**](String.md)| An optional, parameter separated list of the modes to filter by | [optional]
 **faresOnly** | **Boolean**| True to only return stations in that have Fares data available for single fares to another station. | [optional]
 **maxResults** | **Integer**| An optional result limit, defaulting to and with a maximum of 50. Since children of the stop point heirarchy are returned for matches,              it is possible that the flattened result set will contain more than 50 items. | [optional]
 **lines** | [**List&lt;String&gt;**](String.md)| An optional, parameter separated list of the lines to filter by | [optional]
 **includeHubs** | **Boolean**| If true, returns results including HUBs. | [optional]
 **tflOperatedNationalRailStationsOnly** | **Boolean**| If the national-rail mode is included, this flag will filter the national rail stations so that only those operated by TfL are returned | [optional]

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="stopPointSearch_0"></a>
# **stopPointSearch_0**
> SearchResponse stopPointSearch_0(query, modes, faresOnly, maxResults, lines, includeHubs, tflOperatedNationalRailStationsOnly)

Search StopPoints by their common name, or their 5-digit Countdown Bus Stop Code.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.StopPointApi;


StopPointApi apiInstance = new StopPointApi();
String query = "query_example"; // String | The query string, case-insensitive. Leading and trailing wildcards are applied automatically.
List<String> modes = Arrays.asList("modes_example"); // List<String> | An optional, parameter separated list of the modes to filter by
Boolean faresOnly = true; // Boolean | True to only return stations in that have Fares data available for single fares to another station.
Integer maxResults = 56; // Integer | An optional result limit, defaulting to and with a maximum of 50. Since children of the stop point heirarchy are returned for matches,              it is possible that the flattened result set will contain more than 50 items.
List<String> lines = Arrays.asList("lines_example"); // List<String> | An optional, parameter separated list of the lines to filter by
Boolean includeHubs = true; // Boolean | If true, returns results including HUBs.
Boolean tflOperatedNationalRailStationsOnly = true; // Boolean | If the national-rail mode is included, this flag will filter the national rail stations so that only those operated by TfL are returned
try {
    SearchResponse result = apiInstance.stopPointSearch_0(query, modes, faresOnly, maxResults, lines, includeHubs, tflOperatedNationalRailStationsOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StopPointApi#stopPointSearch_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The query string, case-insensitive. Leading and trailing wildcards are applied automatically. |
 **modes** | [**List&lt;String&gt;**](String.md)| An optional, parameter separated list of the modes to filter by | [optional]
 **faresOnly** | **Boolean**| True to only return stations in that have Fares data available for single fares to another station. | [optional]
 **maxResults** | **Integer**| An optional result limit, defaulting to and with a maximum of 50. Since children of the stop point heirarchy are returned for matches,              it is possible that the flattened result set will contain more than 50 items. | [optional]
 **lines** | [**List&lt;String&gt;**](String.md)| An optional, parameter separated list of the lines to filter by | [optional]
 **includeHubs** | **Boolean**| If true, returns results including HUBs. | [optional]
 **tflOperatedNationalRailStationsOnly** | **Boolean**| If the national-rail mode is included, this flag will filter the national rail stations so that only those operated by TfL are returned | [optional]

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

