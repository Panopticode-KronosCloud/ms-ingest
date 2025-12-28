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
import com.panopticode.ingest.service.MetadataService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Metadata service is a wrapper interface to the Chancery,
 * the metadata microservice.
 */
@Service
@Slf4j
public class MetadataServiceImpl implements MetadataService
{
    public static final String LOG_MESSAGE = "Metadata service not implemented!";

    public MetadataServiceImpl()
    { }

    @Override
    public boolean exists(final UUID entryId, final EntryType entryType)
    {
        log.warn(LOG_MESSAGE);
        return true;
    }

    @Override
    public boolean exists(final UUID parentId, final String name)
    {
        log.warn(LOG_MESSAGE);
        return true;
    }

    @Override
    public void create(final FilesystemEntry filesystemEntry)
    {
        log.warn(LOG_MESSAGE);
    }
}
