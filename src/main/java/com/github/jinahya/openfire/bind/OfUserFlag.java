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
import java.util.Date;
import static java.util.Optional.ofNullable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfUserFlagId.class)
public class OfUserFlag implements Serializable {

    public static final String COLUMN_NAME_NAME = "name";

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
    public OfUserFlag username(final String username) {
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

    public OfUserFlag ofUser(final OfUser ofUser) {
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

    public OfUserFlag name(final String name) {
        setName(name);
        return this;
    }

    // --------------------------------------------------------------- startTime
    public Date getStartTime() {
        if (startTime != null) {
            return new Date(startTime.getTime());
        }
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        if (startTime != null) {
            this.startTime = new Date(startTime.getTime());
            return;
        }
        this.startTime = startTime;
    }

    public OfUserFlag startTime(final Date startTime) {
        setStartTime(startTime);
        return this;
    }

    // ----------------------------------------------------------------- endTime
    public Date getEndTime() {
        return ofNullable(endTime).map(v -> new Date(v.getTime())).orElse(null);
    }

    public void setEndTime(final Date endTime) {
        this.endTime = ofNullable(endTime)
                .map(v -> new Date(v.getTime())).orElse(null);
    }

    public OfUserFlag endTime(final Date endTime) {
        setEndTime(endTime);
        return this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    //@XmlElement(required = true)
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
    //@XmlElement(required = true)
    @XmlAttribute(required = true)
    private String name;

    // -------------------------------------------------------------------------
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = OfDate015Converter.class)
    @XmlElement(nillable = true)
    private Date startTime;

    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = OfDate015Converter.class)
    @XmlElement(nillable = true)
    private Date endTime;
}
