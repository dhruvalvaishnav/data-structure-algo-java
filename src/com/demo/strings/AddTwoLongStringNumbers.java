package com.demo.strings;

/**
 * @author Dhruval Vaishnav Created on 09-12-2024
 * <p>
 * // Write a function, add, which adds two large numbers together and returns their sum:
 * // Returns sum of two numbers : String add(String a, String b)
 * <p>
 * - Inputs to the add function are two numbers, represented as strings
 * - Output of the add function is a single string representing the sum of the inputs
 * - Only positive integers need to be supported
 * - Input numbers can be very large, with 100 digits or more.
 * - This negates the ability to convert the entirety of the strings to integers and simply add them together in a 32/64-bit system.
 */
public class AddTwoLongStringNumbers {
    public static void main(String[] args) {
        // System.out.println(add("12300045", "10000005"));
        System.out.println(add("5", "5"));
        // System.out.println(add("12300045", "10000000"));
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder(); // to store the result
        int len1 = a.length() - 1, len2 = b.length() - 1, carry = 0; // carry is initially 0

        // loop through the strings from right to left
        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            // get the last digit of the strings and convert it to integer
            int num1 = len1 >= 0 ? (int) a.charAt(len1) - '0' : 0;
            int num2 = len2 >= 0 ? (int) b.charAt(len2) - '0' : 0;
            int currSum = num1 + num2 + carry; // sum of the digits

            carry = currSum / 10; // carry will be 1 if sum is greater than 10
            sb.append(currSum % 10); // append the last digit of the sum to the result

            len1--;
            len2--;
        }
        return sb.reverse().toString(); // return the result
    }
}
