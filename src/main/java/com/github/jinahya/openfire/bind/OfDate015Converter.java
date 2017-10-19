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

import static java.lang.Long.parseLong;
import static java.lang.String.format;
import java.util.Date;
import static java.util.Optional.ofNullable;
import javax.persistence.AttributeConverter;

/**
 * An attribute converter for converting {@link Date} to/from {@code %015d}
 * database value.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfDate015Converter implements AttributeConverter<Date, String> {

    @Override
    public String convertToDatabaseColumn(final Date attribute) {
        if (true) {
            return ofNullable(attribute)
                    .map(Date::getTime)
                    .map(v -> format("%015d", v))
                    .orElse(null);
        }
        if (attribute == null) {
            return null;
        }
        return format("%1$015d", attribute.getTime());
    }

    @Override
    public Date convertToEntityAttribute(final String dbData) {
        if (true) {
            return ofNullable(dbData)
                    .map(Long::parseLong)
                    .map(Date::new)
                    .orElse(null);
        }
        if (dbData == null) {
            return null;
        }
        return new Date(parseLong(dbData));
    }
}
