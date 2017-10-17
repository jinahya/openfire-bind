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
import java.util.Date;
import static java.util.Optional.ofNullable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
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
public class OfPresence implements Serializable {

    // --------------------------------------------------------------- groupName
    @Deprecated
    public String getUsername() {
        return username;
    }

    @Deprecated
    public void setUsername(final String username) {
        this.username = username;
    }

    @Deprecated
    public OfPresence username(final String username) {
        setUsername(username);
        return this;
    }

    // ------------------------------------------------------------------ ofUser
    public OfUser getOfUser() {
        return ofUser;
    }

    public void setOfUser(final OfUser ofUser) {
        this.ofUser = ofUser;
        this.username = ofNullable(this.ofUser).map(OfUser::getUsername)
                .orElse(null);
    }

    public OfPresence ofUser(final OfUser ofUser) {
        setOfUser(ofUser);
        return this;
    }

    @XmlAttribute
    public String ofUserUsername() {
        return ofNullable(ofUser).map(OfUser::getUsername).orElse(null);
    }

    // --------------------------------------------------------- offlinePresence
    public String getOfflinePresence() {
        return offlinePresence;
    }

    public void setOfflinePresence(final String offlinePresence) {
        this.offlinePresence = offlinePresence;
    }

    public OfPresence name(final String offlinePresence) {
        setOfflinePresence(offlinePresence);
        return this;
    }

    // ------------------------------------------------------------- offlineDate
    public Date getOfflineDate() {
        if (offlineDate == null) {
            return offlineDate;
        }
        return new Date(offlineDate.getTime());
    }

    public void setOfflineDate(final Date offlineDate) {
        if (offlineDate == null) {
            this.offlineDate = null;
            return;
        }
        this.offlineDate = offlineDate;
    }

    public OfPresence offlineDate(final Date offlineDate) {
        setOfflineDate(offlineDate);
        return this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    @XmlTransient
    private String username;

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfUser.COLUMN_NAME_USERNAME,
            referencedColumnName = OfUser.COLUMN_NAME_USERNAME)
    @NotNull
    @XmlTransient
    private OfUser ofUser;

    @Column(name = "offlinePresence")
    @XmlElement(nillable = true)
    private String offlinePresence;

    @Column(name = "offlineDate", nullable = false)
    @Convert(converter = OfDate015Converter.class)
    @NotNull
    @XmlElement(required = true)
    private Date offlineDate;
}
