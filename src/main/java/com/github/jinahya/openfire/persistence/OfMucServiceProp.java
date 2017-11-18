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

import static java.util.Optional.ofNullable;
import javax.json.bind.annotation.JsonbProperty;
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

    private static final long serialVersionUID = -8764347967513782358L;

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofMucServiceProp";

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_SERVICE_ID
            = OfMucService.COLUMN_NAME_SERVICE_ID;

    public static final String ATTRIBUTE_NAME_SERVICE = "service";

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public OfMucServiceProp() {
        super();
    }

    // -------------------------------------------------------- java.lang.Object
    @Override
    public String toString() {
        return super.toString() + "{"
               + "service=" + service
               + "}";
    }

    // -------------------------------------------------------------- idInstance
    public OfMucServicePropId getIdInstance() {
        return new OfMucServicePropId()
                .service(getServiceServiceId())
                .name(getName());
    }

    // ----------------------------------------------------------------- service
    public OfMucService getService() {
        return service;
    }

    public void setService(final OfMucService service) {
        this.service = service;
    }

    public OfMucServiceProp service(final OfMucService service) {
        setService(service);
        return this;
    }

    @JsonbProperty
    @XmlAttribute
    public Long getServiceServiceId() {
        return ofNullable(getService()).map(OfMucService::getServiceId)
                .orElse(null);
    }

    @JsonbProperty
    @XmlAttribute
    public String getServiceSubdomain() {
        return ofNullable(getService()).map(OfMucService::getSubdomain)
                .orElse(null);
    }

    // -------------------------------------------------------------------------
    @XmlTransient
    @NotNull
    @Id
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            name = COLUMN_NAME_SERVICE_ID,
            referencedColumnName = OfMucService.COLUMN_NAME_SERVICE_ID)
    @NamedAttribute(ATTRIBUTE_NAME_SERVICE)
    private OfMucService service;
}
