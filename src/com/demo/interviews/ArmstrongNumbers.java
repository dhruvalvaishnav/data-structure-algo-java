package com.demo.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Given a number x, determine whether the given number is Armstrong number or not.
// ARMSTRONG :: A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if.
//  abcd… = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ….

public class ArmstrongNumbers {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter a number :: ");
//        int number = sc.nextInt();
//        System.out.println(isArmstrong(number));

        List<Integer> numbers = Arrays.asList(123, 153, 1253, 90, 1634, 999);
        for (Integer n : numbers) {
            if (isArmstrongForNDigits(n)) {
//                System.out.println(n + " - is an Armstrong Number");
                System.out.println(n + " - Yes");
            } else {
//                System.out.println(n + " - is not an Armstrong Number");
                System.out.println(n + " - No");
            }
        }

//        System.out.println(isArmstrongForThreeDigits(153));
//        System.out.println(isArmstrongForThreeDigits(1634));
    }

    private static boolean isArmstrongForNDigits(int input) {
        int result = 0, count = 0;
        for (int temp = input; temp != 0; count++) {
            temp = temp / 10;
        }
        for (int temp = input; temp != 0; temp = temp / 10) {
            int remainder = temp % 10;
            result += Math.pow(remainder, count);
        }
        return input == result;
    }

    private static boolean isArmstrongForThreeDigits(int number) {

//        First count number digits (or find order).
//        Let the number of digits be n. For every digit r in input number x, compute r^n.
//        If sum of all such values is equal to n, then return true, else false.

        int temp = number, p = 0;
        while (number > 0) {
            int rem = number % 10;
            p = (p) + (rem * rem * rem);
            number = number / 10;
//            System.out.println("rem " + rem);
//            System.out.println("p " + p);
        }
        return temp == p;
    }
}
