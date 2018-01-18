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
 * GeoCodeSearchMatch
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class GeoCodeSearchMatch {
  @SerializedName("types")
  private List<String> types = null;

  @SerializedName("address")
  private String address = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("lat")
  private Double lat = null;

  @SerializedName("lon")
  private Double lon = null;

  public GeoCodeSearchMatch types(List<String> types) {
    this.types = types;
    return this;
  }

  public GeoCodeSearchMatch addTypesItem(String typesItem) {
    if (this.types == null) {
      this.types = new ArrayList<String>();
    }
    this.types.add(typesItem);
    return this;
  }

   /**
   * The type of the place e.g. \&quot;street_address\&quot;
   * @return types
  **/
  @ApiModelProperty(value = "The type of the place e.g. \"street_address\"")
  public List<String> getTypes() {
    return types;
  }

  public void setTypes(List<String> types) {
    this.types = types;
  }

  public GeoCodeSearchMatch address(String address) {
    this.address = address;
    return this;
  }

   /**
   * A string describing the formatted address of the place. Adds additional context to the place&#39;s Name.
   * @return address
  **/
  @ApiModelProperty(value = "A string describing the formatted address of the place. Adds additional context to the place's Name.")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public GeoCodeSearchMatch id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GeoCodeSearchMatch url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public GeoCodeSearchMatch name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GeoCodeSearchMatch lat(Double lat) {
    this.lat = lat;
    return this;
  }

   /**
   * Get lat
   * @return lat
  **/
  @ApiModelProperty(value = "")
  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public GeoCodeSearchMatch lon(Double lon) {
    this.lon = lon;
    return this;
  }

   /**
   * Get lon
   * @return lon
  **/
  @ApiModelProperty(value = "")
  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoCodeSearchMatch geoCodeSearchMatch = (GeoCodeSearchMatch) o;
    return Objects.equals(this.types, geoCodeSearchMatch.types) &&
        Objects.equals(this.address, geoCodeSearchMatch.address) &&
        Objects.equals(this.id, geoCodeSearchMatch.id) &&
        Objects.equals(this.url, geoCodeSearchMatch.url) &&
        Objects.equals(this.name, geoCodeSearchMatch.name) &&
        Objects.equals(this.lat, geoCodeSearchMatch.lat) &&
        Objects.equals(this.lon, geoCodeSearchMatch.lon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(types, address, id, url, name, lat, lon);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoCodeSearchMatch {\n");
    
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
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

