
# RoadProject

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**projectId** | **String** |  |  [optional]
**schemeName** | **String** |  |  [optional]
**projectName** | **String** |  |  [optional]
**projectDescription** | **String** |  |  [optional]
**projectPageUrl** | **String** |  |  [optional]
**consultationPageUrl** | **String** |  |  [optional]
**consultationStartDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**consultationEndDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**constructionStartDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**constructionEndDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**boroughsBenefited** | **List&lt;String&gt;** |  |  [optional]
**cycleSuperhighwayId** | **String** |  |  [optional]
**phase** | [**PhaseEnum**](#PhaseEnum) |  |  [optional]
**contactName** | **String** |  |  [optional]
**contactEmail** | **String** |  |  [optional]
**externalPageUrl** | **String** |  |  [optional]
**projectSummaryPageUrl** | **String** |  |  [optional]


<a name="PhaseEnum"></a>
## Enum: PhaseEnum
Name | Value
---- | -----
UNSCOPED | &quot;Unscoped&quot;
CONCEPT | &quot;Concept&quot;
CONSULTATIONENDED | &quot;ConsultationEnded&quot;
CONSULTATION | &quot;Consultation&quot;
CONSTRUCTION | &quot;Construction&quot;
COMPLETE | &quot;Complete&quot;



