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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;

/**
 * InstructionStep
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class InstructionStep {
  @SerializedName("description")
  private String description = null;

  @SerializedName("turnDirection")
  private String turnDirection = null;

  @SerializedName("streetName")
  private String streetName = null;

  @SerializedName("distance")
  private Integer distance = null;

  @SerializedName("cumulativeDistance")
  private Integer cumulativeDistance = null;

  @SerializedName("skyDirection")
  private Integer skyDirection = null;

  /**
   * Gets or Sets skyDirectionDescription
   */
  @JsonAdapter(SkyDirectionDescriptionEnum.Adapter.class)
  public enum SkyDirectionDescriptionEnum {
    NORTH("North"),
    
    NORTHEAST("NorthEast"),
    
    EAST("East"),
    
    SOUTHEAST("SouthEast"),
    
    SOUTH("South"),
    
    SOUTHWEST("SouthWest"),
    
    WEST("West"),
    
    NORTHWEST("NorthWest");

    private String value;

    SkyDirectionDescriptionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SkyDirectionDescriptionEnum fromValue(String text) {
      for (SkyDirectionDescriptionEnum b : SkyDirectionDescriptionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SkyDirectionDescriptionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SkyDirectionDescriptionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SkyDirectionDescriptionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SkyDirectionDescriptionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("skyDirectionDescription")
  private SkyDirectionDescriptionEnum skyDirectionDescription = null;

  @SerializedName("cumulativeTravelTime")
  private Integer cumulativeTravelTime = null;

  @SerializedName("latitude")
  private Double latitude = null;

  @SerializedName("longitude")
  private Double longitude = null;

  @SerializedName("pathAttribute")
  private PathAttribute pathAttribute = null;

  @SerializedName("descriptionHeading")
  private String descriptionHeading = null;

  /**
   * Gets or Sets trackType
   */
  @JsonAdapter(TrackTypeEnum.Adapter.class)
  public enum TrackTypeEnum {
    CYCLESUPERHIGHWAY("CycleSuperHighway"),
    
    CANALTOWPATH("CanalTowpath"),
    
    QUIETROAD("QuietRoad"),
    
    PROVISIONFORCYCLISTS("ProvisionForCyclists"),
    
    BUSYROADS("BusyRoads"),
    
    NONE("None"),
    
    PUSHBIKE("PushBike"),
    
    QUIETWAY("Quietway");

    private String value;

    TrackTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TrackTypeEnum fromValue(String text) {
      for (TrackTypeEnum b : TrackTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TrackTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TrackTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TrackTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TrackTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("trackType")
  private TrackTypeEnum trackType = null;

  public InstructionStep description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InstructionStep turnDirection(String turnDirection) {
    this.turnDirection = turnDirection;
    return this;
  }

   /**
   * Get turnDirection
   * @return turnDirection
  **/
  @ApiModelProperty(value = "")
  public String getTurnDirection() {
    return turnDirection;
  }

  public void setTurnDirection(String turnDirection) {
    this.turnDirection = turnDirection;
  }

  public InstructionStep streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

   /**
   * Get streetName
   * @return streetName
  **/
  @ApiModelProperty(value = "")
  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public InstructionStep distance(Integer distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Get distance
   * @return distance
  **/
  @ApiModelProperty(value = "")
  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public InstructionStep cumulativeDistance(Integer cumulativeDistance) {
    this.cumulativeDistance = cumulativeDistance;
    return this;
  }

   /**
   * Get cumulativeDistance
   * @return cumulativeDistance
  **/
  @ApiModelProperty(value = "")
  public Integer getCumulativeDistance() {
    return cumulativeDistance;
  }

  public void setCumulativeDistance(Integer cumulativeDistance) {
    this.cumulativeDistance = cumulativeDistance;
  }

  public InstructionStep skyDirection(Integer skyDirection) {
    this.skyDirection = skyDirection;
    return this;
  }

   /**
   * Get skyDirection
   * @return skyDirection
  **/
  @ApiModelProperty(value = "")
  public Integer getSkyDirection() {
    return skyDirection;
  }

  public void setSkyDirection(Integer skyDirection) {
    this.skyDirection = skyDirection;
  }

  public InstructionStep skyDirectionDescription(SkyDirectionDescriptionEnum skyDirectionDescription) {
    this.skyDirectionDescription = skyDirectionDescription;
    return this;
  }

   /**
   * Get skyDirectionDescription
   * @return skyDirectionDescription
  **/
  @ApiModelProperty(value = "")
  public SkyDirectionDescriptionEnum getSkyDirectionDescription() {
    return skyDirectionDescription;
  }

  public void setSkyDirectionDescription(SkyDirectionDescriptionEnum skyDirectionDescription) {
    this.skyDirectionDescription = skyDirectionDescription;
  }

  public InstructionStep cumulativeTravelTime(Integer cumulativeTravelTime) {
    this.cumulativeTravelTime = cumulativeTravelTime;
    return this;
  }

   /**
   * Get cumulativeTravelTime
   * @return cumulativeTravelTime
  **/
  @ApiModelProperty(value = "")
  public Integer getCumulativeTravelTime() {
    return cumulativeTravelTime;
  }

  public void setCumulativeTravelTime(Integer cumulativeTravelTime) {
    this.cumulativeTravelTime = cumulativeTravelTime;
  }

  public InstructionStep latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * Get latitude
   * @return latitude
  **/
  @ApiModelProperty(value = "")
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public InstructionStep longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * Get longitude
   * @return longitude
  **/
  @ApiModelProperty(value = "")
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public InstructionStep pathAttribute(PathAttribute pathAttribute) {
    this.pathAttribute = pathAttribute;
    return this;
  }

   /**
   * Get pathAttribute
   * @return pathAttribute
  **/
  @ApiModelProperty(value = "")
  public PathAttribute getPathAttribute() {
    return pathAttribute;
  }

  public void setPathAttribute(PathAttribute pathAttribute) {
    this.pathAttribute = pathAttribute;
  }

  public InstructionStep descriptionHeading(String descriptionHeading) {
    this.descriptionHeading = descriptionHeading;
    return this;
  }

   /**
   * Get descriptionHeading
   * @return descriptionHeading
  **/
  @ApiModelProperty(value = "")
  public String getDescriptionHeading() {
    return descriptionHeading;
  }

  public void setDescriptionHeading(String descriptionHeading) {
    this.descriptionHeading = descriptionHeading;
  }

  public InstructionStep trackType(TrackTypeEnum trackType) {
    this.trackType = trackType;
    return this;
  }

   /**
   * Get trackType
   * @return trackType
  **/
  @ApiModelProperty(value = "")
  public TrackTypeEnum getTrackType() {
    return trackType;
  }

  public void setTrackType(TrackTypeEnum trackType) {
    this.trackType = trackType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstructionStep instructionStep = (InstructionStep) o;
    return Objects.equals(this.description, instructionStep.description) &&
        Objects.equals(this.turnDirection, instructionStep.turnDirection) &&
        Objects.equals(this.streetName, instructionStep.streetName) &&
        Objects.equals(this.distance, instructionStep.distance) &&
        Objects.equals(this.cumulativeDistance, instructionStep.cumulativeDistance) &&
        Objects.equals(this.skyDirection, instructionStep.skyDirection) &&
        Objects.equals(this.skyDirectionDescription, instructionStep.skyDirectionDescription) &&
        Objects.equals(this.cumulativeTravelTime, instructionStep.cumulativeTravelTime) &&
        Objects.equals(this.latitude, instructionStep.latitude) &&
        Objects.equals(this.longitude, instructionStep.longitude) &&
        Objects.equals(this.pathAttribute, instructionStep.pathAttribute) &&
        Objects.equals(this.descriptionHeading, instructionStep.descriptionHeading) &&
        Objects.equals(this.trackType, instructionStep.trackType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, turnDirection, streetName, distance, cumulativeDistance, skyDirection, skyDirectionDescription, cumulativeTravelTime, latitude, longitude, pathAttribute, descriptionHeading, trackType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstructionStep {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    turnDirection: ").append(toIndentedString(turnDirection)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    cumulativeDistance: ").append(toIndentedString(cumulativeDistance)).append("\n");
    sb.append("    skyDirection: ").append(toIndentedString(skyDirection)).append("\n");
    sb.append("    skyDirectionDescription: ").append(toIndentedString(skyDirectionDescription)).append("\n");
    sb.append("    cumulativeTravelTime: ").append(toIndentedString(cumulativeTravelTime)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    pathAttribute: ").append(toIndentedString(pathAttribute)).append("\n");
    sb.append("    descriptionHeading: ").append(toIndentedString(descriptionHeading)).append("\n");
    sb.append("    trackType: ").append(toIndentedString(trackType)).append("\n");
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

