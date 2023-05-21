package com.techatpark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main m = new Main();

    @Test
    void sayHello() {
        assertEquals("Hello", m.sayHello());
    }
}