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

import static java.lang.invoke.MethodHandles.lookup;
import static java.util.Optional.ofNullable;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An entity class for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@XmlRootElement
@Entity
@IdClass(OfMucMemberId.class)
public class OfMucMember extends OfMapped {

    private static final long serialVersionUID = -526903256883348399L;

    // -------------------------------------------------------------------------
    private static final Logger logger
            = getLogger(lookup().lookupClass().getName());

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofMucMember";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_ROOM_ID
            = OfMucRoom.COLUMN_NAME_ROOM_ID;

    public static final String ATTRIBUTE_NAME_ROOM = "room";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_JID = "jid";

    public static final String ATTRIBUTE_NAME_JID = "jid";

    // -------------------------------------------------------------- idInstance
    @XmlTransient
    public OfMucMemberId getIdInstance() {
        return new OfMucMemberId().room(getRoomRoomId()).jid(getJid());
    }

    // -------------------------------------------------------------------- room
    public OfMucRoom getRoom() {
        return room;
    }

    public void setRoom(final OfMucRoom room) {
        this.room = room;
    }

    public OfMucMember room(final OfMucRoom room) {
        setRoom(room);
        return this;
    }

    @XmlAttribute
    public Long getRoomRoomId() {
        return ofNullable(getRoom()).map(OfMucRoom::getRoomId).orElse(null);
    }

    // --------------------------------------------------------------------- jid
    public String getJid() {
        return jid;
    }

    public void setJid(final String jid) {
        this.jid = jid;
    }

    public OfMucMember jid(final String jid) {
        setJid(jid);
        return this;
    }

    // ---------------------------------------------------------------- nickname
    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public OfMucMember nickname(final String nickname) {
        setNickname(nickname);
        return this;
    }

    // --------------------------------------------------------------- firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public OfMucMember firstName(final String firstName) {
        setFirstName(firstName);
        return this;
    }

    // ---------------------------------------------------------------- lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public OfMucMember lastName(final String lastName) {
        setLastName(lastName);
        return this;
    }

    // --------------------------------------------------------------------- url
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public OfMucMember url(final String url) {
        setUrl(url);
        return this;
    }

    // ------------------------------------------------------------------- email
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public OfMucMember email(final String email) {
        setEmail(email);
        return this;
    }

    // ---------------------------------------------------------------- faqentry
    public String getFaqentry() {
        return faqentry;
    }

    public void setFaqentry(final String faqentry) {
        this.faqentry = faqentry;
    }

    public OfMucMember faqentry(final String faqentry) {
        setFaqentry(faqentry);
        return this;
    }

    // -------------------------------------------------------------------------
    @JsonbTransient
    @XmlTransient
    @NotNull
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = COLUMN_NAME_ROOM_ID,
            referencedColumnName = OfMucRoom.COLUMN_NAME_ROOM_ID)
    @NamedAttribute(ATTRIBUTE_NAME_ROOM)
    private OfMucRoom room;

    @JsonbProperty()
    @XmlElement(required = true)
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_JID, nullable = false)
    @NamedAttribute(ATTRIBUTE_NAME_JID)
    private String jid;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "nickName")
    private String nickname;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "firstName")
    private String firstName;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "lastName")
    private String lastName;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "url")
    private String url;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "email")
    private String email;

    @JsonbProperty(nillable = true)
    @XmlElement(nillable = true)
    @Column(name = "faqentry")
    private String faqentry;
}
