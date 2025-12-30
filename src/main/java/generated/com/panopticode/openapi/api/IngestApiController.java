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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-27T00:58:13.391965702Z[Europe/London]", comments = "Generator version: 7.18.0")
@Controller
@RequestMapping("${openapi.ingest-microservice_OpenAPI.base-path:/api/v1/ingest}")
public class IngestApiController implements IngestApi {

    private final IngestApiDelegate delegate;

    public IngestApiController(@Autowired(required = false) IngestApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new IngestApiDelegate() {});
    }

    @Override
    public IngestApiDelegate getDelegate() {
        return delegate;
    }

}
