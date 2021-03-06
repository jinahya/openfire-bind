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

import java.util.Objects;

/**
 * The id class for {@link OfGroupProp}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfGroupPropId extends OfPropId<OfGroupPropId> {

    private static final long serialVersionUID = -2588878878648387490L;

    // -------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "{"
               + "group=" + group
               + "}";
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + Objects.hashCode(group);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final OfGroupPropId other = (OfGroupPropId) obj;
        if (!Objects.equals(group, other.group)) {
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------------- group
    public String getGroup() {
        return group;
    }

    void setGroup(final String group) {
        this.group = group;
    }

    OfGroupPropId group(final String group) {
        setGroup(group);
        return this;
    }

    // -------------------------------------------------------------------------
    private String group;
}
