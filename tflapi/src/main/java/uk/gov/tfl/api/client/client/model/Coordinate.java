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

/**
 * Coordinate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class Coordinate {
  @SerializedName("longitude")
  private Double longitude = null;

  @SerializedName("latitude")
  private Double latitude = null;

  @SerializedName("easting")
  private Double easting = null;

  @SerializedName("northing")
  private Double northing = null;

  @SerializedName("xCoord")
  private Integer xCoord = null;

  @SerializedName("yCoord")
  private Integer yCoord = null;

  public Coordinate longitude(Double longitude) {
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

  public Coordinate latitude(Double latitude) {
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

  public Coordinate easting(Double easting) {
    this.easting = easting;
    return this;
  }

   /**
   * Get easting
   * @return easting
  **/
  @ApiModelProperty(value = "")
  public Double getEasting() {
    return easting;
  }

  public void setEasting(Double easting) {
    this.easting = easting;
  }

  public Coordinate northing(Double northing) {
    this.northing = northing;
    return this;
  }

   /**
   * Get northing
   * @return northing
  **/
  @ApiModelProperty(value = "")
  public Double getNorthing() {
    return northing;
  }

  public void setNorthing(Double northing) {
    this.northing = northing;
  }

  public Coordinate xCoord(Integer xCoord) {
    this.xCoord = xCoord;
    return this;
  }

   /**
   * Get xCoord
   * @return xCoord
  **/
  @ApiModelProperty(value = "")
  public Integer getXCoord() {
    return xCoord;
  }

  public void setXCoord(Integer xCoord) {
    this.xCoord = xCoord;
  }

  public Coordinate yCoord(Integer yCoord) {
    this.yCoord = yCoord;
    return this;
  }

   /**
   * Get yCoord
   * @return yCoord
  **/
  @ApiModelProperty(value = "")
  public Integer getYCoord() {
    return yCoord;
  }

  public void setYCoord(Integer yCoord) {
    this.yCoord = yCoord;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinate coordinate = (Coordinate) o;
    return Objects.equals(this.longitude, coordinate.longitude) &&
        Objects.equals(this.latitude, coordinate.latitude) &&
        Objects.equals(this.easting, coordinate.easting) &&
        Objects.equals(this.northing, coordinate.northing) &&
        Objects.equals(this.xCoord, coordinate.xCoord) &&
        Objects.equals(this.yCoord, coordinate.yCoord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(longitude, latitude, easting, northing, xCoord, yCoord);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinate {\n");
    
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    easting: ").append(toIndentedString(easting)).append("\n");
    sb.append("    northing: ").append(toIndentedString(northing)).append("\n");
    sb.append("    xCoord: ").append(toIndentedString(xCoord)).append("\n");
    sb.append("    yCoord: ").append(toIndentedString(yCoord)).append("\n");
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

