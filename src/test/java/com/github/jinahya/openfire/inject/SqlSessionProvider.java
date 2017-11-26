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
package com.github.jinahya.openfire.inject;

import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import javax.inject.Provider;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

public class SqlSessionProvider implements Provider<SqlSession> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    @Override
    public SqlSession get() {
        logger.debug("sqlSessionFactory: {}", sqlSessionFactory);
        return sqlSessionFactory.openSession();
    }

    // -------------------------------------------------------------------------
    @Inject
    private SqlSessionFactory sqlSessionFactory;
}
