package com.demo.assessmenttest;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 22-10-2024
 */
public class Mobiquity {
    public static void main(String[] args) {
        //fizzBuzz(15); // Change this to the desired limit
        System.out.println("smallest positive number from array: " + smallestPositiveNumberFromArray(new int[]{1, 3, 6, 4, 1, 2}));
    }

    public static int smallestPositiveNumberFromArray(int[] arr) {
        // find the smallest positive number from array
        Arrays.sort(arr);
        int smallest = 1;
        for (int j : arr) {
            if (j == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    // Fix this method as per test cases
    public static void fizzBuzz(int limit) {
        for (int n = 1; n <= limit; n++) {
            if (n % 3 == 0 && n % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (n % 3 == 0) {
                System.out.println("Fizz");
            } else if (n % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(n);
            }
        }
    }

}

    


