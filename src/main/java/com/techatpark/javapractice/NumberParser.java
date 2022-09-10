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
                if(isInteger(source)) {
                    return Integer.parseUnsignedInt(source);
                }
                return Long.parseUnsignedLong(source);
            case 11,12,13,14,15,16,17,18:
                return Long.parseUnsignedLong(source);
            case 19:
                if(isLong(source)) {
                    return Long.parseUnsignedLong(source);
                }
                return new BigInteger(source);
            default:
                return new BigInteger(source);
        }
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

    //9223372036854775807
    private boolean isLong(String source) {
        return  Character.getNumericValue(source.charAt(1)) < 3
                && Character.getNumericValue(source.charAt(2)) < 3
                && Character.getNumericValue(source.charAt(3)) < 4
                && Character.getNumericValue(source.charAt(4)) < 4
                && Character.getNumericValue(source.charAt(5)) < 8
                && Character.getNumericValue(source.charAt(6)) < 3
                && Character.getNumericValue(source.charAt(7)) == 0
                && Character.getNumericValue(source.charAt(8)) < 4
                && Character.getNumericValue(source.charAt(9)) < 7
                && Character.getNumericValue(source.charAt(10)) < 9
                && Character.getNumericValue(source.charAt(11)) < 6
                && Character.getNumericValue(source.charAt(12)) < 5
                && Character.getNumericValue(source.charAt(13)) < 8
                && Character.getNumericValue(source.charAt(14)) < 8
                && Character.getNumericValue(source.charAt(15)) < 6
                && Character.getNumericValue(source.charAt(16)) < 9
                && Character.getNumericValue(source.charAt(17)) == 0
                && Character.getNumericValue(source.charAt(18)) < 8;
    }

    // 127
    private boolean isByte(final String source) {
        int lastDigit = Character.getNumericValue(source.charAt(2));
        return Character.getNumericValue(source.charAt(0)) < 2
                && Character.getNumericValue(source.charAt(1)) < 3
                && !(lastDigit == 8 || lastDigit == 9);
    }

    // 32767  21769

    private boolean isShort(final String source) {
        int lastDigit = Character.getNumericValue(source.charAt(4));
        return  !(lastDigit == 8 || lastDigit == 9) && Character.getNumericValue(source.charAt(0)) < 4
                && Character.getNumericValue(source.charAt(1)) < 3
                && Character.getNumericValue(source.charAt(2)) < 8
                && Character.getNumericValue(source.charAt(3)) < 7;
    }

    // 2147483647
    private boolean isInteger(final String source) {
        int lastDigit = Character.getNumericValue(source.charAt(9));
        return  Character.getNumericValue(source.charAt(0)) < 3
                && Character.getNumericValue(source.charAt(1)) < 2
                && Character.getNumericValue(source.charAt(2)) < 5
                && Character.getNumericValue(source.charAt(3)) < 8
                && Character.getNumericValue(source.charAt(4)) < 5
                && Character.getNumericValue(source.charAt(5)) < 9
                && Character.getNumericValue(source.charAt(6)) < 4
                && Character.getNumericValue(source.charAt(7)) < 7
                && Character.getNumericValue(source.charAt(8)) < 5
                && !(lastDigit == 8 || lastDigit == 9);
    }
}
