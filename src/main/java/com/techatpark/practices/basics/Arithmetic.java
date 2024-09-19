package com.techatpark.practices.basics;

public class Arithmetic {

    public static int add(int i, int j) {
        return i+j;
    }

    public static int findSum(int n) {
        return n*(n+1)/2;
    }

    public static int getSum(int n) {
        int sum = 0;
        for(int j=1; j<=n;j++) {
            sum+=j; // sum = sum + j
        }
        return sum;
    }

    public static boolean isEven(int n) {
        if( n%2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {

        /*System.out.println(add(10,20));
        System.out.println(add(40,50));*/
        System.out.println(getSum(99999999));
        System.out.println(isEven(5));
        System.out.println(isEven(8));

    }
}
