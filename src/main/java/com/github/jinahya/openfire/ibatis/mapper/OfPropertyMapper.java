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

import com.github.jinahya.openfire.persistence.OfProp;
import com.github.jinahya.openfire.persistence.OfProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfPropMapper}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public interface OfPropertyMapper extends OfPropMapper<OfProperty> {

    // -------------------------------------------------------------------------
    /**
     * Selects one whose {@value OfProp#COLUMN_NAME_NAME} column matches to
     * given.
     *
     * @param catalog an optional value for database catalog; may be
     * {@code null}.
     * @param schema an optional value for database schema; may be {@code null}.
     * @param name the value for {@value OfProp#COLUMN_NAME_NAME} column.
     * @return found entity or {@code null} if not found
     */
    OfProperty selectOne01(@Param(PARAM_CATALOG) String catalog,
                           @Param(PARAM_SCHEMA) String schema,
                           @Param(PARAM_NAME) String name);

    List<OfProperty> selectList01(@Param(PARAM_CATALOG) String catalog,
                                  @Param(PARAM_SCHEMA) String schema,
                                  @Param(PARAM_ASCENDING) boolean ascending,
                                  RowBounds rowBounds);
}
