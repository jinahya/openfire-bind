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
 * A converter for converting {@link Date} to/from {@code %015d} database value.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
class __Date015Converter2 extends __AbstractConverter<Date, String> {

    // -------------------------------------------------------------------------
    public __Date015Converter2() {
        super(Date.class, String.class);
    }

    // -------------------------------------------------------------------------
    @Override
    public String toColumn(final Date attribute) {
        return converter().toColumn(attribute);
    }

    @Override
    public Date toAttribute(final String column) {
        return converter().toAttribute(column);
    }

    // --------------------------------------------------------------- converter
    private __Converter<Date, String> converter() {
        if (converter == null) {
            converter = new __Date015Converter();
        }
        return converter;
    }

    // -------------------------------------------------------------------------
    private __Converter<Date, String> converter;
}
