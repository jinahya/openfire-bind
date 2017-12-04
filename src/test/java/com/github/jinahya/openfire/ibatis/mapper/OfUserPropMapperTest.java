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

import com.github.jinahya.openfire.persistence.OfUserProp;
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
 * A class for testing {@link OfUserPropMapper}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfUserPropMapperTest
        extends OfPropMapperTest<OfUserProp, OfUserPropMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfUserPropsPaginated(
            final OfUserPropMapper mapper,
            final String username,
            final Consumer<List<OfUserProp>> consumer) {
        final int limit = 3;
        for (int offset = 0; offset <= 8; offset += limit) {
            final List<OfUserProp> ofUserProps = mapper.selectList01(
                    CATALOG, SCHEMA, username, current().nextBoolean(),
                    new RowBounds(offset, limit));
            logger.debug("ofUserProps: {}", ofUserProps);
            assertNotNull(ofUserProps);
            if (ofUserProps.isEmpty()) {
                break;
            }
            ofUserProps.forEach(ofUserProp -> {
                logger.debug("ofUserProp: {}", ofUserProp);
            });
            consumer.accept(ofUserProps);
        }
    }

    // -------------------------------------------------------------------------
    public OfUserPropMapperTest() {
        super(OfUserProp.class, OfUserPropMapper.class);
    }

    // -------------------------------------------------------------------------    
    private void test(final String username) {
        acceptOfUserPropsPaginated(
                mappedMapper,
                username,
                ofUserProps -> {
                    validate(ofUserProps);
                    ofUserProps.forEach(ofUserProp -> {
                        assertNotNull(ofUserProp.getUserUsername());
                        if (username != null) {
                            assertEquals(ofUserProp.getUserUsername(),
                                         username);
                        }
                        final OfUserProp one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA,
                                ofUserProp.getUserUsername(),
                                ofUserProp.getName());
                        assertNotNull(one);
                    });
                });
    }

    @Test
    public void testWithUser() {
        OfUserMapperTest.acceptOfUsersPaginated(
                ofUserMapper,
                ofUsers -> {
                    ofUsers.forEach(ofUser -> {
                        test(ofUser.getUsername());
                    });
                });
    }

    @Test
    public void testWithoutUser() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfUserMapper ofUserMapper;
}
