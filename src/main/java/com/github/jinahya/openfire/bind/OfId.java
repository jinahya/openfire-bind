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

/**
 * And entity for {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@Entity
public class OfId implements Serializable {

    public static final String TABLE_NAME = "ofID";

    public static final String COLUMN_NAME_ID_TYPE = "idType";

    public static final String COLUMN_NAME_ID = "id";

    // -------------------------------------------------------------------------
    @Id
    @Column(name = COLUMN_NAME_ID_TYPE)
    private int idType;

    @Column(name = COLUMN_NAME_ID, nullable = false)
    private long id;
}
