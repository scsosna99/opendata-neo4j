# ModeApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**modeArrivals**](ModeApi.md#modeArrivals) | **GET** /Mode/{mode}/Arrivals | Gets the next arrival predictions for all stops of a given mode
[**modeGetActiveServiceTypes**](ModeApi.md#modeGetActiveServiceTypes) | **GET** /Mode/ActiveServiceTypes | Returns the service type active for a mode.              Currently only supports tube


<a name="modeArrivals"></a>
# **modeArrivals**
> List&lt;Prediction&gt; modeArrivals(mode, count)

Gets the next arrival predictions for all stops of a given mode

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.ModeApi;


ModeApi apiInstance = new ModeApi();
String mode = "mode_example"; // String | A mode name e.g. tube, dlr
Integer count = 56; // Integer | A number of arrivals to return for each stop, -1 to return all available.
try {
    List<Prediction> result = apiInstance.modeArrivals(mode, count);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModeApi#modeArrivals");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mode** | **String**| A mode name e.g. tube, dlr |
 **count** | **Integer**| A number of arrivals to return for each stop, -1 to return all available. | [optional]

### Return type

[**List&lt;Prediction&gt;**](Prediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="modeGetActiveServiceTypes"></a>
# **modeGetActiveServiceTypes**
> List&lt;ActiveServiceType&gt; modeGetActiveServiceTypes()

Returns the service type active for a mode.              Currently only supports tube

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.ModeApi;


ModeApi apiInstance = new ModeApi();
try {
    List<ActiveServiceType> result = apiInstance.modeGetActiveServiceTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ModeApi#modeGetActiveServiceTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ActiveServiceType&gt;**](ActiveServiceType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

