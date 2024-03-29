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
 * FaresSection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-01-12T14:08:15.676-06:00")
public class FaresSection {
  @SerializedName("header")
  private String header = null;

  @SerializedName("index")
  private Integer index = null;

  @SerializedName("rows")
  private List<FareDetails> rows = null;

  @SerializedName("messages")
  private List<Message> messages = null;

  public FaresSection header(String header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public FaresSection index(Integer index) {
    this.index = index;
    return this;
  }

   /**
   * Get index
   * @return index
  **/
  @ApiModelProperty(value = "")
  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public FaresSection rows(List<FareDetails> rows) {
    this.rows = rows;
    return this;
  }

  public FaresSection addRowsItem(FareDetails rowsItem) {
    if (this.rows == null) {
      this.rows = new ArrayList<FareDetails>();
    }
    this.rows.add(rowsItem);
    return this;
  }

   /**
   * Get rows
   * @return rows
  **/
  @ApiModelProperty(value = "")
  public List<FareDetails> getRows() {
    return rows;
  }

  public void setRows(List<FareDetails> rows) {
    this.rows = rows;
  }

  public FaresSection messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public FaresSection addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<Message>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Get messages
   * @return messages
  **/
  @ApiModelProperty(value = "")
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FaresSection faresSection = (FaresSection) o;
    return Objects.equals(this.header, faresSection.header) &&
        Objects.equals(this.index, faresSection.index) &&
        Objects.equals(this.rows, faresSection.rows) &&
        Objects.equals(this.messages, faresSection.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, index, rows, messages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FaresSection {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

