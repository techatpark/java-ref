package com.techatpark.javapractice.oops;

import com.techatpark.javapractice.oops.categories.Department;

import java.time.LocalDate;

public class Person {

    public String name;

    public String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void walk() {
        System.out.println(name + " walks now");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
