package com.techatpark.practices;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.techatpark.practices.repository.EmployeeRepository;

import javax.sql.DataSource;


public class HelloJdbc {
    public static void main(String[] args)  {
        // Create DS
        DataSource dataSource = getDatasource();


        EmployeeRepository employeeRepository = new EmployeeRepository(dataSource);



    }


    private static DataSource getDatasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("user");
        dataSource.setPassword("password");
        return dataSource;
    }
}
