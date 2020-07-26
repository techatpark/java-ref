package com.techatpark.javapractice.oops;

import com.techatpark.javapractice.oops.categories.Department;
import com.techatpark.javapractice.oops.character.Structured;

public class Manager extends Employee implements Structured {

    public Manager(String name, String email) {
        super(name, email);
    }

    @Override
    public void doWhatISay() {

    }
}
