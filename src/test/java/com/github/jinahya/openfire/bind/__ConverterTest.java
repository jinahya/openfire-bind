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
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import static org.testng.AssertJUnit.assertNull;
import org.testng.annotations.Test;

abstract class __ConverterTest<T extends __Converter<X, Y>, X, Y> {

    // -------------------------------------------------------------------------
    public __ConverterTest(final Class<T> converterClass) {
        super();
        this.converterClass
                = requireNonNull(converterClass, "converterClass is null");
    }

    protected <R> R applyConveter(final Function<T, R> function) {
        return function.apply(conveter());
    }

    protected <U, R> R applyConveter(final BiFunction<T, U, R> function,
                                     final U u) {
        return applyConveter(v -> function.apply(v, u));
    }

    protected void acceptConveter(final Consumer<T> consumer) {
        applyConveter(v -> {
            consumer.accept(v);
            return null;
        });
    }

    protected <U> void acceptConveter(final BiConsumer<T, U> consumer,
                                      final U u) {
        acceptConveter(v -> consumer.accept(v, u));
    }

    // -------------------------------------------------------------------------
    @Test
    public void assertNullForNull() {
        assertNull(applyConveter(v -> v.toAttribute(null)));
        assertNull(applyConveter(v -> v.toColumn(null)));
    }

    // ---------------------------------------------------------------- conveter
    protected T conveter() {
        if (conveter == null) {
            try {
                conveter = converterClass.newInstance();
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException(roe);
            }
        }
        return conveter;
    }

    // -------------------------------------------------------------------------
    protected final Class<T> converterClass;

    private T conveter;
}
