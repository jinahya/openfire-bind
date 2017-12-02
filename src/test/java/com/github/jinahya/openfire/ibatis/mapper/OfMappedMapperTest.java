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

import com.github.jinahya.openfire.inject.OfMappedMapperModule;
import com.github.jinahya.openfire.inject.SqlSessionFactoryModule;
import com.github.jinahya.openfire.inject.SqlSessionModule;
import com.github.jinahya.openfire.inject.ValidatorFactoryModule;
import com.github.jinahya.openfire.inject.ValidatorModule;
import com.github.jinahya.openfire.persistence.OfMapped;
import com.github.jinahya.openfire.persistence.OfMappedTest;
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import static java.util.Objects.requireNonNull;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

@Guice(modules = {ValidatorFactoryModule.class, ValidatorModule.class,
                  SqlSessionFactoryModule.class, SqlSessionModule.class,
                  OfMappedMapperModule.class})
public abstract class OfMappedMapperTest<T extends OfMapped, U extends OfMappedMapper<T>>
        extends OfMappedTest<T> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    protected static final String CATALOG = System.getProperty("jdbc.catalog");

    protected static final String SCHEMA = System.getProperty("jdbc.schema");

    public static final String RESOURCE_NAME = "/META-INF/mybatis-config.xml";

    // -------------------------------------------------------------------------
    public OfMappedMapperTest(final Class<T> mappedClass,
                              final Class<U> mapperClass) {
        super(mappedClass);
        this.mapperClass = requireNonNull(mapperClass);
    }

    @BeforeClass
    void beforeClass() {
        logger.debug("sqlSession: {} / {}", sqlSession,
                     getClass().getSimpleName());
        mappedMapper = sqlSession.getMapper(mapperClass);
        logger.debug("mappedMapper: {} / {}", mappedMapper,
                     getClass().getSimpleName());
    }

    @AfterClass
    void afterClass() {
        mappedMapper = null;
        logger.debug("mappedMapper nullified / {}", getClass().getSimpleName());
        sqlSession.close();
        logger.debug("sqlSession closed / {}", getClass().getSimpleName());
        sqlSession = null;
        logger.debug("sqlSession nullified / {}", getClass().getSimpleName());
    }

    // -------------------------------------------------------------------------
    protected final Class<U> mapperClass;

    @Inject
    protected SqlSession sqlSession;

    protected U mappedMapper;
}
