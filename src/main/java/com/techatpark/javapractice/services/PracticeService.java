package com.techatpark.javapractice.services;

import com.techatpark.javapractice.repository.PracticeRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeService {

    private PracticeRepository practiceRepository;
    public void createPractice(String name, String description) {
        try {
            practiceRepository.createPractice(name, description);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb", "user1", "pass");
            Statement st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
