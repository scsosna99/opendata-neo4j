# BikePointApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bikePointGet**](BikePointApi.md#bikePointGet) | **GET** /BikePoint/{id} | Gets the bike point with the given id.
[**bikePointGetAll**](BikePointApi.md#bikePointGetAll) | **GET** /BikePoint | Gets all bike point locations. The Place object has an addtionalProperties array which contains the nbBikes, nbDocks and nbSpaces              numbers which give the status of the BikePoint. A mismatch in these numbers i.e. nbDocks - (nbBikes + nbSpaces) !&#x3D; 0 indicates broken docks.
[**bikePointSearch**](BikePointApi.md#bikePointSearch) | **GET** /BikePoint/Search | Search for bike stations by their name, a bike point&#39;s name often contains information about the name of the street              or nearby landmarks, for example. Note that the search result does not contain the PlaceProperties i.e. the status              or occupancy of the BikePoint, to get that information you should retrieve the BikePoint by its id on /BikePoint/id.


<a name="bikePointGet"></a>
# **bikePointGet**
> Place bikePointGet(id)

Gets the bike point with the given id.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.BikePointApi;


BikePointApi apiInstance = new BikePointApi();
String id = "id_example"; // String | A bike point id (a list of ids can be obtained from the above BikePoint call)
try {
    Place result = apiInstance.bikePointGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BikePointApi#bikePointGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| A bike point id (a list of ids can be obtained from the above BikePoint call) |

### Return type

[**Place**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="bikePointGetAll"></a>
# **bikePointGetAll**
> List&lt;Place&gt; bikePointGetAll()

Gets all bike point locations. The Place object has an addtionalProperties array which contains the nbBikes, nbDocks and nbSpaces              numbers which give the status of the BikePoint. A mismatch in these numbers i.e. nbDocks - (nbBikes + nbSpaces) !&#x3D; 0 indicates broken docks.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.BikePointApi;


BikePointApi apiInstance = new BikePointApi();
try {
    List<Place> result = apiInstance.bikePointGetAll();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BikePointApi#bikePointGetAll");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="bikePointSearch"></a>
# **bikePointSearch**
> List&lt;Place&gt; bikePointSearch(query)

Search for bike stations by their name, a bike point&#39;s name often contains information about the name of the street              or nearby landmarks, for example. Note that the search result does not contain the PlaceProperties i.e. the status              or occupancy of the BikePoint, to get that information you should retrieve the BikePoint by its id on /BikePoint/id.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.BikePointApi;


BikePointApi apiInstance = new BikePointApi();
String query = "query_example"; // String | The search term e.g. \"St. James\"
try {
    List<Place> result = apiInstance.bikePointSearch(query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BikePointApi#bikePointSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The search term e.g. \&quot;St. James\&quot; |

### Return type

[**List&lt;Place&gt;**](Place.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

