# JourneyApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**journeyJourneyResults**](JourneyApi.md#journeyJourneyResults) | **GET** /Journey/JourneyResults/{from}/to/{to} | Perform a Journey Planner search from the parameters specified in simple types
[**journeyMeta**](JourneyApi.md#journeyMeta) | **GET** /Journey/Meta/Modes | Gets a list of all of the available journey planner modes


<a name="journeyJourneyResults"></a>
# **journeyJourneyResults**
> ItineraryResult journeyJourneyResults(from, to, via, nationalSearch, date, time, timeIs, journeyPreference, mode, accessibilityPreference, fromName, toName, viaName, maxTransferMinutes, maxWalkingMinutes, walkingSpeed, cyclePreference, adjustment, bikeProficiency, alternativeCycle, alternativeWalking, applyHtmlMarkup, useMultiModalCall, walkingOptimization, taxiOnlyTrip)

Perform a Journey Planner search from the parameters specified in simple types

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.JourneyApi;


JourneyApi apiInstance = new JourneyApi();
String from = "from_example"; // String | Origin of the journey. Can be WGS84 coordinates expressed as \"lat,long\", a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name).
String to = "to_example"; // String | Destination of the journey. Can be WGS84 coordinates expressed as \"lat,long\", a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name).
String via = "via_example"; // String | Travel through point on the journey. Can be WGS84 coordinates expressed as \"lat,long\", a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name).
Boolean nationalSearch = true; // Boolean | Does the journey cover stops outside London? eg. \"nationalSearch=true\"
String date = "date_example"; // String | The date must be in yyyyMMdd format
String time = "time_example"; // String | The time must be in HHmm format
String timeIs = "timeIs_example"; // String | Does the time given relate to arrival or leaving time? Possible options: \"departing\" | \"arriving\"
String journeyPreference = "journeyPreference_example"; // String | The journey preference eg possible options: \"leastinterchange\" | \"leasttime\" | \"leastwalking\"
List<String> mode = Arrays.asList("mode_example"); // List<String> | The mode must be a comma separated list of modes. eg possible options: \"public-bus,overground,train,tube,coach,dlr,cablecar,tram,river,walking,cycle\"
List<String> accessibilityPreference = Arrays.asList("accessibilityPreference_example"); // List<String> | The accessibility preference must be a comma separated list eg. \"noSolidStairs,noEscalators,noElevators,stepFreeToVehicle,stepFreeToPlatform\"
String fromName = "fromName_example"; // String | An optional name to associate with the origin of the journey in the results.
String toName = "toName_example"; // String | An optional name to associate with the destination of the journey in the results.
String viaName = "viaName_example"; // String | An optional name to associate with the via point of the journey in the results.
String maxTransferMinutes = "maxTransferMinutes_example"; // String | The max walking time in minutes for transfer eg. \"120\"
String maxWalkingMinutes = "maxWalkingMinutes_example"; // String | The max walking time in minutes for journeys eg. \"120\"
String walkingSpeed = "walkingSpeed_example"; // String | The walking speed. eg possible options: \"slow\" | \"average\" | \"fast\".
String cyclePreference = "cyclePreference_example"; // String | The cycle preference. eg possible options: \"allTheWay\" | \"leaveAtStation\" | \"takeOnTransport\" | \"cycleHire\"
String adjustment = "adjustment_example"; // String | Time adjustment command. eg possible options: \"TripFirst\" | \"TripLast\"
List<String> bikeProficiency = Arrays.asList("bikeProficiency_example"); // List<String> | A comma separated list of cycling proficiency levels. eg possible options: \"easy,moderate,fast\"
Boolean alternativeCycle = true; // Boolean | Option to determine whether to return alternative cycling journey
Boolean alternativeWalking = true; // Boolean | Option to determine whether to return alternative walking journey
Boolean applyHtmlMarkup = true; // Boolean | Flag to determine whether certain text (e.g. walking instructions) should be output with HTML tags or not.
Boolean useMultiModalCall = true; // Boolean | A boolean to indicate whether or not to return 3 public transport journeys, a bus journey, a cycle hire journey, a personal cycle journey and a walking journey
Boolean walkingOptimization = true; // Boolean | A boolean to indicate whether to optimize journeys using walking
Boolean taxiOnlyTrip = true; // Boolean | A boolean to indicate whether to return one or more taxi journeys. Note, setting this to true will override \"useMultiModalCall\".
try {
    ItineraryResult result = apiInstance.journeyJourneyResults(from, to, via, nationalSearch, date, time, timeIs, journeyPreference, mode, accessibilityPreference, fromName, toName, viaName, maxTransferMinutes, maxWalkingMinutes, walkingSpeed, cyclePreference, adjustment, bikeProficiency, alternativeCycle, alternativeWalking, applyHtmlMarkup, useMultiModalCall, walkingOptimization, taxiOnlyTrip);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JourneyApi#journeyJourneyResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **String**| Origin of the journey. Can be WGS84 coordinates expressed as \&quot;lat,long\&quot;, a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name). |
 **to** | **String**| Destination of the journey. Can be WGS84 coordinates expressed as \&quot;lat,long\&quot;, a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name). |
 **via** | **String**| Travel through point on the journey. Can be WGS84 coordinates expressed as \&quot;lat,long\&quot;, a UK postcode, a Naptan (StopPoint) id, an ICS StopId, or a free-text string (will cause disambiguation unless it exactly matches a point of interest name). | [optional]
 **nationalSearch** | **Boolean**| Does the journey cover stops outside London? eg. \&quot;nationalSearch&#x3D;true\&quot; | [optional]
 **date** | **String**| The date must be in yyyyMMdd format | [optional]
 **time** | **String**| The time must be in HHmm format | [optional]
 **timeIs** | **String**| Does the time given relate to arrival or leaving time? Possible options: \&quot;departing\&quot; | \&quot;arriving\&quot; | [optional] [enum: Arriving, Departing]
 **journeyPreference** | **String**| The journey preference eg possible options: \&quot;leastinterchange\&quot; | \&quot;leasttime\&quot; | \&quot;leastwalking\&quot; | [optional] [enum: LeastInterchange, LeastTime, LeastWalking]
 **mode** | [**List&lt;String&gt;**](String.md)| The mode must be a comma separated list of modes. eg possible options: \&quot;public-bus,overground,train,tube,coach,dlr,cablecar,tram,river,walking,cycle\&quot; | [optional]
 **accessibilityPreference** | [**List&lt;String&gt;**](String.md)| The accessibility preference must be a comma separated list eg. \&quot;noSolidStairs,noEscalators,noElevators,stepFreeToVehicle,stepFreeToPlatform\&quot; | [optional] [enum: NoRequirements, NoSolidStairs, NoEscalators, NoElevators, StepFreeToVehicle, StepFreeToPlatform]
 **fromName** | **String**| An optional name to associate with the origin of the journey in the results. | [optional]
 **toName** | **String**| An optional name to associate with the destination of the journey in the results. | [optional]
 **viaName** | **String**| An optional name to associate with the via point of the journey in the results. | [optional]
 **maxTransferMinutes** | **String**| The max walking time in minutes for transfer eg. \&quot;120\&quot; | [optional]
 **maxWalkingMinutes** | **String**| The max walking time in minutes for journeys eg. \&quot;120\&quot; | [optional]
 **walkingSpeed** | **String**| The walking speed. eg possible options: \&quot;slow\&quot; | \&quot;average\&quot; | \&quot;fast\&quot;. | [optional] [enum: Slow, Average, Fast]
 **cyclePreference** | **String**| The cycle preference. eg possible options: \&quot;allTheWay\&quot; | \&quot;leaveAtStation\&quot; | \&quot;takeOnTransport\&quot; | \&quot;cycleHire\&quot; | [optional] [enum: None, LeaveAtStation, TakeOnTransport, AllTheWay, CycleHire]
 **adjustment** | **String**| Time adjustment command. eg possible options: \&quot;TripFirst\&quot; | \&quot;TripLast\&quot; | [optional]
 **bikeProficiency** | [**List&lt;String&gt;**](String.md)| A comma separated list of cycling proficiency levels. eg possible options: \&quot;easy,moderate,fast\&quot; | [optional] [enum: Easy, Moderate, Fast]
 **alternativeCycle** | **Boolean**| Option to determine whether to return alternative cycling journey | [optional]
 **alternativeWalking** | **Boolean**| Option to determine whether to return alternative walking journey | [optional]
 **applyHtmlMarkup** | **Boolean**| Flag to determine whether certain text (e.g. walking instructions) should be output with HTML tags or not. | [optional]
 **useMultiModalCall** | **Boolean**| A boolean to indicate whether or not to return 3 public transport journeys, a bus journey, a cycle hire journey, a personal cycle journey and a walking journey | [optional]
 **walkingOptimization** | **Boolean**| A boolean to indicate whether to optimize journeys using walking | [optional]
 **taxiOnlyTrip** | **Boolean**| A boolean to indicate whether to return one or more taxi journeys. Note, setting this to true will override \&quot;useMultiModalCall\&quot;. | [optional]

### Return type

[**ItineraryResult**](ItineraryResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="journeyMeta"></a>
# **journeyMeta**
> List&lt;Mode&gt; journeyMeta()

Gets a list of all of the available journey planner modes

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.JourneyApi;


JourneyApi apiInstance = new JourneyApi();
try {
    List<Mode> result = apiInstance.journeyMeta();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling JourneyApi#journeyMeta");
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

