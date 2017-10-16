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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    @Id
    @Column(name = COLUMN_NAME_USERNAME, nullable = false, unique = true,
            updatable = false)
    @NotNull
    @XmlElement(required = true)
    private String username;
}
