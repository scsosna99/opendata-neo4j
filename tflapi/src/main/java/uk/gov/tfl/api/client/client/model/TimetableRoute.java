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
 * TimetableRoute
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class TimetableRoute {
  @SerializedName("stationIntervals")
  private List<StationInterval> stationIntervals = null;

  @SerializedName("schedules")
  private List<Schedule> schedules = null;

  public TimetableRoute stationIntervals(List<StationInterval> stationIntervals) {
    this.stationIntervals = stationIntervals;
    return this;
  }

  public TimetableRoute addStationIntervalsItem(StationInterval stationIntervalsItem) {
    if (this.stationIntervals == null) {
      this.stationIntervals = new ArrayList<StationInterval>();
    }
    this.stationIntervals.add(stationIntervalsItem);
    return this;
  }

   /**
   * Get stationIntervals
   * @return stationIntervals
  **/
  @ApiModelProperty(value = "")
  public List<StationInterval> getStationIntervals() {
    return stationIntervals;
  }

  public void setStationIntervals(List<StationInterval> stationIntervals) {
    this.stationIntervals = stationIntervals;
  }

  public TimetableRoute schedules(List<Schedule> schedules) {
    this.schedules = schedules;
    return this;
  }

  public TimetableRoute addSchedulesItem(Schedule schedulesItem) {
    if (this.schedules == null) {
      this.schedules = new ArrayList<Schedule>();
    }
    this.schedules.add(schedulesItem);
    return this;
  }

   /**
   * Get schedules
   * @return schedules
  **/
  @ApiModelProperty(value = "")
  public List<Schedule> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<Schedule> schedules) {
    this.schedules = schedules;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimetableRoute timetableRoute = (TimetableRoute) o;
    return Objects.equals(this.stationIntervals, timetableRoute.stationIntervals) &&
        Objects.equals(this.schedules, timetableRoute.schedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stationIntervals, schedules);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimetableRoute {\n");
    
    sb.append("    stationIntervals: ").append(toIndentedString(stationIntervals)).append("\n");
    sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
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

