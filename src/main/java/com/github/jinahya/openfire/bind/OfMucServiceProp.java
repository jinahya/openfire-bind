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
 * The entity for {@value OfMucServiceProp#TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
@IdClass(OfMucServicePropId.class)
public class OfMucServiceProp extends OfProp<OfMucServiceProp> {

    public static final String TABLE_NAME = "ofServiceProp";

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public OfMucServiceProp() {
        super();
    }

    // -------------------------------------------------------------- idInstance
    public OfMucServicePropId getIdInstance() {
        return new OfMucServicePropId()
                .service(getOfMucServiceServiceId())
                .name(getName());
    }

    // ------------------------------------------------------------ ofMucService
    public OfMucService getOfMucService() {
        return ofMucService;
    }

    public void setOfMucService(final OfMucService ofMucService) {
        this.ofMucService = ofMucService;
    }

    public OfMucServiceProp ofMucService(final OfMucService ofMucService) {
        setOfMucService(ofMucService);
        return this;
    }

    @XmlAttribute
    public Long getOfMucServiceServiceId() {
        return ofNullable(getOfMucService())
                .map(OfMucService::getServiceId)
                .orElse(null);
    }

    @XmlAttribute
    public String getOfMucServiceSubdomain() {
        return ofNullable(getOfMucService())
                .map(OfMucService::getSubdomain)
                .orElse(null);
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
    private OfMucService ofMucService;
}
