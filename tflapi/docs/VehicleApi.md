# VehicleApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**vehicleGet**](VehicleApi.md#vehicleGet) | **GET** /Vehicle/{ids}/Arrivals | Gets the predictions for a given list of vehicle Id&#39;s.
[**vehicleGetEmissionsSurchargeCompliance**](VehicleApi.md#vehicleGetEmissionsSurchargeCompliance) | **GET** /Vehicle/EmissionSurcharge | Gets the Emissions Surcharge compliance for the Vehicle
[**vehicleGetUlezCompliance**](VehicleApi.md#vehicleGetUlezCompliance) | **GET** /Vehicle/UlezCompliance | Gets the Ulez Surcharge compliance for the Vehicle


<a name="vehicleGet"></a>
# **vehicleGet**
> List&lt;Prediction&gt; vehicleGet(ids)

Gets the predictions for a given list of vehicle Id&#39;s.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.VehicleApi;


VehicleApi apiInstance = new VehicleApi();
List<String> ids = Arrays.asList("ids_example"); // List<String> | A comma-separated list of vehicle ids e.g. LX58CFV,LX11AZB,LX58CFE. Max approx. 25 ids.
try {
    List<Prediction> result = apiInstance.vehicleGet(ids);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehicleApi#vehicleGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | [**List&lt;String&gt;**](String.md)| A comma-separated list of vehicle ids e.g. LX58CFV,LX11AZB,LX58CFE. Max approx. 25 ids. |

### Return type

[**List&lt;Prediction&gt;**](Prediction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="vehicleGetEmissionsSurchargeCompliance"></a>
# **vehicleGetEmissionsSurchargeCompliance**
> VehicleMatch vehicleGetEmissionsSurchargeCompliance(vrm)

Gets the Emissions Surcharge compliance for the Vehicle

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.VehicleApi;


VehicleApi apiInstance = new VehicleApi();
String vrm = "vrm_example"; // String | The Vehicle Registration Mark
try {
    VehicleMatch result = apiInstance.vehicleGetEmissionsSurchargeCompliance(vrm);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehicleApi#vehicleGetEmissionsSurchargeCompliance");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vrm** | **String**| The Vehicle Registration Mark |

### Return type

[**VehicleMatch**](VehicleMatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="vehicleGetUlezCompliance"></a>
# **vehicleGetUlezCompliance**
> VehicleMatch vehicleGetUlezCompliance(vrm)

Gets the Ulez Surcharge compliance for the Vehicle

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.VehicleApi;


VehicleApi apiInstance = new VehicleApi();
String vrm = "vrm_example"; // String | The Vehicle Registration Mark
try {
    VehicleMatch result = apiInstance.vehicleGetUlezCompliance(vrm);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehicleApi#vehicleGetUlezCompliance");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vrm** | **String**| The Vehicle Registration Mark |

### Return type

[**VehicleMatch**](VehicleMatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

