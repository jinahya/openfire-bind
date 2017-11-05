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

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

/**
 * An attribute converter for converting entity attributes of {@link Date} type
 * to/from database columns of {@code Long}(milliseconds) type.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@MappedJdbcTypes(JdbcType.BIGINT)
public class __DateMillisTypeHandler
        extends __TypeHandler<__DateMillisConverter, Date> {

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public __DateMillisTypeHandler() {
        super(__DateMillisConverter.class);
    }

    // -------------------------------------------------------------------------
    @Override
    public void setNonNullParameter(
            final PreparedStatement ps, final int i, final Date parameter,
            final JdbcType jdbcType)
            throws SQLException {
        ps.setLong(i, converter().toColumn(parameter));
    }

    @Override
    public Date getNullableResult(final ResultSet rs, final String columnName)
            throws SQLException {
        return converter().toAttribute(rs.getLong(columnName));
    }

    @Override
    public Date getNullableResult(final ResultSet rs, final int columnIndex)
            throws SQLException {
        return converter().toAttribute(rs.getLong(columnIndex));
    }

    @Override
    public Date getNullableResult(final CallableStatement cs,
                                  final int columnIndex)
            throws SQLException {
        return converter().toAttribute(cs.getLong(columnIndex));
    }
}
