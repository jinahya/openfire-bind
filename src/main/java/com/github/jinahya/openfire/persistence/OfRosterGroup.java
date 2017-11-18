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
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfRosterGroupId.class)
public class OfRosterGroup extends OfMapped {

    private static final Logger logger
            = getLogger(lookup().lookupClass().getName());

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "OfRosterGroups";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_ROSTER_ID
            = OfRoster.COLUMN_NAME_ROSTER_ID;

    public static final String ATTRIBUTE_NAME_ROSTER = "roster";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_RANK = "rank";

    public static final String ATTRIBUTE_NAME_RANK = "rank";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_GROUP_NAME = "groupName";

    public static final String ATTRIBUTE_NAME_GROUP_NAME = "groupName";

    // -------------------------------------------------------------- idInstance
    public OfRosterGroupId getIdInstance() {
        return new OfRosterGroupId()
                .roster(getRosterRosterId())
                .rank(getRank());
    }

    // ------------------------------------------------------------------ roster
    public OfRoster getRoster() {
        return roster;
    }

    public void setRoster(final OfRoster roster) {
        this.roster = roster;
    }

    public OfRosterGroup roster(final OfRoster roster) {
        setRoster(roster);
        return this;
    }

    @XmlAttribute
    public Long getRosterRosterId() {
        return ofNullable(getRoster()).map(OfRoster::getRosterId).orElse(null);
    }

    // -------------------------------------------------------------------- rank
    public Long getRank() {
        return rank;
    }

    public void setRank(final Long rank) {
        this.rank = rank;
    }

    public OfRosterGroup rank(final Long rank) {
        setRank(rank);
        return this;
    }

    // --------------------------------------------------------------- groupName
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    public OfRosterGroup groupName(final String groupName) {
        setGroupName(groupName);
        return this;
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = COLUMN_NAME_ROSTER_ID,
            referencedColumnName = OfRoster.COLUMN_NAME_ROSTER_ID)
    private OfRoster roster;

    @XmlElement
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_RANK, nullable = false)
    private Long rank;

    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_RANK, nullable = false)
    private String groupName;
}