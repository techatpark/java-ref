package com.techatpark.javapractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class NumberParserTest {

    @Test
    void parserNumber() throws ParseException {


        NumberParser parser = new NumberParser();

        Assertions.assertInstanceOf(
                Byte.class,
                parser.parser(Byte.toString(Byte.MAX_VALUE)),
                "Byte Max not identified properly");

        Assertions.assertInstanceOf(
                Short.class,
                parser.parser(Short.toString(Short .MAX_VALUE)),
                "Short Max not identified properly");

//        Assertions.assertInstanceOf(
//                Integer.class,
//                parser.parser(Integer.toString(Integer .MAX_VALUE)),
//                "Integer Max not identified properly");


    }
}