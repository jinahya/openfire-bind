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

import java.util.Objects;

/**
 * An id class for {@link OfUserProp} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfUserPropId extends OfPropId<OfUserPropId> {

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(user);
        hash = 97 * hash + Objects.hashCode(getName());
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
        final OfUserPropId other = (OfUserPropId) obj;
        if (!Objects.equals(user, other.user)) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
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

    public OfUserPropId user(final String user) {
        setUser(user);
        return this;
    }

    // -------------------------------------------------------------------------
    private String user;
}