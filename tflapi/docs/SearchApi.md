# SearchApi

All URIs are relative to *https://api.tfl.gov.uk*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchBusSchedules**](SearchApi.md#searchBusSchedules) | **GET** /Search/BusSchedules | Searches the bus schedules folder on S3 for a given bus number.
[**searchGet**](SearchApi.md#searchGet) | **GET** /Search | Search the site for occurrences of the query string. The maximum number of results returned is equal to the maximum page size              of 100. To return subsequent pages, use the paginated overload.
[**searchMetaCategories**](SearchApi.md#searchMetaCategories) | **GET** /Search/Meta/Categories | Gets the available search categories.
[**searchMetaSearchProviders**](SearchApi.md#searchMetaSearchProviders) | **GET** /Search/Meta/SearchProviders | Gets the available searchProvider names.
[**searchMetaSorts**](SearchApi.md#searchMetaSorts) | **GET** /Search/Meta/Sorts | Gets the available sorting options.


<a name="searchBusSchedules"></a>
# **searchBusSchedules**
> SearchResponse searchBusSchedules(query)

Searches the bus schedules folder on S3 for a given bus number.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
String query = "query_example"; // String | The search query
try {
    SearchResponse result = apiInstance.searchBusSchedules(query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchBusSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The search query |

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="searchGet"></a>
# **searchGet**
> SearchResponse searchGet(query)

Search the site for occurrences of the query string. The maximum number of results returned is equal to the maximum page size              of 100. To return subsequent pages, use the paginated overload.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
String query = "query_example"; // String | The search query
try {
    SearchResponse result = apiInstance.searchGet(query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The search query |

### Return type

[**SearchResponse**](SearchResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="searchMetaCategories"></a>
# **searchMetaCategories**
> List&lt;String&gt; searchMetaCategories()

Gets the available search categories.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
try {
    List<String> result = apiInstance.searchMetaCategories();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchMetaCategories");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="searchMetaSearchProviders"></a>
# **searchMetaSearchProviders**
> List&lt;String&gt; searchMetaSearchProviders()

Gets the available searchProvider names.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
try {
    List<String> result = apiInstance.searchMetaSearchProviders();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchMetaSearchProviders");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

<a name="searchMetaSorts"></a>
# **searchMetaSorts**
> List&lt;String&gt; searchMetaSorts()

Gets the available sorting options.

### Example
```java
// Import classes:
//import uk.gov.tfl.api.client.client.ApiException;
//import uk.gov.tfl.api.client.client.api.SearchApi;


SearchApi apiInstance = new SearchApi();
try {
    List<String> result = apiInstance.searchMetaSorts();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SearchApi#searchMetaSorts");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/json, application/xml, text/xml

