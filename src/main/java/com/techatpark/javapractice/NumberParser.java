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


        int length = source.length();

        switch (length) {
            case 1,2:
                return Byte.parseByte(source);
            case 3:
                return isByte(source) ? Byte.parseByte(source) : Short.parseShort(source);
            case 4,5,6:
                return Short.parseShort(source);
        }

        throw new UnsupportedOperationException("Yet to implement");
    }

    private boolean isByte(String source) {
        int charZero = Character.getNumericValue(source.charAt(0));
        if(charZero == 1) {
            int charOne = Character.getNumericValue(source.charAt(1));
            if(charOne < 3) {
                int charTwo = Character.getNumericValue(source.charAt(2));
                if(charTwo != 8 && charTwo != 9) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
