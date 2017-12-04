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

import static com.github.jinahya.openfire.ibatis.mapper.OfMucRoomMapperTest.acceptOfMucRoomsPaginated;
import com.github.jinahya.openfire.persistence.OfMucRoomProp;
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

/**
 * A class for testing {@link OfMucRoomProp}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfMucRoomPropMapperTest
        extends OfPropMapperTest<OfMucRoomProp, OfMucRoomPropMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfMucRoomPropsPaginated(
            final OfMucRoomPropMapper mapper,
            final Long roomId,
            final Consumer<List<OfMucRoomProp>> consumer) {
        final int limit = 4;
        for (int offset = 0; offset <= 16; offset += limit) {
            final List<OfMucRoomProp> ofMucRoomProps = mapper.selectList01(
                    CATALOG, SCHEMA, roomId, current().nextBoolean(),
                    current().nextBoolean(), new RowBounds(offset, limit));
            if (ofMucRoomProps.isEmpty()) {
                break;
            }
            ofMucRoomProps.forEach(ofMucRoomProp -> {
                logger.debug("ofMucRoomProp: {}", ofMucRoomProp);
            });
            consumer.accept(ofMucRoomProps);
        }
    }

    // -------------------------------------------------------------------------
    public OfMucRoomPropMapperTest() {
        super(OfMucRoomProp.class, OfMucRoomPropMapper.class);
    }

    // -------------------------------------------------------------------------    
    private void test(final Long roomId) {
        acceptOfMucRoomPropsPaginated(
                mappedMapper,
                roomId,
                ofMucRoomProps -> {
                    validate(ofMucRoomProps);
                    ofMucRoomProps.forEach(ofMucRoomProp -> {
                        assertNotNull(ofMucRoomProp.getRoomRoomId());
                        if (roomId != null) {
                            assertEquals(ofMucRoomProp.getRoomRoomId(), roomId);
                        }
                        final OfMucRoomProp one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA, ofMucRoomProp.getRoomRoomId(),
                                ofMucRoomProp.getName());
                        assertNotNull(one);
                    });
                });
    }

    @Test
    public void testWithRoom() {
        acceptOfMucRoomsPaginated(
                ofMucRoomMapper,
                null,
                ofMucRooms -> {
                    ofMucRooms.forEach(ofMucRoom -> {
                        test(ofMucRoom.getRoomId());
                    });
                });
    }

    @Test
    public void testWithoutRoom() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucRoomMapper ofMucRoomMapper;
}
