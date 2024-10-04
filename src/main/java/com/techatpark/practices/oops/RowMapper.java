package com.techatpark.practices.oops;

import java.sql.ResultSet;
import java.sql.SQLException; /**
 * Row Mapper for Resultsets.
 */
public interface RowMapper<T> {
    T mapRow(ResultSet resultSet, int i) throws SQLException;
}
