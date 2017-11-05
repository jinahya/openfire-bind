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
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

public class __DateMillisConverterTest
        extends __ConverterTest<__DateMillisConverter, Date, Long> {

    // -------------------------------------------------------------------------
    public __DateMillisConverterTest() {
        super(__DateMillisConverter.class);
    }

    // -------------------------------------------------------------------------
    @Test
    public void testToColumn() {
        final Date attribute = new Date();
        final Long column = applyConveter(c -> c.toColumn(attribute));
        assertEquals(column.longValue(), attribute.getTime());
    }

    @Test
    public void testToAttribute() {
        final long column = System.currentTimeMillis();
        final Date attribute = applyConveter(v -> v.toAttribute(column));
        assertEquals(attribute.getTime(), column);
    }
}
