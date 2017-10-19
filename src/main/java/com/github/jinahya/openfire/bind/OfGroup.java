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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfGroup implements Serializable {

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofGroup";

    public static final String COLUMN_NAME_GROUP_NAME = "groupName";

    public static final String COLUMN_NAME_DESCRIPTION = "description";

    // -------------------------------------------------------------------------
    // --------------------------------------------------------------- groupName
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    public OfGroup groupName(final String groupName) {
        setGroupName(groupName);
        return this;
    }

    // ------------------------------------------------------------- description
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public OfGroup description(final String description) {
        setDescription(description);
        return this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = COLUMN_NAME_GROUP_NAME, nullable = false)
    @NotNull
    @XmlElement(required = true)
    private String groupName;

    @Id
    @Column(name = COLUMN_NAME_DESCRIPTION)
    @XmlElement(nillable = true)
    private String description;
}
