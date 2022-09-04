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
            default:
                throw new UnsupportedOperationException("Yet to implement");
        }


    }

    private boolean isByte(final String source) {
        if (Character.getNumericValue(source.charAt(0)) == 1) {
            if (Character.getNumericValue(source.charAt(1)) < 3) {
                int lastDigit = Character.getNumericValue(source.charAt(2));
                return !(lastDigit == 8
                        || lastDigit == 9);
            }
        }
        return false;
    }

    // 32767
    private boolean isShort(final String source) {
        if (Character.getNumericValue(source.charAt(0)) < 4) {
            if (Character.getNumericValue(source.charAt(1)) < 3) {
                if (Character.getNumericValue(source.charAt(2)) < 8) {
                    if (Character.getNumericValue(source.charAt(3)) < 7) {
                        int lastDigit = Character.getNumericValue(source.charAt(4));
                        return !(lastDigit == 8
                                || lastDigit == 9);
                    }
                }

            }
        }
        return false;
    }



}
