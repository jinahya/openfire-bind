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

/**
 * An attribute converter for converting {@link Date} to/from {@code Long}
 * database value.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
class __DateMillisConverter2 extends __AbstractConverter<Date, Long> {

    // -------------------------------------------------------------------------
    public __DateMillisConverter2() {
        super(Date.class, Long.class);
    }

    // -------------------------------------------------------------------------
    @Override
    public Long toColumn(final Date attribute) {
        return converter().toColumn(attribute);
    }

    @Override
    public Date toAttribute(final Long column) {
        return converter().toAttribute(column);
    }

    // --------------------------------------------------------------- converter
    private __Converter<Date, Long> converter() {
        if (converter == null) {
            converter = new __DateMillisConverter();
        }
        return converter;
    }

    // -------------------------------------------------------------------------
    private __Converter<Date, Long> converter;
}
