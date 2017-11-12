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

import static java.lang.invoke.MethodHandles.lookup;
import java.lang.reflect.Field;
import static java.util.Objects.requireNonNull;
import org.apache.ibatis.javassist.Modifier;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;

/**
 * An abstract test class for subclasses of {@link OfMapped} class.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> subclass type parameter
 */
abstract class OfMappedTest<T extends OfMapped> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    private static void checkNamedAttribute(final Class<?> currentClass) {
        for (final Field field : currentClass.getDeclaredFields()) {
            final NamedAttribute annotation
                    = field.getAnnotation(NamedAttribute.class);
            if (annotation == null) {
                final int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    logger.warn("{} is not annotated with {}", field,
                                NamedAttribute.class);
                }
                continue;
            }
            if (!field.getName().endsWith(annotation.value())) {
                logger.warn("{} is not named correctly: {}", field, annotation);
            }
        }
        final Class<?> superClass = currentClass.getSuperclass();
        if (superClass != null) {
            checkNamedAttribute(superClass);
        }
    }

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     *
     * @param subclass subtype.
     */
    public OfMappedTest(final Class<T> subclass) {
        super();
        this.subclass = requireNonNull(subclass, "subtype is null");
    }

    // -------------------------------------------------------------------------
    /**
     * Checks all fields of {@link #subclass}, including those of super classes,
     * for {@link NamedAttribute}.
     */
    @Test
    public void checkNamedAttribute() {
        checkNamedAttribute(subclass);
    }

    // -------------------------------------------------------------------------
    /**
     * The subclass.
     */
    protected final Class<T> subclass;
}
