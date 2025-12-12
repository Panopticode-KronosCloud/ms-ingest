package com.panopticode.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * MoveEntryRequest
 */

@JsonTypeName("moveEntry_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-12T01:30:18.089030221Z[Europe/London]", comments = "Generator version: 7.17.0")
public class MoveEntryRequest {

  private UUID newParentId;

  private @Nullable String newName;

  public MoveEntryRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MoveEntryRequest(UUID newParentId) {
    this.newParentId = newParentId;
  }

  public MoveEntryRequest newParentId(UUID newParentId) {
    this.newParentId = newParentId;
    return this;
  }

  /**
   * Get newParentId
   * @return newParentId
   */
  @NotNull @Valid 
  @Schema(name = "new_parent_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("new_parent_id")
  public UUID getNewParentId() {
    return newParentId;
  }

  public void setNewParentId(UUID newParentId) {
    this.newParentId = newParentId;
  }

  public MoveEntryRequest newName(@Nullable String newName) {
    this.newName = newName;
    return this;
  }

  /**
   * Get newName
   * @return newName
   */
  
  @Schema(name = "new_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("new_name")
  public @Nullable String getNewName() {
    return newName;
  }

  public void setNewName(@Nullable String newName) {
    this.newName = newName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveEntryRequest moveEntryRequest = (MoveEntryRequest) o;
    return Objects.equals(this.newParentId, moveEntryRequest.newParentId) &&
        Objects.equals(this.newName, moveEntryRequest.newName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newParentId, newName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveEntryRequest {\n");
    sb.append("    newParentId: ").append(toIndentedString(newParentId)).append("\n");
    sb.append("    newName: ").append(toIndentedString(newName)).append("\n");
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

