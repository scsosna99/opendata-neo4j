# TravelTimeApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**travelTimeGetCompareOverlay**](TravelTimeApi.md#travelTimeGetCompareOverlay) | **GET** /TravelTimes/compareOverlay/{z}/mapcenter/{mapCenterLat}/{mapCenterLon}/pinlocation/{pinLat}/{pinLon}/dimensions/{width}/{height} | Gets the TravelTime overlay.
[**travelTimeGetOverlay**](TravelTimeApi.md#travelTimeGetOverlay) | **GET** /TravelTimes/overlay/{z}/mapcenter/{mapCenterLat}/{mapCenterLon}/pinlocation/{pinLat}/{pinLon}/dimensions/{width}/{height} | Gets the TravelTime overlay.


<a name="travelTimeGetCompareOverlay"></a>
# **travelTimeGetCompareOverlay**
> Object travelTimeGetCompareOverlay(z, pinLat, pinLon, mapCenterLat, mapCenterLon, scenarioTitle, timeOfDayId, modeId, width, height, direction, travelTimeInterval, compareType, compareValue)

Gets the TravelTime overlay.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.TravelTimeApi;


TravelTimeApi apiInstance = new TravelTimeApi();
Integer z = 56; // Integer | The zoom level.
Double pinLat = 3.4D; // Double | The latitude of the pin.
Double pinLon = 3.4D; // Double | The longitude of the pin.
Double mapCenterLat = 3.4D; // Double | The map center latitude.
Double mapCenterLon = 3.4D; // Double | The map center longitude.
String scenarioTitle = "scenarioTitle_example"; // String | The title of the scenario.
String timeOfDayId = "timeOfDayId_example"; // String | The id for the time of day (AM/INTER/PM)
String modeId = "modeId_example"; // String | The id of the mode.
Integer width = 56; // Integer | The width of the requested overlay.
Integer height = 56; // Integer | The height of the requested overlay.
String direction = "direction_example"; // String | The direction of travel.
Integer travelTimeInterval = 56; // Integer | The total minutes between the travel time bands
String compareType = "compareType_example"; // String | 
String compareValue = "compareValue_example"; // String | 
try {
    Object result = apiInstance.travelTimeGetCompareOverlay(z, pinLat, pinLon, mapCenterLat, mapCenterLon, scenarioTitle, timeOfDayId, modeId, width, height, direction, travelTimeInterval, compareType, compareValue);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TravelTimeApi#travelTimeGetCompareOverlay");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **z** | **Integer**| The zoom level. |
 **pinLat** | **Double**| The latitude of the pin. |
 **pinLon** | **Double**| The longitude of the pin. |
 **mapCenterLat** | **Double**| The map center latitude. |
 **mapCenterLon** | **Double**| The map center longitude. |
 **scenarioTitle** | **String**| The title of the scenario. |
 **timeOfDayId** | **String**| The id for the time of day (AM/INTER/PM) |
 **modeId** | **String**| The id of the mode. |
 **width** | **Integer**| The width of the requested overlay. |
 **height** | **Integer**| The height of the requested overlay. |
 **direction** | **String**| The direction of travel. | [enum: Average, From, To]
 **travelTimeInterval** | **Integer**| The total minutes between the travel time bands |
 **compareType** | **String**|  |
 **compareValue** | **String**|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="travelTimeGetOverlay"></a>
# **travelTimeGetOverlay**
> Object travelTimeGetOverlay(z, pinLat, pinLon, mapCenterLat, mapCenterLon, scenarioTitle, timeOfDayId, modeId, width, height, direction, travelTimeInterval)

Gets the TravelTime overlay.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.TravelTimeApi;


TravelTimeApi apiInstance = new TravelTimeApi();
Integer z = 56; // Integer | The zoom level.
Double pinLat = 3.4D; // Double | The latitude of the pin.
Double pinLon = 3.4D; // Double | The longitude of the pin.
Double mapCenterLat = 3.4D; // Double | The map center latitude.
Double mapCenterLon = 3.4D; // Double | The map center longitude.
String scenarioTitle = "scenarioTitle_example"; // String | The title of the scenario.
String timeOfDayId = "timeOfDayId_example"; // String | The id for the time of day (AM/INTER/PM)
String modeId = "modeId_example"; // String | The id of the mode.
Integer width = 56; // Integer | The width of the requested overlay.
Integer height = 56; // Integer | The height of the requested overlay.
String direction = "direction_example"; // String | The direction of travel.
Integer travelTimeInterval = 56; // Integer | The total minutes between the travel time bands
try {
    Object result = apiInstance.travelTimeGetOverlay(z, pinLat, pinLon, mapCenterLat, mapCenterLon, scenarioTitle, timeOfDayId, modeId, width, height, direction, travelTimeInterval);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TravelTimeApi#travelTimeGetOverlay");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **z** | **Integer**| The zoom level. |
 **pinLat** | **Double**| The latitude of the pin. |
 **pinLon** | **Double**| The longitude of the pin. |
 **mapCenterLat** | **Double**| The map center latitude. |
 **mapCenterLon** | **Double**| The map center longitude. |
 **scenarioTitle** | **String**| The title of the scenario. |
 **timeOfDayId** | **String**| The id for the time of day (AM/INTER/PM) |
 **modeId** | **String**| The id of the mode. |
 **width** | **Integer**| The width of the requested overlay. |
 **height** | **Integer**| The height of the requested overlay. |
 **direction** | **String**| The direction of travel. | [enum: Average, From, To]
 **travelTimeInterval** | **Integer**| The total minutes between the travel time bands |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

