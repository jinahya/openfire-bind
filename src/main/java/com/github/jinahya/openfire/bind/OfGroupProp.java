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

import static java.util.Optional.ofNullable;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfGroupPropId.class)
public class OfGroupProp extends OfProp<OfGroupProp> {

    public static final String TABLE_NAME = "ofGroupProp";

    // -------------------------------------------------------------- idInstance
    public OfGroupPropId getIdInstance() {
        return new OfGroupPropId().ofGroup(getOfGroupGroupName())
                .name(getName());
    }

    // ----------------------------------------------------------------- ofGroup
    public OfGroup getOfGroup() {
        return ofGroup;
    }

    public void setOfGroup(final OfGroup ofGroup) {
        this.ofGroup = ofGroup;
    }

    public OfGroupProp ofGroup(final OfGroup ofGroup) {
        setOfGroup(ofGroup);
        return this;
    }

    @XmlAttribute
    public String getOfGroupGroupName() {
        return ofNullable(getOfGroup()).map(OfGroup::getGroupName).orElse(null);
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfGroup.COLUMN_NAME_GROUP_NAME,
            referencedColumnName = OfGroup.COLUMN_NAME_GROUP_NAME)
    @ManyToOne(optional = false)
    @Id
    private OfGroup ofGroup;
}
