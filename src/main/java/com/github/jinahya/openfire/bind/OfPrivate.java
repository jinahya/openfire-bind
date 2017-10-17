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
import static java.util.Optional.ofNullable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
@Entity
public class OfPrivate implements Serializable {

    public static final String TABLE_NAME = "ofPrivate";

    public static final String COLUMN_NAME_NAME = "name";

    public static final String COLUMN_NAME_NAMESPACE = "namespace";

    public static final String COLUMN_NAME_PRIVATE_DATA = "privateData";

    // -------------------------------------------------------------------------
    // ---------------------------------------------------------------- username
    @Deprecated
    public String getUsername() {
        return username;
    }

    @Deprecated
    public void setUsername(final String username) {
        this.username = username;
    }

    @Deprecated
    public OfPrivate username(final String username) {
        setUsername(username);
        return this;
    }

    // ------------------------------------------------------------------ ofUser
    public OfUser getOfUser() {
        return ofUser;
    }

    public void setOfUser(final OfUser ofUser) {
        this.ofUser = ofUser;
        username = ofNullable(this.ofUser).map(OfUser::getUsername)
                .orElse(null);
    }

    public OfPrivate ofUser(final OfUser ofUser) {
        setOfUser(ofUser);
        return this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfPrivate name(final String name) {
        setName(name);
        return this;
    }

    // --------------------------------------------------------------- namespace
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(final String namespace) {
        this.namespace = namespace;
    }

    public OfPrivate namespace(final String namespace) {
        setNamespace(namespace);
        return this;
    }

    // ------------------------------------------------------------- privateData
    public String getPrivateData() {
        return privateData;
    }

    public void setPrivateData(final String privateData) {
        this.privateData = privateData;
    }

    public OfPrivate privateData(final String privateData) {
        setPrivateData(privateData);
        return this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    @XmlElement(required = true)
    @XmlAttribute(required = true)
    private String username;

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfUser.COLUMN_NAME_USERNAME,
            referencedColumnName = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    @XmlTransient
    private OfUser ofUser;

    @Id
    @Column(name = COLUMN_NAME_NAME)
    @NotNull
    @XmlElement(required = true)
    private String name;

    // -------------------------------------------------------------------------
    @Id
    @Column(name = "namespace")
    @XmlElement(required = true)
    private String namespace;

    @Column(name = "privateData")
    @XmlElement(required = true)
    private String privateData;
}
