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

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO representing a list of possible journeys.
 */
@ApiModel(description = "A DTO representing a list of possible journeys.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class ItineraryResult {
  @SerializedName("journeys")
  private List<Journey> journeys = null;

  @SerializedName("lines")
  private List<Line> lines = null;

  @SerializedName("cycleHireDockingStationData")
  private JourneyPlannerCycleHireDockingStationData cycleHireDockingStationData = null;

  @SerializedName("stopMessages")
  private List<String> stopMessages = null;

  @SerializedName("recommendedMaxAgeMinutes")
  private Integer recommendedMaxAgeMinutes = null;

  @SerializedName("searchCriteria")
  private SearchCriteria searchCriteria = null;

  @SerializedName("journeyVector")
  private JourneyVector journeyVector = null;

  public ItineraryResult journeys(List<Journey> journeys) {
    this.journeys = journeys;
    return this;
  }

  public ItineraryResult addJourneysItem(Journey journeysItem) {
    if (this.journeys == null) {
      this.journeys = new ArrayList<Journey>();
    }
    this.journeys.add(journeysItem);
    return this;
  }

   /**
   * Get journeys
   * @return journeys
  **/
  @ApiModelProperty(value = "")
  public List<Journey> getJourneys() {
    return journeys;
  }

  public void setJourneys(List<Journey> journeys) {
    this.journeys = journeys;
  }

  public ItineraryResult lines(List<Line> lines) {
    this.lines = lines;
    return this;
  }

  public ItineraryResult addLinesItem(Line linesItem) {
    if (this.lines == null) {
      this.lines = new ArrayList<Line>();
    }
    this.lines.add(linesItem);
    return this;
  }

   /**
   * Get lines
   * @return lines
  **/
  @ApiModelProperty(value = "")
  public List<Line> getLines() {
    return lines;
  }

  public void setLines(List<Line> lines) {
    this.lines = lines;
  }

  public ItineraryResult cycleHireDockingStationData(JourneyPlannerCycleHireDockingStationData cycleHireDockingStationData) {
    this.cycleHireDockingStationData = cycleHireDockingStationData;
    return this;
  }

   /**
   * Get cycleHireDockingStationData
   * @return cycleHireDockingStationData
  **/
  @ApiModelProperty(value = "")
  public JourneyPlannerCycleHireDockingStationData getCycleHireDockingStationData() {
    return cycleHireDockingStationData;
  }

  public void setCycleHireDockingStationData(JourneyPlannerCycleHireDockingStationData cycleHireDockingStationData) {
    this.cycleHireDockingStationData = cycleHireDockingStationData;
  }

  public ItineraryResult stopMessages(List<String> stopMessages) {
    this.stopMessages = stopMessages;
    return this;
  }

  public ItineraryResult addStopMessagesItem(String stopMessagesItem) {
    if (this.stopMessages == null) {
      this.stopMessages = new ArrayList<String>();
    }
    this.stopMessages.add(stopMessagesItem);
    return this;
  }

   /**
   * Get stopMessages
   * @return stopMessages
  **/
  @ApiModelProperty(value = "")
  public List<String> getStopMessages() {
    return stopMessages;
  }

  public void setStopMessages(List<String> stopMessages) {
    this.stopMessages = stopMessages;
  }

  public ItineraryResult recommendedMaxAgeMinutes(Integer recommendedMaxAgeMinutes) {
    this.recommendedMaxAgeMinutes = recommendedMaxAgeMinutes;
    return this;
  }

   /**
   * Get recommendedMaxAgeMinutes
   * @return recommendedMaxAgeMinutes
  **/
  @ApiModelProperty(value = "")
  public Integer getRecommendedMaxAgeMinutes() {
    return recommendedMaxAgeMinutes;
  }

  public void setRecommendedMaxAgeMinutes(Integer recommendedMaxAgeMinutes) {
    this.recommendedMaxAgeMinutes = recommendedMaxAgeMinutes;
  }

  public ItineraryResult searchCriteria(SearchCriteria searchCriteria) {
    this.searchCriteria = searchCriteria;
    return this;
  }

   /**
   * Get searchCriteria
   * @return searchCriteria
  **/
  @ApiModelProperty(value = "")
  public SearchCriteria getSearchCriteria() {
    return searchCriteria;
  }

  public void setSearchCriteria(SearchCriteria searchCriteria) {
    this.searchCriteria = searchCriteria;
  }

  public ItineraryResult journeyVector(JourneyVector journeyVector) {
    this.journeyVector = journeyVector;
    return this;
  }

   /**
   * Get journeyVector
   * @return journeyVector
  **/
  @ApiModelProperty(value = "")
  public JourneyVector getJourneyVector() {
    return journeyVector;
  }

  public void setJourneyVector(JourneyVector journeyVector) {
    this.journeyVector = journeyVector;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItineraryResult itineraryResult = (ItineraryResult) o;
    return Objects.equals(this.journeys, itineraryResult.journeys) &&
        Objects.equals(this.lines, itineraryResult.lines) &&
        Objects.equals(this.cycleHireDockingStationData, itineraryResult.cycleHireDockingStationData) &&
        Objects.equals(this.stopMessages, itineraryResult.stopMessages) &&
        Objects.equals(this.recommendedMaxAgeMinutes, itineraryResult.recommendedMaxAgeMinutes) &&
        Objects.equals(this.searchCriteria, itineraryResult.searchCriteria) &&
        Objects.equals(this.journeyVector, itineraryResult.journeyVector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(journeys, lines, cycleHireDockingStationData, stopMessages, recommendedMaxAgeMinutes, searchCriteria, journeyVector);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItineraryResult {\n");
    
    sb.append("    journeys: ").append(toIndentedString(journeys)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
    sb.append("    cycleHireDockingStationData: ").append(toIndentedString(cycleHireDockingStationData)).append("\n");
    sb.append("    stopMessages: ").append(toIndentedString(stopMessages)).append("\n");
    sb.append("    recommendedMaxAgeMinutes: ").append(toIndentedString(recommendedMaxAgeMinutes)).append("\n");
    sb.append("    searchCriteria: ").append(toIndentedString(searchCriteria)).append("\n");
    sb.append("    journeyVector: ").append(toIndentedString(journeyVector)).append("\n");
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

