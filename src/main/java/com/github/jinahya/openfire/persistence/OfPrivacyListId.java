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
package com.github.jinahya.openfire.persistence;

import java.io.Serializable;
import java.util.Objects;

/**
 * An id class for {@link OfPrivacyList} class.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfPrivacyListId implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(user);
        hash = 11 * hash + Objects.hashCode(name);
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
        final OfPrivacyListId other = (OfPrivacyListId) obj;
        if (!Objects.equals(user, other.user)) {
            return false;
        }
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        return true;
    }

    // -------------------------------------------------------------------- user
    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public OfPrivacyListId user(final String user) {
        setUser(user);
        return this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfPrivacyListId name(final String name) {
        setName(name);
        return this;
    }

    // -------------------------------------------------------------------------
    private String user;

    private String name;
}
