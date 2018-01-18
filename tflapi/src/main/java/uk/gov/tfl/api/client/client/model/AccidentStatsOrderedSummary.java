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
 * AccidentStatsOrderedSummary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class AccidentStatsOrderedSummary {
  @SerializedName("year")
  private Integer year = null;

  @SerializedName("borough")
  private String borough = null;

  @SerializedName("accidents")
  private Integer accidents = null;

  public AccidentStatsOrderedSummary year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(value = "")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public AccidentStatsOrderedSummary borough(String borough) {
    this.borough = borough;
    return this;
  }

   /**
   * Get borough
   * @return borough
  **/
  @ApiModelProperty(value = "")
  public String getBorough() {
    return borough;
  }

  public void setBorough(String borough) {
    this.borough = borough;
  }

  public AccidentStatsOrderedSummary accidents(Integer accidents) {
    this.accidents = accidents;
    return this;
  }

   /**
   * Get accidents
   * @return accidents
  **/
  @ApiModelProperty(value = "")
  public Integer getAccidents() {
    return accidents;
  }

  public void setAccidents(Integer accidents) {
    this.accidents = accidents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccidentStatsOrderedSummary accidentStatsOrderedSummary = (AccidentStatsOrderedSummary) o;
    return Objects.equals(this.year, accidentStatsOrderedSummary.year) &&
        Objects.equals(this.borough, accidentStatsOrderedSummary.borough) &&
        Objects.equals(this.accidents, accidentStatsOrderedSummary.accidents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, borough, accidents);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccidentStatsOrderedSummary {\n");
    
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    borough: ").append(toIndentedString(borough)).append("\n");
    sb.append("    accidents: ").append(toIndentedString(accidents)).append("\n");
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

