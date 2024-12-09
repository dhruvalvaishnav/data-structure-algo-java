package com.demo.interviews.interview2024;

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
        StringBuilder sb = new StringBuilder();
        int left = a.length() - 1, right = b.length() - 1, carry = 0;

        while (left >= 0 || right >= 0 || carry > 0) {
            int num1 = left >= 0 ? (int) a.charAt(left) - '0' : 0;
            int num2 = right >= 0 ? (int) b.charAt(right) - '0' : 0;
            int currSum = num1 + num2 + carry;

            carry = currSum / 10; // carry will be 1 if sum is greater than 10
            sb.append(currSum % 10);

            left--;
            right--;
        }

        return sb.reverse().toString();
    }
}
