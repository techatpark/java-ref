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
                return isNegative ? -Byte.parseByte(source) : Byte.parseByte(source);
            case 3:
                return getByteOrShort(source,isNegative);
            case 4:
                return isNegative ? -Short.parseShort(source) : Short.parseShort(source);
            case 5:
                return getShortOrInteger(source,isNegative);
            case 6, 7, 8 , 9:
                return isNegative ? -Integer.parseUnsignedInt(source) : Integer.parseUnsignedInt(source);
            case 10:
                return getIntegerOrLong(source,isNegative);
            case 11,12,13,14,15,16,17,18:
                return isNegative ? -Long.parseUnsignedLong(source) : Long.parseUnsignedLong(source) ;
            case 19:
                return getLongOrBigNumber(source,isNegative);
            default:
                return new BigInteger(source);
        }
    }



    private Number getByteOrShort(String source, boolean isNegative) {
        short aShort = Short.parseShort(source);
        if(isNegative) {
            aShort = (short) -aShort;
            if(aShort >= Byte.MIN_VALUE) {
                return (byte) aShort;
            }
            return aShort;

        } else {
            if(aShort <= Byte.MAX_VALUE) {
                return (byte) aShort;
            }
            return aShort;
        }


    }

    private Number getShortOrInteger(String source, boolean isNegative) {
        int integer = Integer.parseUnsignedInt(source);
        if(isNegative) {
            integer = -integer;
            if(integer >= Short.MIN_VALUE) {
                return (short) integer;
            }
            return integer;
        } else {
            if(integer <= Short.MAX_VALUE) {
                return (short) integer;
            }
            return integer;
        }

    }

    private Number getIntegerOrLong(String source, boolean isNegative) {
        long aLong = Long.parseUnsignedLong(source);
        if(aLong <= Integer.MAX_VALUE) {
            return (int) aLong;
        }
        return aLong;
    }

    private Number getLongOrBigNumber(String source, boolean isNegative) {
        BigInteger bigInteger = new BigInteger(source);
        if(bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > -1) {
            return bigInteger.longValue();
        }
        return bigInteger;
    }


    /**
     * Gets Compact decimal Number of a source String.
     * @param source
     * @return Float,Double or BigDecimal
     */
    public Number parseDecimalNumber(final String source) {
        float aFloat = Float.parseFloat(source);
        if(aFloat == Float.POSITIVE_INFINITY) {
            double aDouble = Double.parseDouble(source);
            if(aDouble == Double.POSITIVE_INFINITY) {
                return new BigDecimal(source);
            }
            return aDouble;
        }

        return aFloat;
    }

}
