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
public class OfMucServiceProp
        extends OfOwnedProp<OfMucService, OfMucServiceProp> {

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
                .serviceId(ofNullable(getOfMucService())
                        .map(OfMucService::getServiceId)
                        .orElse(null))
                .name(getName());
    }

//    // --------------------------------------------------------------- serviceId
//    @Deprecated
//    public long getServiceId() {
//        return serviceId;
//    }
//
//    @Deprecated
//    public void setServiceId(final long serviceId) {
//        this.serviceId = serviceId;
//    }
//
//    @Deprecated
//    public OfMucServiceProp serviceId(final long serviceId) {
//        setServiceId(serviceId);
//        return this;
//    }
    // ------------------------------------------------------------ ofMucService
    @Override
    OfMucService getOwner() {
        return ofMucService;
    }

    @Override
    void setOwner(final OfMucService owner) {
        this.ofMucService = owner;
    }

    public OfMucService getOfMucService() {
        return getOwner();
    }

    public void setOfMucService(final OfMucService ofMucService) {
        setOwner(ofMucService);
    }

    public OfMucServiceProp ofMucService(final OfMucService ofMucService) {
        return owner(ofMucService);
    }

    @XmlAttribute
    public Long ofMucServiceServiceId() {
        return ofNullable(getOfMucService())
                .map(OfMucService::getServiceId)
                .orElse(null);
    }

    @XmlAttribute
    public String ofMucServiceSubdomain() {
        return ofNullable(getOfMucService())
                .map(OfMucService::getSubdomain)
                .orElse(null);
    }
//
//    // -------------------------------------------------------------------- name
//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public OfMucServiceProp name(final String name) {
//        setName(name);
//        return this;
//    }
//
//    // --------------------------------------------------------------- propValue
//    public String getPropValue() {
//        return propValue;
//    }
//
//    public void setPropValue(final String propValue) {
//        this.propValue = propValue;
//    }
//
//    public OfMucServiceProp propValue(final String propValue) {
//        setPropValue(propValue);
//        return this;
//    }

    // -------------------------------------------------------------------------
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = OfMucService.COLUMN_NAME_SERVICE_ID,
            referencedColumnName = OfMucService.COLUMN_NAME_SERVICE_ID)
    @NotNull
    @XmlTransient
    private OfMucService ofMucService;

//    @Id
//    @Column(name = "name", nullable = false)
//    @NotNull
//    @XmlElement(required = true)
//    private String name;
//
//    @Column(name = "propValue", nullable = false)
//    @NotNull
//    @XmlElement(required = true)
//    private String propValue;
}
