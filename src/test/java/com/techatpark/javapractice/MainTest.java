package com.techatpark.javapractice;

import com.techatpark.javapractice.constants.ApplicationConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main main;

    MainTest() {
        this.main = new Main(null);
    }

    @Test
    void sayHello() {
        assertEquals("Hello world! Welcome to "+ ApplicationConstants.APPLICATION_NAME
                ,main.sayHello("world"));
    }

}