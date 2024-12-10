package com.demo.strings;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 09-12-2024
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * <p>
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * <p>
 * Constraints:
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3")); // 6
        System.out.println(multiply("0", "3")); // 0
        System.out.println(multiply("123", "456")); // 56088
    }

    public static String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the result is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Result array with maximum possible size
        int[] arr = new int[num1.length() + num2.length()];

        // Reverse the strings to make calculation easier
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Multiply each digit of num1 by each digit of num2
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                // Get the numeric value of each digit
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                arr[i + j] += digit1 * digit2; // Multiply and add to the corresponding position in the result array
                arr[i + j + 1] += arr[i + j] / 10; // Handle carry-over to the next position
                arr[i + j] = arr[i + j] % 10;
            }
        }
        // Construct the result string from the array
        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            // Skip leading zeros
            if (!(result.length() == 0 && arr[i] == 0)) {
                result.append(arr[i]);
            }
        }
        return result.toString();
    }
}






