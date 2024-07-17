package com.techatpark.practices;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;


public class HelloJdbc {
    public static void main(String[] args)  {
        // Create DS
        DataSource dataSource = getDatasource();

        String sql = """
                SELECT id, title, directed_by FROM movie
                """;


    }


    private static DataSource getDatasource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }
}
