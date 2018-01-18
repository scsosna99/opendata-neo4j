# LineApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**lineArrivals**](LineApi.md#lineArrivals) | **GET** /Line/{ids}/Arrivals/{stopPointId} | Get the list of arrival predictions for given lineId ids based at the given stop
[**lineDisruption**](LineApi.md#lineDisruption) | **GET** /Line/{ids}/Disruption | Get disruptions for the given lineId ids
[**lineDisruptionByMode**](LineApi.md#lineDisruptionByMode) | **GET** /Line/Mode/{modes}/Disruption | Get disruptions for all lines of the given modes.
[**lineGet**](LineApi.md#lineGet) | **GET** /Line/{ids} | Gets lines that match the specified lineId ids.
[**lineGetByMode**](LineApi.md#lineGetByMode) | **GET** /Line/Mode/{modes} | Gets lines that serve the given modes.
[**lineLineRoutesByIds**](LineApi.md#lineLineRoutesByIds) | **GET** /Line/{ids}/Route | Get all valid routes for given lineId ids, including the name and id of the originating and terminating stops for each route.
[**lineMetaDisruptionCategories**](LineApi.md#lineMetaDisruptionCategories) | **GET** /Line/Meta/DisruptionCategories | Gets a list of valid disruption categories
[**lineMetaModes**](LineApi.md#lineMetaModes) | **GET** /Line/Meta/Modes | Gets a list of valid modes
[**lineMetaServiceTypes**](LineApi.md#lineMetaServiceTypes) | **GET** /Line/Meta/ServiceTypes | Gets a list of valid ServiceTypes to filter on
[**lineMetaSeverity**](LineApi.md#lineMetaSeverity) | **GET** /Line/Meta/Severity | Gets a list of valid severity codes
[**lineRoute**](LineApi.md#lineRoute) | **GET** /Line/Route | Get all valid routes for all lines, including the name and id of the originating and terminating stops for each route.
[**lineRouteByMode**](LineApi.md#lineRouteByMode) | **GET** /Line/Mode/{modes}/Route | Gets all lines and their valid routes for given modes, including the name and id of the originating and terminating stops for each route
[**lineRouteSequence**](LineApi.md#lineRouteSequence) | **GET** /Line/{id}/Route/Sequence/{direction} | Gets all valid routes for given lineId id, including the sequence of stops on each route.
[**lineSearch**](LineApi.md#lineSearch) | **GET** /Line/Search/{query} | Search for lines or routes matching the query string
[**lineStatus**](LineApi.md#lineStatus) | **GET** /Line/{ids}/Status/{StartDate}/to/{EndDate} | Gets the lineId status for given lineId ids during the provided dates e.g Minor Delays
[**lineStatusByIds**](LineApi.md#lineStatusByIds) | **GET** /Line/{ids}/Status | Gets the lineId status of for given lineId ids e.g Minor Delays
[**lineStatusByMode**](LineApi.md#lineStatusByMode) | **GET** /Line/Mode/{modes}/Status | Gets the lineId status of for all lines for the given modes
[**lineStatusBySeverity**](LineApi.md#lineStatusBySeverity) | **GET** /Line/Status/{severity} | Gets the lineId status for all lines with a given severity              A list of valid severity codes can be obtained from a call to Line/Meta/Severity
[**lineStopPoints**](LineApi.md#lineStopPoints) | **GET** /Line/{id}/StopPoints | Gets a list of the stations that serve the given lineId id
[**lineTimetable**](LineApi.md#lineTimetable) | **GET** /Line/{id}/Timetable/{fromStopPointId} | Gets the timetable for a specified station on the give lineId
[**lineTimetableTo**](LineApi.md#lineTimetableTo) | **GET** /Line/{id}/Timetable/{fromStopPointId}/to/{toStopPointId} | Gets the timetable for a specified station on the give lineId with specified destination


<a name="lineArrivals"></a>
# **lineArrivals**
> List&lt;Prediction&gt; lineArrivals(ids, stopPointId, direction, destinationStationId)

Get the list of arrival predictions for given lineId ids based at the given stop

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
String stopPointId = "stopPointId_example"; // String | Optional. Id of stop to get arrival predictions for (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
String direction = "direction_example"; // String | Optional. The direction of travel. Can be inbound or outbound or all. If left blank, and destinationStopId is set, will default to all
String destinationStationId = "destinationStationId_example"; // String | Optional. Id of destination stop
try {
    List<Prediction> result = apiInstance.lineArrivals(ids, stopPointId, direction, destinationStationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineArrivals");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |
 **stopPointId** | **String**| Optional. Id of stop to get arrival predictions for (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **direction** | **String**| Optional. The direction of travel. Can be inbound or outbound or all. If left blank, and destinationStopId is set, will default to all | [optional] [enum: inbound, outbound, all]
 **destinationStationId** | **String**| Optional. Id of destination stop | [optional]

### Return type

[**List&lt;Prediction&gt;**](Prediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineDisruption"></a>
# **lineDisruption**
> List&lt;Disruption&gt; lineDisruption(ids)

Get disruptions for the given lineId ids

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
try {
    List<Disruption> result = apiInstance.lineDisruption(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineDisruption");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |

### Return type

[**List&lt;Disruption&gt;**](Disruption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineDisruptionByMode"></a>
# **lineDisruptionByMode**
> List&lt;Disruption&gt; lineDisruptionByMode(modes)

Get disruptions for all lines of the given modes.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-separated list of modes e.g. tube,dlr
try {
    List<Disruption> result = apiInstance.lineDisruptionByMode(modes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineDisruptionByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of modes e.g. tube,dlr |

### Return type

[**List&lt;Disruption&gt;**](Disruption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineGet"></a>
# **lineGet**
> List&lt;Line&gt; lineGet(ids)

Gets lines that match the specified lineId ids.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
try {
    List<Line> result = apiInstance.lineGet(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineGetByMode"></a>
# **lineGetByMode**
> List&lt;Line&gt; lineGetByMode(modes)

Gets lines that serve the given modes.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-separated list of modes e.g. tube,dlr
try {
    List<Line> result = apiInstance.lineGetByMode(modes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineGetByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of modes e.g. tube,dlr |

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineLineRoutesByIds"></a>
# **lineLineRoutesByIds**
> List&lt;Line&gt; lineLineRoutesByIds(ids, serviceTypes)

Get all valid routes for given lineId ids, including the name and id of the originating and terminating stops for each route.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    List<Line> result = apiInstance.lineLineRoutesByIds(ids, serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineLineRoutesByIds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineMetaDisruptionCategories"></a>
# **lineMetaDisruptionCategories**
> List&lt;String&gt; lineMetaDisruptionCategories()

Gets a list of valid disruption categories

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
try {
    List<String> result = apiInstance.lineMetaDisruptionCategories();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineMetaDisruptionCategories");
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

<a name="lineMetaModes"></a>
# **lineMetaModes**
> List&lt;Mode&gt; lineMetaModes()

Gets a list of valid modes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
try {
    List<Mode> result = apiInstance.lineMetaModes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineMetaModes");
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

<a name="lineMetaServiceTypes"></a>
# **lineMetaServiceTypes**
> List&lt;String&gt; lineMetaServiceTypes()

Gets a list of valid ServiceTypes to filter on

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
try {
    List<String> result = apiInstance.lineMetaServiceTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineMetaServiceTypes");
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

<a name="lineMetaSeverity"></a>
# **lineMetaSeverity**
> List&lt;StatusSeverity&gt; lineMetaSeverity()

Gets a list of valid severity codes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
try {
    List<StatusSeverity> result = apiInstance.lineMetaSeverity();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineMetaSeverity");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;StatusSeverity&gt;**](StatusSeverity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineRoute"></a>
# **lineRoute**
> List&lt;Line&gt; lineRoute(serviceTypes)

Get all valid routes for all lines, including the name and id of the originating and terminating stops for each route.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    List<Line> result = apiInstance.lineRoute(serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineRoute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineRouteByMode"></a>
# **lineRouteByMode**
> List&lt;Line&gt; lineRouteByMode(modes, serviceTypes)

Gets all lines and their valid routes for given modes, including the name and id of the originating and terminating stops for each route

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-separated list of modes e.g. tube,dlr
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    List<Line> result = apiInstance.lineRouteByMode(modes, serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineRouteByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of modes e.g. tube,dlr |
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineRouteSequence"></a>
# **lineRouteSequence**
> RouteSequence lineRouteSequence(id, direction, serviceTypes, excludeCrowding)

Gets all valid routes for given lineId id, including the sequence of stops on each route.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
String id = "id_example"; // String | A single lineId id e.g. victoria
String direction = "direction_example"; // String | The direction of travel. Can be inbound or outbound.
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
Boolean excludeCrowding = true; // Boolean | That excludes crowding from lineId disruptions. Can be true or false.
try {
    RouteSequence result = apiInstance.lineRouteSequence(id, direction, serviceTypes, excludeCrowding);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineRouteSequence");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A single lineId id e.g. victoria |
 **direction** | **String**| The direction of travel. Can be inbound or outbound. | [enum: inbound, outbound, all]
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]
 **excludeCrowding** | **Boolean**| That excludes crowding from lineId disruptions. Can be true or false. | [optional]

### Return type

[**RouteSequence**](RouteSequence.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineSearch"></a>
# **lineSearch**
> RouteSearchResponse lineSearch(query, modes, serviceTypes)

Search for lines or routes matching the query string

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
String query = "query_example"; // String | Search term e.g victoria
List<String> modes = Arrays.asList("modes_example"); // List<String> | Optionally filter by the specified modes
List<String> serviceTypes = Arrays.asList("serviceTypes_example"); // List<String> | A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to 'Regular' if not specified
try {
    RouteSearchResponse result = apiInstance.lineSearch(query, modes, serviceTypes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| Search term e.g victoria |
 **modes** | [**List&lt;String&gt;**](String.md)| Optionally filter by the specified modes | [optional]
 **serviceTypes** | [**List&lt;String&gt;**](String.md)| A comma seperated list of service types to filter on. Supported values: Regular, Night. Defaulted to &#39;Regular&#39; if not specified | [optional] [enum: Regular, Night]

### Return type

[**RouteSearchResponse**](RouteSearchResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineStatus"></a>
# **lineStatus**
> List&lt;Line&gt; lineStatus(ids, startDate, endDate, detail, dateRangeStartDate, dateRangeEndDate)

Gets the lineId status for given lineId ids during the provided dates e.g Minor Delays

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
String startDate = "startDate_example"; // String | 
String endDate = "endDate_example"; // String | 
Boolean detail = true; // Boolean | Include details of the disruptions that are causing the lineId status including the affected stops and routes
OffsetDateTime dateRangeStartDate = new OffsetDateTime(); // OffsetDateTime | 
OffsetDateTime dateRangeEndDate = new OffsetDateTime(); // OffsetDateTime | 
try {
    List<Line> result = apiInstance.lineStatus(ids, startDate, endDate, detail, dateRangeStartDate, dateRangeEndDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |
 **startDate** | **String**|  |
 **endDate** | **String**|  |
 **detail** | **Boolean**| Include details of the disruptions that are causing the lineId status including the affected stops and routes | [optional]
 **dateRangeStartDate** | **OffsetDateTime**|  | [optional]
 **dateRangeEndDate** | **OffsetDateTime**|  | [optional]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineStatusByIds"></a>
# **lineStatusByIds**
> List&lt;Line&gt; lineStatusByIds(ids, detail)

Gets the lineId status of for given lineId ids e.g Minor Delays

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids.
Boolean detail = true; // Boolean | Include details of the disruptions that are causing the lineId status including the affected stops and routes
try {
    List<Line> result = apiInstance.lineStatusByIds(ids, detail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineStatusByIds");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of lineId ids e.g. victoria,circle,N133. Max. approx. 20 ids. |
 **detail** | **Boolean**| Include details of the disruptions that are causing the lineId status including the affected stops and routes | [optional]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineStatusByMode"></a>
# **lineStatusByMode**
> List&lt;Line&gt; lineStatusByMode(modes, detail)

Gets the lineId status of for all lines for the given modes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
List<String> modes = Arrays.asList("modes_example"); // List<String> | A comma-separated list of modes to filter by. e.g. tube,dlr
Boolean detail = true; // Boolean | Include details of the disruptions that are causing the lineId status including the affected stops and routes
try {
    List<Line> result = apiInstance.lineStatusByMode(modes, detail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineStatusByMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **modes** | [**List&lt;String&gt;**](String.md)| A comma-separated list of modes to filter by. e.g. tube,dlr |
 **detail** | **Boolean**| Include details of the disruptions that are causing the lineId status including the affected stops and routes | [optional]

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineStatusBySeverity"></a>
# **lineStatusBySeverity**
> List&lt;Line&gt; lineStatusBySeverity(severity)

Gets the lineId status for all lines with a given severity              A list of valid severity codes can be obtained from a call to Line/Meta/Severity

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
Integer severity = 56; // Integer | The level of severity (eg: a number from 0 to 14)
try {
    List<Line> result = apiInstance.lineStatusBySeverity(severity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineStatusBySeverity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **severity** | **Integer**| The level of severity (eg: a number from 0 to 14) |

### Return type

[**List&lt;Line&gt;**](Line.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineStopPoints"></a>
# **lineStopPoints**
> List&lt;StopPoint&gt; lineStopPoints(id, tflOperatedNationalRailStationsOnly)

Gets a list of the stations that serve the given lineId id

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
String id = "id_example"; // String | A single lineId id e.g. victoria
Boolean tflOperatedNationalRailStationsOnly = true; // Boolean | If the national-rail lineId is requested, this flag will filter the national rail stations so that only those operated by TfL are returned
try {
    List<StopPoint> result = apiInstance.lineStopPoints(id, tflOperatedNationalRailStationsOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineStopPoints");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A single lineId id e.g. victoria |
 **tflOperatedNationalRailStationsOnly** | **Boolean**| If the national-rail lineId is requested, this flag will filter the national rail stations so that only those operated by TfL are returned | [optional]

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineTimetable"></a>
# **lineTimetable**
> TimetableResponse lineTimetable(fromStopPointId, id)

Gets the timetable for a specified station on the give lineId

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
String fromStopPointId = "fromStopPointId_example"; // String | The originating station's stop point id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
String id = "id_example"; // String | A single lineId id e.g. victoria
try {
    TimetableResponse result = apiInstance.lineTimetable(fromStopPointId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineTimetable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fromStopPointId** | **String**| The originating station&#39;s stop point id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **id** | **String**| A single lineId id e.g. victoria |

### Return type

[**TimetableResponse**](TimetableResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="lineTimetableTo"></a>
# **lineTimetableTo**
> TimetableResponse lineTimetableTo(fromStopPointId, id, toStopPointId)

Gets the timetable for a specified station on the give lineId with specified destination

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.LineApi;


LineApi apiInstance = new LineApi();
String fromStopPointId = "fromStopPointId_example"; // String | The originating station's stop point id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name)
String id = "id_example"; // String | A single lineId id e.g. victoria
String toStopPointId = "toStopPointId_example"; // String | The destination stations's Naptan code
try {
    TimetableResponse result = apiInstance.lineTimetableTo(fromStopPointId, id, toStopPointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LineApi#lineTimetableTo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fromStopPointId** | **String**| The originating station&#39;s stop point id (station naptan code e.g. 940GZZLUASL, you can use /StopPoint/Search/{query} endpoint to find a stop point id from a station name) |
 **id** | **String**| A single lineId id e.g. victoria |
 **toStopPointId** | **String**| The destination stations&#39;s Naptan code |

### Return type

[**TimetableResponse**](TimetableResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

