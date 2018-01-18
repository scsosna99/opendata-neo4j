
# StopPoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**naptanId** | **String** |  |  [optional]
**platformName** | **String** |  |  [optional]
**indicator** | **String** | The indicator of the stop point e.g. \&quot;Stop K\&quot; |  [optional]
**stopLetter** | **String** | The stop letter, if it could be cleansed from the Indicator e.g. \&quot;K\&quot; |  [optional]
**modes** | **List&lt;String&gt;** |  |  [optional]
**icsCode** | **String** |  |  [optional]
**smsCode** | **String** |  |  [optional]
**stopType** | **String** |  |  [optional]
**stationNaptan** | **String** |  |  [optional]
**accessibilitySummary** | **String** |  |  [optional]
**hubNaptanCode** | **String** |  |  [optional]
**lines** | [**List&lt;Identifier&gt;**](Identifier.md) |  |  [optional]
**lineGroup** | [**List&lt;LineGroup&gt;**](LineGroup.md) |  |  [optional]
**lineModeGroups** | [**List&lt;LineModeGroup&gt;**](LineModeGroup.md) |  |  [optional]
**fullName** | **String** |  |  [optional]
**naptanMode** | **String** |  |  [optional]
**status** | **Boolean** |  |  [optional]
**id** | **String** | A unique identifier. |  [optional]
**url** | **String** | The unique location of this resource. |  [optional]
**commonName** | **String** | A human readable name. |  [optional]
**distance** | **Double** | The distance of the place from its search point, if this is the result              of a geographical search, otherwise zero. |  [optional]
**placeType** | **String** | The type of Place. See /Place/Meta/placeTypes for possible values. |  [optional]
**additionalProperties** | [**List&lt;AdditionalProperties&gt;**](AdditionalProperties.md) | A bag of additional key/value pairs with extra information about this place. |  [optional]
**children** | [**List&lt;Place&gt;**](Place.md) |  |  [optional]
**childrenUrls** | **List&lt;String&gt;** |  |  [optional]
**lat** | **Double** | WGS84 latitude of the location. |  [optional]
**lon** | **Double** | WGS84 longitude of the location. |  [optional]



