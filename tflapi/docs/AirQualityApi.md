# AirQualityApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**airQualityGet**](AirQualityApi.md#airQualityGet) | **GET** /AirQuality | Gets air quality data feed


<a name="airQualityGet"></a>
# **airQualityGet**
> Object airQualityGet()

Gets air quality data feed

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.AirQualityApi;


AirQualityApi apiInstance = new AirQualityApi();
try {
    Object result = apiInstance.airQualityGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AirQualityApi#airQualityGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

