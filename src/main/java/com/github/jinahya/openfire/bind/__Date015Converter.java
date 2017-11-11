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
 * A converter for converting entity attributes of {@link Date} type to/from
 * database columns of {@code %015d}-formatted {@code String}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
class __Date015Converter implements __Converter<Date, String> {

    static final String FORMAT = "%015d";

    @Override
    public String toColumn(final Date attribute) {
        return ofNullable(attribute)
                .map(Date::getTime)
                .map(v -> format(FORMAT, v))
                .orElse(null);
    }

    @Override
    public Date toAttribute(final String column) {
        return ofNullable(column)
                .map(Long::parseLong)
                .map(Date::new)
                .orElse(null);
    }
}