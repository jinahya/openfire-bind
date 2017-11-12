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
 * The entity class for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfUserPropId.class)
public class OfUserProp extends OfProp<OfUserProp> {

    // -------------------------------------------------------------------------
    /**
     * The name of the table to which this entity class is bound. The value is
     * {@value #TABLE_NAME}.
     */
    public static final String TABLE_NAME = "ofUserProp";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_USERNAME
            = OfUser.COLUMN_NAME_USERNAME;

    // -------------------------------------------------------------- idInstance
    /**
     * Return the id instance of this entity instance.
     *
     * @return the id instance
     */
    public OfUserPropId getIdInstance() {
        return new OfUserPropId().user(getUserUsername()).name(getName());
    }

    // -------------------------------------------------------------------- user
    public OfUser getUser() {
        return user;
    }

    public void setUser(final OfUser user) {
        this.user = user;
    }

    public OfUserProp user(final OfUser user) {
        setUser(user);
        return this;
    }

    @XmlAttribute
    public String getUserUsername() {
        return ofNullable(getUser()).map(OfUser::getUsername).orElse(null);
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
}
