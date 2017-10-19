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
import static java.util.Optional.ofNullable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An entity for {@value OfGroupUser#TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfGroupUserId.class)
public class OfGroupUser implements Serializable {

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofGroupUser";

    public static final String COLUMN_NAME_ADMINISTRATOR = "administrator";

    // -------------------------------------------------------------- idInstance
    public OfGroupUserId getIdInstance() {
        return new OfGroupUserId()
                .groupName(getOfGroupGroupName())
                .username(getOfUserUsername())
                .administrator(isAdministrator());
    }

//    // --------------------------------------------------------------- groupName
//    @Deprecated
//    public String getGroupName() {
//        return groupName;
//    }
//
//    @Deprecated
//    public void setGroupName(final String groupName) {
//        this.groupName = groupName;
//    }
    // ----------------------------------------------------------------- ofGroup
    public OfGroup getOfGroup() {
        return ofGroup;
    }

    public void setOfGroup(final OfGroup ofGroup) {
        this.ofGroup = ofGroup;
    }

    public OfGroupUser ofGroup(final OfGroup ofGroup) {
        setOfGroup(ofGroup);
        return this;
    }

    @XmlAttribute
    public String getOfGroupGroupName() {
        return ofNullable(ofGroup).map(OfGroup::getGroupName).orElse(null);
    }

//    // ---------------------------------------------------------------- username
//    @Deprecated
//    public String getUsername() {
//        return username;
//    }
//
//    @Deprecated
//    public void setUsername(final String username) {
//        this.username = username;
//    }
    // ------------------------------------------------------------------ ofUser
    public OfUser getOfUser() {
        return ofUser;
    }

    public void setOfUser(final OfUser ofUser) {
        this.ofUser = ofUser;
    }

    public OfGroupUser ofUser(final OfUser ofUser) {
        setOfUser(ofUser);
        return this;
    }

    @XmlAttribute
    public String getOfUserUsername() {
        return ofNullable(ofUser).map(OfUser::getUsername).orElse(null);
    }

    // ----------------------------------------------------------- administrator
    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(final boolean administrator) {
        this.administrator = administrator;
    }

    public OfGroupUser administrator(final boolean administrator) {
        setAdministrator(administrator);
        return this;
    }

    // -------------------------------------------------------------------------
//    @Id
//    @Column(name = OfGroup.COLUMN_NAME_GROUP_NAME, nullable = false)
//    @NotNull
//    @XmlTransient
//    private String groupName;
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfGroup.COLUMN_NAME_GROUP_NAME,
            referencedColumnName = OfGroup.COLUMN_NAME_GROUP_NAME)
    @NotNull
    @XmlTransient
    private OfGroup ofGroup;

//    @Id
//    @Column(name = OfUser.COLUMN_NAME_USERNAME, nullable = false)
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

    @Id
    @Column(name = COLUMN_NAME_ADMINISTRATOR, nullable = false)
    @XmlElement(required = true)
    private boolean administrator;
}
