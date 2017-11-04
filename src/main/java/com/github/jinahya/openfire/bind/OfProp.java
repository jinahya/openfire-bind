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

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An abstract class for {@code Prop} classes.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> subclass type parameter
 */
@XmlTransient
@MappedSuperclass
abstract class OfProp<T extends OfProp<T>> extends OfMapped {

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_NAME = "name";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_PROP_VALUE = "propValue";

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

    // --------------------------------------------------------------- propValue
    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(final String propValue) {
        this.propValue = propValue;
    }

    @SuppressWarnings("unchecked")
    public T propValue(final String propValue) {
        setPropValue(propValue);
        return (T) this;
    }

    // -------------------------------------------------------------------------
    @XmlElement(required = true)
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_PROP_VALUE, nullable = false)
    private String propValue;
}
