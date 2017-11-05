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
import org.apache.ibatis.type.JdbcType;

abstract class __TypeHandler2<T extends __AbstractConverter<X, Y>, X, Y>
        extends __TypeHandler1<T, X, Y> {

    // -------------------------------------------------------------------------
    public __TypeHandler2(final Class<T> converterClass) {
        super(converterClass);
    }

    // -------------------------------------------------------------------------
    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i,
                                    final X parameter, final JdbcType jdbcType)
            throws SQLException {
        super.setNonNullParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public X getNullableResult(final ResultSet rs, final String columnName)
            throws SQLException {
        return converter().toAttribute(
                rs.getObject(columnName, converter().columnClass));
    }

    @Override
    public X getNullableResult(final ResultSet rs, final int columnIndex)
            throws SQLException {
        return converter().toAttribute(
                rs.getObject(columnIndex, converter().columnClass));
    }

    @Override
    public X getNullableResult(final CallableStatement cs,
                               final int columnIndex)
            throws SQLException {
        return converter().toAttribute(
                cs.getObject(columnIndex, converter().columnClass));
    }
}
