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
 * Leg
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class Leg {
  @SerializedName("duration")
  private Integer duration = null;

  @SerializedName("speed")
  private String speed = null;

  @SerializedName("instruction")
  private Instruction instruction = null;

  @SerializedName("obstacles")
  private List<Obstacle> obstacles = null;

  @SerializedName("departureTime")
  private OffsetDateTime departureTime = null;

  @SerializedName("arrivalTime")
  private OffsetDateTime arrivalTime = null;

  @SerializedName("departurePoint")
  private Point departurePoint = null;

  @SerializedName("arrivalPoint")
  private Point arrivalPoint = null;

  @SerializedName("path")
  private Path path = null;

  @SerializedName("routeOptions")
  private List<RouteOption> routeOptions = null;

  @SerializedName("mode")
  private Identifier mode = null;

  @SerializedName("disruptions")
  private List<Disruption> disruptions = null;

  @SerializedName("plannedWorks")
  private List<PlannedWork> plannedWorks = null;

  @SerializedName("distance")
  private Double distance = null;

  @SerializedName("isDisrupted")
  private Boolean isDisrupted = null;

  @SerializedName("hasFixedLocations")
  private Boolean hasFixedLocations = null;

  public Leg duration(Integer duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(value = "")
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Leg speed(String speed) {
    this.speed = speed;
    return this;
  }

   /**
   * Get speed
   * @return speed
  **/
  @ApiModelProperty(value = "")
  public String getSpeed() {
    return speed;
  }

  public void setSpeed(String speed) {
    this.speed = speed;
  }

  public Leg instruction(Instruction instruction) {
    this.instruction = instruction;
    return this;
  }

   /**
   * Describes the action the user need to take for this section, E.g. \&quot;walk to the              district line\&quot;
   * @return instruction
  **/
  @ApiModelProperty(value = "Describes the action the user need to take for this section, E.g. \"walk to the              district line\"")
  public Instruction getInstruction() {
    return instruction;
  }

  public void setInstruction(Instruction instruction) {
    this.instruction = instruction;
  }

  public Leg obstacles(List<Obstacle> obstacles) {
    this.obstacles = obstacles;
    return this;
  }

  public Leg addObstaclesItem(Obstacle obstaclesItem) {
    if (this.obstacles == null) {
      this.obstacles = new ArrayList<Obstacle>();
    }
    this.obstacles.add(obstaclesItem);
    return this;
  }

   /**
   * Get obstacles
   * @return obstacles
  **/
  @ApiModelProperty(value = "")
  public List<Obstacle> getObstacles() {
    return obstacles;
  }

  public void setObstacles(List<Obstacle> obstacles) {
    this.obstacles = obstacles;
  }

  public Leg departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

   /**
   * Get departureTime
   * @return departureTime
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public Leg arrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

   /**
   * Get arrivalTime
   * @return arrivalTime
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Leg departurePoint(Point departurePoint) {
    this.departurePoint = departurePoint;
    return this;
  }

   /**
   * Get departurePoint
   * @return departurePoint
  **/
  @ApiModelProperty(value = "")
  public Point getDeparturePoint() {
    return departurePoint;
  }

  public void setDeparturePoint(Point departurePoint) {
    this.departurePoint = departurePoint;
  }

  public Leg arrivalPoint(Point arrivalPoint) {
    this.arrivalPoint = arrivalPoint;
    return this;
  }

   /**
   * Get arrivalPoint
   * @return arrivalPoint
  **/
  @ApiModelProperty(value = "")
  public Point getArrivalPoint() {
    return arrivalPoint;
  }

  public void setArrivalPoint(Point arrivalPoint) {
    this.arrivalPoint = arrivalPoint;
  }

  public Leg path(Path path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public Path getPath() {
    return path;
  }

  public void setPath(Path path) {
    this.path = path;
  }

  public Leg routeOptions(List<RouteOption> routeOptions) {
    this.routeOptions = routeOptions;
    return this;
  }

  public Leg addRouteOptionsItem(RouteOption routeOptionsItem) {
    if (this.routeOptions == null) {
      this.routeOptions = new ArrayList<RouteOption>();
    }
    this.routeOptions.add(routeOptionsItem);
    return this;
  }

   /**
   * Get routeOptions
   * @return routeOptions
  **/
  @ApiModelProperty(value = "")
  public List<RouteOption> getRouteOptions() {
    return routeOptions;
  }

  public void setRouteOptions(List<RouteOption> routeOptions) {
    this.routeOptions = routeOptions;
  }

  public Leg mode(Identifier mode) {
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(value = "")
  public Identifier getMode() {
    return mode;
  }

  public void setMode(Identifier mode) {
    this.mode = mode;
  }

  public Leg disruptions(List<Disruption> disruptions) {
    this.disruptions = disruptions;
    return this;
  }

  public Leg addDisruptionsItem(Disruption disruptionsItem) {
    if (this.disruptions == null) {
      this.disruptions = new ArrayList<Disruption>();
    }
    this.disruptions.add(disruptionsItem);
    return this;
  }

   /**
   * Get disruptions
   * @return disruptions
  **/
  @ApiModelProperty(value = "")
  public List<Disruption> getDisruptions() {
    return disruptions;
  }

  public void setDisruptions(List<Disruption> disruptions) {
    this.disruptions = disruptions;
  }

  public Leg plannedWorks(List<PlannedWork> plannedWorks) {
    this.plannedWorks = plannedWorks;
    return this;
  }

  public Leg addPlannedWorksItem(PlannedWork plannedWorksItem) {
    if (this.plannedWorks == null) {
      this.plannedWorks = new ArrayList<PlannedWork>();
    }
    this.plannedWorks.add(plannedWorksItem);
    return this;
  }

   /**
   * Get plannedWorks
   * @return plannedWorks
  **/
  @ApiModelProperty(value = "")
  public List<PlannedWork> getPlannedWorks() {
    return plannedWorks;
  }

  public void setPlannedWorks(List<PlannedWork> plannedWorks) {
    this.plannedWorks = plannedWorks;
  }

  public Leg distance(Double distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Get distance
   * @return distance
  **/
  @ApiModelProperty(value = "")
  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

   /**
   * Get isDisrupted
   * @return isDisrupted
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsDisrupted() {
    return isDisrupted;
  }

   /**
   * Get hasFixedLocations
   * @return hasFixedLocations
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasFixedLocations() {
    return hasFixedLocations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leg leg = (Leg) o;
    return Objects.equals(this.duration, leg.duration) &&
        Objects.equals(this.speed, leg.speed) &&
        Objects.equals(this.instruction, leg.instruction) &&
        Objects.equals(this.obstacles, leg.obstacles) &&
        Objects.equals(this.departureTime, leg.departureTime) &&
        Objects.equals(this.arrivalTime, leg.arrivalTime) &&
        Objects.equals(this.departurePoint, leg.departurePoint) &&
        Objects.equals(this.arrivalPoint, leg.arrivalPoint) &&
        Objects.equals(this.path, leg.path) &&
        Objects.equals(this.routeOptions, leg.routeOptions) &&
        Objects.equals(this.mode, leg.mode) &&
        Objects.equals(this.disruptions, leg.disruptions) &&
        Objects.equals(this.plannedWorks, leg.plannedWorks) &&
        Objects.equals(this.distance, leg.distance) &&
        Objects.equals(this.isDisrupted, leg.isDisrupted) &&
        Objects.equals(this.hasFixedLocations, leg.hasFixedLocations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, speed, instruction, obstacles, departureTime, arrivalTime, departurePoint, arrivalPoint, path, routeOptions, mode, disruptions, plannedWorks, distance, isDisrupted, hasFixedLocations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leg {\n");
    
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    instruction: ").append(toIndentedString(instruction)).append("\n");
    sb.append("    obstacles: ").append(toIndentedString(obstacles)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    arrivalTime: ").append(toIndentedString(arrivalTime)).append("\n");
    sb.append("    departurePoint: ").append(toIndentedString(departurePoint)).append("\n");
    sb.append("    arrivalPoint: ").append(toIndentedString(arrivalPoint)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    routeOptions: ").append(toIndentedString(routeOptions)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    disruptions: ").append(toIndentedString(disruptions)).append("\n");
    sb.append("    plannedWorks: ").append(toIndentedString(plannedWorks)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    isDisrupted: ").append(toIndentedString(isDisrupted)).append("\n");
    sb.append("    hasFixedLocations: ").append(toIndentedString(hasFixedLocations)).append("\n");
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

