package com.techatpark.practices.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverserTest {

    @Test
    void testReverse() {
        StringReverser reverser = new StringReverser();
        String s = "i like this program very much";
        String[] words = s.split("\\s");

        words = reverser.reverse(words);

        s = String.join(" ", words);

        System.out.println(s);
    }

}