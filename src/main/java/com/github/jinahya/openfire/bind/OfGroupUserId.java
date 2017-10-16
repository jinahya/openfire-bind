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
import java.util.Objects;

/**
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
public class OfGroupUserId implements Serializable {

    // -------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(groupName);
        hash = 67 * hash + Objects.hashCode(username);
        hash = 67 * hash + (administrator ? 1 : 0);
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
        final OfGroupUserId other = (OfGroupUserId) obj;
        if (administrator != other.administrator) {
            return false;
        }
        if (!Objects.equals(groupName, other.groupName)) {
            return false;
        }
        if (!Objects.equals(username, other.username)) {
            return false;
        }
        return true;
    }

    // -------------------------------------------------------------------------
    private String groupName;

    private String username;

    private boolean administrator;
}
