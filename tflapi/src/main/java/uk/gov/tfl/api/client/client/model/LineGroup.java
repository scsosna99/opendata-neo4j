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
 * LineGroup
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class LineGroup {
  @SerializedName("naptanIdReference")
  private String naptanIdReference = null;

  @SerializedName("stationAtcoCode")
  private String stationAtcoCode = null;

  @SerializedName("lineIdentifier")
  private List<String> lineIdentifier = null;

  public LineGroup naptanIdReference(String naptanIdReference) {
    this.naptanIdReference = naptanIdReference;
    return this;
  }

   /**
   * Get naptanIdReference
   * @return naptanIdReference
  **/
  @ApiModelProperty(value = "")
  public String getNaptanIdReference() {
    return naptanIdReference;
  }

  public void setNaptanIdReference(String naptanIdReference) {
    this.naptanIdReference = naptanIdReference;
  }

  public LineGroup stationAtcoCode(String stationAtcoCode) {
    this.stationAtcoCode = stationAtcoCode;
    return this;
  }

   /**
   * Get stationAtcoCode
   * @return stationAtcoCode
  **/
  @ApiModelProperty(value = "")
  public String getStationAtcoCode() {
    return stationAtcoCode;
  }

  public void setStationAtcoCode(String stationAtcoCode) {
    this.stationAtcoCode = stationAtcoCode;
  }

  public LineGroup lineIdentifier(List<String> lineIdentifier) {
    this.lineIdentifier = lineIdentifier;
    return this;
  }

  public LineGroup addLineIdentifierItem(String lineIdentifierItem) {
    if (this.lineIdentifier == null) {
      this.lineIdentifier = new ArrayList<String>();
    }
    this.lineIdentifier.add(lineIdentifierItem);
    return this;
  }

   /**
   * Get lineIdentifier
   * @return lineIdentifier
  **/
  @ApiModelProperty(value = "")
  public List<String> getLineIdentifier() {
    return lineIdentifier;
  }

  public void setLineIdentifier(List<String> lineIdentifier) {
    this.lineIdentifier = lineIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineGroup lineGroup = (LineGroup) o;
    return Objects.equals(this.naptanIdReference, lineGroup.naptanIdReference) &&
        Objects.equals(this.stationAtcoCode, lineGroup.stationAtcoCode) &&
        Objects.equals(this.lineIdentifier, lineGroup.lineIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(naptanIdReference, stationAtcoCode, lineIdentifier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineGroup {\n");
    
    sb.append("    naptanIdReference: ").append(toIndentedString(naptanIdReference)).append("\n");
    sb.append("    stationAtcoCode: ").append(toIndentedString(stationAtcoCode)).append("\n");
    sb.append("    lineIdentifier: ").append(toIndentedString(lineIdentifier)).append("\n");
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

