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
import javax.persistence.AttributeConverter;

abstract class __AttributeConverter<T extends __Converter<X, Y>, X, Y>
        implements AttributeConverter<X, Y> {

    // -------------------------------------------------------------------------
    public __AttributeConverter(final Class<T> converterType) {
        super();
        this.converterType
                = requireNonNull(converterType, "converterType is null");
    }

    // -------------------------------------------------------------------------
    @Override
    public Y convertToDatabaseColumn(final X attribute) {
        return converter().toColumn(attribute);
    }

    @Override
    public X convertToEntityAttribute(final Y dbData) {
        return converter().toAttribute(dbData);
    }

    // --------------------------------------------------------------- converter
    private T converter() {
        if (converter == null) {
            try {
                converter
                        = converterType.getDeclaredConstructor().newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException(roe);
            }
        }
        return converter;
    }

    // -------------------------------------------------------------------------
    /**
     * The type of converter.
     */
    protected final Class<T> converterType;

    private T converter;
}
