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
import org.threeten.bp.OffsetDateTime;

/**
 * PredictionTiming
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class PredictionTiming {
  @SerializedName("countdownServerAdjustment")
  private String countdownServerAdjustment = null;

  @SerializedName("source")
  private OffsetDateTime source = null;

  @SerializedName("insert")
  private OffsetDateTime insert = null;

  @SerializedName("read")
  private OffsetDateTime read = null;

  @SerializedName("sent")
  private OffsetDateTime sent = null;

  @SerializedName("received")
  private OffsetDateTime received = null;

  public PredictionTiming countdownServerAdjustment(String countdownServerAdjustment) {
    this.countdownServerAdjustment = countdownServerAdjustment;
    return this;
  }

   /**
   * Get countdownServerAdjustment
   * @return countdownServerAdjustment
  **/
  @ApiModelProperty(value = "")
  public String getCountdownServerAdjustment() {
    return countdownServerAdjustment;
  }

  public void setCountdownServerAdjustment(String countdownServerAdjustment) {
    this.countdownServerAdjustment = countdownServerAdjustment;
  }

  public PredictionTiming source(OffsetDateTime source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getSource() {
    return source;
  }

  public void setSource(OffsetDateTime source) {
    this.source = source;
  }

  public PredictionTiming insert(OffsetDateTime insert) {
    this.insert = insert;
    return this;
  }

   /**
   * Get insert
   * @return insert
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getInsert() {
    return insert;
  }

  public void setInsert(OffsetDateTime insert) {
    this.insert = insert;
  }

  public PredictionTiming read(OffsetDateTime read) {
    this.read = read;
    return this;
  }

   /**
   * Get read
   * @return read
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getRead() {
    return read;
  }

  public void setRead(OffsetDateTime read) {
    this.read = read;
  }

  public PredictionTiming sent(OffsetDateTime sent) {
    this.sent = sent;
    return this;
  }

   /**
   * Get sent
   * @return sent
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getSent() {
    return sent;
  }

  public void setSent(OffsetDateTime sent) {
    this.sent = sent;
  }

  public PredictionTiming received(OffsetDateTime received) {
    this.received = received;
    return this;
  }

   /**
   * Get received
   * @return received
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getReceived() {
    return received;
  }

  public void setReceived(OffsetDateTime received) {
    this.received = received;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PredictionTiming predictionTiming = (PredictionTiming) o;
    return Objects.equals(this.countdownServerAdjustment, predictionTiming.countdownServerAdjustment) &&
        Objects.equals(this.source, predictionTiming.source) &&
        Objects.equals(this.insert, predictionTiming.insert) &&
        Objects.equals(this.read, predictionTiming.read) &&
        Objects.equals(this.sent, predictionTiming.sent) &&
        Objects.equals(this.received, predictionTiming.received);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countdownServerAdjustment, source, insert, read, sent, received);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PredictionTiming {\n");
    
    sb.append("    countdownServerAdjustment: ").append(toIndentedString(countdownServerAdjustment)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    insert: ").append(toIndentedString(insert)).append("\n");
    sb.append("    read: ").append(toIndentedString(read)).append("\n");
    sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
    sb.append("    received: ").append(toIndentedString(received)).append("\n");
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

