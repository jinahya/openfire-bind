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
import javax.persistence.MappedSuperclass;

/**
 * An abstract class for prop classes.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> subclass type parameter
 */
@MappedSuperclass
abstract class OfPropId<T extends OfPropId<T>> implements Serializable {

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 83 * hash + Objects.hashCode(name);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final OfPropId<?> other = (OfPropId<?>) obj;
//        if (!Objects.equals(name, other.name)) {
//            return false;
//        }
//        return true;
//    }
    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    public T name(final String name) {
        setName(name);
        return (T) this;
    }

    // -------------------------------------------------------------------------
    private String name;
}