package com.techatpark.practices.oops;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class SqlBuilderTest {

    static final String DB_URL = "jdbc:h2:mem:test_mem";
    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    @Test
    void testSQL() throws SQLException {

        final String ddl = """
                CREATE TABLE movie (
                    id bigint auto_increment PRIMARY KEY,
                    title VARCHAR(80),
                    directed_by VARCHAR(80)
                );
                
                INSERT INTO movie(title,directed_by) VALUES('Coolie','Lokesh');
                """;

        final String query = """
                SELECT id, title, directed_by from movie where id = ?
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)) {

            int updateRows = SqlBuilder.sql(ddl).executeUpdate(connection);

            System.out.println("Create Tables that updated " + updateRows);

            Movie movie = SqlBuilder.sql(query)
                    .param(1)
                    .query(SqlBuilderTest::mapRow)
                    .single(connection);

            System.out.println(movie);

        }

    }


    private static Movie mapRow(ResultSet rs) throws SQLException {
        return new Movie(rs.getShort(1),
                rs.getString(2),
                rs.getString(3)
        );
    }

}
