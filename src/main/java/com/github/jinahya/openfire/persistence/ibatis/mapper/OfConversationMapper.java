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

import com.github.jinahya.openfire.persistence.OfConversation;
import com.github.jinahya.openfire.persistence.OfMucRoom;
import static com.github.jinahya.openfire.persistence.ibatis.mapper.OfMappedMapper.PARAM_CATALOG;
import static com.github.jinahya.openfire.persistence.ibatis.mapper.OfMappedMapper.PARAM_SCHEMA;
import static com.github.jinahya.openfire.persistence.ibatis.mapper.OfMucServiceMapper.PARAM_SUBDOMAIN;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public interface OfConversationMapper extends OfMappedMapper<OfConversation> {

    String PARAM_CONVERSATION_ID = "conversationId";

    String PARAM_ROOM = "room";

    // -------------------------------------------------------------------------
    OfConversation selectOne01(@Param(PARAM_CATALOG) String catalog,
                               @Param(PARAM_SCHEMA) String schema,
                               @Param(PARAM_CONVERSATION_ID) long conversaionId,
                               @Param(PARAM_ROOM) String room);

    List<OfMucRoom> selectList01(@Param(PARAM_CATALOG) String catalog,
                                 @Param(PARAM_SCHEMA) String schema,
                                 @Param(PARAM_ROOM) String room,
                                 @Param(PARAM_NATURAL) boolean natural,
                                 @Param(PARAM_ASCENDING) boolean ascending,
                                 RowBounds rowBounds);
}
