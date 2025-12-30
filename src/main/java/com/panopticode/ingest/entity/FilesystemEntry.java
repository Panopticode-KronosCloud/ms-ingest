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

package com.panopticode.ingest.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Generic entry in an abstract filesystem.
 *
 * @param id unique, immutable identifier
 * @param name name doesn't need to be unique or immutable, and it's a more user-friendly identifier
 * @param parentId id of the parent entity (as in a folder containing a file)
 * @param type type, not limited to file, folder (e.g. symlinks, virtual mount points...)
 * @param size size in bytes
 * @param mediaType MIME type, e.g. text/plain, image/png ...
 * @param metadata arbitrary metadata set by client applications
 * @param created date and time the record was created, ISO Date Format yyyy-MM-ddThh:mm:ss — for example, "2025-12-27T18:33:47.963222956Z"
 * @param lastModified last time the record was modified, same date format as <code>created</code>
 * @param rawAccess whether this file is exposed for raw access in Speculum
 * @param entryStatus status of this entry (deleted, staged ...)
 */
@Builder
public record FilesystemEntry(
    UUID id,
    String name,
    UUID parentId,
    EntryType type,
    long size,
    String mediaType,
    JsonNode metadata,
    OffsetDateTime created,
    OffsetDateTime lastModified,
    boolean rawAccess,
    EntryStatus entryStatus)
{ }
