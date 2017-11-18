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
package com.github.jinahya.openfire.persistence;

import static com.github.jinahya.openfire.persistence.Utilities.copyOf;
import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The entity class for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@XmlRootElement
@Entity
public class OfConversation implements Serializable {

    private static final long serialVersionUID = -8556282042062757153L;

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofConversation";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_CONVERSATION_ID = "conversationID";

    public static final String ATTRIBUTE_NAME_CONVERSATION_ID
            = "conversationId";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_ROOM = "room";

    public static final String ATTRIBUTE_NAME_ROOM = "room";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_IS_EXTERNAL = "isExternal";

    public static final String ATTRIBUTE_NAME_EXTERNAL = "external";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_START_DATE = "startDate";

    public static final String ATTRIBUTE_NAME_START_DATE = "startDate";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_LAST_ACTIVITY = "lastActivity";

    public static final String ATTRIBUTE_NAME_LAST_ACTIVITY = "lastActivity";

    // -------------------------------------------------------------------------
    /**
     * The name of the column to which {@value #ATTRIBUTE_NAME_MESSAGE_COUNT}
     * attribute is bound.
     */
    public static final String COLUMN_NAME_MESSAGE_COUNT = "messageCount";

    /**
     * The name of the attribute from which {@value #COLUMN_NAME_MESSAGE_COUNT}
     * column is bound.
     */
    public static final String ATTRIBUTE_NAME_MESSAGE_COUNT = "messageCount";

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public OfConversation() {
        super();
    }

    // ---------------------------------------------------------- conversationId
    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(final Long conversationId) {
        this.conversationId = conversationId;
    }

    public OfConversation conversationId(final Long conversationId) {
        setConversationId(conversationId);
        return this;
    }

    // -------------------------------------------------------------------- room
//    public String getRoom() {
//        return room;
//    }
//
//    public void setRoom(final String room) {
//        this.room = room;
//    }
    public OfMucRoom getRoom() {
        return room;
    }

    public void setRoom(final OfMucRoom room) {
        this.room = room;
    }

    public OfConversation room(final OfMucRoom room) {
        setRoom(room);
        return this;
    }

    // ---------------------------------------------------------------- external
    public boolean isExternal() {
        return external;
    }

    public void setExternal(final boolean external) {
        this.external = external;
    }

    // --------------------------------------------------------------- startDate
    public Date getStartDate() {
        return copyOf(startDate);
    }

    public void setStartDate(final Date startDate) {
        this.startDate = copyOf(startDate);
    }

    // ------------------------------------------------------------ lastActivity
    public Date getLastActivity() {
        return copyOf(lastActivity);
    }

    public void setLastActivity(final Date lastActivity) {
        this.lastActivity = copyOf(lastActivity);
    }

    // ------------------------------------------------------------ messageCount
    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(final int messageCount) {
        this.messageCount = messageCount;
    }

    // -------------------------------------------------------------------------
    @JsonbProperty()
    @XmlElement()
    @Id
    @Column(name = COLUMN_NAME_CONVERSATION_ID, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_CONVERSATION_ID)
    private Long conversationId;

//    @JsonbProperty(nillable = true)
//    @XmlElement(nillable = true)
//    @Basic
//    @Column(name = COLUMN_NAME_ROOM)
//    @NamedAttribute(ATTRIBUTE_NAME_ROOM)
//    private String room;
    @JsonbTransient
    @XmlTransient
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
                name = COLUMN_NAME_ROOM,
                referencedColumnName = OfMucRoom.COLUMN_NAME_NAME)
    @NamedAttribute(ATTRIBUTE_NAME_ROOM)
    private OfMucRoom room;

    @JsonbProperty
    @XmlElement(required = true)
    @Column(name = COLUMN_NAME_IS_EXTERNAL, nullable = false)
    @Basic(optional = false)
    @NamedAttribute(ATTRIBUTE_NAME_EXTERNAL)
    private boolean external;

    @JsonbProperty()
    @XmlElement()
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = DateMillisAttributeConverter.class)
    @Column(name = COLUMN_NAME_START_DATE, nullable = false)
    private Date startDate;

    @JsonbProperty()
    @XmlElement()
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = DateMillisAttributeConverter.class)
    @Column(name = COLUMN_NAME_LAST_ACTIVITY, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_LAST_ACTIVITY)
    private Date lastActivity;

    @JsonbProperty()
    @XmlElement()
    @Basic(optional = false)
    @Column(name = COLUMN_NAME_MESSAGE_COUNT, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_MESSAGE_COUNT)
    private int messageCount;
}
