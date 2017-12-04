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
import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.CATALOG;
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import java.util.function.Consumer;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;
import static com.github.jinahya.openfire.ibatis.mapper.OfMucRoomMapperTest.acceptOfMucRoomsPaginated;
import static java.util.concurrent.ThreadLocalRandom.current;
import static org.testng.Assert.assertEquals;

public class OfConversationMapperTest
        extends OfMappedMapperTest<OfConversation, OfConversationMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptMucConversationsPaginated(
            final OfConversationMapper mapper,
            final String room,
            final Consumer<List<OfConversation>> consumer) {
        final int limit = 4;
        for (int offset = 0; offset <= 16; offset += limit) {
            final List<OfConversation> ofConversations = mapper.selectList01(
                    CATALOG, SCHEMA, room, current().nextBoolean(),
                    current().nextBoolean(), new RowBounds(offset, limit));
            if (ofConversations.isEmpty()) {
                break;
            }
            ofConversations.forEach(ofConversation -> {
                logger.debug("ofConversation: {}", ofConversation);
            });
            consumer.accept(ofConversations);
        }
    }

    // -------------------------------------------------------------------------
    public OfConversationMapperTest() {
        super(OfConversation.class, OfConversationMapper.class);
    }

    // -------------------------------------------------------------------------
    private void test(final String room) {
        acceptMucConversationsPaginated(
                mappedMapper,
                room,
                list -> {
                    validate(list);
                    list.forEach(v -> {
                        final OfConversation one
                                = mappedMapper.selectOne01(
                                        CATALOG, SCHEMA, v.getConversationId());
                        validate(one);
                        if (room != null) {
                            assertEquals(one.getRoom(), room);
                        }
                    });
                });
    }

    @Test
    public void selectList01WithRoom() {
        acceptOfMucRoomsPaginated(
                ofMucRoomMapper,
                null,
                ofMucRooms -> {
                    ofMucRooms.forEach(v -> {
                        final String room = OfConversation.room(v, DOMAIN);
                        test(room);
                    });
                });
    }

    @Test
    public void selectList01WithoutRoom() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucRoomMapper ofMucRoomMapper;
}
