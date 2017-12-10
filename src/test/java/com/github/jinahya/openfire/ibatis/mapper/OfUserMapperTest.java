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

import com.github.jinahya.openfire.persistence.OfUser;
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
 * Test class for {@link OfUserMapper}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfUserMapperTest
        extends OfMappedMapperTest<OfUser, OfUserMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfUsers(
            final OfUserMapper mapper,
            final Consumer<List<OfUser>> consumer) {
        final int limit = 2;
        for (int offset = 0; offset <= 4; offset += limit) {
            final List<OfUser> ofUsers = mapper.selectList01(
                    CATALOG, SCHEMA, current().nextBoolean(),
                    new RowBounds(offset, limit));
            if (ofUsers.isEmpty()) {
                break;
            }
            ofUsers.forEach(ofUser -> {
                logger.debug("ofUser: {}", ofUser);
            });
            consumer.accept(ofUsers);
        }
    }

    // -------------------------------------------------------------------------
    public OfUserMapperTest() {
        super(OfUser.class, OfUserMapper.class);
    }

    // -------------------------------------------------------------------------
    @Test
    public void test() {
        acceptOfUsers(
                mappedMapper,
                ofUsers -> {
                    validate(ofUsers);
                    ofUsers.forEach(ofUser -> {
                        final OfUser one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA, ofUser.getUsername());
                        assertNotNull(one);
                        assertEquals(one.getUsername(), ofUser.getUsername());
                    });
                });
    }
}
