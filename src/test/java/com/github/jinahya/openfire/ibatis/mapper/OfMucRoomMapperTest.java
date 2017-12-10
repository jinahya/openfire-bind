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
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import java.util.function.Consumer;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;
import static java.util.concurrent.ThreadLocalRandom.current;
import static com.github.jinahya.openfire.ibatis.mapper.OfMucServiceMapperTest.acceptOfMucServices;

public class OfMucRoomMapperTest
        extends OfMappedMapperTest<OfMucRoom, OfMucRoomMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfMucRooms(
            final OfMucRoomMapper mapper, final Long serviceId,
            final Consumer<List<OfMucRoom>> consumer) {
        final int limit = 3;
        for (int offset = 0; offset <= 8; offset += limit) {
            final List<OfMucRoom> ofMucRooms = mapper.selectList01(
                    CATALOG, SCHEMA, serviceId, current().nextBoolean(),
                    current().nextBoolean(), new RowBounds(offset, limit));
            if (ofMucRooms.isEmpty()) {
                break;
            }
            ofMucRooms.forEach(ofMucRoom -> {
                logger.debug("ofMucRoom: {}", ofMucRoom);
            });
            consumer.accept(ofMucRooms);
        }
    }

    // -------------------------------------------------------------------------
    public OfMucRoomMapperTest() {
        super(OfMucRoom.class, OfMucRoomMapper.class);
    }

    private void test(final long serviceId) {
        acceptOfMucRooms(
                mappedMapper,
                serviceId,
                list -> {
                    validate(list);
                    list.forEach(v -> {
                        final OfMucRoom one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA, serviceId, v.getName());
                        assertNotNull(v);
                        validate(list);
                    });
                });
    }

    @Test
    public void selectWithService() {
        acceptOfMucServices(
                ofMucServiceMapper,
                services -> {
                    services.forEach(service -> {
                        test(service.getServiceId());
                    });
                });
    }

    //@Test
    public void testWithoutService() {
        //test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucServiceMapper ofMucServiceMapper;
}
