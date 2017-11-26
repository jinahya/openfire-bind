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

import com.github.jinahya.openfire.persistence.OfMucService;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test class for {@link OfMucServiceMapper}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfMucServiceMapperTest
        extends OfMappedMapperTest<OfMucService, OfMucServiceMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public OfMucServiceMapperTest() {
        super(OfMucService.class, OfMucServiceMapper.class);
    }

    // -------------------------------------------------------------------------
    @Test
    public void test() {
        final List<OfMucService> services = mappedMapper.selectList01(
                CATALOG, SCHEMA, true, true, RowBounds.DEFAULT);
        services.forEach(service -> {
            validate(service);
        });
        services.forEach(v -> {
            final Long serviceId = v.getServiceId();
            assertNotNull(serviceId);
            {
                final OfMucService oneByServiceId = mappedMapper.selectOne01(
                        CATALOG, SCHEMA, serviceId, null);
                logger.debug("oneByServiceId: {}", oneByServiceId);
                assertNotNull(oneByServiceId);
            }
            final String subdomain = v.getSubdomain();
            assertNotNull(subdomain);
            {
                final OfMucService oneBySubdomain = mappedMapper.selectOne01(
                        CATALOG, SCHEMA, null, subdomain);
                logger.debug("oneBySubdomain: {}", oneBySubdomain);
                assertNotNull(oneBySubdomain);
            }
        });
    }
}
