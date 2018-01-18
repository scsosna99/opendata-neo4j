
# InstructionStep

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** |  |  [optional]
**turnDirection** | **String** |  |  [optional]
**streetName** | **String** |  |  [optional]
**distance** | **Integer** |  |  [optional]
**cumulativeDistance** | **Integer** |  |  [optional]
**skyDirection** | **Integer** |  |  [optional]
**skyDirectionDescription** | [**SkyDirectionDescriptionEnum**](#SkyDirectionDescriptionEnum) |  |  [optional]
**cumulativeTravelTime** | **Integer** |  |  [optional]
**latitude** | **Double** |  |  [optional]
**longitude** | **Double** |  |  [optional]
**pathAttribute** | [**PathAttribute**](PathAttribute.md) |  |  [optional]
**descriptionHeading** | **String** |  |  [optional]
**trackType** | [**TrackTypeEnum**](#TrackTypeEnum) |  |  [optional]


<a name="SkyDirectionDescriptionEnum"></a>
## Enum: SkyDirectionDescriptionEnum
Name | Value
---- | -----
NORTH | &quot;North&quot;
NORTHEAST | &quot;NorthEast&quot;
EAST | &quot;East&quot;
SOUTHEAST | &quot;SouthEast&quot;
SOUTH | &quot;South&quot;
SOUTHWEST | &quot;SouthWest&quot;
WEST | &quot;West&quot;
NORTHWEST | &quot;NorthWest&quot;


<a name="TrackTypeEnum"></a>
## Enum: TrackTypeEnum
Name | Value
---- | -----
CYCLESUPERHIGHWAY | &quot;CycleSuperHighway&quot;
CANALTOWPATH | &quot;CanalTowpath&quot;
QUIETROAD | &quot;QuietRoad&quot;
PROVISIONFORCYCLISTS | &quot;ProvisionForCyclists&quot;
BUSYROADS | &quot;BusyRoads&quot;
NONE | &quot;None&quot;
PUSHBIKE | &quot;PushBike&quot;
QUIETWAY | &quot;Quietway&quot;



