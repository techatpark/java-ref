package com.techatpark.javapractice.oops;

import com.techatpark.javapractice.oops.categories.Department;

import java.time.LocalDate;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), email);
    }
}
