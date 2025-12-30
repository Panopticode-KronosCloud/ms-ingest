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

package com.panopticode.ingest.mapper;

import com.panopticode.ingest.entity.FilesystemEntry;
import com.panopticode.openapi.model.EntryResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Decorated mapper to validate and map various entities.
 *
 * <p>Its implementation is automatically generated with MapStruct.</p>
 *
 * <p>It supports building, validating and mapping to/from
 * DB entities, API Entities and internal representations.</p>
 */
@Mapper(componentModel = "spring")
public abstract class AbstractEntityMapper
{
    @Autowired
    private ObjectMapper _objectMapper;

    public abstract EntryResponse toEntryResponse(FilesystemEntry filesystemEntry);

    <T> JsonNullable<T> toJsonNullable(T object)
    {
        return JsonNullable.of(object);
    }

    JsonNullable<Map<String, Object>> toJsonNullableMap(JsonNode node)
    {
        if (node == null || node.isNull())
        {
            return JsonNullable.undefined();
        }

        final var map =
                _objectMapper.convertValue(
                        node,
                        new TypeReference<Map<String, Object>>()
                        { });

        return JsonNullable.of(map);
    }
}
