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

import java.io.Serializable;
import java.util.Objects;

/**
 * An abstract class for {@code IdClass} of {@code Prop} classes.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> owner id type parameter
 * @param <U> subclass type parameter
 */
abstract class OfOwnedPropId<T, U extends OfOwnedPropId<T, U>>
        implements Serializable {

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(ownerId);
        hash = 71 * hash + Objects.hashCode(name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OfOwnedPropId<?, ?> other = (OfOwnedPropId<?, ?>) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ownerId, other.ownerId)) {
            return false;
        }
        return true;
    }

    // ----------------------------------------------------------------- ownerId
    T getOwnerId() {
        return ownerId;
    }

    void setOwnerId(final T ownerId) {
        this.ownerId = ownerId;
    }

    @SuppressWarnings("unchecked")
    U ownerId(final T ownerId) {
        setOwnerId(ownerId);
        return (U) this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    public U name(final String name) {
        setName(name);
        return (U) this;
    }

    // -------------------------------------------------------------------------
    private T ownerId;

    private String name;
}
