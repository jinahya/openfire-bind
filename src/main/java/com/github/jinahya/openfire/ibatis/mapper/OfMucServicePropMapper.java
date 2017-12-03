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

import com.github.jinahya.openfire.persistence.OfMucRoomProp;
import com.github.jinahya.openfire.persistence.OfMucServiceProp;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfMucRoomProp}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public interface OfMucServicePropMapper extends OfPropMapper<OfMucServiceProp> {

    String PARAM_SERVICE_ID = OfMucServiceMapper.PARAM_SERVICE_ID;

    // -------------------------------------------------------------------------
    OfMucServiceProp selectOne01(@Param(PARAM_CATALOG) String catalog,
                                 @Param(PARAM_SCHEMA) String schema,
                                 @Param(PARAM_SERVICE_ID) long serviceId,
                                 @Param(PARAM_NAME) String name);

    List<OfMucServiceProp> selectList01(
            @Param(PARAM_CATALOG) String catalog,
            @Param(PARAM_SCHEMA) String schema,
            @Param(PARAM_SERVICE_ID) Long serviceId,
            @Param(PARAM_NATURAL) boolean natural,
            @Param(PARAM_ASCENDING) boolean ascending,
            RowBounds rowBounds);
}
