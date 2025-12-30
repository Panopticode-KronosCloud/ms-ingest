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
 * CreateNewFolderRequest
 */

@JsonTypeName("createNewFolder_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-27T00:58:13.391965702Z[Europe/London]", comments = "Generator version: 7.18.0")
public class CreateNewFolderRequest {

  private UUID parentId;

  private String name;

  public CreateNewFolderRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateNewFolderRequest(UUID parentId, String name) {
    this.parentId = parentId;
    this.name = name;
  }

  public CreateNewFolderRequest parentId(UUID parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Get parentId
   * @return parentId
   */
  @NotNull @Valid 
  @Schema(name = "parent_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parent_id")
  public UUID getParentId() {
    return parentId;
  }

  public void setParentId(UUID parentId) {
    this.parentId = parentId;
  }

  public CreateNewFolderRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNewFolderRequest createNewFolderRequest = (CreateNewFolderRequest) o;
    return Objects.equals(this.parentId, createNewFolderRequest.parentId) &&
        Objects.equals(this.name, createNewFolderRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentId, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNewFolderRequest {\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

