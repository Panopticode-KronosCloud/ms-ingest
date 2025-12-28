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

import lombok.Getter;

/**
 * Status of a file.
 *
 * <ul>
 *     <li/> "unavailable": some necessary processing haven't taken place yet and the file is not available
 *     <li/> "deleted": the file is soft-deleted
 *     <li/> "staged": the file hasn't reached long-term storage yet, but it's available in cache for most purposes
 *     <li/> "ready": the file has been fully ingested, post-processed and lives in long-term storage
 * </ul>
 */
@Getter
public enum EntryStatus
{
    UNAVAILABLE("unavailable"),
    DELETED("deleted"),
    STAGED("staged"),
    READY("ready");

    private final String _value;

    EntryStatus(final String value)
    {
        this._value = value;
    }

    @Override
    public String toString()
    {
        return get_value();
    }

    public static EntryStatus fromValue(String value)
    {
        for (var b : EntryStatus.values())
        {
            if (b._value.equals(value))
            {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
