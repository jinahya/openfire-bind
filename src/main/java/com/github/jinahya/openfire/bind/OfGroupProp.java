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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
@Entity
@IdClass(OfGroupPropId.class)
public class OfGroupProp implements Serializable {

    public static final String TABLE_NAME = "ofGroupProp";

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public OfGroupProp() {
        super();
    }

    // -------------------------------------------------------------- idInstance
    public OfGroupPropId getIdInstance() {
        return new OfGroupPropId().groupName(groupName).name(name);
    }

    // --------------------------------------------------------------- groupName
    @Deprecated
    public String getGroupName() {
        return groupName;
    }

    @Deprecated
    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    @Deprecated
    public OfGroupProp groupName(final String groupName) {
        setGroupName(groupName);
        return this;
    }

    // ----------------------------------------------------------------- ofGroup
    public OfGroup getOfGroup() {
        return ofGroup;
    }

    public void setOfGroup(final OfGroup ofGroup) {
        this.ofGroup = ofGroup;
        this.groupName = ofNullable(this.ofGroup)
                .map(OfGroup::getGroupName)
                .orElse(null);
    }

    public OfGroupProp ofGroup(final OfGroup ofGroup) {
        setOfGroup(ofGroup);
        return this;
    }

    @XmlAttribute
    public String ofGroupGroupName() {
        return ofNullable(ofGroup).map(OfGroup::getGroupName).orElse(null);
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfGroupProp name(final String name) {
        setName(name);
        return this;
    }

    // --------------------------------------------------------------- propValue
    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(final String propValue) {
        this.propValue = propValue;
    }

    public OfGroupProp propValue(final String propValue) {
        setPropValue(propValue);
        return this;
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = OfGroup.COLUMN_NAME_GROUP_NAME, nullable = false)
    @NotNull
    @XmlTransient
    private String groupName;

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfGroup.COLUMN_NAME_GROUP_NAME,
            referencedColumnName = OfGroup.COLUMN_NAME_GROUP_NAME)
    @NotNull
    @XmlTransient
    private OfGroup ofGroup;

    @Id
    @Column(name = "name", nullable = false)
    @NotNull
    @XmlElement(required = true)
    private String name;

    @Column(name = "propValue", nullable = false)
    @NotNull
    @XmlElement(required = true)
    private String propValue;
}
