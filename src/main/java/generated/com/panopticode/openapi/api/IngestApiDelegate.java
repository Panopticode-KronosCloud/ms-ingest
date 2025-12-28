package com.panopticode.openapi.api;

import com.panopticode.openapi.model.CreateNewFolderRequest;
import org.springframework.format.annotation.DateTimeFormat;
import com.panopticode.openapi.model.EntryResponse;
import com.panopticode.openapi.model.ErrorModel;
import com.panopticode.openapi.model.MoveEntryRequest;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import java.util.UUID;
import com.panopticode.openapi.model.UpdateEntryMetadataRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link IngestApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-27T00:58:13.391965702Z[Europe/London]", comments = "Generator version: 7.18.0")
public interface IngestApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /folders : Create an empty folder
     * Create an empty folder
     *
     * @param createNewFolderRequest Request object to create a new folder (required)
     * @return Folder successfully created (status code 201)
     *         or Folder already exists (status code 400)
     *         or Parent not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see IngestApi#createNewFolder
     */
    default ResponseEntity<EntryResponse> createNewFolder(CreateNewFolderRequest createNewFolderRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : { \"key\" : \"\" }, \"size\" : 0, \"media_type\" : \"media_type\", \"parent_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"created\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"entry_status\" : \"unavailable\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"file\", \"last_modified\" : \"2000-01-23T04:56:07.000+00:00\", \"raw_access\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /entries/{entryId} : Delete a file or directory
     * Delete a file or directory, if it exists
     *
     * @param entryId  (required)
     * @return Deletion completed successfully (status code 204)
     *         or Invalid entry id (status code 404)
     *         or Unexpected error (status code 200)
     * @see IngestApi#deleteEntry
     */
    default ResponseEntity<Void> deleteEntry(UUID entryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /entries/{entryId}/move : Move or rename an entry (file or folder)
     *
     * @param entryId  (required)
     * @param moveEntryRequest Data object to move an entry (file or folder) (required)
     * @return Entry successfully moved/renamed (status code 200)
     *         or Invalid parent id (status code 404)
     * @see IngestApi#moveEntry
     */
    default ResponseEntity<EntryResponse> moveEntry(UUID entryId,
        MoveEntryRequest moveEntryRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : { \"key\" : \"\" }, \"size\" : 0, \"media_type\" : \"media_type\", \"parent_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"created\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"entry_status\" : \"unavailable\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"file\", \"last_modified\" : \"2000-01-23T04:56:07.000+00:00\", \"raw_access\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /entries/{entryId}/metadata : Update metadata for an entry
     * Update metadata for an entry (file or folder)
     *
     * @param entryId  (required)
     * @param updateEntryMetadataRequest Update an entry with an arbitrary metadata object (required)
     * @return Metadata successfully updated (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Entry not found (status code 404)
     *         or Unexpected error (status code 200)
     * @see IngestApi#updateEntryMetadata
     */
    default ResponseEntity<EntryResponse> updateEntryMetadata(UUID entryId,
        UpdateEntryMetadataRequest updateEntryMetadataRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : { \"key\" : \"\" }, \"size\" : 0, \"media_type\" : \"media_type\", \"parent_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"created\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"entry_status\" : \"unavailable\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"file\", \"last_modified\" : \"2000-01-23T04:56:07.000+00:00\", \"raw_access\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /files : Upload or update a file
     * Upload a new file. If override&#x3D;true, an existing file with the same parent and name will be replaced. 
     *
     * @param file  (required)
     * @param name  (required)
     * @param override  (optional, default to false)
     * @param created Optionally pass the created date. If not provided, will be set at time of upload (optional)
     * @param lastModified Optionally pass the last modified date. If not provided, will be set at time of upload (optional)
     * @param parentId the id of the parent folder, or null for root (optional)
     * @param metadata Arbitrary JSON metadata for the file (optional)
     * @param rawAccess Whether or not to allow this file to be accessible from the Web; defaults to false (optional, default to false)
     * @return Change successfully queued (status code 201)
     *         or Invalid input (status code 405)
     *         or Unexpected error (status code 200)
     * @see IngestApi#upsertFile
     */
    default ResponseEntity<EntryResponse> upsertFile(MultipartFile file,
        String name,
        Boolean override,
        OffsetDateTime created,
        OffsetDateTime lastModified,
        UUID parentId,
        Map<String, Object> metadata,
        Boolean rawAccess) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : { \"key\" : \"\" }, \"size\" : 0, \"media_type\" : \"media_type\", \"parent_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"created\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"entry_status\" : \"unavailable\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"file\", \"last_modified\" : \"2000-01-23T04:56:07.000+00:00\", \"raw_access\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
