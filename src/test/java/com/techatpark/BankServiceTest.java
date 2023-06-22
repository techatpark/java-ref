package com.techatpark;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {
    @DisplayName("Test check for Invalid bank account")
    @Test
    public void testCheckForInvalidBankAccountNumber() {
        BankService bankAccountNumberServicesObject = new BankService();
//        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod1(null));
//        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod1(""));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod1("00000000000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod1("SA123450000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod1("1234567"));
        // Using Method 2
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod2(null));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod2(""));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod2("00000000000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod2("SA123450000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberMethod2("1234567"));
        // Using regular expression check
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression(null));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression(""));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("00000000000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("SA123450000000"));
        assertEquals(false, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("1234567"));
    }

    @DisplayName("Test check for Valid bank account")
    @Test
    public void testCheckForvalidBankAccountNumber() {
        BankService bankAccountNumberServicesObject = new BankService();
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod1("12345678901234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod1("11223344551234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod1("11022033012346"));
        // Using method 2
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod2("12345678901234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod2("11223344551234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberMethod2("11022033012346"));
        // Using regular expression check
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("12345678901234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("11223344551234"));
        assertEquals(true, bankAccountNumberServicesObject.isValidAccountNumberUsingRegularExpression("11022033012346"));

    }
}