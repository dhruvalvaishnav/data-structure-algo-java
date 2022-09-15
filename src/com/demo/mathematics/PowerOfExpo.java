package com.demo.mathematics;

/*
    Power of Expo ( Math.pow)

    Given base and integer exponent, compute value of base raised to the power of exponent.

    Test Cases:
        Input: 2.0, 4
        Output: 16.0

 */
public class PowerOfExpo {
    public static void main(String[] args) {
        System.out.println(power(2.0, 4));
        System.out.println(power(6.0, 2));
        System.out.println(power(4.0, 3));
        System.out.println(power(3.0, 2));
        System.out.println(power(0.0, 0));
        System.out.println(power(2.0, 0));
        System.out.println(power(2.0, 1));
    }

    public static double power(double base, int exp) {
        System.out.print(base + " ^ " + exp + " = ");
        return Math.pow(base, exp);
    }

}
