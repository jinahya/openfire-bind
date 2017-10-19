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

import static java.util.Optional.ofNullable;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfGroupPropId.class)
public class OfUserProp extends OfOwnedProp<OfUser, OfUserProp> {

//    // --------------------------------------------------------------- groupName
//    @Deprecated
//    public String getUsername() {
//        return username;
//    }
//
//    @Deprecated
//    public void setUsername(final String username) {
//        this.username = username;
//    }
//
//    @Deprecated
//    public OfUserProp username(final String username) {
//        setUsername(username);
//        return this;
//    }

    // ------------------------------------------------------------------ ofUser
    @Override
    OfUser getOwner() {
        return ofUser;
    }

    @Override
    void setOwner(OfUser owner) {
        this.ofUser = owner;
    }

    public OfUser getOfUser() {
        return getOwner();
    }

    public void setOfUser(final OfUser ofUser) {
        setOwner(ofUser);
    }

    public OfUserProp ofUser(final OfUser ofUser) {
        return owner(ofUser);
    }

    @XmlAttribute
    public String ofUserUsername() {
        return ofNullable(ofUser).map(OfUser::getUsername).orElse(null);
    }

//    // -------------------------------------------------------------------- name
//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public OfUserProp name(final String name) {
//        setName(name);
//        return this;
//    }
//
//    // --------------------------------------------------------------- propValue
//    public String getPropValue() {
//        return propValue;
//    }
//
//    public void setPropValue(final String propValue) {
//        this.propValue = propValue;
//    }
//
//    public OfUserProp propValue(final String propValue) {
//        setPropValue(propValue);
//        return this;
//    }

    // -------------------------------------------------------------------------
//    @Id
//    @Column(name = OfUser.COLUMN_NAME_USERNAME)
//    @NotNull
//    @XmlTransient
//    private String username;
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfUser.COLUMN_NAME_USERNAME,
            referencedColumnName = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    @XmlTransient
    private OfUser ofUser;

//    @Id
//    @Column(name = "name", nullable = false)
//    @NotNull
//    @XmlElement(required = true)
//    private String name;
//
//    @Column(name = "propValue", nullable = false)
//    @NotNull
//    @XmlElement(required = true)
//    private String propValue;
}
