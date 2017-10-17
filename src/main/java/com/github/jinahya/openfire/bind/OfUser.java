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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
@Entity
public class OfUser implements Serializable {

    // -------------------------------------------------------------------------
    public static final String COLUMN_NAME_USERNAME = "username";

    public static final String COLUMN_NAME_NAME = "name";

    public static final String COLUMN_NAME_EMAIL = "email";

    public static final String COLUMN_NAME_CREATION_DATE = "creationDate";

    public static final String COLUMN_NAME_MODIFICATION_DATE
            = "modificationDate";

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // ---------------------------------------------------------------- username
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    // ------------------------------------------------------------------- email
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    // ------------------------------------------------------------ creationDate
    public Date getCreationDate() {
        if (creationDate == null) {
            return null;
        }
        return new Date(creationDate.getTime());
    }

    public void setCreationDate(final Date creationDate) {
        if (creationDate == null) {
            this.creationDate = null;
        }
        this.creationDate = new Date(creationDate.getTime());
    }

    // -------------------------------------------------------- modificationDate
    public Date getModificationDate() {
        if (modificationDate == null) {
            return null;
        }
        return new Date(modificationDate.getTime());
    }

    public void setModificationDate(final Date modificationDate) {
        if (modificationDate == null) {
            this.modificationDate = null;
        }
        this.modificationDate = new Date(modificationDate.getTime());
    }

    // -------------------------------------------------------------------------
    @Id
    @Column(name = COLUMN_NAME_USERNAME)
    @NotNull
    @XmlElement(required = true)
    private String username;

    @Column(name = "storedKey")
    private String storedKey;

    @Column(name = "serverKey")
    private String serverKey;

    private String salt;

    @Column(name = "iterations", nullable = false)
    private int iterations;

    @Column(name = "plainPassword", nullable = false)
    private String plainPassword;

    @Column(name = "encryptedPassword")
    private String encryptedPassword;

    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @Column(name = COLUMN_NAME_EMAIL)
    private String email;

    @Column(name = COLUMN_NAME_CREATION_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = OfDate015Converter.class)
    @NotNull
    @XmlElement(required = true)
    private Date creationDate;

    @Column(name = COLUMN_NAME_MODIFICATION_DATE, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = OfDate015Converter.class)
    @NotNull
    @XmlElement(required = true)
    private Date modificationDate;
}
