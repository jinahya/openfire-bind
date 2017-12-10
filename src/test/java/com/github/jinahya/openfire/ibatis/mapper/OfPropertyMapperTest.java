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

import com.github.jinahya.openfire.persistence.OfProperty;
import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.CATALOG;
import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.SCHEMA;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import static java.util.concurrent.ThreadLocalRandom.current;
import java.util.function.Consumer;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfPropertyMapperTest
        extends OfPropMapperTest<OfProperty, OfPropertyMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfProperties(
            final OfPropertyMapper mapper,
            final Consumer<List<OfProperty>> consumer) {
        final int limit = 8;
        for (int offset = 0; offset <= 1024; offset += limit) {
            final List<OfProperty> ofProperties = mapper.selectList01(
                    CATALOG, SCHEMA, current().nextBoolean(),
                    new RowBounds(offset, limit));
            if (ofProperties.isEmpty()) {
                break;
            }
            ofProperties.forEach(ofProperty -> {
                logger.debug("ofProperty: {}", ofProperty);
            });
            consumer.accept(ofProperties);
        }
    }
    // -------------------------------------------------------------------------

    public OfPropertyMapperTest() {
        super(OfProperty.class, OfPropertyMapper.class);
    }

    // -------------------------------------------------------------------------    
    @Test
    public void test() {
        acceptOfProperties(
                mappedMapper,
                ofProperties -> {
                    validate(ofProperties);
                    ofProperties.forEach(ofProperty -> {
                        final OfProperty one = mappedMapper.selectOne01(
                                CATALOG, SCHEMA, ofProperty.getName());
                        assertNotNull(one);
                    });
                });
    }
}
