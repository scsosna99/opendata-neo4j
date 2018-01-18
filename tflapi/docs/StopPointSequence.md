
# StopPointSequence

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lineId** | **String** |  |  [optional]
**lineName** | **String** |  |  [optional]
**direction** | **String** |  |  [optional]
**branchId** | **Integer** | The id of this branch. |  [optional]
**nextBranchIds** | **List&lt;Integer&gt;** | The ids of the next branch(es) in the sequence. Note that the next and previous branch id can be              identical in the case of a looped route e.g. the Circle lineId. |  [optional]
**prevBranchIds** | **List&lt;Integer&gt;** | The ids of the previous branch(es) in the sequence. Note that the next and previous branch id can be              identical in the case of a looped route e.g. the Circle lineId. |  [optional]
**stopPoint** | [**List&lt;MatchedStop&gt;**](MatchedStop.md) |  |  [optional]
**serviceType** | [**ServiceTypeEnum**](#ServiceTypeEnum) |  |  [optional]


<a name="ServiceTypeEnum"></a>
## Enum: ServiceTypeEnum
Name | Value
---- | -----
REGULAR | &quot;Regular&quot;
NIGHT | &quot;Night&quot;



