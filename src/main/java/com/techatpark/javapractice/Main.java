package com.techatpark.javapractice;

import com.techatpark.javapractice.constants.ApplicationConstants;

import java.sql.Connection;

/**
 * Main Class.
 */
public final class Main {

    Connection connection;

    public Main(Connection connection) {
        System.out.println(connection);
    }
    /**
     * Say Hello.
     * @param name
     * @return Hellotext
     */
    public String sayHello(final String name) {
        return "Hello " + name + "! Welcome to " + ApplicationConstants.APPLICATION_NAME;
    }
}
