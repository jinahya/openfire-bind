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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Entity class for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfVersion implements Serializable {

    private static final long serialVersionUID = -8672734544040136059L;

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofVersion";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_NAME = "name";

    public static final String ATTRIBUTE_NAME_NAME = "name";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_VERSION = "version";

    public static final String ATTRIBUTE_NAME_VERSION = "version";

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfVersion name(final String name) {
        setName(name);
        return this;
    }

    // ----------------------------------------------------------------- version
    public int getVersion() {
        return version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public OfVersion version(final int version) {
        setVersion(version);
        return this;
    }

    // -------------------------------------------------------------------------
    @XmlAttribute(required = true)
    @NotNull
    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @XmlElement(required = true)
    @Column(name = "version", nullable = false)
    private int version;
}
