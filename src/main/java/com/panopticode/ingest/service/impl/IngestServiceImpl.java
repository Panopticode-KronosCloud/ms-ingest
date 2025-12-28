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

package com.panopticode.ingest.service.impl;

import com.panopticode.ingest.entity.EntryType;
import com.panopticode.ingest.entity.FilesystemEntry;
import com.panopticode.ingest.exception.EntityNotFoundException;
import com.panopticode.ingest.exception.ValidationException;
import com.panopticode.ingest.service.IngestService;
import com.panopticode.ingest.service.MetadataService;
import com.panopticode.ingest.service.TemporaryStorageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * Implementation of the ingest service. This implementation is moving the content
 * in a temporary storage, trusts an external service to persist metadata and
 * returns as quick as it can. The content is intended to be staged and will be
 * moved to permanent, long-term storage in a second, asynchronous phase.
 */
@Service
@Slf4j
public class IngestServiceImpl implements IngestService
{
    private final TemporaryStorageService _temporaryStorageService;
    private final MetadataService _metadataService;

    @Autowired
    public IngestServiceImpl(final TemporaryStorageService temporaryStorageService,
                             final MetadataService metadataService)
    {
        _temporaryStorageService = temporaryStorageService;
        _metadataService = metadataService;
    }

    @Override
    public UUID ingest(final InputStream inputStream,
                       final FilesystemEntry filesystemEntry,
                       final boolean override)
    {
        if (!_metadataService.exists(filesystemEntry.parentId(), EntryType.DIRECTORY))
        {
            throw new EntityNotFoundException("Folder", filesystemEntry.parentId());
        }

        if (!override && _metadataService.exists(filesystemEntry.parentId(), filesystemEntry.name()))
        {
            throw new ValidationException("Entry {} already exist in parent folder {} and the override flag is not set",
                    filesystemEntry.name(), filesystemEntry.parentId());
        }

        final var uuid = UUID.randomUUID();

        _temporaryStorageService.store(inputStream, uuid);

        _metadataService.create(filesystemEntry);

        return uuid;
    }
}
