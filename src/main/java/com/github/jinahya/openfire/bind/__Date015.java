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

import static java.lang.String.format;
import java.util.Date;
import static java.util.Optional.ofNullable;

/**
 * An attribute converter for converting {@link Date} to/from {@code %015d}
 * database value.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
class __Date015 implements __Converter<String, Date> {

    @Override
    public String toDatabaseColumn(final Date attributeValue) {
        return ofNullable(attributeValue)
                .map(Date::getTime)
                .map(v -> format("%015d", v))
                .orElse(null);
    }

    @Override
    public Date toEntityAttribute(final String columnValue) {
        return ofNullable(columnValue)
                .map(Long::parseLong)
                .map(Date::new)
                .orElse(null);
    }
}
