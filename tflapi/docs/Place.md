
# Place

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
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



