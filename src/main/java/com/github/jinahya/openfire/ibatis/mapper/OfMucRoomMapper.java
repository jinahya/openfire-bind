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

import com.github.jinahya.openfire.persistence.OfMucRoom;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfMucRoom}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Mapper
public interface OfMucRoomMapper extends OfMappedMapper<OfMucRoom> {

    /**
     * Parameter value for {@value OfMucRoom#COLUMN_NAME_SERVICE_ID} column.
     */
    String PARAM_SERVICE_ID = OfMucServiceMapper.PARAM_SERVICE_ID;

    /**
     * Parameter value for {@link OfMucRoom#COLUMN_NAME_ROOM_ID} column.
     */
    String PARAM_ROOM_ID = "roomId";

    /**
     * Parameter value for {@value OfMucRoom#COLUMN_NAME_NAME} column.
     */
    String PARAM_NAME = "name";

    // -------------------------------------------------------------------------
    /**
     * Selects the room whose {@value OfMucRoom#COLUMN_NAME_SERVICE_ID} column
     * and {@value OfMucRoom#COLUMN_NAME_NAME} match given.
     *
     * @param catalog the value for database catalog; may be {@code null}.
     * @param schema the value for database schema; may be {@code null}.
     * @param serviceId the value for {@link OfMucRoom#COLUMN_NAME_SERVICE_ID}
     * column.
     * @param name the value for {@link OfMucRoom#COLUMN_NAME_NAME} column.
     * @return found entity or {@code null} if not found.
     */
    OfMucRoom selectOne01(@Param(PARAM_CATALOG) String catalog,
                          @Param(PARAM_SCHEMA) String schema,
                          @Param(PARAM_SERVICE_ID) long serviceId,
                          @NotNull @Param(PARAM_NAME) String name);

    List<OfMucRoom> selectList01(@Param(PARAM_CATALOG) String catalog,
                                 @Param(PARAM_SCHEMA) String schema,
                                 @Param(PARAM_SERVICE_ID) Long serviceId,
                                 @Param(PARAM_NATURAL) boolean natural,
                                 @Param(PARAM_ASCENDING) boolean ascending,
                                 RowBounds rowBounds);
}
