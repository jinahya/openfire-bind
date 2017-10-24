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
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfMucRoomId implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(ofMucService);
        hash = 59 * hash + Objects.hashCode(name);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OfMucRoomId other = (OfMucRoomId) obj;
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        if (!Objects.equals(ofMucService, other.ofMucService)) {
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------ ofMucService
    public Long getOfMucService() {
        return ofMucService;
    }

    public void setOfMucService(final Long ofMucService) {
        this.ofMucService = ofMucService;
    }

    public OfMucRoomId ofMucService(final Long ofMucService) {
        setOfMucService(ofMucService);
        return this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfMucRoomId name(final String name) {
        setName(name);
        return this;
    }

    // -------------------------------------------------------------------------
    private Long ofMucService;

    private String name;
}
