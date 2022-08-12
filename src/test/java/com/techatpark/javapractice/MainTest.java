package com.techatpark.javapractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main main;

    MainTest() {
        this.main = new Main();
    }

    @Test
    void sayHello() {
        assertEquals("Hello world"
                ,main.sayHello("world"));
    }

}