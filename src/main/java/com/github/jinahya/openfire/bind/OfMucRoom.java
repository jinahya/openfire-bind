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

import static com.github.jinahya.openfire.bind.OfUtils.copyOf;
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
@IdClass(OfMucRoomId.class)
public class OfMucRoom implements Serializable {

    public static final String TABLE_NAME = "ofMucRoom";

    public static final String COLUMN_NAME_ROOM_ID = "roomID";

    // -------------------------------------------------------------- idInstance
    public OfMucRoomId getIdInstance() {
        return new OfMucRoomId()
                .ofMucService(getOfMucServiceServiceId())
                .name(getName());
    }

    // ------------------------------------------------------------ ofMucService
    public OfMucService getOfMucSerrvice() {
        return ofMucSerrvice;
    }

    public void setOfMucSerrvice(final OfMucService ofMucSerrvice) {
        this.ofMucSerrvice = ofMucSerrvice;
    }

    public OfMucRoom ofMucService(final OfMucService ofMucService) {
        setOfMucSerrvice(ofMucSerrvice);
        return this;
    }

    @XmlAttribute
    public Long getOfMucServiceServiceId() {
        return ofNullable(getOfMucSerrvice()).map(OfMucService::getServiceId)
                .orElse(null);
    }

    // ------------------------------------------------------------------ roomId
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(final Long roomId) {
        this.roomId = roomId;
    }

    public OfMucRoom roomId(final Long roomId) {
        setRoomId(roomId);
        return this;
    }

    // ------------------------------------------------------------ creationDate
    public Date getCreationDate() {
        return copyOf(creationDate);
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = copyOf(creationDate);
    }

    public OfMucRoom creationDate(final Date creationDate) {
        setCreationDate(creationDate);
        return this;
    }

    // -------------------------------------------------------- modificationDate
    public Date getModificationDate() {
        return copyOf(modificationDate);
    }

    public void setModificationDate(final Date modificationDate) {
        this.modificationDate = copyOf(modificationDate);
    }

    public OfMucRoom modificationDate(final Date modificationDate) {
        setModificationDate(modificationDate);
        return this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfMucRoom name(final String name) {
        setName(name);
        return this;
    }

    // ------------------------------------------------------------- naturalName
    public String getNaturalName() {
        return naturalName;
    }

    public void setNaturalName(final String naturalName) {
        this.naturalName = naturalName;
    }

    public OfMucRoom naturalName(final String naturalName) {
        setNaturalName(naturalName);
        return this;
    }

    // ------------------------------------------------------------- description
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public OfMucRoom description(final String description) {
        setDescription(description);
        return this;
    }

    // -------------------------------------------------------------- lockedDate
    public Date getLockedDate() {
        return copyOf(lockedDate);
    }

    public void setLockedDate(final Date lockedDate) {
        this.lockedDate = copyOf(lockedDate);
    }

    public OfMucRoom lockedDate(final Date lockDate) {
        setLockedDate(lockedDate);
        return this;
    }

    // --------------------------------------------------------------- emptyDate
    public Date getEmptyDate() {
        return copyOf(emptyDate);
    }

    public void setEmptyDate(final Date emptyDate) {
        this.emptyDate = copyOf(emptyDate);
    }

    public OfMucRoom emptyDate(final Date emptyDate) {
        setEmptyDate(emptyDate);
        return this;
    }

    // -------------------------------------------------------- canChangeSubject
    public boolean isCanChangeSubject() {
        return canChangeSubject;
    }

    public void setCanChangeSubject(final boolean canChangeSubject) {
        this.canChangeSubject = canChangeSubject;
    }

    public OfMucRoom canChangeSubject(final boolean canChangeSubject) {
        setCanChangeSubject(canChangeSubject);
        return this;
    }

    // ---------------------------------------------------------------- maxUsers
    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(final int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public OfMucRoom maxUsers(final int maxUsers) {
        setMaxUsers(maxUsers);
        return this;
    }

    // -------------------------------------------------------------- publicRoom
    public boolean isPublicRoom() {
        return publicRoom;
    }

    public void setPublicRoom(final boolean publicRoom) {
        this.publicRoom = publicRoom;
    }

    public OfMucRoom publicRoom(final boolean publicRoom) {
        setPublicRoom(publicRoom);
        return this;
    }

    // --------------------------------------------------------------- moderated
    public boolean isModerated() {
        return moderated;
    }

    public void setModerated(final boolean moderated) {
        this.moderated = moderated;
    }

    public OfMucRoom moderated(final boolean moderated) {
        setModerated(moderated);
        return this;
    }

    // ------------------------------------------------------------- membersOnly
    public boolean isMembersOnly() {
        return membersOnly;
    }

    public void setMembersOnly(final boolean membersOnly) {
        this.membersOnly = membersOnly;
    }

    public OfMucRoom membersOnly(final boolean membersOnly) {
        setMembersOnly(membersOnly);
        return this;
    }

    // --------------------------------------------------------------- canInvite
    public boolean isCanInvite() {
        return canInvite;
    }

    public void setCanInvite(final boolean canInvite) {
        this.canInvite = canInvite;
    }

    public OfMucRoom canInvite(final boolean canInvite) {
        setCanInvite(canInvite);
        return this;
    }

    // ------------------------------------------------------------ roomPassword
    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(final String roomPassword) {
        this.roomPassword = roomPassword;
    }

    public OfMucRoom roomPassword(final String roomPassword) {
        setRoomPassword(roomPassword);
        return this;
    }

    // ---------------------------------------------------------- canDiscoverJid
    public boolean isCanDiscoverJid() {
        return canDiscoverJid;
    }

    public void setCanDiscoverJid(final boolean canDiscoverJid) {
        this.canDiscoverJid = canDiscoverJid;
    }

    public OfMucRoom canDiscoverJid(final boolean canDiscoverJid) {
        setCanDiscoverJid(canDiscoverJid);
        return this;
    }

    // -------------------------------------------------------------- logEnabled
    public boolean isLogEnabled() {
        return logEnabled;
    }

    public void setLogEnabled(final boolean logEnabled) {
        this.logEnabled = logEnabled;
    }

    public OfMucRoom logEnabled(final boolean logEnabled) {
        setLogEnabled(logEnabled);
        return this;
    }

    // ----------------------------------------------------------------- subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public OfMucRoom subject(final String subject) {
        setSubject(subject);
        return this;
    }

    // -------------------------------------------------------- rolesToBroadcast
    public boolean isRolesToBroadcast() {
        return rolesToBroadcast;
    }

    public void setRolesToBroadcast(final boolean rolesToBroadcast) {
        this.rolesToBroadcast = rolesToBroadcast;
    }

    public OfMucRoom rolesToBroadcast(final boolean rolesToBroadcast) {
        setRolesToBroadcast(rolesToBroadcast);
        return this;
    }

    // --------------------------------------------------------- useReservedNick
    public boolean isUseReservedNick() {
        return useReservedNick;
    }

    public void setUseReservedNick(final boolean useReservedNick) {
        this.useReservedNick = useReservedNick;
    }

    public OfMucRoom useReservedNick(final boolean useReservedNick) {
        setUseReservedNick(useReservedNick);
        return this;
    }

    // ----------------------------------------------------------- canChangeNick
    public boolean isCanChangeNick() {
        return canChangeNick;
    }

    public void setCanChangeNick(final boolean canChangeNick) {
        this.canChangeNick = canChangeNick;
    }

    public OfMucRoom canChangeNick(final boolean canChangeNick) {
        setCanChangeNick(canChangeNick);
        return this;
    }

    // ------------------------------------------------------------- canRegister
    public boolean isCanRegister() {
        return canRegister;
    }

    public void setCanRegister(final boolean canRegister) {
        this.canRegister = canRegister;
    }

    public OfMucRoom canRegister(final boolean canRegister) {
        setCanRegister(canRegister);
        return this;
    }

    // ----------------------------------------------------------------- allowpm
    public Boolean getAllowpm() {
        return allowpm;
    }

    public void setAllowpm(final Boolean allowpm) {
        this.allowpm = allowpm;
    }

    public OfMucRoom allowpm(final Boolean allowpm) {
        setAllowpm(allowpm);
        return this;
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfMucService.COLUMN_NAME_SERVICE_ID,
            referencedColumnName = OfMucService.COLUMN_NAME_SERVICE_ID)
    @ManyToOne(optional = false)
    @Id
    private OfMucService ofMucSerrvice;

    @XmlElement(required = true)
    @NotNull
    @Column(name = "roomID", nullable = false)
    private Long roomId;

    @Column(name = "creationDate", nullable = false)
    @Convert(converter = OfDate015Converter.class)
    @NotNull
    @XmlElement(required = true)
    private Date creationDate;

    @XmlElement(required = true)
    @NotNull
    @Convert(converter = OfDate015Converter.class)
    @Column(name = "modificationDate", nullable = false)
    private Date modificationDate;

    @XmlElement(required = true)
    @NotNull
    @Column(name = "name", nullable = false)
    @Id
    private String name;

    @XmlElement(required = true)
    @NotNull
    @Column(name = "naturalName", nullable = false)
    private String naturalName;

    @XmlElement(nillable = true)
    @Column(name = "description")
    private String description;

    @XmlElement(required = true)
    @NotNull
    @Convert(converter = OfDate015Converter.class)
    @Column(name = "lockedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;

    @XmlElement(nillable = true)
    @Convert(converter = OfDate015Converter.class)
    @Column(name = "emptyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emptyDate;

    @XmlElement(required = true)
    @Column(name = "canChangeSubject", nullable = false)
    private boolean canChangeSubject;

    @XmlElement(required = true)
    @Column(name = "maxUsers", nullable = false)
    private int maxUsers;

    @XmlElement(required = true)
    @Column(name = "publicRoom", nullable = false)
    private boolean publicRoom;

    @XmlElement(required = true)
    @Column(name = "moderated", nullable = false)
    private boolean moderated;

    @XmlElement(required = true)
    @Column(name = "membersOnly", nullable = false)
    private boolean membersOnly;

    @XmlElement(required = true)
    @Column(name = "canInvite", nullable = false)
    private boolean canInvite;

    @XmlElement
    @Column(name = "roomPassword")
    private String roomPassword;

    @XmlElement(required = true)
    @Column(name = "canDiscoverJid", nullable = false)
    private boolean canDiscoverJid;

    @XmlElement(required = true)
    @Column(name = "logEnabled", nullable = false)
    private boolean logEnabled;

    @XmlElement(nillable = true)
    @Column(name = "subject")
    private String subject;

    @XmlElement(required = true)
    @Column(name = "rolesToBroadcast", nullable = false)
    private boolean rolesToBroadcast;

    @XmlElement(required = true)
    @Column(name = "useReservedNick", nullable = false)
    private boolean useReservedNick;

    @XmlElement(required = true)
    @Column(name = "canChangeNick", nullable = false)
    private boolean canChangeNick;

    @XmlElement(required = true)
    @Column(name = "canRegister", nullable = false)
    private boolean canRegister;

    @XmlElement(nillable = true)
    @Column(name = "allowpm")
    private Boolean allowpm;
}
