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

import com.panopticode.ingest.entity.FilesystemEntry;

import java.io.InputStream;
import java.util.UUID;

/**
 * Ingest service is the gateway to the storage system.
 */
public interface IngestService
{
    /**
     * Create or update filesystem entry.
     * <p/>
     * The implementing method should synchronously return as quick as possible.
     *
     * @param inputStream the content byte stream
     * @param filesystemEntry Metadata object related to the content
     * @param override if set to false and content exists, throw an error. Ignored for new content.
     * @return the unique id associated with the staged content
     */
    UUID ingest(InputStream inputStream, FilesystemEntry filesystemEntry, boolean override);
}
