/*
 * Copyright 2017 Jin Kwon &lt;onacit at wemakeprice.com&gt;.
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

/**
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
public class OfGroupPropId implements Serializable {

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (groupName != null ? groupName.hashCode() : 0);
        hash = 17 * hash + (name != null ? name.hashCode() : 0);
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
        final OfGroupPropId other = (OfGroupPropId) obj;
        if ((groupName == null)
            ? (other.groupName != null) : !groupName.equals(other.groupName)) {
            return false;
        }
        if ((name == null) ? (other.name != null) : !name.equals(other.name)) {
            return false;
        }
        return true;
    }

    // --------------------------------------------------------------- groupName
    public OfGroupPropId groupName(final String groupName) {
        this.groupName = groupName;
        return this;
    }

    // -------------------------------------------------------------------- name
    public OfGroupPropId name(final String name) {
        this.name = name;
        return this;
    }

    // -------------------------------------------------------------------------
    private String groupName;

    private String name;
}
