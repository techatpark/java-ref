package com.techatpark.javapractice.oops;

import com.techatpark.javapractice.oops.categories.Department;
import com.techatpark.javapractice.oops.character.Disciplined;

public class Employee extends Person implements Disciplined {

    private Department department ;

    private Company company ;

    public Employee(String name, String email) {
        super(name, email);
    }


    void work() {
        System.out.println("I am working");
    }


    @Override
    public void doWhatOthersSay() {

    }
}
