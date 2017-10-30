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
 * The id class for {@link OfGroupProp}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfGroupPropId extends OfPropId<OfGroupPropId> {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(group);
        hash = 97 * hash + Objects.hashCode(getName());
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
        final OfGroupPropId other = (OfGroupPropId) obj;
        if (!Objects.equals(group, other.group)) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------------- group
    public String getGroup() {
        return group;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public OfGroupPropId group(final String group) {
        setGroup(group);
        return this;
    }

    // -------------------------------------------------------------------------
    private String group;
}
