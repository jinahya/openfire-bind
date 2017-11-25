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
package com.github.jinahya.openfire.persistence.ibatis.mapper;

import com.github.jinahya.openfire.persistence.OfMapped;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> ofMapped type parameter
 */
public interface OfMappedMapper<T extends OfMapped> {

    String PARAM_CATALOG = "catalog";

    String PARAM_SCHEMA = "schema";

    String PARAM_ENTITY = "entity";

    String PARAM_NATURAL = "natural";

    String PARAM_ASCENDING = "ascending";

    // -------------------------------------------------------------------------
}
