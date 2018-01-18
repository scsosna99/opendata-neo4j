
# RoadCorridor

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The Id of the Corridor e.g. \&quot;A406\&quot; |  [optional]
**displayName** | **String** | The display name of the Corridor e.g. \&quot;North Circular (A406)\&quot;. This              may be identical to the Id. |  [optional]
**group** | **String** | The group name of the Corridor e.g. \&quot;Central London\&quot;. Most corridors are not grouped, in which case this field can be null. |  [optional]
**statusSeverity** | **String** | Standard multi-mode status severity code |  [optional]
**statusSeverityDescription** | **String** | Description of the status severity as applied to RoadCorridors |  [optional]
**bounds** | **String** | The Bounds of the Corridor, given by the south-east followed by the north-west co-ordinate              pair in geoJSON format e.g. \&quot;[[-1.241531,51.242151],[1.641223,53.765721]]\&quot; |  [optional]
**envelope** | **String** | The Envelope of the Corridor, given by the corner co-ordinates of a rectangular (four-point) polygon              in geoJSON format e.g. \&quot;[[-1.241531,51.242151],[-1.241531,53.765721],[1.641223,53.765721],[1.641223,51.242151]]\&quot; |  [optional]
**statusAggregationStartDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start of the period over which status has been aggregated, or null if this is the current corridor status. |  [optional]
**statusAggregationEndDate** | [**OffsetDateTime**](OffsetDateTime.md) | The end of the period over which status has been aggregated, or null if this is the current corridor status. |  [optional]
**url** | **String** | URL to retrieve this Corridor. |  [optional]



