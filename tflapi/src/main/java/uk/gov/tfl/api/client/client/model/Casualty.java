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
 * Casualty
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class Casualty {
  @SerializedName("age")
  private Integer age = null;

  @SerializedName("class")
  private String propertyClass = null;

  @SerializedName("severity")
  private String severity = null;

  @SerializedName("mode")
  private String mode = null;

  @SerializedName("ageBand")
  private String ageBand = null;

  public Casualty age(Integer age) {
    this.age = age;
    return this;
  }

   /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Casualty propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

   /**
   * Get propertyClass
   * @return propertyClass
  **/
  @ApiModelProperty(value = "")
  public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public Casualty severity(String severity) {
    this.severity = severity;
    return this;
  }

   /**
   * Get severity
   * @return severity
  **/
  @ApiModelProperty(value = "")
  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public Casualty mode(String mode) {
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

  public Casualty ageBand(String ageBand) {
    this.ageBand = ageBand;
    return this;
  }

   /**
   * Get ageBand
   * @return ageBand
  **/
  @ApiModelProperty(value = "")
  public String getAgeBand() {
    return ageBand;
  }

  public void setAgeBand(String ageBand) {
    this.ageBand = ageBand;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Casualty casualty = (Casualty) o;
    return Objects.equals(this.age, casualty.age) &&
        Objects.equals(this.propertyClass, casualty.propertyClass) &&
        Objects.equals(this.severity, casualty.severity) &&
        Objects.equals(this.mode, casualty.mode) &&
        Objects.equals(this.ageBand, casualty.ageBand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, propertyClass, severity, mode, ageBand);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Casualty {\n");
    
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    ageBand: ").append(toIndentedString(ageBand)).append("\n");
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

