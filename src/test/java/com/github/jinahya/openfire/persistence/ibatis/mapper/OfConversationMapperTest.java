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
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import static java.util.Optional.ofNullable;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;

public class OfConversationMapperTest
        extends OfMappedMapperTest<OfConversation, OfConversationMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public OfConversationMapperTest() {
        super(OfConversation.class, OfConversationMapper.class);
    }

    private void testSelectList01(final OfMucRoom ofMucRoom) {
        final String room = ofNullable(ofMucRoom)
                .map(v -> OfConversation.room(v, DOMAIN))
                .orElse(null);
        final List<OfConversation> conversations = mappedMapper.selectList01(
                CATALOG, SCHEMA, room, true, true, RowBounds.DEFAULT);
        validate(conversations);
        conversations.forEach(conversation -> {
            final OfConversation one = mappedMapper.selectOne01(
                    CATALOG, SCHEMA, conversation.getConversationId(), room);
            validate(one);
        });
    }

    @Test
    public void selectList01WithRoom() {
        final List<OfMucRoom> rooms = ofMucRoomMapper.selectList01(
                CATALOG, SCHEMA, null, true, true, RowBounds.DEFAULT);
        rooms.forEach(room -> {
            testSelectList01(room);
        });
    }

    @Test
    public void selectList01WithoutRoom() {
        testSelectList01(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucRoomMapper ofMucRoomMapper;
}
