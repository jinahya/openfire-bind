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
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.function.Consumer;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;
import static com.github.jinahya.openfire.ibatis.mapper.OfMucRoomMapperTest.acceptOfMucRooms;

public class OfMucMemberMapperTest
        extends OfMappedMapperTest<OfMucMember, OfMucMemberMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfMucMembers(
            final OfMucMemberMapper mapper, final Long roomId,
            final Consumer<List<OfMucMember>> consumer) {
        final int limit = 3;
        for (int offset = 0; offset <= 8; offset += limit) {
            final List<OfMucMember> ofMucMembers = mapper.selectList01(
                    CATALOG, SCHEMA, roomId, current().nextBoolean(),
                    current().nextBoolean(), new RowBounds(offset, limit));
            if (ofMucMembers.isEmpty()) {
                break;
            }
            ofMucMembers.forEach(ofMucMember -> {
                logger.debug("ofMucMember: {}", ofMucMember);
            });
            consumer.accept(ofMucMembers);
        }
    }

    // -------------------------------------------------------------------------
    public OfMucMemberMapperTest() {
        super(OfMucMember.class, OfMucMemberMapper.class);
    }

    // -------------------------------------------------------------------------
    private void test(final Long roomId) {
        acceptOfMucMembers(
                mappedMapper,
                roomId,
                ofMucMembers -> {
                    validate(ofMucMembers);
                    ofMucMembers.forEach(ofMucMember -> {
                        if (roomId != null) {
                            assertEquals(ofMucMember.getRoomRoomId(), roomId);
                        }
                        final OfMucMember one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA, ofMucMember.getRoomRoomId(),
                                ofMucMember.getJid());
                        assertNotNull(ofMucMember);
                        if (roomId != null) {
                            assertEquals(one.getRoom().getRoomId(), roomId);
                        }
                    });
                });
    }

    @Test
    public void selectWithRoom() {
        acceptOfMucRooms(
                ofMucRoomMapper,
                null,
                ofMucRooms -> {
                    ofMucRooms.forEach(ofMucRoom -> {
                        test(ofMucRoom.getRoomId());
                    });
                });
    }

    //@Test
    public void testWithoutRoom() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucRoomMapper ofMucRoomMapper;
}
