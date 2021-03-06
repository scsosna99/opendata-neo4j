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
 * RouteSearchMatch
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class RouteSearchMatch {
  @SerializedName("lineId")
  private String lineId = null;

  @SerializedName("mode")
  private String mode = null;

  @SerializedName("lineName")
  private String lineName = null;

  @SerializedName("lineRouteSection")
  private List<LineRouteSection> lineRouteSection = null;

  @SerializedName("matchedRouteSections")
  private List<MatchedRouteSections> matchedRouteSections = null;

  @SerializedName("matchedStops")
  private List<MatchedStop> matchedStops = null;

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

  public RouteSearchMatch lineId(String lineId) {
    this.lineId = lineId;
    return this;
  }

   /**
   * Get lineId
   * @return lineId
  **/
  @ApiModelProperty(value = "")
  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  public RouteSearchMatch mode(String mode) {
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(value = "")
  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public RouteSearchMatch lineName(String lineName) {
    this.lineName = lineName;
    return this;
  }

   /**
   * Get lineName
   * @return lineName
  **/
  @ApiModelProperty(value = "")
  public String getLineName() {
    return lineName;
  }

  public void setLineName(String lineName) {
    this.lineName = lineName;
  }

  public RouteSearchMatch lineRouteSection(List<LineRouteSection> lineRouteSection) {
    this.lineRouteSection = lineRouteSection;
    return this;
  }

  public RouteSearchMatch addLineRouteSectionItem(LineRouteSection lineRouteSectionItem) {
    if (this.lineRouteSection == null) {
      this.lineRouteSection = new ArrayList<LineRouteSection>();
    }
    this.lineRouteSection.add(lineRouteSectionItem);
    return this;
  }

   /**
   * Get lineRouteSection
   * @return lineRouteSection
  **/
  @ApiModelProperty(value = "")
  public List<LineRouteSection> getLineRouteSection() {
    return lineRouteSection;
  }

  public void setLineRouteSection(List<LineRouteSection> lineRouteSection) {
    this.lineRouteSection = lineRouteSection;
  }

  public RouteSearchMatch matchedRouteSections(List<MatchedRouteSections> matchedRouteSections) {
    this.matchedRouteSections = matchedRouteSections;
    return this;
  }

  public RouteSearchMatch addMatchedRouteSectionsItem(MatchedRouteSections matchedRouteSectionsItem) {
    if (this.matchedRouteSections == null) {
      this.matchedRouteSections = new ArrayList<MatchedRouteSections>();
    }
    this.matchedRouteSections.add(matchedRouteSectionsItem);
    return this;
  }

   /**
   * Get matchedRouteSections
   * @return matchedRouteSections
  **/
  @ApiModelProperty(value = "")
  public List<MatchedRouteSections> getMatchedRouteSections() {
    return matchedRouteSections;
  }

  public void setMatchedRouteSections(List<MatchedRouteSections> matchedRouteSections) {
    this.matchedRouteSections = matchedRouteSections;
  }

  public RouteSearchMatch matchedStops(List<MatchedStop> matchedStops) {
    this.matchedStops = matchedStops;
    return this;
  }

  public RouteSearchMatch addMatchedStopsItem(MatchedStop matchedStopsItem) {
    if (this.matchedStops == null) {
      this.matchedStops = new ArrayList<MatchedStop>();
    }
    this.matchedStops.add(matchedStopsItem);
    return this;
  }

   /**
   * Get matchedStops
   * @return matchedStops
  **/
  @ApiModelProperty(value = "")
  public List<MatchedStop> getMatchedStops() {
    return matchedStops;
  }

  public void setMatchedStops(List<MatchedStop> matchedStops) {
    this.matchedStops = matchedStops;
  }

  public RouteSearchMatch id(String id) {
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

  public RouteSearchMatch url(String url) {
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

  public RouteSearchMatch name(String name) {
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

  public RouteSearchMatch lat(Double lat) {
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

  public RouteSearchMatch lon(Double lon) {
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
    RouteSearchMatch routeSearchMatch = (RouteSearchMatch) o;
    return Objects.equals(this.lineId, routeSearchMatch.lineId) &&
        Objects.equals(this.mode, routeSearchMatch.mode) &&
        Objects.equals(this.lineName, routeSearchMatch.lineName) &&
        Objects.equals(this.lineRouteSection, routeSearchMatch.lineRouteSection) &&
        Objects.equals(this.matchedRouteSections, routeSearchMatch.matchedRouteSections) &&
        Objects.equals(this.matchedStops, routeSearchMatch.matchedStops) &&
        Objects.equals(this.id, routeSearchMatch.id) &&
        Objects.equals(this.url, routeSearchMatch.url) &&
        Objects.equals(this.name, routeSearchMatch.name) &&
        Objects.equals(this.lat, routeSearchMatch.lat) &&
        Objects.equals(this.lon, routeSearchMatch.lon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineId, mode, lineName, lineRouteSection, matchedRouteSections, matchedStops, id, url, name, lat, lon);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteSearchMatch {\n");
    
    sb.append("    lineId: ").append(toIndentedString(lineId)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    lineName: ").append(toIndentedString(lineName)).append("\n");
    sb.append("    lineRouteSection: ").append(toIndentedString(lineRouteSection)).append("\n");
    sb.append("    matchedRouteSections: ").append(toIndentedString(matchedRouteSections)).append("\n");
    sb.append("    matchedStops: ").append(toIndentedString(matchedStops)).append("\n");
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

