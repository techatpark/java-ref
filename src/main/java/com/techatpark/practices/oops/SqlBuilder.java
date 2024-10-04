package com.techatpark.practices.oops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlBuilder {

    private final String sql;

    private final List<Object> parameters;

    public SqlBuilder(final String sql) {
        this.sql = sql;
        this.parameters = new ArrayList<>();
    }

    public static SqlBuilder sql(final String sql) {
        return new SqlBuilder(sql);
    }

    public SqlBuilder param(Object value) {
        this.parameters.add(value);
        return this;
    }

    public  <T> SqlBuilder.Query<T> query(RowMapper<T> rowMapper) {
        return this.new Query<T>(rowMapper);
    }

    /**
     * Row Mapper for Resultsets.
     */
    public interface RowMapper<T> {
        T mapRow(ResultSet resultSet, int i) throws SQLException;
    }

    public class Query<T> {


        private final RowMapper<T> rowMapper;

        private Query(final RowMapper<T> rowMapper) {
            this.rowMapper = rowMapper;
        }



        public T single(final Connection connection) throws SQLException {
            T movie = null;
            try (PreparedStatement  preparedStatement = connection.prepareStatement(sql)) {

                for (int i = 0; i < parameters.size(); i++) {
                    preparedStatement.setObject(i+1, parameters.get(i));
                }

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    movie = rowMapper.mapRow(resultSet, 1);
                }


            }
            return movie;
        }
    }
}
