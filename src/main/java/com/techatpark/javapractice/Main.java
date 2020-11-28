package com.techatpark.javapractice;

import com.techatpark.javapractice.constants.ApplicationConstants;

/**
 * Main Class.
 */
public final class Main {
    /**
     * Say Hello.
     * @param name
     * @return Hellotext
     */
    public String sayHello(final String name) {
        return "Hello " + name + "! Welcome to " + ApplicationConstants.APPLICATION_NAME;
    }
}
