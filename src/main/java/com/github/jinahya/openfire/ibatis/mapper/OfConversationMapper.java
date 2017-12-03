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

import com.github.jinahya.openfire.persistence.OfConversation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * A mapper interface for {@link OfConversation}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Mapper
public interface OfConversationMapper extends OfMappedMapper<OfConversation> {

    /**
     * Parameter value for {@value OfConversation#COLUMN_NAME_CONVERSATION_ID}
     * column.
     */
    String PARAM_CONVERSATION_ID = "conversationId";

    /**
     * Parameter value for {@value OfConversation#COLUMN_NAME_ROOM} column.
     */
    String PARAM_ROOM = "room";

    // -------------------------------------------------------------------------
    OfConversation selectOne01(
            @Param(PARAM_CATALOG) String catalog,
            @Param(PARAM_SCHEMA) String schema,
            @Param(PARAM_CONVERSATION_ID) long conversaionId);

    List<OfConversation> selectList01(@Param(PARAM_CATALOG) String catalog,
                                      @Param(PARAM_SCHEMA) String schema,
                                      @Param(PARAM_ROOM) String room,
                                      @Param(PARAM_NATURAL) boolean natural,
                                      @Param(PARAM_ASCENDING) boolean ascending,
                                      RowBounds rowBounds);
}
