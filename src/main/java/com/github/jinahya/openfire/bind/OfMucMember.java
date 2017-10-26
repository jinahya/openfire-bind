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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@XmlRootElement
@IdClass(OfMucMemberId.class)
@Entity
public class OfMucMember implements Serializable {

    public static final String TABLE_NAME = "ofMucMember";

    public static final String COLUMN_NAME_JID = "jid";

    // -------------------------------------------------------------- idInstance
    @XmlTransient
    public OfMucMemberId getIdInstance() {
        return new OfMucMemberId().ofMucRoom(getOfMucRoomRoomId()).jid(jid);
    }

    // --------------------------------------------------------------- ofMucRoom
    public OfMucRoom getOfMucRoom() {
        return ofMucRoom;
    }

    public void setOfMucRoom(final OfMucRoom ofMucRoom) {
        this.ofMucRoom = ofMucRoom;
    }

    public OfMucMember ofMucRoom(final OfMucRoom ofMucRoom) {
        setOfMucRoom(ofMucRoom);
        return this;
    }

    @XmlAttribute
    public Long getOfMucRoomRoomId() {
        return ofNullable(ofMucRoom).map(OfMucRoom::getRoomId).orElse(null);
    }

    // --------------------------------------------------------------------- jid
    public String getJid() {
        return jid;
    }

    public void setJid(final String jid) {
        this.jid = jid;
    }

    // ---------------------------------------------------------------- nickname
    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    // --------------------------------------------------------------- firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    // ---------------------------------------------------------------- lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    // --------------------------------------------------------------------- url
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    // ------------------------------------------------------------------- email
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    // ---------------------------------------------------------------- faqentry
    public String getFaqentry() {
        return faqentry;
    }

    public void setFaqentry(final String faqentry) {
        this.faqentry = faqentry;
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfMucRoom.COLUMN_NAME_ROOM_ID,
            referencedColumnName = OfMucRoom.COLUMN_NAME_ROOM_ID)
    @ManyToOne(optional = false)
    @Id
    private OfMucRoom ofMucRoom;

    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_JID, nullable = false)
    @Id
    private String jid;

    @XmlElement(nillable = true)
    @Column(name = "nickName")
    private String nickname;

    @XmlElement(nillable = true)
    @Column(name = "firstName")
    private String firstName;

    @XmlElement(nillable = true)
    @Column(name = "lastName")
    private String lastName;

    @XmlElement(nillable = true)
    @Column(name = "url")
    private String url;

    @XmlElement(nillable = true)
    @Column(name = "email")
    private String email;

    @XmlElement(nillable = true)
    @Column(name = "faqentry")
    private String faqentry;
}
