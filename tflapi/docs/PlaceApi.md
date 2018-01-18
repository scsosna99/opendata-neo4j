# PlaceApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**placeGet**](PlaceApi.md#placeGet) | **GET** /Place/{id} | Gets the place with the given id.
[**placeGetAt**](PlaceApi.md#placeGetAt) | **GET** /Place/{type}/At/{Lat}/{Lon} | Gets any places of the given type whose geography intersects the given latitude and longitude. In practice this means the Place              must be polygonal e.g. a BoroughBoundary.
[**placeGetByGeoBox**](PlaceApi.md#placeGetByGeoBox) | **GET** /Place | Gets the places that lie within the bounding box defined by the lat/lon of its north-west and south-east corners. Optionally filters              on type and can strip properties for a smaller payload.
[**placeGetByType**](PlaceApi.md#placeGetByType) | **GET** /Place/Type/{types} | Gets all places of a given type
[**placeGetOverlay**](PlaceApi.md#placeGetOverlay) | **GET** /Place/{type}/overlay/{z}/{Lat}/{Lon}/{width}/{height} | Gets the place overlay for a given set of co-ordinates and a given width/height.
[**placeGetStreetsByPostCode**](PlaceApi.md#placeGetStreetsByPostCode) | **GET** /Place/Address/Streets/{Postcode} | Gets the set of streets associated with a post code.
[**placeMetaCategories**](PlaceApi.md#placeMetaCategories) | **GET** /Place/Meta/Categories | Gets a list of all of the available place property categories and keys.
[**placeMetaPlaceTypes**](PlaceApi.md#placeMetaPlaceTypes) | **GET** /Place/Meta/PlaceTypes | Gets a list of the available types of Place.
[**placeSearch**](PlaceApi.md#placeSearch) | **GET** /Place/Search | Gets all places that matches the given query


<a name="placeGet"></a>
# **placeGet**
> List&lt;Place&gt; placeGet(id, includeChildren)

Gets the place with the given id.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
String id = "id_example"; // String | The id of the place, you can use the /Place/Types/{types} endpoint to get a list of places for a given type including their ids
Boolean includeChildren = true; // Boolean | Defaults to false. If true child places e.g. individual charging stations at a charge point while be included, otherwise just the URLs of any child places will be returned
try {
    List<Place> result = apiInstance.placeGet(id, includeChildren);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the place, you can use the /Place/Types/{types} endpoint to get a list of places for a given type including their ids |
 **includeChildren** | **Boolean**| Defaults to false. If true child places e.g. individual charging stations at a charge point while be included, otherwise just the URLs of any child places will be returned | [optional]

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeGetAt"></a>
# **placeGetAt**
> Object placeGetAt(type, lat, lon, locationLat, locationLon)

Gets any places of the given type whose geography intersects the given latitude and longitude. In practice this means the Place              must be polygonal e.g. a BoroughBoundary.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
List<String> type = Arrays.asList("type_example"); // List<String> | The place type (a valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint)
String lat = "lat_example"; // String | 
String lon = "lon_example"; // String | 
Double locationLat = 3.4D; // Double | 
Double locationLon = 3.4D; // Double | 
try {
    Object result = apiInstance.placeGetAt(type, lat, lon, locationLat, locationLon);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGetAt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | [**List&lt;String&gt;**](String.md)| The place type (a valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint) |
 **lat** | **String**|  |
 **lon** | **String**|  |
 **locationLat** | **Double**|  |
 **locationLon** | **Double**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeGetByGeoBox"></a>
# **placeGetByGeoBox**
> List&lt;StopPoint&gt; placeGetByGeoBox(bbBoxpointsSwLat, bbBoxpointsSwLon, bbBoxpointsNeLat, bbBoxpointsNeLon, categories, includeChildren, type, activeOnly)

Gets the places that lie within the bounding box defined by the lat/lon of its north-west and south-east corners. Optionally filters              on type and can strip properties for a smaller payload.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
Double bbBoxpointsSwLat = 3.4D; // Double | 
Double bbBoxpointsSwLon = 3.4D; // Double | 
Double bbBoxpointsNeLat = 3.4D; // Double | 
Double bbBoxpointsNeLon = 3.4D; // Double | 
List<String> categories = Arrays.asList("categories_example"); // List<String> | an optional list of comma separated property categories to return in the Place's property bag. If null or empty, all categories of property are returned. Pass the keyword \"none\" to return no properties (a valid list of categories can be obtained from the /Place/Meta/categories endpoint)
Boolean includeChildren = true; // Boolean | Defaults to false. If true child places e.g. individual charging stations at a charge point while be included, otherwise just the URLs of any child places will be returned
List<String> type = Arrays.asList("type_example"); // List<String> | place types to filter on, or null to return all types
Boolean activeOnly = true; // Boolean | An optional parameter to limit the results to active records only (Currently only the 'VariableMessageSign' place type is supported)
try {
    List<StopPoint> result = apiInstance.placeGetByGeoBox(bbBoxpointsSwLat, bbBoxpointsSwLon, bbBoxpointsNeLat, bbBoxpointsNeLon, categories, includeChildren, type, activeOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGetByGeoBox");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bbBoxpointsSwLat** | **Double**|  |
 **bbBoxpointsSwLon** | **Double**|  |
 **bbBoxpointsNeLat** | **Double**|  |
 **bbBoxpointsNeLon** | **Double**|  |
 **categories** | [**List&lt;String&gt;**](String.md)| an optional list of comma separated property categories to return in the Place&#39;s property bag. If null or empty, all categories of property are returned. Pass the keyword \&quot;none\&quot; to return no properties (a valid list of categories can be obtained from the /Place/Meta/categories endpoint) | [optional]
 **includeChildren** | **Boolean**| Defaults to false. If true child places e.g. individual charging stations at a charge point while be included, otherwise just the URLs of any child places will be returned | [optional]
 **type** | [**List&lt;String&gt;**](String.md)| place types to filter on, or null to return all types | [optional]
 **activeOnly** | **Boolean**| An optional parameter to limit the results to active records only (Currently only the &#39;VariableMessageSign&#39; place type is supported) | [optional]

### Return type

[**List&lt;StopPoint&gt;**](StopPoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeGetByType"></a>
# **placeGetByType**
> List&lt;Place&gt; placeGetByType(types, activeOnly)

Gets all places of a given type

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
List<String> types = Arrays.asList("types_example"); // List<String> | A comma-separated list of the types to return. Max. approx 12 types.              A valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint.
Boolean activeOnly = true; // Boolean | An optional parameter to limit the results to active records only (Currently only the 'VariableMessageSign' place type is supported)
try {
    List<Place> result = apiInstance.placeGetByType(types, activeOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGetByType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **types** | [**List&lt;String&gt;**](String.md)| A comma-separated list of the types to return. Max. approx 12 types.              A valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint. |
 **activeOnly** | **Boolean**| An optional parameter to limit the results to active records only (Currently only the &#39;VariableMessageSign&#39; place type is supported) | [optional]

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeGetOverlay"></a>
# **placeGetOverlay**
> Object placeGetOverlay(z, type, width, height, lat, lon, locationLat, locationLon)

Gets the place overlay for a given set of co-ordinates and a given width/height.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
Integer z = 56; // Integer | The zoom level
List<String> type = Arrays.asList("type_example"); // List<String> | The place type (a valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint)
Integer width = 56; // Integer | The width of the requested overlay.
Integer height = 56; // Integer | The height of the requested overlay.
String lat = "lat_example"; // String | 
String lon = "lon_example"; // String | 
Double locationLat = 3.4D; // Double | 
Double locationLon = 3.4D; // Double | 
try {
    Object result = apiInstance.placeGetOverlay(z, type, width, height, lat, lon, locationLat, locationLon);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGetOverlay");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **z** | **Integer**| The zoom level |
 **type** | [**List&lt;String&gt;**](String.md)| The place type (a valid list of place types can be obtained from the /Place/Meta/placeTypes endpoint) |
 **width** | **Integer**| The width of the requested overlay. |
 **height** | **Integer**| The height of the requested overlay. |
 **lat** | **String**|  |
 **lon** | **String**|  |
 **locationLat** | **Double**|  |
 **locationLon** | **Double**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeGetStreetsByPostCode"></a>
# **placeGetStreetsByPostCode**
> Object placeGetStreetsByPostCode(postcode, postcodeInputPostcode)

Gets the set of streets associated with a post code.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
String postcode = "postcode_example"; // String | 
String postcodeInputPostcode = "postcodeInputPostcode_example"; // String | 
try {
    Object result = apiInstance.placeGetStreetsByPostCode(postcode, postcodeInputPostcode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeGetStreetsByPostCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postcode** | **String**|  |
 **postcodeInputPostcode** | **String**|  | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeMetaCategories"></a>
# **placeMetaCategories**
> List&lt;PlaceCategory&gt; placeMetaCategories()

Gets a list of all of the available place property categories and keys.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
try {
    List<PlaceCategory> result = apiInstance.placeMetaCategories();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeMetaCategories");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;PlaceCategory&gt;**](PlaceCategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeMetaPlaceTypes"></a>
# **placeMetaPlaceTypes**
> List&lt;PlaceCategory&gt; placeMetaPlaceTypes()

Gets a list of the available types of Place.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
try {
    List<PlaceCategory> result = apiInstance.placeMetaPlaceTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeMetaPlaceTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;PlaceCategory&gt;**](PlaceCategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="placeSearch"></a>
# **placeSearch**
> List&lt;Place&gt; placeSearch(name, types)

Gets all places that matches the given query

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.PlaceApi;


PlaceApi apiInstance = new PlaceApi();
String name = "name_example"; // String | The name of the place, you can use the /Place/Types/{types} endpoint to get a list of places for a given type including their names.
List<String> types = Arrays.asList("types_example"); // List<String> | A comma-separated list of the types to return. Max. approx 12 types.
try {
    List<Place> result = apiInstance.placeSearch(name, types);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PlaceApi#placeSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the place, you can use the /Place/Types/{types} endpoint to get a list of places for a given type including their names. |
 **types** | [**List&lt;String&gt;**](String.md)| A comma-separated list of the types to return. Max. approx 12 types. | [optional]

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

