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

/**
 * PlacePolygon
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class PlacePolygon {
  @SerializedName("geoPoints")
  private List<GeoPoint> geoPoints = null;

  @SerializedName("commonName")
  private String commonName = null;

  public PlacePolygon geoPoints(List<GeoPoint> geoPoints) {
    this.geoPoints = geoPoints;
    return this;
  }

  public PlacePolygon addGeoPointsItem(GeoPoint geoPointsItem) {
    if (this.geoPoints == null) {
      this.geoPoints = new ArrayList<GeoPoint>();
    }
    this.geoPoints.add(geoPointsItem);
    return this;
  }

   /**
   * Get geoPoints
   * @return geoPoints
  **/
  @ApiModelProperty(value = "")
  public List<GeoPoint> getGeoPoints() {
    return geoPoints;
  }

  public void setGeoPoints(List<GeoPoint> geoPoints) {
    this.geoPoints = geoPoints;
  }

  public PlacePolygon commonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

   /**
   * Get commonName
   * @return commonName
  **/
  @ApiModelProperty(value = "")
  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlacePolygon placePolygon = (PlacePolygon) o;
    return Objects.equals(this.geoPoints, placePolygon.geoPoints) &&
        Objects.equals(this.commonName, placePolygon.commonName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(geoPoints, commonName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlacePolygon {\n");
    
    sb.append("    geoPoints: ").append(toIndentedString(geoPoints)).append("\n");
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
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

