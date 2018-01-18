
# RouteSection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The Id of the route |  [optional]
**lineId** | **String** | The Id of the Line |  [optional]
**routeCode** | **String** | The route code |  [optional]
**name** | **String** | Name such as \&quot;72\&quot; |  [optional]
**lineString** | **String** | The co-ordinates of the route&#39;s path as a geoJSON lineString |  [optional]
**direction** | **String** | Inbound or Outbound |  [optional]
**originationName** | **String** | The name of the Origin StopPoint |  [optional]
**destinationName** | **String** | The name of the Destination StopPoint |  [optional]
**validTo** | [**OffsetDateTime**](OffsetDateTime.md) | The DateTime that the Service containing this Route is valid until. |  [optional]
**validFrom** | [**OffsetDateTime**](OffsetDateTime.md) | The DateTime that the Service containing this Route is valid from. |  [optional]
**routeSectionNaptanEntrySequence** | [**List&lt;RouteSectionNaptanEntrySequence&gt;**](RouteSectionNaptanEntrySequence.md) |  |  [optional]



