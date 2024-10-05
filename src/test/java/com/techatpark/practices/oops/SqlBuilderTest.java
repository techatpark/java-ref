package com.techatpark.practices.oops;

import org.junit.jupiter.api.Assertions;
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
                )
                """;

        final String insertSql = """
                INSERT INTO movie(title,directed_by) VALUES('Coolie','Lokesh')
                """;

        final String query = """
                SELECT id, title, directed_by from movie where id = ?
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)) {

            int updateRows = new SqlBuilder(ddl).executeUpdate(connection);

            Assertions.assertEquals(0,updateRows);

            updateRows = new SqlBuilder(insertSql).executeUpdate(connection);

            Assertions.assertEquals(1,updateRows);

            Movie movie = new SqlBuilder(query)
                    .param(1)
                    .query(SqlBuilderTest::mapRow)
                    .single(connection);

            Assertions.assertEquals("Coolie",movie.title());

            new SqlBuilder(insertSql).executeUpdate(connection);

            Assertions.assertEquals(2, new SqlBuilder("SELECT id, title, directed_by from movie")
                    .query(SqlBuilderTest::mapRow)
                    .list(connection)
                    .size());
        }

    }


    private static Movie mapRow(ResultSet rs) throws SQLException {
        return new Movie(rs.getShort(1),
                rs.getString(2),
                rs.getString(3)
        );
    }

}
