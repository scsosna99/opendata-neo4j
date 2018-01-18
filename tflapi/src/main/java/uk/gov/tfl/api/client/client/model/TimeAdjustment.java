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
 * TimeAdjustment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class TimeAdjustment {
  @SerializedName("date")
  private String date = null;

  @SerializedName("time")
  private String time = null;

  @SerializedName("timeIs")
  private String timeIs = null;

  @SerializedName("uri")
  private String uri = null;

  public TimeAdjustment date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public TimeAdjustment time(String time) {
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public TimeAdjustment timeIs(String timeIs) {
    this.timeIs = timeIs;
    return this;
  }

   /**
   * Get timeIs
   * @return timeIs
  **/
  @ApiModelProperty(value = "")
  public String getTimeIs() {
    return timeIs;
  }

  public void setTimeIs(String timeIs) {
    this.timeIs = timeIs;
  }

  public TimeAdjustment uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @ApiModelProperty(value = "")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeAdjustment timeAdjustment = (TimeAdjustment) o;
    return Objects.equals(this.date, timeAdjustment.date) &&
        Objects.equals(this.time, timeAdjustment.time) &&
        Objects.equals(this.timeIs, timeAdjustment.timeIs) &&
        Objects.equals(this.uri, timeAdjustment.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, time, timeIs, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeAdjustment {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    timeIs: ").append(toIndentedString(timeIs)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

