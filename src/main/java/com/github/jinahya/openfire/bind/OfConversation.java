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

import static com.github.jinahya.openfire.bind.OfUtilities.copyOf;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

/**
 * An entity for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfConversation implements Serializable {

    public static final String TABLE_NAME = "ofConversation";

    public static final String COLUMN_NAME_CONVERSATION_ID = "conversationID";

    public static final String COLUMN_NAME_ROOM = "room";

    public static final String COLUMN_NAME_IS_EXTERNAL = "isExternal";

    public static final String COLUMN_NAME_IS_START_DATE = "startDate";

    public static final String COLUMN_NAME_IS_LAST_ACTIVITY = "lastActivity";

    public static final String COLUMN_NAME_IS_MESSAGE_COUNT = "messageCount";

    // ---------------------------------------------------------- conversationId
    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(final Long conversationId) {
        this.conversationId = conversationId;
    }

    // -------------------------------------------------------------------- room
    public String getRoom() {
        return room;
    }

    public void setRoom(final String room) {
        this.room = room;
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
    @XmlElement(required = true)
    @Column(name = COLUMN_NAME_CONVERSATION_ID)
    @Id
    private Long conversationId;

    @XmlElement(nillable = true)
    @Column(name = COLUMN_NAME_ROOM, nullable = true)
    @Basic
    private String room;

    @XmlElement(required = true)
    @Column(name = COLUMN_NAME_IS_EXTERNAL, nullable = false)
    @Basic(optional = false)
    private boolean external;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = __DateMillisConverter.class)
    @Column(name = COLUMN_NAME_IS_START_DATE, nullable = false)
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = __DateMillisConverter.class)
    @Column(name = COLUMN_NAME_IS_LAST_ACTIVITY, nullable = false)
    private Date lastActivity;

    @Basic(optional = false)
    @Column(name = COLUMN_NAME_IS_MESSAGE_COUNT, nullable = false)
    private int messageCount;
}
