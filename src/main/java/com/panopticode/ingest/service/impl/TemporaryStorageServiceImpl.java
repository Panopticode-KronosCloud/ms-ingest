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

import com.panopticode.ingest.service.TemporaryStorageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * TemporaryStorageService service is a wrapper interface to Citadel,
 * the temporary blob storage.
 */
@Service
@Slf4j
public class TemporaryStorageServiceImpl implements TemporaryStorageService
{
    public TemporaryStorageServiceImpl()
    { }

    @Override
    public void store(final InputStream inputStream, final UUID uuid)
    {
        log.warn("TBS store not implemented yet!");
    }
}
