package com.techatpark.javapractice;

import java.math.BigInteger;
import java.text.ParseException;

public class NumberParser {

    /**
     * Getc Compact Number of a source String.
     * @param source
     * @return Byte, Short, Integer or Long
     * @throws ParseException
     */
    public Number parser(final String source)
            throws ParseException {
        switch (source.length()) {
            case 1, 2:
                return Byte.parseByte(source);
            case 3:
                if(isByte(source)) {
                    return Byte.parseByte(source);
                }
                return Short.parseShort(source);
            case 4:
                return Short.parseShort(source);
            case 5:
                if(isShort(source)) {
                    return Short.parseShort(source);
                }
                return Integer.parseInt(source);
            case 6, 7, 8 , 9:
                return Integer.parseInt(source);
            case 10:
                if(isInteger(source)) {
                    return Integer.parseInt(source);
                }
                return Long.parseLong(source);
            case 11,12,13,14,15,16,17,18:
                return Long.parseLong(source);
            case 19:
                if(isLong(source)) {
                    return Long.parseLong(source);
                }
                return new BigInteger(source);
            default:
                return new BigInteger(source);
//                throw new UnsupportedOperationException("Yet to implement");
        }

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

    // 32767
    private boolean isShort(final String source) {
        int lastDigit = Character.getNumericValue(source.charAt(4));
        return  Character.getNumericValue(source.charAt(0)) < 4
                && Character.getNumericValue(source.charAt(1)) < 3
                && Character.getNumericValue(source.charAt(2)) < 8
                && Character.getNumericValue(source.charAt(3)) < 7
                && !(lastDigit == 8 || lastDigit == 9);
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
