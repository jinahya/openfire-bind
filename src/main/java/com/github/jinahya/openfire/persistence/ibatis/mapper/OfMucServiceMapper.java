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

import com.github.jinahya.openfire.persistence.OfMucService;
import static com.github.jinahya.openfire.persistence.ibatis.mapper.OfMappedMapper.PARAM_CATALOG;
import static com.github.jinahya.openfire.persistence.ibatis.mapper.OfMappedMapper.PARAM_SCHEMA;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfMucService}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public interface OfMucServiceMapper extends OfMappedMapper<OfMucService> {

    String PARAM_SERVICE_ID = "serviceId";

    String PARAM_SUBDOMAIN = "subdomain";

    // -------------------------------------------------------------------------
    /**
     * Selects an entity. Note that either {@code serviceId} or
     * {@code subdomain} must be specified.
     *
     * @param catalog the value for database catalog; may be {@code null}.
     * @param schema the value for database schema; may be {@code null}.
     * @param serviceId the value for
     * {@value OfMucService#COLUMN_NAME_SERVICE_ID} column.
     * @param subdomain the value for
     * {@value OfMucService#COLUMN_NAME_SUBDOMAIN} column.
     * @return selected entity or {@code null} if not found
     */
    OfMucService selectOne01(@Param(PARAM_CATALOG) String catalog,
                             @Param(PARAM_SCHEMA) String schema,
                             @Param(PARAM_SERVICE_ID) Long serviceId,
                             @Param(PARAM_SUBDOMAIN) String subdomain);

    List<OfMucService> selectList01(@Param(PARAM_CATALOG) String catalog,
                                    @Param(PARAM_SCHEMA) String schema,
                                    @Param(PARAM_NATURAL) boolean natural,
                                    @Param(PARAM_ASCENDING) boolean ascending,
                                    RowBounds rowBounds);
}
