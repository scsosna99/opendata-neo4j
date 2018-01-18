
# Prediction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The identitier for the prediction |  [optional]
**operationType** | **Integer** | The type of the operation (1: is new or has been updated, 2: should be deleted from any client cache) |  [optional]
**vehicleId** | **String** | The actual vehicle in transit (for train modes, the leading car of the rolling set) |  [optional]
**naptanId** | **String** | Identifier for the prediction |  [optional]
**stationName** | **String** | Station name |  [optional]
**lineId** | **String** | Unique identifier for the Line |  [optional]
**lineName** | **String** | Line Name |  [optional]
**platformName** | **String** | Platform name (for bus, this is the stop letter) |  [optional]
**direction** | **String** | Direction (unified to inbound/outbound) |  [optional]
**bearing** | **String** | Bearing (between 0 to 359) |  [optional]
**destinationNaptanId** | **String** | Naptan Identifier for the prediction&#39;s destination |  [optional]
**destinationName** | **String** | Name of the destination |  [optional]
**timestamp** | [**OffsetDateTime**](OffsetDateTime.md) | Timestamp for when the prediction was inserted/modified (source column drives what objects are broadcast on each iteration) |  [optional]
**timeToStation** | **Integer** | Prediction of the Time to station in seconds |  [optional]
**currentLocation** | **String** | The current location of the vehicle. |  [optional]
**towards** | **String** | Routing information or other descriptive text about the path of the vehicle towards the destination |  [optional]
**expectedArrival** | [**OffsetDateTime**](OffsetDateTime.md) | The expected arrival time of the vehicle at the stop/station |  [optional]
**timeToLive** | [**OffsetDateTime**](OffsetDateTime.md) | The expiry time for the prediction |  [optional]
**modeName** | **String** | The mode name of the station/lineId the prediction relates to |  [optional]
**timing** | [**PredictionTiming**](PredictionTiming.md) | Keep the original timestamp from MongoDb fo debugging purposes |  [optional]



