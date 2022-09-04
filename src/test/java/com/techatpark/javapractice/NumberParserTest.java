package com.techatpark.javapractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class NumberParserTest {

    @Test
    void parserNumber() throws ParseException {
        NumberParser parser = new NumberParser();

        Assertions.assertEquals(parser.parser("12").getClass(), Byte.class ,
                "Byte not identified properly");

        Assertions.assertEquals(parser.parser("1283").getClass(), Short.class ,
                "Short not identified properly");

        Assertions.assertEquals(parser.parser("245").getClass(), Short.class ,
                "Short not identified properly");

        Assertions.assertEquals(parser.parser("135").getClass(), Short.class ,
                "Short not identified properly");

        Assertions.assertEquals(parser.parser("129").getClass(), Short.class ,
                "Short not identified properly");
    }
}