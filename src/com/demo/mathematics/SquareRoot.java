package com.demo.mathematics;

/*
    Returns square root of the given double

    Test Cases:
               Input1:  4
               Output1: 2

               Input2:  2
               Output2: 1.41421

 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(4));
        System.out.println(squareRoot(2));
        System.out.println(squareRoot(49));
        System.out.println(squareRoot(25));
        System.out.println(squareRoot(625));
        System.out.println(squareRoot(1225));
    }

    private static double squareRoot(double x) {
        System.out.print("square Root of " + x + " is = ");
        return Math.sqrt(x);
    }

}
