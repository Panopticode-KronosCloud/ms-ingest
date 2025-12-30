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

import java.io.InputStream;
import java.util.UUID;

/**
 * Short-term storage service.
 */
public interface TemporaryStorageService
{
    /**
     * Store content in the short-term storage.
     *
     * @param inputStream the content as a stream of bytes
     * @param uuid the unique ID to use to identify the content in future calls
     */
    void store(InputStream inputStream, UUID uuid);
}
