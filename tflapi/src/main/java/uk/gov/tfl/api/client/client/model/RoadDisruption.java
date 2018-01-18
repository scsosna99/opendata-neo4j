/*
 * Transport for London Unified API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package uk.gov.tfl.api.client.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * RoadDisruption
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class RoadDisruption {
  @SerializedName("id")
  private String id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("point")
  private String point = null;

  @SerializedName("severity")
  private String severity = null;

  @SerializedName("ordinal")
  private Integer ordinal = null;

  @SerializedName("category")
  private String category = null;

  @SerializedName("subCategory")
  private String subCategory = null;

  @SerializedName("comments")
  private String comments = null;

  @SerializedName("currentUpdate")
  private String currentUpdate = null;

  @SerializedName("currentUpdateDateTime")
  private OffsetDateTime currentUpdateDateTime = null;

  @SerializedName("corridorIds")
  private List<String> corridorIds = null;

  @SerializedName("startDateTime")
  private OffsetDateTime startDateTime = null;

  @SerializedName("endDateTime")
  private OffsetDateTime endDateTime = null;

  @SerializedName("lastModifiedTime")
  private OffsetDateTime lastModifiedTime = null;

  @SerializedName("levelOfInterest")
  private String levelOfInterest = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("geography")
  private DbGeography geography = null;

  @SerializedName("geometry")
  private DbGeography geometry = null;

  @SerializedName("streets")
  private List<Street> streets = null;

  @SerializedName("isProvisional")
  private Boolean isProvisional = null;

  @SerializedName("hasClosures")
  private Boolean hasClosures = null;

  @SerializedName("linkText")
  private String linkText = null;

  @SerializedName("linkUrl")
  private String linkUrl = null;

  @SerializedName("roadProject")
  private RoadProject roadProject = null;

  @SerializedName("publishStartDate")
  private OffsetDateTime publishStartDate = null;

  @SerializedName("publishEndDate")
  private OffsetDateTime publishEndDate = null;

  @SerializedName("timeFrame")
  private String timeFrame = null;

  @SerializedName("roadDisruptionLines")
  private List<RoadDisruptionLine> roadDisruptionLines = null;

  @SerializedName("roadDisruptionImpactAreas")
  private List<RoadDisruptionImpactArea> roadDisruptionImpactAreas = null;

  @SerializedName("recurringSchedules")
  private List<RoadDisruptionSchedule> recurringSchedules = null;

  public RoadDisruption id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the road disruption
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for the road disruption")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RoadDisruption url(String url) {
    this.url = url;
    return this;
  }

   /**
   * URL to retrieve this road disruption
   * @return url
  **/
  @ApiModelProperty(value = "URL to retrieve this road disruption")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public RoadDisruption point(String point) {
    this.point = point;
    return this;
  }

   /**
   * Latitude and longitude (WGS84) of the centroid of the disruption, stored in a geoJSON-formatted string.
   * @return point
  **/
  @ApiModelProperty(value = "Latitude and longitude (WGS84) of the centroid of the disruption, stored in a geoJSON-formatted string.")
  public String getPoint() {
    return point;
  }

  public void setPoint(String point) {
    this.point = point;
  }

  public RoadDisruption severity(String severity) {
    this.severity = severity;
    return this;
  }

   /**
   * A description of the severity of the disruption.
   * @return severity
  **/
  @ApiModelProperty(value = "A description of the severity of the disruption.")
  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public RoadDisruption ordinal(Integer ordinal) {
    this.ordinal = ordinal;
    return this;
  }

   /**
   * An ordinal of the disruption based on severity, level of interest and corridor.
   * @return ordinal
  **/
  @ApiModelProperty(value = "An ordinal of the disruption based on severity, level of interest and corridor.")
  public Integer getOrdinal() {
    return ordinal;
  }

  public void setOrdinal(Integer ordinal) {
    this.ordinal = ordinal;
  }

  public RoadDisruption category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Describes the nature of disruption e.g. Traffic Incidents, Works
   * @return category
  **/
  @ApiModelProperty(value = "Describes the nature of disruption e.g. Traffic Incidents, Works")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public RoadDisruption subCategory(String subCategory) {
    this.subCategory = subCategory;
    return this;
  }

   /**
   * Describes the sub-category of disruption e.g. Collapsed Manhole, Abnormal Load
   * @return subCategory
  **/
  @ApiModelProperty(value = "Describes the sub-category of disruption e.g. Collapsed Manhole, Abnormal Load")
  public String getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(String subCategory) {
    this.subCategory = subCategory;
  }

  public RoadDisruption comments(String comments) {
    this.comments = comments;
    return this;
  }

   /**
   * Full text of comments describing the disruption, including details of any road closures and diversions, where appropriate.
   * @return comments
  **/
  @ApiModelProperty(value = "Full text of comments describing the disruption, including details of any road closures and diversions, where appropriate.")
  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public RoadDisruption currentUpdate(String currentUpdate) {
    this.currentUpdate = currentUpdate;
    return this;
  }

   /**
   * Text of the most recent update from the LSTCC on the state of the               disruption, including the current traffic impact and any advice to               road users.
   * @return currentUpdate
  **/
  @ApiModelProperty(value = "Text of the most recent update from the LSTCC on the state of the               disruption, including the current traffic impact and any advice to               road users.")
  public String getCurrentUpdate() {
    return currentUpdate;
  }

  public void setCurrentUpdate(String currentUpdate) {
    this.currentUpdate = currentUpdate;
  }

  public RoadDisruption currentUpdateDateTime(OffsetDateTime currentUpdateDateTime) {
    this.currentUpdateDateTime = currentUpdateDateTime;
    return this;
  }

   /**
   * The time when the last CurrentUpdate description was recorded,               or null if no CurrentUpdate has been applied.
   * @return currentUpdateDateTime
  **/
  @ApiModelProperty(value = "The time when the last CurrentUpdate description was recorded,               or null if no CurrentUpdate has been applied.")
  public OffsetDateTime getCurrentUpdateDateTime() {
    return currentUpdateDateTime;
  }

  public void setCurrentUpdateDateTime(OffsetDateTime currentUpdateDateTime) {
    this.currentUpdateDateTime = currentUpdateDateTime;
  }

  public RoadDisruption corridorIds(List<String> corridorIds) {
    this.corridorIds = corridorIds;
    return this;
  }

  public RoadDisruption addCorridorIdsItem(String corridorIdsItem) {
    if (this.corridorIds == null) {
      this.corridorIds = new ArrayList<String>();
    }
    this.corridorIds.add(corridorIdsItem);
    return this;
  }

   /**
   * The Ids of affected corridors, if any.
   * @return corridorIds
  **/
  @ApiModelProperty(value = "The Ids of affected corridors, if any.")
  public List<String> getCorridorIds() {
    return corridorIds;
  }

  public void setCorridorIds(List<String> corridorIds) {
    this.corridorIds = corridorIds;
  }

  public RoadDisruption startDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

   /**
   * The date and time which the disruption started. For a planned disruption (i.e. planned road works) this date will be in the future.              For unplanned disruptions, this will default to the date on which the disruption was first recorded, but may be adjusted by the operator.
   * @return startDateTime
  **/
  @ApiModelProperty(value = "The date and time which the disruption started. For a planned disruption (i.e. planned road works) this date will be in the future.              For unplanned disruptions, this will default to the date on which the disruption was first recorded, but may be adjusted by the operator.")
  public OffsetDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public RoadDisruption endDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

   /**
   * The date and time on which the disruption ended. For planned disruptions, this date will have a valid value. For unplanned               disruptions in progress, this field will be omitted.
   * @return endDateTime
  **/
  @ApiModelProperty(value = "The date and time on which the disruption ended. For planned disruptions, this date will have a valid value. For unplanned               disruptions in progress, this field will be omitted.")
  public OffsetDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
  }

  public RoadDisruption lastModifiedTime(OffsetDateTime lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
    return this;
  }

   /**
   * The date and time on which the disruption was last modified in the system. This information can reliably be used by a developer to quickly              compare two instances of the same disruption to determine if it has been changed.
   * @return lastModifiedTime
  **/
  @ApiModelProperty(value = "The date and time on which the disruption was last modified in the system. This information can reliably be used by a developer to quickly              compare two instances of the same disruption to determine if it has been changed.")
  public OffsetDateTime getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(OffsetDateTime lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public RoadDisruption levelOfInterest(String levelOfInterest) {
    this.levelOfInterest = levelOfInterest;
    return this;
  }

   /**
   * This describes the level of potential impact on traffic operations of the disruption.               High &#x3D; e.g. a one-off disruption on a major or high profile route which will require a high level of operational attention               Medium &#x3D; This is the default value               Low &#x3D; e.g. a frequently occurring disruption which is well known
   * @return levelOfInterest
  **/
  @ApiModelProperty(value = "This describes the level of potential impact on traffic operations of the disruption.               High = e.g. a one-off disruption on a major or high profile route which will require a high level of operational attention               Medium = This is the default value               Low = e.g. a frequently occurring disruption which is well known")
  public String getLevelOfInterest() {
    return levelOfInterest;
  }

  public void setLevelOfInterest(String levelOfInterest) {
    this.levelOfInterest = levelOfInterest;
  }

  public RoadDisruption location(String location) {
    this.location = location;
    return this;
  }

   /**
   * Main road name / number (borough) or preset area name where the disruption is located. This might be useful for a map popup where space is limited.
   * @return location
  **/
  @ApiModelProperty(value = "Main road name / number (borough) or preset area name where the disruption is located. This might be useful for a map popup where space is limited.")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public RoadDisruption status(String status) {
    this.status = status;
    return this;
  }

   /**
   * This describes the status of the disruption.                Active &#x3D; currently in progress               Active Long Term &#x3D; currently in progress and long term              Scheduled &#x3D; scheduled to start within the next 180 days              Recurring Works &#x3D; planned maintenance works that follow a regular routine or pattern and whose next occurrence is to start within the next 180 days.              Recently Cleared &#x3D; recently cleared in the last 24 hours              Note that the status of Scheduled or Recurring Works disruptions will change to Active when they start, and will change status again when they end.
   * @return status
  **/
  @ApiModelProperty(value = "This describes the status of the disruption.                Active = currently in progress               Active Long Term = currently in progress and long term              Scheduled = scheduled to start within the next 180 days              Recurring Works = planned maintenance works that follow a regular routine or pattern and whose next occurrence is to start within the next 180 days.              Recently Cleared = recently cleared in the last 24 hours              Note that the status of Scheduled or Recurring Works disruptions will change to Active when they start, and will change status again when they end.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public RoadDisruption geography(DbGeography geography) {
    this.geography = geography;
    return this;
  }

   /**
   * Geography version of Point for output as GeoJSON.              Can not use Geometry in a consistent way as non-TIMS disruptions do not have a polygon
   * @return geography
  **/
  @ApiModelProperty(value = "Geography version of Point for output as GeoJSON.              Can not use Geometry in a consistent way as non-TIMS disruptions do not have a polygon")
  public DbGeography getGeography() {
    return geography;
  }

  public void setGeography(DbGeography geography) {
    this.geography = geography;
  }

  public RoadDisruption geometry(DbGeography geometry) {
    this.geometry = geometry;
    return this;
  }

   /**
   * GeoJSON formatted latitude/longitude (WGS84) pairs forming an enclosed polyline or polygon. The polygon will only be included where affected streets information              is not available for the disruption, would be inappropriate (e.g. a very large number of streets), or is centred on an area without streets (e.g. a football stadium).
   * @return geometry
  **/
  @ApiModelProperty(value = "GeoJSON formatted latitude/longitude (WGS84) pairs forming an enclosed polyline or polygon. The polygon will only be included where affected streets information              is not available for the disruption, would be inappropriate (e.g. a very large number of streets), or is centred on an area without streets (e.g. a football stadium).")
  public DbGeography getGeometry() {
    return geometry;
  }

  public void setGeometry(DbGeography geometry) {
    this.geometry = geometry;
  }

  public RoadDisruption streets(List<Street> streets) {
    this.streets = streets;
    return this;
  }

  public RoadDisruption addStreetsItem(Street streetsItem) {
    if (this.streets == null) {
      this.streets = new ArrayList<Street>();
    }
    this.streets.add(streetsItem);
    return this;
  }

   /**
   * A collection of zero or more streets affected by the disruption.
   * @return streets
  **/
  @ApiModelProperty(value = "A collection of zero or more streets affected by the disruption.")
  public List<Street> getStreets() {
    return streets;
  }

  public void setStreets(List<Street> streets) {
    this.streets = streets;
  }

  public RoadDisruption isProvisional(Boolean isProvisional) {
    this.isProvisional = isProvisional;
    return this;
  }

   /**
   * True if the disruption is planned on a future date that is open to change
   * @return isProvisional
  **/
  @ApiModelProperty(value = "True if the disruption is planned on a future date that is open to change")
  public Boolean isIsProvisional() {
    return isProvisional;
  }

  public void setIsProvisional(Boolean isProvisional) {
    this.isProvisional = isProvisional;
  }

  public RoadDisruption hasClosures(Boolean hasClosures) {
    this.hasClosures = hasClosures;
    return this;
  }

   /**
   * True if any of the affected Streets have a \&quot;Full Closure\&quot; status, false otherwise. A RoadDisruption that has HasClosures is considered a               Severe or Serious disruption for severity filtering purposes.
   * @return hasClosures
  **/
  @ApiModelProperty(value = "True if any of the affected Streets have a \"Full Closure\" status, false otherwise. A RoadDisruption that has HasClosures is considered a               Severe or Serious disruption for severity filtering purposes.")
  public Boolean isHasClosures() {
    return hasClosures;
  }

  public void setHasClosures(Boolean hasClosures) {
    this.hasClosures = hasClosures;
  }

  public RoadDisruption linkText(String linkText) {
    this.linkText = linkText;
    return this;
  }

   /**
   * The text of any associated link
   * @return linkText
  **/
  @ApiModelProperty(value = "The text of any associated link")
  public String getLinkText() {
    return linkText;
  }

  public void setLinkText(String linkText) {
    this.linkText = linkText;
  }

  public RoadDisruption linkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
    return this;
  }

   /**
   * The url of any associated link
   * @return linkUrl
  **/
  @ApiModelProperty(value = "The url of any associated link")
  public String getLinkUrl() {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }

  public RoadDisruption roadProject(RoadProject roadProject) {
    this.roadProject = roadProject;
    return this;
  }

   /**
   * Any associated road project
   * @return roadProject
  **/
  @ApiModelProperty(value = "Any associated road project")
  public RoadProject getRoadProject() {
    return roadProject;
  }

  public void setRoadProject(RoadProject roadProject) {
    this.roadProject = roadProject;
  }

  public RoadDisruption publishStartDate(OffsetDateTime publishStartDate) {
    this.publishStartDate = publishStartDate;
    return this;
  }

   /**
   * TDM Additional properties
   * @return publishStartDate
  **/
  @ApiModelProperty(value = "TDM Additional properties")
  public OffsetDateTime getPublishStartDate() {
    return publishStartDate;
  }

  public void setPublishStartDate(OffsetDateTime publishStartDate) {
    this.publishStartDate = publishStartDate;
  }

  public RoadDisruption publishEndDate(OffsetDateTime publishEndDate) {
    this.publishEndDate = publishEndDate;
    return this;
  }

   /**
   * Get publishEndDate
   * @return publishEndDate
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getPublishEndDate() {
    return publishEndDate;
  }

  public void setPublishEndDate(OffsetDateTime publishEndDate) {
    this.publishEndDate = publishEndDate;
  }

  public RoadDisruption timeFrame(String timeFrame) {
    this.timeFrame = timeFrame;
    return this;
  }

   /**
   * Get timeFrame
   * @return timeFrame
  **/
  @ApiModelProperty(value = "")
  public String getTimeFrame() {
    return timeFrame;
  }

  public void setTimeFrame(String timeFrame) {
    this.timeFrame = timeFrame;
  }

  public RoadDisruption roadDisruptionLines(List<RoadDisruptionLine> roadDisruptionLines) {
    this.roadDisruptionLines = roadDisruptionLines;
    return this;
  }

  public RoadDisruption addRoadDisruptionLinesItem(RoadDisruptionLine roadDisruptionLinesItem) {
    if (this.roadDisruptionLines == null) {
      this.roadDisruptionLines = new ArrayList<RoadDisruptionLine>();
    }
    this.roadDisruptionLines.add(roadDisruptionLinesItem);
    return this;
  }

   /**
   * Get roadDisruptionLines
   * @return roadDisruptionLines
  **/
  @ApiModelProperty(value = "")
  public List<RoadDisruptionLine> getRoadDisruptionLines() {
    return roadDisruptionLines;
  }

  public void setRoadDisruptionLines(List<RoadDisruptionLine> roadDisruptionLines) {
    this.roadDisruptionLines = roadDisruptionLines;
  }

  public RoadDisruption roadDisruptionImpactAreas(List<RoadDisruptionImpactArea> roadDisruptionImpactAreas) {
    this.roadDisruptionImpactAreas = roadDisruptionImpactAreas;
    return this;
  }

  public RoadDisruption addRoadDisruptionImpactAreasItem(RoadDisruptionImpactArea roadDisruptionImpactAreasItem) {
    if (this.roadDisruptionImpactAreas == null) {
      this.roadDisruptionImpactAreas = new ArrayList<RoadDisruptionImpactArea>();
    }
    this.roadDisruptionImpactAreas.add(roadDisruptionImpactAreasItem);
    return this;
  }

   /**
   * Get roadDisruptionImpactAreas
   * @return roadDisruptionImpactAreas
  **/
  @ApiModelProperty(value = "")
  public List<RoadDisruptionImpactArea> getRoadDisruptionImpactAreas() {
    return roadDisruptionImpactAreas;
  }

  public void setRoadDisruptionImpactAreas(List<RoadDisruptionImpactArea> roadDisruptionImpactAreas) {
    this.roadDisruptionImpactAreas = roadDisruptionImpactAreas;
  }

  public RoadDisruption recurringSchedules(List<RoadDisruptionSchedule> recurringSchedules) {
    this.recurringSchedules = recurringSchedules;
    return this;
  }

  public RoadDisruption addRecurringSchedulesItem(RoadDisruptionSchedule recurringSchedulesItem) {
    if (this.recurringSchedules == null) {
      this.recurringSchedules = new ArrayList<RoadDisruptionSchedule>();
    }
    this.recurringSchedules.add(recurringSchedulesItem);
    return this;
  }

   /**
   * Get recurringSchedules
   * @return recurringSchedules
  **/
  @ApiModelProperty(value = "")
  public List<RoadDisruptionSchedule> getRecurringSchedules() {
    return recurringSchedules;
  }

  public void setRecurringSchedules(List<RoadDisruptionSchedule> recurringSchedules) {
    this.recurringSchedules = recurringSchedules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoadDisruption roadDisruption = (RoadDisruption) o;
    return Objects.equals(this.id, roadDisruption.id) &&
        Objects.equals(this.url, roadDisruption.url) &&
        Objects.equals(this.point, roadDisruption.point) &&
        Objects.equals(this.severity, roadDisruption.severity) &&
        Objects.equals(this.ordinal, roadDisruption.ordinal) &&
        Objects.equals(this.category, roadDisruption.category) &&
        Objects.equals(this.subCategory, roadDisruption.subCategory) &&
        Objects.equals(this.comments, roadDisruption.comments) &&
        Objects.equals(this.currentUpdate, roadDisruption.currentUpdate) &&
        Objects.equals(this.currentUpdateDateTime, roadDisruption.currentUpdateDateTime) &&
        Objects.equals(this.corridorIds, roadDisruption.corridorIds) &&
        Objects.equals(this.startDateTime, roadDisruption.startDateTime) &&
        Objects.equals(this.endDateTime, roadDisruption.endDateTime) &&
        Objects.equals(this.lastModifiedTime, roadDisruption.lastModifiedTime) &&
        Objects.equals(this.levelOfInterest, roadDisruption.levelOfInterest) &&
        Objects.equals(this.location, roadDisruption.location) &&
        Objects.equals(this.status, roadDisruption.status) &&
        Objects.equals(this.geography, roadDisruption.geography) &&
        Objects.equals(this.geometry, roadDisruption.geometry) &&
        Objects.equals(this.streets, roadDisruption.streets) &&
        Objects.equals(this.isProvisional, roadDisruption.isProvisional) &&
        Objects.equals(this.hasClosures, roadDisruption.hasClosures) &&
        Objects.equals(this.linkText, roadDisruption.linkText) &&
        Objects.equals(this.linkUrl, roadDisruption.linkUrl) &&
        Objects.equals(this.roadProject, roadDisruption.roadProject) &&
        Objects.equals(this.publishStartDate, roadDisruption.publishStartDate) &&
        Objects.equals(this.publishEndDate, roadDisruption.publishEndDate) &&
        Objects.equals(this.timeFrame, roadDisruption.timeFrame) &&
        Objects.equals(this.roadDisruptionLines, roadDisruption.roadDisruptionLines) &&
        Objects.equals(this.roadDisruptionImpactAreas, roadDisruption.roadDisruptionImpactAreas) &&
        Objects.equals(this.recurringSchedules, roadDisruption.recurringSchedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, point, severity, ordinal, category, subCategory, comments, currentUpdate, currentUpdateDateTime, corridorIds, startDateTime, endDateTime, lastModifiedTime, levelOfInterest, location, status, geography, geometry, streets, isProvisional, hasClosures, linkText, linkUrl, roadProject, publishStartDate, publishEndDate, timeFrame, roadDisruptionLines, roadDisruptionImpactAreas, recurringSchedules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoadDisruption {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    point: ").append(toIndentedString(point)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    ordinal: ").append(toIndentedString(ordinal)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    subCategory: ").append(toIndentedString(subCategory)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    currentUpdate: ").append(toIndentedString(currentUpdate)).append("\n");
    sb.append("    currentUpdateDateTime: ").append(toIndentedString(currentUpdateDateTime)).append("\n");
    sb.append("    corridorIds: ").append(toIndentedString(corridorIds)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
    sb.append("    lastModifiedTime: ").append(toIndentedString(lastModifiedTime)).append("\n");
    sb.append("    levelOfInterest: ").append(toIndentedString(levelOfInterest)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    geography: ").append(toIndentedString(geography)).append("\n");
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    streets: ").append(toIndentedString(streets)).append("\n");
    sb.append("    isProvisional: ").append(toIndentedString(isProvisional)).append("\n");
    sb.append("    hasClosures: ").append(toIndentedString(hasClosures)).append("\n");
    sb.append("    linkText: ").append(toIndentedString(linkText)).append("\n");
    sb.append("    linkUrl: ").append(toIndentedString(linkUrl)).append("\n");
    sb.append("    roadProject: ").append(toIndentedString(roadProject)).append("\n");
    sb.append("    publishStartDate: ").append(toIndentedString(publishStartDate)).append("\n");
    sb.append("    publishEndDate: ").append(toIndentedString(publishEndDate)).append("\n");
    sb.append("    timeFrame: ").append(toIndentedString(timeFrame)).append("\n");
    sb.append("    roadDisruptionLines: ").append(toIndentedString(roadDisruptionLines)).append("\n");
    sb.append("    roadDisruptionImpactAreas: ").append(toIndentedString(roadDisruptionImpactAreas)).append("\n");
    sb.append("    recurringSchedules: ").append(toIndentedString(recurringSchedules)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

