package com.techatpark.javapractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

class NumberParserTest {

    @Test
    void parserNumber() throws ParseException {

        NumberParser parser = new NumberParser();

        Assertions.assertInstanceOf(
                Byte.class,
                parser.parseNumber(Byte.toString(Byte.MAX_VALUE)),
                "Byte Max not identified properly");

        Assertions.assertInstanceOf(
                Short.class,
                parser.parseNumber(Short.toString(Short .MAX_VALUE)),
                "Short Max not identified properly");

        Assertions.assertInstanceOf(
                Integer.class,
                parser.parseNumber(Integer.toString(Integer.MAX_VALUE)),
                "Integer Max not identified properly");

        Assertions.assertInstanceOf(
                Long.class,
                parser.parseNumber(Long.toString(Long.MAX_VALUE)),
                "Long Max not identified properly");

        Assertions.assertInstanceOf(
                BigInteger.class,
                parser.parseNumber(BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.TWO).toString()),
                "BigInteger Max not identified properly");


    }

    @Test
    void parserDecimalNumber() throws ParseException {

        NumberParser parser = new NumberParser();

        Assertions.assertInstanceOf(
                Float.class,
                parser.parseDecimalNumber(Float.toString(Float.MAX_VALUE)),
                "Float Max not identified properly");

        Assertions.assertInstanceOf(
                Double.class,
                parser.parseDecimalNumber(Double.toString(Double.MAX_VALUE)),
                "Double Max not identified properly");

        Assertions.assertInstanceOf(
                BigDecimal.class,
                parser.parseDecimalNumber(BigDecimal.valueOf(Double.MAX_VALUE)
                        .multiply(BigDecimal.TEN).toString()),
                "Double Max not identified properly");

    }
}