/*
 * ingest-microservice
 * Copyright (c) 2024-2026 Panopticode.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.panopticode.ingest.controller;

import com.panopticode.ingest.entity.EntryStatus;
import com.panopticode.ingest.entity.EntryType;
import com.panopticode.ingest.entity.FilesystemEntry;
import com.panopticode.ingest.exception.DataLayerException;
import com.panopticode.ingest.mapper.AbstractEntityMapper;
import com.panopticode.ingest.service.IngestService;
import com.panopticode.openapi.api.IngestApiDelegate;
import com.panopticode.openapi.model.CreateNewFolderRequest;
import com.panopticode.openapi.model.EntryResponse;
import com.panopticode.openapi.model.MoveEntryRequest;
import com.panopticode.openapi.model.UpdateEntryMetadataRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.UUID;

import static com.panopticode.ingest.utils.Validator.validateNonNull;
import static com.panopticode.ingest.utils.Validator.validateNotEmpty;

/**
 * Controller for the ingest API.
 */
@Service
@Slf4j
public class IngestControllerDelegate implements IngestApiDelegate
{
    private final IngestService _ingestService;
    private final AbstractEntityMapper _entityMapper;
    private final ObjectMapper _objectMapper;

    @Autowired
    public IngestControllerDelegate(final IngestService ingestService,
                                    final AbstractEntityMapper entityMapper,
                                    final ObjectMapper objectMapper)
    {
        _ingestService = ingestService;
        _entityMapper = entityMapper;
        _objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<EntryResponse> createNewFolder(final CreateNewFolderRequest createNewFolderRequest)
    {
        log.debug("INGEST API CONTROLLER: createNewFolder");
        return IngestApiDelegate.super.createNewFolder(createNewFolderRequest);
    }

    @Override
    public ResponseEntity<Void> deleteEntry(final UUID entryId)
    {
        log.debug("INGEST API CONTROLLER: deleteEntry");
        return IngestApiDelegate.super.deleteEntry(entryId);
    }

    @Override
    public ResponseEntity<EntryResponse> moveEntry(final UUID entryId, final MoveEntryRequest moveEntryRequest)
    {
        log.debug("INGEST API CONTROLLER: moveEntry");
        return IngestApiDelegate.super.moveEntry(entryId, moveEntryRequest);
    }

    @Override
    public ResponseEntity<EntryResponse> updateEntryMetadata(final UUID entryId, final UpdateEntryMetadataRequest updateEntryMetadataRequest)
    {
        log.debug("INGEST API CONTROLLER: updateEntryMetadata");
        return IngestApiDelegate.super.updateEntryMetadata(entryId, updateEntryMetadataRequest);
    }

    @Override
    @SuppressWarnings("checkstyle:parameternumber") // overriding generated code
    public ResponseEntity<EntryResponse> upsertFile(final MultipartFile file,
                                                    final String name,
                                                    final Boolean override,
                                                    final OffsetDateTime created,
                                                    final OffsetDateTime lastModified,
                                                    final UUID parentId,
                                                    final Map<String, Object> metadata,
                                                    final Boolean rawAccess)
    {
        log.debug("INGEST API CONTROLLER: upsertFile");
        validateNonNull(file, "file to upload");
        validateNotEmpty(name, "name of file to upload");

        final var entryBuilder = FilesystemEntry.builder();

        entryBuilder
                .name(name)
                .mediaType(file.getContentType())
                .size(file.getSize())
                .type(EntryType.FILE)
                .rawAccess(rawAccess != null && rawAccess)
                .created(created == null ? OffsetDateTime.now(ZoneId.systemDefault()) : created)
                .parentId(parentId)
                .metadata(metadata == null ? NullNode.getInstance() : _objectMapper.valueToTree(metadata))
                .lastModified(lastModified == null ? OffsetDateTime.now(ZoneId.systemDefault()) : lastModified)
                .entryStatus(EntryStatus.UNAVAILABLE);

        final var overrideUnboxed = override != null && override;

        try (var is = file.getInputStream())
        {
            final var id = _ingestService.ingest(is, entryBuilder.build(), overrideUnboxed);
            entryBuilder.id(id);
            entryBuilder.entryStatus(EntryStatus.STAGED);
        } catch (IOException e)
        {
            throw new DataLayerException("Temporary store of file {} failed", name, e);
        }

        return ResponseEntity.accepted().body(_entityMapper.toEntryResponse(entryBuilder.build()));
    }
}
