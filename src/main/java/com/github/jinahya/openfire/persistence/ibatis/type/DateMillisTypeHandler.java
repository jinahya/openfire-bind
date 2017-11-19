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
package com.github.jinahya.openfire.persistence.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import static java.util.Optional.ofNullable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * An attribute converter for converting {@code Date} attribute to/from
 * milliseconds numerics columns.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class DateMillisTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(final PreparedStatement statement,
                                    final int index, final Date value,
                                    final JdbcType type)
            throws SQLException {
        statement.setLong(index, value.getTime());
    }

    @Override
    public Date getNullableResult(final ResultSet results, final String label)
            throws SQLException {
        return ofNullable(results.getLong(label)).map(Date::new).orElse(null);
    }

    @Override
    public Date getNullableResult(final ResultSet results, final int index)
            throws SQLException {
        return ofNullable(results.getLong(index)).map(Date::new).orElse(null);
    }

    @Override
    public Date getNullableResult(final CallableStatement statement,
                                  final int index)
            throws SQLException {
        return ofNullable(statement.getLong(index)).map(Date::new).orElse(null);
    }
}
