package com.demo.mathematics;

/*
    Returns true if x is a power-of-10. Otherwise, returns false.

    Test Cases:
           INPUT:
           Input1: 3
           Output1: false

           Input1: 10
           Output1: true

 */
public class IsPowerOf10 {
    public static void main(String[] args) {
        System.out.println("is 3 power of 10 ? : " + isPowerOf10(3));
        System.out.println("is 10 power of 10 ? : " + isPowerOf10(10));
        System.out.println("is 15 power of 10 ? : " + isPowerOf10(15));
        System.out.println("is 33 power of 10 ? : " + isPowerOf10(33));
        System.out.println("is 20 power of 10 ? : " + isPowerOf10(20));
    }

    private static boolean isPowerOf10(int x) {
        return x % 10 == 0;
    }
}
