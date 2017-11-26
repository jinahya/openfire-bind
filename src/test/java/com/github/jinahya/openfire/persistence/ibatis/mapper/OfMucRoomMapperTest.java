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

import com.github.jinahya.openfire.persistence.OfMucRoom;
import com.github.jinahya.openfire.persistence.OfMucService;
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import javax.validation.Validator;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class OfMucRoomMapperTest
        extends OfMappedMapperTest<OfMucRoom, OfMucRoomMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public OfMucRoomMapperTest() {
        super(OfMucRoom.class, OfMucRoomMapper.class);
    }

    //@Test
    public void selectList01WithServiceId() {
        final List<OfMucService> services = ofMucServiceMapper.selectList01(
                CATALOG, SCHEMA, true, true, RowBounds.DEFAULT);
        logger.debug("servcies: {}", services);
        services.forEach(service -> {
            logger.debug("service: {}", service);
            final Long serviceId = service.getServiceId();
            assertNotNull(serviceId);
            final List<OfMucRoom> rooms = mappedMapper.selectList01(
                    CATALOG, SCHEMA, serviceId, true, true, null);
            rooms.forEach(room -> {
                validate(validator, room);
            });
        });
    }

    @Test
    public void selectList01WithoutServiceId() {
        final List<OfMucRoom> rooms = mappedMapper.selectList01(
                CATALOG, SCHEMA, null, true, true, RowBounds.DEFAULT);
        rooms.forEach(room -> {
            validate(validator, room);
            final OfMucService service = room.getService();
            assertNotNull(service);
            final Long serviceId = service.getServiceId();
            assertNotNull(serviceId);
            final OfMucRoom one = mappedMapper.selectOne01(
                    CATALOG, SCHEMA, serviceId, room.getName());
            assertNotNull(room);
        });
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucServiceMapper ofMucServiceMapper;

    @Inject
    private Validator validator;
}
