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
 * Disambiguation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class Disambiguation {
  @SerializedName("disambiguationOptions")
  private List<DisambiguationOption> disambiguationOptions = null;

  public Disambiguation disambiguationOptions(List<DisambiguationOption> disambiguationOptions) {
    this.disambiguationOptions = disambiguationOptions;
    return this;
  }

  public Disambiguation addDisambiguationOptionsItem(DisambiguationOption disambiguationOptionsItem) {
    if (this.disambiguationOptions == null) {
      this.disambiguationOptions = new ArrayList<DisambiguationOption>();
    }
    this.disambiguationOptions.add(disambiguationOptionsItem);
    return this;
  }

   /**
   * Get disambiguationOptions
   * @return disambiguationOptions
  **/
  @ApiModelProperty(value = "")
  public List<DisambiguationOption> getDisambiguationOptions() {
    return disambiguationOptions;
  }

  public void setDisambiguationOptions(List<DisambiguationOption> disambiguationOptions) {
    this.disambiguationOptions = disambiguationOptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Disambiguation disambiguation = (Disambiguation) o;
    return Objects.equals(this.disambiguationOptions, disambiguation.disambiguationOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disambiguationOptions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Disambiguation {\n");
    
    sb.append("    disambiguationOptions: ").append(toIndentedString(disambiguationOptions)).append("\n");
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

