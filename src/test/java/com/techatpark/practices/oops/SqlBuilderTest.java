package com.techatpark.practices.oops;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class SqlBuilderTest {

    static final String DB_URL = "jdbc:h2:mem:test_mem";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";


    void selectSingle(Connection connection) throws SQLException {
        final String sql = """
                SELECT id, title, directed_by from movie where id = ?
                """;
        try (PreparedStatement  preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            Movie movie ;
            if(resultSet.next()) {
                movie = new Movie(resultSet.getShort(1), resultSet.getString(2),
                        resultSet.getString(3));

                System.out.println("From Raw JDBC");
                System.out.println(movie);
            }

        }





        Movie movie = SqlBuilder.sql(sql)
                .param(1)
                .query(SqlBuilderTest::mapRow)
                .single(connection);



        System.out.println("From Our JDBC Client");

        System.out.println(movie);

    }




    @Test
    void testSQL() {
        Connection conn = null;
        Statement stmt = null;
        try {

            //STEP 1: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 2: Execute a query
            stmt = conn.createStatement();
            String sql = """
                    
                    CREATE TABLE movie (
                        id bigint auto_increment PRIMARY KEY,
                        title VARCHAR(80),
                        directed_by VARCHAR(80)
                    );
                    
                    INSERT INTO movie(title,directed_by) VALUES('Coolie','Lokesh');
                    
                    """;
            stmt.executeUpdate(sql);


            selectSingle(conn);

            // STEP 3: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
    }


    private static Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(rs.getShort(1),
                rs.getString(2),
                rs.getString(3)
        );
    }

}
