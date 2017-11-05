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

/**
 * An abstract using a specific column type.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 * @param <T> converter type parameter
 * @param <X> attribute type parameter
 * @param <Y> column type parameter
 */
abstract class __TypeHandler1<T extends __Converter<X, Y>, X, Y>
        extends __TypeHandler<T, X> {

    // -------------------------------------------------------------------------
    public __TypeHandler1(final Class<T> converterClass) {
        super(converterClass);
    }

    // -------------------------------------------------------------------------
    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i,
                                    final X parameter, final JdbcType jdbcType)
            throws SQLException {
        ps.setObject(i, converter().toColumn(parameter), jdbcType.TYPE_CODE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public X getNullableResult(final ResultSet rs, final String columnName)
            throws SQLException {
        return converter().toAttribute((Y) rs.getObject(columnName));
    }

    @Override
    @SuppressWarnings("unchecked")
    public X getNullableResult(final ResultSet rs, final int columnIndex)
            throws SQLException {
        return converter().toAttribute((Y) rs.getObject(columnIndex));
    }

    @Override
    @SuppressWarnings("unchecked")
    public X getNullableResult(final CallableStatement cs,
                               final int columnIndex)
            throws SQLException {
        return converter().toAttribute((Y) cs.getObject(columnIndex));
    }
}
