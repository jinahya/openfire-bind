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

import static com.github.jinahya.openfire.bind.Utilities.copyOf;
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
 * An entity for {@value OfPresence#TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfOfflineId.class)
public class OfOffline implements Serializable {

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofOffline";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_USERNAME
            = OfUser.COLUMN_NAME_USERNAME;

    public static final String ATRRIBUTE_NAME_USER = "user";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_MESSAGE_ID = "messageID";

    public static final String ATTRIBUTE_NAME_MESSAGE_ID = "messageId";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_CREATION_DATE = "creationDate";

    public static final String ATTRIBUTE_NAME_CREATION_DATE = "creationDate";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_MESSAGE_SIZE = "messageSize";

    public static final String ATTRIBUTE_NAME_MESSAGE_SIZE = "messageSize";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_STANZA = "stanza";

    public static final String ATTRIBUTE_NAME_STANZA = "stanza";

    // -------------------------------------------------------------- idInstance
    public OfOfflineId getIdIsnstance() {
        return new OfOfflineId()
                .user(getUserUsername())
                .messageId(getMessageId());
    }

    // -------------------------------------------------------------------- user
    public OfUser getUser() {
        return user;
    }

    public void setUser(final OfUser user) {
        this.user = user;
    }

    public OfOffline user(final OfUser user) {
        setUser(user);
        return this;
    }

    @XmlAttribute
    public String getUserUsername() {
        return ofNullable(getUser()).map(OfUser::getUsername).orElse(null);
    }

    // --------------------------------------------------------------- messageId
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    // ------------------------------------------------------------ creationDate
    public Date getCreationDate() {
        return copyOf(creationDate);
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = copyOf(creationDate);
    }

    public OfOffline creationDate(final Date creationDate) {
        setCreationDate(creationDate);
        return this;
    }

    // ------------------------------------------------------------- messageSize
    public int getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(int messageSize) {
        this.messageSize = messageSize;
    }

    public OfOffline messageSize(final int messageSize) {
        setMessageSize(messageSize);
        return this;
    }

    // ------------------------------------------------------------------ stanza
    public String getStanza() {
        return stanza;
    }

    public void setStanza(final String stanza) {
        this.stanza = stanza;
    }

    public OfOffline stanza(final String stanza) {
        setStanza(stanza);
        return this;
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
    @Column(name = COLUMN_NAME_MESSAGE_ID, nullable = false)
    private Long messageId;

    @XmlElement(required = true)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = __Date015AttributeConverter.class)
    @Column(name = COLUMN_NAME_CREATION_DATE, nullable = false)
    private Date creationDate;

    @XmlElement(required = true)
    @Column(name = COLUMN_NAME_MESSAGE_SIZE, nullable = false)
    private int messageSize;

    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_STANZA, nullable = false)
    private String stanza;
}
