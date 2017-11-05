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

import static com.github.jinahya.openfire.bind.OfUtilities.copyOf;
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
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfUser implements Serializable {

    // -------------------------------------------------------------------------
    public static final String TABLE_NAME = "ofUser";

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

    public OfUser username(final String username) {
        setUsername(username);
        return this;
    }

    // -------------------------------------------------------------------- name
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OfUser name(final String name) {
        setName(name);
        return this;
    }

    // ------------------------------------------------------------------- email
    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public OfUser email(final String email) {
        setEmail(email);
        return this;
    }

    // ------------------------------------------------------------ creationDate
    public Date getCreationDate() {
        return copyOf(creationDate);
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = copyOf(creationDate);
    }

    public OfUser creationDate(final Date creationDate) {
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

    public OfUser modificationDate(final Date modificationDate) {
        setModificationDate(modificationDate);
        return this;
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

    @XmlElement(required = true)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = __Date015AttributeConverter.class)
    @Column(name = COLUMN_NAME_CREATION_DATE, nullable = false)
    private Date creationDate;

    @XmlElement(required = true)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = __Date015AttributeConverter.class)
    @Column(name = COLUMN_NAME_MODIFICATION_DATE, nullable = false)
    private Date modificationDate;
}
