# AccidentStatsApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accidentStatsGet**](AccidentStatsApi.md#accidentStatsGet) | **GET** /AccidentStats/{year} | Gets all accident details for accidents occuring in the specified year


<a name="accidentStatsGet"></a>
# **accidentStatsGet**
> List&lt;AccidentDetail&gt; accidentStatsGet(year)

Gets all accident details for accidents occuring in the specified year

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.AccidentStatsApi;


AccidentStatsApi apiInstance = new AccidentStatsApi();
Integer year = 56; // Integer | The year for which to filter the accidents on.
try {
    List<AccidentDetail> result = apiInstance.accidentStatsGet(year);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccidentStatsApi#accidentStatsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **year** | **Integer**| The year for which to filter the accidents on. |

### Return type

[**List&lt;AccidentDetail&gt;**](AccidentDetail.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

