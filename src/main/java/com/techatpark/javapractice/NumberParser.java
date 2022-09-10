package com.techatpark.javapractice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberParser {

    /**
     * Gets Compact Number of a source String.
     * @param source
     * @param isNegative
     * @return Byte, Short, Integer, Long or BigInteger
     */
    public Number parseNumber(final String source, boolean isNegative) {
        switch (source.length()) {
            case 1, 2:
                return Byte.parseByte(source);
            case 3:
                return getByteOrShort(source);
            case 4:
                return Short.parseShort(source);
            case 5:
                return getShortOrInteger(source);
            case 6, 7, 8 , 9:
                return Integer.parseUnsignedInt(source);
            case 10:
                return getIntegerOrLong(source);
            case 11,12,13,14,15,16,17,18:
                return Long.parseUnsignedLong(source);
            case 19:
                return getLongOrBigNumber(source);
            default:
                return new BigInteger(source);
        }
    }

    private Number getLongOrBigNumber(String source) {
        BigInteger bigInteger = new BigInteger(source);
        if(bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > -1) {
            return bigInteger.longValue();
        }
        return bigInteger;
    }


    private Number getByteOrShort(String source) {
        Short aShort = Short.parseShort(source);
        if(aShort <= Byte.MAX_VALUE) {
            return aShort.byteValue();
        }
        return aShort;
    }

    private Number getShortOrInteger(String source) {
        Integer integer = Integer.parseUnsignedInt(source);
        if(integer <= Short.MAX_VALUE) {
            return integer.shortValue();
        }
        return integer;
    }

    private Number getIntegerOrLong(String source) {
        Long aLong = Long.parseUnsignedLong(source);
        if(aLong <= Integer.MAX_VALUE) {
            return aLong.intValue();
        }
        return aLong;
    }
    /**
     * Gets Compact decimal Number of a source String.
     * @param source
     * @return Float,Double or BigDecimal
     */
    public Number parseDecimalNumber(final String source) {
        Float aFloat = Float.parseFloat(source);
        if(aFloat.floatValue() == Float.POSITIVE_INFINITY) {
            Double aDouble = Double.parseDouble(source);
            if(aDouble.doubleValue() == Double.POSITIVE_INFINITY) {
                return new BigDecimal(source);
            }
            return aDouble;
        }

        return aFloat;
    }

}
