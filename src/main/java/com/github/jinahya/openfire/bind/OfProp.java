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
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An abstract class for {@code Prop} classes.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> owner type parameter
 * @param <U> subclass type parameter
 */
@MappedSuperclass
@XmlTransient
abstract class OfProp<T extends Serializable, U extends OfProp<T, U>>
        implements Serializable {

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_NAME = "name";

    public static final String COLUMN_NAME_PROP_VALUE = "propValue";

    // ------------------------------------------------------------------- owner
    abstract T getOwner();

    abstract void setOwner(T owner);

    @SuppressWarnings("unchecked")
    U owner(final T owner) {
        setOwner(owner);
        return (U) this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    public U name(final String name) {
        setName(name);
        return (U) this;
    }

    // --------------------------------------------------------------- propValue
    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(final String propValue) {
        this.propValue = propValue;
    }

    @SuppressWarnings("unchecked")
    public U propValue(final String propValue) {
        setPropValue(propValue);
        return (U) this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = COLUMN_NAME_NAME, nullable = false)
    @NotNull
    @XmlElement(required = true)
    private String name;

    @Column(name = COLUMN_NAME_PROP_VALUE, nullable = false)
    @NotNull
    @XmlElement(required = true)
    private String propValue;
}
