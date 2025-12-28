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

package com.panopticode.ingest.service;

import com.panopticode.ingest.entity.EntryType;
import com.panopticode.ingest.entity.FilesystemEntry;

import java.util.UUID;

/**
 * Service responsible for handling metadata of filesystem entries.
 */
public interface MetadataService
{
    /**
     * Check if a record exists by ID and entry type.
     *
     * @param entryId unique ID of the entry
     * @param entryType type of the entry
     * @return true if the entity exists
     */
    boolean exists(UUID entryId, EntryType entryType);

    /**
     * Check if a record exists by path. The path is inferred using the name
     * of the record and its parent entry.
     *
     * @param parentId unique ID of the parent
     * @param name name of the entry
     * @return true if the entity exists
     */
    boolean exists(UUID parentId, String name);

    /**
     * Create a new metadata record. This method will throw an error if the
     * entry already exists.
     *
     * @param filesystemEntry the new entry
     */
    void create(FilesystemEntry filesystemEntry);
}
