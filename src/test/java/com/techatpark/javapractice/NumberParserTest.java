package com.techatpark.javapractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class NumberParserTest {

    @Test
    void parserNumber() throws ParseException {
        NumberParser parser = new NumberParser();
        Assertions.assertEquals(parser.parser("127").getClass(), Byte.class ,
                "Byte not identified properly");

        Assertions.assertEquals(parser.parser("128").getClass(), Short.class ,
                "Short not identified properly");
    }
}