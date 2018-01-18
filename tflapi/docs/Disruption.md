
# Disruption

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**category** | [**CategoryEnum**](#CategoryEnum) | Gets or sets the category of this dispruption. |  [optional]
**type** | **String** | Gets or sets the disruption type of this dispruption. |  [optional]
**categoryDescription** | **String** | Gets or sets the description of the category. |  [optional]
**description** | **String** | Gets or sets the description of this disruption. |  [optional]
**summary** | **String** | Gets or sets the summary of this disruption. |  [optional]
**additionalInfo** | **String** | Gets or sets the additionaInfo of this disruption. |  [optional]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | Gets or sets the date/time when this disruption was created. |  [optional]
**lastUpdate** | [**OffsetDateTime**](OffsetDateTime.md) | Gets or sets the date/time when this disruption was last updated. |  [optional]
**affectedRoutes** | [**List&lt;RouteSection&gt;**](RouteSection.md) | Gets or sets the routes affected by this disruption |  [optional]
**affectedStops** | [**List&lt;StopPoint&gt;**](StopPoint.md) | Gets or sets the stops affected by this disruption |  [optional]
**closureText** | **String** | Text describing the closure type |  [optional]


<a name="CategoryEnum"></a>
## Enum: CategoryEnum
Name | Value
---- | -----
UNDEFINED | &quot;Undefined&quot;
REALTIME | &quot;RealTime&quot;
PLANNEDWORK | &quot;PlannedWork&quot;
INFORMATION | &quot;Information&quot;
EVENT | &quot;Event&quot;
CROWDING | &quot;Crowding&quot;
STATUSALERT | &quot;StatusAlert&quot;



