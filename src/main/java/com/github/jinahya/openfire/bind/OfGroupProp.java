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
 * An entity for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfGroupPropId.class)
public class OfGroupProp extends OfProp<OfGroupProp> {

    public static final String TABLE_NAME = "ofGroupProp";

    public static final String COLUMN_NAME_GROUP_NAME
            = OfGroup.COLUMN_NAME_GROUP_NAME;

    // -------------------------------------------------------------- idInstance
    public OfGroupPropId getIdInstance() {
        return new OfGroupPropId().group(getGroupGroupName()).name(getName());
    }

    // ------------------------------------------------------------------- group
    public OfGroup getGroup() {
        return group;
    }

    public void setGroup(final OfGroup group) {
        this.group = group;
    }

    public OfGroupProp group(final OfGroup group) {
        setGroup(group);
        return this;
    }

    @XmlAttribute
    public String getGroupGroupName() {
        return ofNullable(getGroup()).map(OfGroup::getGroupName).orElse(null);
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = COLUMN_NAME_GROUP_NAME,
            referencedColumnName = OfGroup.COLUMN_NAME_GROUP_NAME)
    private OfGroup group;
}
