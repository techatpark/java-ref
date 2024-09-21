package com.techatpark.practices.oops;

public class MyVechiles {



    public static void main(String[] args) {
        Vehicle bmw = new Car("White", "BMW");
        Vehicle maruti80 = new Car("Red", "Maruti");

        bmw.start();
//        bmw.applyAcc(100);
//        bmw.stop();

        maruti80.start();;
//        maruti80.stop();
//
        Bike hero = new Bike("Black");
        hero.start();;
        hero.applyBreak();;
    }
}

