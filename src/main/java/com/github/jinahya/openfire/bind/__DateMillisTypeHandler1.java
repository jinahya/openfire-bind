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
package com.github.jinahya.openfire.bind;

import java.util.Date;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

/**
 * An attribute converter for converting entity attributes of {@link Date} type
 * to/from database columns of {@code Long}(milliseconds) type.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@MappedJdbcTypes(JdbcType.BIGINT)
public class __DateMillisTypeHandler1
        extends __TypeHandler1<__DateMillisConverter, Date, Long> {

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public __DateMillisTypeHandler1() {
        super(__DateMillisConverter.class);
    }
}
