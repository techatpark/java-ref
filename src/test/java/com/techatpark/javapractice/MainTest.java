package com.techatpark.javapractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sayHello() {
        assertEquals("Hello world!",new Main().sayHello("world"));
    }
}