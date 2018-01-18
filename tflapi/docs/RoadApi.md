# RoadApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**roadDisruptedStreets**](RoadApi.md#roadDisruptedStreets) | **GET** /Road/all/Street/Disruption | Gets a list of disrupted streets. If no date filters are provided, current disruptions are returned.
[**roadDisruption**](RoadApi.md#roadDisruption) | **GET** /Road/{ids}/Disruption | Get active disruptions, filtered by road ids
[**roadDisruptionById**](RoadApi.md#roadDisruptionById) | **GET** /Road/all/Disruption/{disruptionIds} | Gets a list of active disruptions filtered by disruption Ids.
[**roadGet**](RoadApi.md#roadGet) | **GET** /Road | Gets all roads managed by TfL
[**roadGet_0**](RoadApi.md#roadGet_0) | **GET** /Road/{ids} | Gets the road with the specified id (e.g. A1)
[**roadMetaCategories**](RoadApi.md#roadMetaCategories) | **GET** /Road/Meta/Categories | Gets a list of valid RoadDisruption categories
[**roadMetaSeverities**](RoadApi.md#roadMetaSeverities) | **GET** /Road/Meta/Severities | Gets a list of valid RoadDisruption severity codes
[**roadStatus**](RoadApi.md#roadStatus) | **GET** /Road/{ids}/Status | Gets the specified roads with the status aggregated over the date range specified, or now until the end of today if no dates are passed.


<a name="roadDisruptedStreets"></a>
# **roadDisruptedStreets**
> Object roadDisruptedStreets(startDate, endDate)

Gets a list of disrupted streets. If no date filters are provided, current disruptions are returned.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
OffsetDateTime startDate = new OffsetDateTime(); // OffsetDateTime | Optional, the start time to filter on.
OffsetDateTime endDate = new OffsetDateTime(); // OffsetDateTime | Optional, The end time to filter on.
try {
    Object result = apiInstance.roadDisruptedStreets(startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadDisruptedStreets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **OffsetDateTime**| Optional, the start time to filter on. |
 **endDate** | **OffsetDateTime**| Optional, The end time to filter on. |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="roadDisruption"></a>
# **roadDisruption**
> List&lt;RoadDisruption&gt; roadDisruption(ids, stripContent, severities, categories, closures)

Get active disruptions, filtered by road ids

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | Comma-separated list of road identifiers e.g. \"A406, A2\" use all for all to ignore id filter (a full list of supported road identifiers can be found at the /Road/ endpoint)
Boolean stripContent = true; // Boolean | Optional, defaults to false. When true, removes every property/node except for id, point, severity, severityDescription, startDate, endDate, corridor details, location, comments and streets
List<String> severities = Arrays.asList("severities_example"); // List<String> | an optional list of Severity names to filter on (a valid list of severities can be obtained from the /Road/Meta/severities endpoint)
List<String> categories = Arrays.asList("categories_example"); // List<String> | an optional list of category names to filter on (a valid list of categories can be obtained from the /Road/Meta/categories endpoint)
Boolean closures = true; // Boolean | Optional, defaults to true. When true, always includes disruptions that have road closures, regardless of the severity filter. When false, the severity filter works as normal.
try {
    List<RoadDisruption> result = apiInstance.roadDisruption(ids, stripContent, severities, categories, closures);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadDisruption");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| Comma-separated list of road identifiers e.g. \&quot;A406, A2\&quot; use all for all to ignore id filter (a full list of supported road identifiers can be found at the /Road/ endpoint) |
 **stripContent** | **Boolean**| Optional, defaults to false. When true, removes every property/node except for id, point, severity, severityDescription, startDate, endDate, corridor details, location, comments and streets | [optional]
 **severities** | [**List&lt;String&gt;**](String.md)| an optional list of Severity names to filter on (a valid list of severities can be obtained from the /Road/Meta/severities endpoint) | [optional]
 **categories** | [**List&lt;String&gt;**](String.md)| an optional list of category names to filter on (a valid list of categories can be obtained from the /Road/Meta/categories endpoint) | [optional]
 **closures** | **Boolean**| Optional, defaults to true. When true, always includes disruptions that have road closures, regardless of the severity filter. When false, the severity filter works as normal. | [optional]

### Return type

[**List&lt;RoadDisruption&gt;**](RoadDisruption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml, application/geo+json

<a name="roadDisruptionById"></a>
# **roadDisruptionById**
> RoadDisruption roadDisruptionById(disruptionIds, stripContent)

Gets a list of active disruptions filtered by disruption Ids.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
List<String> disruptionIds = Arrays.asList("disruptionIds_example"); // List<String> | Comma-separated list of disruption identifiers to filter by.
Boolean stripContent = true; // Boolean | Optional, defaults to false. When true, removes every property/node except for id, point, severity, severityDescription, startDate, endDate, corridor details, location and comments.
try {
    RoadDisruption result = apiInstance.roadDisruptionById(disruptionIds, stripContent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadDisruptionById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **disruptionIds** | [**List&lt;String&gt;**](String.md)| Comma-separated list of disruption identifiers to filter by. |
 **stripContent** | **Boolean**| Optional, defaults to false. When true, removes every property/node except for id, point, severity, severityDescription, startDate, endDate, corridor details, location and comments. | [optional]

### Return type

[**RoadDisruption**](RoadDisruption.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml, application/geo+json

<a name="roadGet"></a>
# **roadGet**
> List&lt;RoadCorridor&gt; roadGet()

Gets all roads managed by TfL

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
try {
    List<RoadCorridor> result = apiInstance.roadGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RoadCorridor&gt;**](RoadCorridor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="roadGet_0"></a>
# **roadGet_0**
> List&lt;RoadCorridor&gt; roadGet_0(ids)

Gets the road with the specified id (e.g. A1)

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | Comma-separated list of road identifiers e.g. \"A406, A2\" (a full list of supported road identifiers can be found at the /Road/ endpoint)
try {
    List<RoadCorridor> result = apiInstance.roadGet_0(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadGet_0");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| Comma-separated list of road identifiers e.g. \&quot;A406, A2\&quot; (a full list of supported road identifiers can be found at the /Road/ endpoint) |

### Return type

[**List&lt;RoadCorridor&gt;**](RoadCorridor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="roadMetaCategories"></a>
# **roadMetaCategories**
> List&lt;String&gt; roadMetaCategories()

Gets a list of valid RoadDisruption categories

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
try {
    List<String> result = apiInstance.roadMetaCategories();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadMetaCategories");
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

<a name="roadMetaSeverities"></a>
# **roadMetaSeverities**
> List&lt;StatusSeverity&gt; roadMetaSeverities()

Gets a list of valid RoadDisruption severity codes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
try {
    List<StatusSeverity> result = apiInstance.roadMetaSeverities();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadMetaSeverities");
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

<a name="roadStatus"></a>
# **roadStatus**
> List&lt;RoadCorridor&gt; roadStatus(ids, dateRangeNullableStartDate, dateRangeNullableEndDate)

Gets the specified roads with the status aggregated over the date range specified, or now until the end of today if no dates are passed.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.RoadApi;


RoadApi apiInstance = new RoadApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | Comma-separated list of road identifiers e.g. \"A406, A2\" or use \"all\" to ignore id filter (a full list of supported road identifiers can be found at the /Road/ endpoint)
OffsetDateTime dateRangeNullableStartDate = new OffsetDateTime(); // OffsetDateTime | 
OffsetDateTime dateRangeNullableEndDate = new OffsetDateTime(); // OffsetDateTime | 
try {
    List<RoadCorridor> result = apiInstance.roadStatus(ids, dateRangeNullableStartDate, dateRangeNullableEndDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RoadApi#roadStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| Comma-separated list of road identifiers e.g. \&quot;A406, A2\&quot; or use \&quot;all\&quot; to ignore id filter (a full list of supported road identifiers can be found at the /Road/ endpoint) |
 **dateRangeNullableStartDate** | **OffsetDateTime**|  | [optional]
 **dateRangeNullableEndDate** | **OffsetDateTime**|  | [optional]

### Return type

[**List&lt;RoadCorridor&gt;**](RoadCorridor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

