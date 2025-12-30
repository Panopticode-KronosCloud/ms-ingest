package com.panopticode.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateEntryMetadataRequest
 */

@JsonTypeName("updateEntryMetadata_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-27T00:58:13.391965702Z[Europe/London]", comments = "Generator version: 7.18.0")
public class UpdateEntryMetadataRequest {

  private Object metadata;

  public UpdateEntryMetadataRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateEntryMetadataRequest(Object metadata) {
    this.metadata = metadata;
  }

  public UpdateEntryMetadataRequest metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Arbitrary metadata object
   * @return metadata
   */
  @NotNull 
  @Schema(name = "metadata", description = "Arbitrary metadata object", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateEntryMetadataRequest updateEntryMetadataRequest = (UpdateEntryMetadataRequest) o;
    return Objects.equals(this.metadata, updateEntryMetadataRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateEntryMetadataRequest {\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

