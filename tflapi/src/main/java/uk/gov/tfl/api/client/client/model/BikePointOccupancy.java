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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Bike point occupancy
 */
@ApiModel(description = "Bike point occupancy")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class BikePointOccupancy {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("bikesCount")
  private Integer bikesCount = null;

  @SerializedName("emptyDocks")
  private Integer emptyDocks = null;

  @SerializedName("totalDocks")
  private Integer totalDocks = null;

  public BikePointOccupancy id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Id of the bike point such as BikePoints_1
   * @return id
  **/
  @ApiModelProperty(value = "Id of the bike point such as BikePoints_1")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BikePointOccupancy name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name / Common name of the bike point
   * @return name
  **/
  @ApiModelProperty(value = "Name / Common name of the bike point")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BikePointOccupancy bikesCount(Integer bikesCount) {
    this.bikesCount = bikesCount;
    return this;
  }

   /**
   * Total bike counts
   * @return bikesCount
  **/
  @ApiModelProperty(value = "Total bike counts")
  public Integer getBikesCount() {
    return bikesCount;
  }

  public void setBikesCount(Integer bikesCount) {
    this.bikesCount = bikesCount;
  }

  public BikePointOccupancy emptyDocks(Integer emptyDocks) {
    this.emptyDocks = emptyDocks;
    return this;
  }

   /**
   * Empty docks
   * @return emptyDocks
  **/
  @ApiModelProperty(value = "Empty docks")
  public Integer getEmptyDocks() {
    return emptyDocks;
  }

  public void setEmptyDocks(Integer emptyDocks) {
    this.emptyDocks = emptyDocks;
  }

  public BikePointOccupancy totalDocks(Integer totalDocks) {
    this.totalDocks = totalDocks;
    return this;
  }

   /**
   * Total docks available
   * @return totalDocks
  **/
  @ApiModelProperty(value = "Total docks available")
  public Integer getTotalDocks() {
    return totalDocks;
  }

  public void setTotalDocks(Integer totalDocks) {
    this.totalDocks = totalDocks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BikePointOccupancy bikePointOccupancy = (BikePointOccupancy) o;
    return Objects.equals(this.id, bikePointOccupancy.id) &&
        Objects.equals(this.name, bikePointOccupancy.name) &&
        Objects.equals(this.bikesCount, bikePointOccupancy.bikesCount) &&
        Objects.equals(this.emptyDocks, bikePointOccupancy.emptyDocks) &&
        Objects.equals(this.totalDocks, bikePointOccupancy.totalDocks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, bikesCount, emptyDocks, totalDocks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BikePointOccupancy {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    bikesCount: ").append(toIndentedString(bikesCount)).append("\n");
    sb.append("    emptyDocks: ").append(toIndentedString(emptyDocks)).append("\n");
    sb.append("    totalDocks: ").append(toIndentedString(totalDocks)).append("\n");
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

