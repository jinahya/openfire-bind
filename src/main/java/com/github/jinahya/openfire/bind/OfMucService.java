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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

/**
 * An entity for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfMucService implements Serializable {

    // -------------------------------------------------------------------------
    /**
     * The name of the target table of this entity.
     */
    public static final String TABLE_NAME = "ofMucService";

    public static final String COLUMN_NAME_SERVICE_ID = "serviceID";

    public static final String COLUMN_NAME_SUBDOMAIN = "subdomain";

    // --------------------------------------------------------------- serviceId
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(final Long serviceId) {
        this.serviceId = serviceId;
    }

    public OfMucService serviceId(final Long serviceId) {
        setServiceId(serviceId);
        return this;
    }

    // --------------------------------------------------------------- subdomain
    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(final String subdomain) {
        this.subdomain = subdomain;
    }

    public OfMucService subdomain(final String subdomain) {
        setSubdomain(subdomain);
        return this;
    }

    // ------------------------------------------------------------- description
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    // ------------------------------------------------------------------ hidden
    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(final boolean hidden) {
        this.hidden = hidden;
    }

    // -------------------------------------------------------------------------
    @XmlElement(required = true)
    @NotNull
    @Column(name = COLUMN_NAME_SERVICE_ID, nullable = false)
    private Long serviceId;

    @XmlElement(required = true)
    @NotNull
    @Id
    @Column(name = COLUMN_NAME_SUBDOMAIN, nullable = false, unique = true)
    private String subdomain;

    @XmlElement(nillable = true)
    @Column(name = "description")
    private String description;

    @XmlElement(required = true)
    @Column(name = "isHidden", nullable = false)
    private boolean hidden;
}
