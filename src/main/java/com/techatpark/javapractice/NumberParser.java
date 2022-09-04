package com.techatpark.javapractice;

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
            default:
                throw new UnsupportedOperationException("Yet to implement");
        }


    }

    private boolean isByte(final String source) {
        int lastDigit = Character.getNumericValue(source.charAt(2));
        return Character.getNumericValue(source.charAt(0)) == 1
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
        int lastDigit = Character.getNumericValue(source.charAt(7));
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
