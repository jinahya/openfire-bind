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

import static java.util.Objects.requireNonNull;
import org.apache.ibatis.type.BaseTypeHandler;

abstract class __TypeHandler<T extends __Converter<X, ?>, X>
        extends BaseTypeHandler<X> {

    // -------------------------------------------------------------------------
    public __TypeHandler(final Class<T> converterClass) {
        super();
        this.converterClass
                = requireNonNull(converterClass, "converterClass is null");
    }

    // --------------------------------------------------------------- converter
    protected T converter() {
        if (converter == null) {
            try {
                converter
                        = converterClass.getDeclaredConstructor().newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException(roe);
            }
        }
        return converter;
    }

    // -------------------------------------------------------------------------
    protected final Class<T> converterClass;

    private T converter;
}
