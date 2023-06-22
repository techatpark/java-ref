package com.techatpark;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankService {
    // Lets assume that bank account number should be with
    // 14 digits (numeric) only It cannot contain 14 zeros,
    // it cannot be null, cannot be empty These are initial
    // level of validations, other than that for checking
    // whether valid unique number then bank database has to
    // be checked and there we need to check But in this
    // tutorial let us check only with initial level of
    // validations
    public boolean
    isValidAccountNumberMethod1(String accountNumber)
    {
        if (accountNumber == null
                || accountNumber.equalsIgnoreCase("")) {
            return false; // should be a valid number and it
            // cannot be null or ""
        }
        try {
            Long.parseLong(
                    accountNumber); // As account number is of
            // 14 digits, we need to go
            // with Long.parseLong only
            if (accountNumber.length() == 14) {
                int count = 0;
                for (int i = 0; i < accountNumber.length();
                     i++) {
                    if (accountNumber.charAt(i) == '0') {
                        count += 1;
                    }
                }
                if (count == 14) { // all digits are 0
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean
    isValidAccountNumberMethod2(String accountNumber)
    {
        if (accountNumber == null
                || accountNumber.equalsIgnoreCase("")) {
            return false; // should be a valid number and it
            // cannot be null or ""
        }
        if (accountNumber.length() == 14) {
            int count = 0;
            for (int i = 0; i < accountNumber.length();
                 i++) {
                // If we find the character is not a digit,
                // then it has to be returned false
                if (!Character.isDigit(
                        accountNumber.charAt(i))) {
                    return false;
                }
                if (accountNumber.charAt(i) == '0') {
                    count += 1;
                }
            }
            if (count == 14) { // all digits are 0
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public boolean
    isValidAccountNumberUsingRegularExpression(
            String accountNumber)
    {
        if (accountNumber == null
                || accountNumber.equalsIgnoreCase("")) {
            return false; // should be a valid number and it
            // cannot be null or ""
        }
        if (accountNumber.length() == 14) {
            int count = 0;
            String regularExpression
                    = "[0-9]+"; // Regular expression to check
            // for only digits Compile the
            // ReGex
            Pattern pattern
                    = Pattern.compile(regularExpression);
            Matcher matcher
                    = pattern.matcher(accountNumber);
            if (matcher.matches()) { // only when it matches
                for (int i = 0; i < accountNumber.length();
                     i++) {
                    if (accountNumber.charAt(i) == '0') {
                        count += 1;
                    }
                }
                if (count == 14) { // all digits are 0
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
