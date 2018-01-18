
# Street

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Street name |  [optional]
**closure** | **String** | Type of road closure. Some example values:              Open &#x3D; road is open, not blocked, not closed, not restricted. It maybe that the disruption has been moved out of the carriageway.              Partial Closure &#x3D; road is partially blocked, closed or restricted.               Full Closure &#x3D; road is fully blocked or closed. |  [optional]
**directions** | **String** | The direction of the disruption on the street. Some example values:              All Directions              All Approaches              Clockwise              Anti-Clockwise              Northbound              Eastbound              Southbound              Westbound              Both Directions |  [optional]
**segments** | [**List&lt;StreetSegment&gt;**](StreetSegment.md) | Geographic description of the sections of this street that are affected. |  [optional]
**sourceSystemId** | **Long** | The ID from the source system of the disruption that this street belongs to. |  [optional]
**sourceSystemKey** | **String** | The key of the source system of the disruption that this street belongs to. |  [optional]



