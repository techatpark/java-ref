package com.techatpark.practices;

import com.techatpark.practices.repository.EmployeeRepository;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;


public class HelloJdbc {
    public static void main(String[] args)  {
        // Create DS
        DataSource dataSource = getDatasource();


        EmployeeRepository employeeRepository = new EmployeeRepository(dataSource);



    }


    private static DataSource getDatasource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }
}
