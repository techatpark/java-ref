package com.techatpark.practices.oops;

public class Car implements Vehicle {
    String brand;
    String color;
    int speed;
    public Car(String aColor, String aBrand) {
        color = aColor;
        brand = aBrand;
    }
    public void applyAcc(int speed) {
        this.speed += speed;
        System.out.println("Speed :" + this.speed);
    }
    @Override
    public void start() {
        System.out.println("Starting .." + brand + " With color " + color + " in the speed " + speed);
    }
    public void stop() {
        speed = 0;
        System.out.println("Stopped");
    }


}
