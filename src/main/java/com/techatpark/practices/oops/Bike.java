package com.techatpark.practices.oops;

public class Bike implements Vehicle {
    String color;
    int speed;
    int wheels;
    public Bike(String aColor) {
        color = aColor;
        wheels = 2;
    }

    @Override
    public void start() {
        System.out.println("Starting the bike ...");
    }

    public void applyBreak() {
        System.out.println("Break Applied ");
        speed = 0;
    }
}
