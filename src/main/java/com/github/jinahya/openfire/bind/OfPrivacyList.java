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
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfPrivacyListId.class)
public class OfPrivacyList implements Serializable {

    public static final String TABLE_NAME = "ofPrivacyList";

    public static final String COLUMN_NAME_USERNAME
            = OfUser.COLUMN_NAME_USERNAME;

    public static final String COLUMN_NAME_NAME = "name";

    public static final String COLUMN_NAME_IS_DEFAULT = "isDefault";

    public static final String COLUMN_NAME_LIST = "list";

    // -------------------------------------------------------------------- user
    public OfUser getUser() {
        return user;
    }

    public void setUser(final OfUser user) {
        this.user = user;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    // ----------------------------------------------------------------- default
    public boolean isDefault() {
        return default__;
    }

    public void setDefault(final boolean default__) {
        this.default__ = default__;
    }

    // -------------------------------------------------------------------- list
    public String getList() {
        return list;
    }

    public void setList(final String list) {
        this.list = list;
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = COLUMN_NAME_USERNAME,
            referencedColumnName = OfUser.COLUMN_NAME_USERNAME)
    private OfUser user;

    @XmlElement(required = true)
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @XmlElement(required = true)
    @Column(name = COLUMN_NAME_IS_DEFAULT, nullable = false)
    private boolean default__;

    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_LIST, nullable = false)
    private String list;
}
