package com.techatpark.javapractice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Main main;

    MainTest() {
        this.main = new Main();
    }

    @Test
    void sayHello() {
        //approch for comparing char
//        {"geeksforgeeks", "geeks", "geek", "geezer"}
        assertEquals("gee",main.sayHello(new ArrayList<String>(Arrays.asList("geeks for geeks", "geeks","geek","geezer"))));
//        {"apple", "ape", "april"}
        assertEquals("ap"
                ,main.sayHello( new ArrayList<String>(Arrays.asList("apple", "ape", "april"))));
//        {“apple”, “ape”, “zebra”}
        assertEquals(""
                ,main.sayHello( new ArrayList<String>(Arrays.asList("apple", "ape", "zebra"))));
    }

}