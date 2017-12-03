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

import com.github.jinahya.openfire.persistence.OfMucMember;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfMucMember}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Mapper
public interface OfMucMemberMapper extends OfMappedMapper<OfMucMember> {

    /**
     * Parameter value for {@value OfMucMember#COLUMN_NAME_ROOM_ID} column.
     */
    String PARAM_ROOM_ID = "roomId";

    /**
     * Parameter value for {@value OfMucMember#COLUMN_NAME_JID} column.
     */
    String PARAM_JID = "jid";

    // -------------------------------------------------------------------------
    OfMucMember selectOne01(@Param(PARAM_CATALOG) String catalog,
                            @Param(PARAM_SCHEMA) String schema,
                            @Param(PARAM_ROOM_ID) long roomId,
                            @Param(PARAM_JID) String jid);

    List<OfMucMember> selectList01(@Param(PARAM_CATALOG) String catalog,
                                   @Param(PARAM_SCHEMA) String schema,
                                   @Param(PARAM_ROOM_ID) Long roomId,
                                   @Param(PARAM_NATURAL) boolean natural,
                                   @Param(PARAM_ASCENDING) boolean ascending,
                                   RowBounds rowBounds);
}
