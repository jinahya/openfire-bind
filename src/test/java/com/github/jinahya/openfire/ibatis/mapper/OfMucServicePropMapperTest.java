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

import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.CATALOG;
import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.SCHEMA;
import com.github.jinahya.openfire.persistence.OfMucServiceProp;
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
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfMucServicePropMapperTest
        extends OfPropMapperTest<OfMucServiceProp, OfMucServicePropMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfMucServicePropsPaginated(
            final OfMucServicePropMapper mapper,
            final Long serviceId,
            final Consumer<List<OfMucServiceProp>> consumer) {
        final int limit = 3;
        for (int offset = 0; offset <= 8; offset += limit) {
            final List<OfMucServiceProp> list = mapper.selectList01(
                    CATALOG, SCHEMA, serviceId, current().nextBoolean(),
                    current().nextBoolean(), new RowBounds(offset, limit));
            if (list.isEmpty()) {
                break;
            }
            list.forEach(v -> {
                logger.debug("ofMucServiceProp: {}", v);
            });
            consumer.accept(list);
        }
    }

    // -------------------------------------------------------------------------
    public OfMucServicePropMapperTest() {
        super(OfMucServiceProp.class, OfMucServicePropMapper.class);
    }

    // -------------------------------------------------------------------------    
    private void test(final Long serviceId) {
        acceptOfMucServicePropsPaginated(
                mappedMapper,
                serviceId,
                ofMucServiceProps -> {
                    validate(ofMucServiceProps);
                    ofMucServiceProps.forEach(ofMucServiceProp -> {
                        assertNotNull(ofMucServiceProp.getServiceServiceId());
                        if (serviceId != null) {
                            assertEquals(ofMucServiceProp.getServiceServiceId(),
                                         serviceId);
                        }
                        final OfMucServiceProp one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA,
                                ofMucServiceProp.getServiceServiceId(),
                                ofMucServiceProp.getName());
                        assertNotNull(one);
                    });
                });
    }

    @Test
    public void testWithService() {
        OfMucServiceMapperTest.acceptOfMucServicesPaginated(
                ofMucServiceMapper,
                ofMucServices -> {
                    ofMucServices.forEach(ofMucService -> {
                        test(ofMucService.getServiceId());
                    });
                });
    }

    @Test
    public void testWithoutService() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfMucServiceMapper ofMucServiceMapper;
}
