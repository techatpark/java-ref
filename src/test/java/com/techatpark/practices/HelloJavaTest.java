package com.techatpark.practices;

import org.junit.jupiter.api.Test;

class HelloJavaTest {

    @Test
    void testReverse() {
        HelloJava reverser = new HelloJava();
        String s = "i like this program very much";
        String[] words = s.split("\\s");

        words = reverser.reverse(words);

        s = String.join(" ", words);

        System.out.println(s);
    }

}