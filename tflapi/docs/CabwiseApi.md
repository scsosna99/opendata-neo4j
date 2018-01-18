# CabwiseApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cabwiseGet**](CabwiseApi.md#cabwiseGet) | **GET** /Cabwise/search | Gets taxis and minicabs contact information


<a name="cabwiseGet"></a>
# **cabwiseGet**
> Object cabwiseGet(lat, lon, optype, wc, radius, name, maxResults, legacyFormat, forceXml, twentyFourSevenOnly)

Gets taxis and minicabs contact information

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.CabwiseApi;


CabwiseApi apiInstance = new CabwiseApi();
Double lat = 3.4D; // Double | Latitude
Double lon = 3.4D; // Double | Longitude
String optype = "optype_example"; // String | Operator Type e.g Minicab, Executive, Limousine
String wc = "wc_example"; // String | Wheelchair accessible
Double radius = 3.4D; // Double | The radius of the bounding circle in metres
String name = "name_example"; // String | Trading name of operating company
Integer maxResults = 56; // Integer | An optional parameter to limit the number of results return. Default and maximum is 20.
Boolean legacyFormat = true; // Boolean | Legacy Format
Boolean forceXml = true; // Boolean | Force Xml
Boolean twentyFourSevenOnly = true; // Boolean | Twenty Four Seven Only
try {
    Object result = apiInstance.cabwiseGet(lat, lon, optype, wc, radius, name, maxResults, legacyFormat, forceXml, twentyFourSevenOnly);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CabwiseApi#cabwiseGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Double**| Latitude |
 **lon** | **Double**| Longitude |
 **optype** | **String**| Operator Type e.g Minicab, Executive, Limousine | [optional]
 **wc** | **String**| Wheelchair accessible | [optional]
 **radius** | **Double**| The radius of the bounding circle in metres | [optional]
 **name** | **String**| Trading name of operating company | [optional]
 **maxResults** | **Integer**| An optional parameter to limit the number of results return. Default and maximum is 20. | [optional]
 **legacyFormat** | **Boolean**| Legacy Format | [optional]
 **forceXml** | **Boolean**| Force Xml | [optional]
 **twentyFourSevenOnly** | **Boolean**| Twenty Four Seven Only | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

