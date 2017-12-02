/*
 * Copyright 2017 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.openfire.ibatis.mapper;

import com.github.jinahya.openfire.persistence.OfMapped;

/**
 * A mapper interface for {@link OfMapped}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> subclass type parameter
 */
public interface OfMappedMapper<T extends OfMapped> {

    /**
     * Param value for database catalog.
     */
    String PARAM_CATALOG = "catalog";

    /**
     * Param value for database schema.
     */
    String PARAM_SCHEMA = "schema";

    /**
     * Param value for entity.
     */
    String PARAM_ENTITY = "entity";

    /**
     * Param name for natural ordering.
     */
    String PARAM_NATURAL = "natural";

    /**
     * Param value for ascending order.
     */
    String PARAM_ASCENDING = "ascending";

    // -------------------------------------------------------------------------
}
