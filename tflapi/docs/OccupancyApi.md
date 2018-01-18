# OccupancyApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**occupancyGet**](OccupancyApi.md#occupancyGet) | **GET** /Occupancy/CarPark/{id} | Gets the occupancy for a car park with a given id
[**occupancyGetAllChargeConnectorStatus**](OccupancyApi.md#occupancyGetAllChargeConnectorStatus) | **GET** /Occupancy/ChargeConnector | Gets the occupancy for all charge connectors
[**occupancyGetBikePointsOccupancies**](OccupancyApi.md#occupancyGetBikePointsOccupancies) | **GET** /Occupancy/BikePoints/{ids} | Get the occupancy for bike points.
[**occupancyGetChargeConnectorStatus**](OccupancyApi.md#occupancyGetChargeConnectorStatus) | **GET** /Occupancy/ChargeConnector/{ids} | Gets the occupancy for a charge connectors with a given id (sourceSystemPlaceId)
[**occupancyGet_0**](OccupancyApi.md#occupancyGet_0) | **GET** /Occupancy/CarPark | Gets the occupancy for all car parks that have occupancy data


<a name="occupancyGet"></a>
# **occupancyGet**
> CarParkOccupancy occupancyGet(id)

Gets the occupancy for a car park with a given id

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.OccupancyApi;


OccupancyApi apiInstance = new OccupancyApi();
String id = "id_example"; // String | 
try {
    CarParkOccupancy result = apiInstance.occupancyGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OccupancyApi#occupancyGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**CarParkOccupancy**](CarParkOccupancy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="occupancyGetAllChargeConnectorStatus"></a>
# **occupancyGetAllChargeConnectorStatus**
> List&lt;ChargeConnectorOccupancy&gt; occupancyGetAllChargeConnectorStatus()

Gets the occupancy for all charge connectors

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.OccupancyApi;


OccupancyApi apiInstance = new OccupancyApi();
try {
    List<ChargeConnectorOccupancy> result = apiInstance.occupancyGetAllChargeConnectorStatus();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OccupancyApi#occupancyGetAllChargeConnectorStatus");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ChargeConnectorOccupancy&gt;**](ChargeConnectorOccupancy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="occupancyGetBikePointsOccupancies"></a>
# **occupancyGetBikePointsOccupancies**
> List&lt;BikePointOccupancy&gt; occupancyGetBikePointsOccupancies(ids)

Get the occupancy for bike points.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.OccupancyApi;


OccupancyApi apiInstance = new OccupancyApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | 
try {
    List<BikePointOccupancy> result = apiInstance.occupancyGetBikePointsOccupancies(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OccupancyApi#occupancyGetBikePointsOccupancies");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)|  |

### Return type

[**List&lt;BikePointOccupancy&gt;**](BikePointOccupancy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="occupancyGetChargeConnectorStatus"></a>
# **occupancyGetChargeConnectorStatus**
> List&lt;ChargeConnectorOccupancy&gt; occupancyGetChargeConnectorStatus(ids)

Gets the occupancy for a charge connectors with a given id (sourceSystemPlaceId)

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.OccupancyApi;


OccupancyApi apiInstance = new OccupancyApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | 
try {
    List<ChargeConnectorOccupancy> result = apiInstance.occupancyGetChargeConnectorStatus(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OccupancyApi#occupancyGetChargeConnectorStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)|  |

### Return type

[**List&lt;ChargeConnectorOccupancy&gt;**](ChargeConnectorOccupancy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="occupancyGet_0"></a>
# **occupancyGet_0**
> List&lt;CarParkOccupancy&gt; occupancyGet_0()

Gets the occupancy for all car parks that have occupancy data

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.OccupancyApi;


OccupancyApi apiInstance = new OccupancyApi();
try {
    List<CarParkOccupancy> result = apiInstance.occupancyGet_0();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OccupancyApi#occupancyGet_0");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CarParkOccupancy&gt;**](CarParkOccupancy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

