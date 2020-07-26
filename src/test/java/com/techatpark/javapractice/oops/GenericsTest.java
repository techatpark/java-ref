package com.techatpark.javapractice.oops;

import com.techatpark.javapractice.oops.categories.Department;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GenericsTest {

    @Test
    void testGroup() {

        Person person = new Person("dddd", "hi@hi.co");
        person.name = "Sathish";

        Employee employee = new Employee("dddd", "hi@hi.co");


        Manager manager = new Manager("dddd", "hi@hi.co");

        List<Employee> bucketOfEmployees = new ArrayList();

        bucketOfEmployees.add(employee);

        bucketOfEmployees.add(manager);


        List<Manager> bucketOfManagers = new ArrayList<>(5);
        bucketOfManagers.add(manager);

        employee = manager;


    }
}









//