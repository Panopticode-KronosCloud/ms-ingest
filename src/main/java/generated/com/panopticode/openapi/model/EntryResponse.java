package com.panopticode.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Entry object
 */

@Schema(name = "EntryResponse", description = "Entry object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-27T00:58:13.391965702Z[Europe/London]", comments = "Generator version: 7.18.0")
public class EntryResponse {

  private @Nullable UUID id;

  private @Nullable String name;

  private JsonNullable<UUID> parentId = JsonNullable.<UUID>undefined();

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    FILE("file"),
    
    DIRECTORY("directory");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable TypeEnum type;

  private JsonNullable<Long> size = JsonNullable.<Long>undefined();

  private JsonNullable<String> mediaType = JsonNullable.<String>undefined();

  @Valid
  private JsonNullable<Map<String, Object>> metadata = JsonNullable.<Map<String, Object>>undefined();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime lastModified;

  private @Nullable Boolean rawAccess;

  /**
   * Gets or Sets entryStatus
   */
  public enum EntryStatusEnum {
    UNAVAILABLE("unavailable"),
    
    DELETED("deleted"),
    
    STAGED("staged"),
    
    READY("ready");

    private final String value;

    EntryStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EntryStatusEnum fromValue(String value) {
      for (EntryStatusEnum b : EntryStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable EntryStatusEnum entryStatus;

  public EntryResponse id(@Nullable UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable UUID getId() {
    return id;
  }

  public void setId(@Nullable UUID id) {
    this.id = id;
  }

  public EntryResponse name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public EntryResponse parentId(UUID parentId) {
    this.parentId = JsonNullable.of(parentId);
    return this;
  }

  /**
   * Get parentId
   * @return parentId
   */
  @Valid 
  @Schema(name = "parent_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parent_id")
  public JsonNullable<UUID> getParentId() {
    return parentId;
  }

  public void setParentId(JsonNullable<UUID> parentId) {
    this.parentId = parentId;
  }

  public EntryResponse type(@Nullable TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public @Nullable TypeEnum getType() {
    return type;
  }

  public void setType(@Nullable TypeEnum type) {
    this.type = type;
  }

  public EntryResponse size(Long size) {
    this.size = JsonNullable.of(size);
    return this;
  }

  /**
   * Get size
   * @return size
   */
  
  @Schema(name = "size", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public JsonNullable<Long> getSize() {
    return size;
  }

  public void setSize(JsonNullable<Long> size) {
    this.size = size;
  }

  public EntryResponse mediaType(String mediaType) {
    this.mediaType = JsonNullable.of(mediaType);
    return this;
  }

  /**
   * Get mediaType
   * @return mediaType
   */
  
  @Schema(name = "media_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("media_type")
  public JsonNullable<String> getMediaType() {
    return mediaType;
  }

  public void setMediaType(JsonNullable<String> mediaType) {
    this.mediaType = mediaType;
  }

  public EntryResponse metadata(Map<String, Object> metadata) {
    this.metadata = JsonNullable.of(metadata);
    return this;
  }

  public EntryResponse putMetadataItem(String key, Object metadataItem) {
    if (this.metadata == null || !this.metadata.isPresent()) {
      this.metadata = JsonNullable.of(new HashMap<>());
    }
    this.metadata.get().put(key, metadataItem);
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   */
  
  @Schema(name = "metadata", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metadata")
  public JsonNullable<Map<String, Object>> getMetadata() {
    return metadata;
  }

  public void setMetadata(JsonNullable<Map<String, Object>> metadata) {
    this.metadata = metadata;
  }

  public EntryResponse created(@Nullable OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   */
  @Valid 
  @Schema(name = "created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created")
  public @Nullable OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(@Nullable OffsetDateTime created) {
    this.created = created;
  }

  public EntryResponse lastModified(@Nullable OffsetDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * Get lastModified
   * @return lastModified
   */
  @Valid 
  @Schema(name = "last_modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last_modified")
  public @Nullable OffsetDateTime getLastModified() {
    return lastModified;
  }

  public void setLastModified(@Nullable OffsetDateTime lastModified) {
    this.lastModified = lastModified;
  }

  public EntryResponse rawAccess(@Nullable Boolean rawAccess) {
    this.rawAccess = rawAccess;
    return this;
  }

  /**
   * Get rawAccess
   * @return rawAccess
   */
  
  @Schema(name = "raw_access", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("raw_access")
  public @Nullable Boolean isRawAccess() {
    return rawAccess;
  }

  public void setRawAccess(@Nullable Boolean rawAccess) {
    this.rawAccess = rawAccess;
  }

  public EntryResponse entryStatus(@Nullable EntryStatusEnum entryStatus) {
    this.entryStatus = entryStatus;
    return this;
  }

  /**
   * Get entryStatus
   * @return entryStatus
   */
  
  @Schema(name = "entry_status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entry_status")
  public @Nullable EntryStatusEnum getEntryStatus() {
    return entryStatus;
  }

  public void setEntryStatus(@Nullable EntryStatusEnum entryStatus) {
    this.entryStatus = entryStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntryResponse entryResponse = (EntryResponse) o;
    return Objects.equals(this.id, entryResponse.id) &&
        Objects.equals(this.name, entryResponse.name) &&
        equalsNullable(this.parentId, entryResponse.parentId) &&
        Objects.equals(this.type, entryResponse.type) &&
        equalsNullable(this.size, entryResponse.size) &&
        equalsNullable(this.mediaType, entryResponse.mediaType) &&
        equalsNullable(this.metadata, entryResponse.metadata) &&
        Objects.equals(this.created, entryResponse.created) &&
        Objects.equals(this.lastModified, entryResponse.lastModified) &&
        Objects.equals(this.rawAccess, entryResponse.rawAccess) &&
        Objects.equals(this.entryStatus, entryResponse.entryStatus);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, hashCodeNullable(parentId), type, hashCodeNullable(size), hashCodeNullable(mediaType), hashCodeNullable(metadata), created, lastModified, rawAccess, entryStatus);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntryResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    mediaType: ").append(toIndentedString(mediaType)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    rawAccess: ").append(toIndentedString(rawAccess)).append("\n");
    sb.append("    entryStatus: ").append(toIndentedString(entryStatus)).append("\n");
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

