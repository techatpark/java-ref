package com.techatpark.practices;

import org.postgresql.ds.PGSimpleDataSource;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloJdbc {
    public static void main(String[] args)  {
        // Create DS
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("password");

        String sql = """
                SELECT id, title, directed_by FROM movie
                """;

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID + " + resultSet.getLong(1));
                System.out.println("Title + " + resultSet.getString(2));
                System.out.println("Directed By + " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
