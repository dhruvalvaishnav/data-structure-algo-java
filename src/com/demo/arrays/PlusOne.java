package com.demo.arrays;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 09-12-2024
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public static void main(String[] args) {
        System.out.println("Plus one of [1,2,3] is: " + Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println("Plus one of [4,3,2,1] is: " + Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println("Plus one of [9] is: " + Arrays.toString(plusOne(new int[]{9})));
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last element
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, simply add 1 and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, set it to 0 and carry over
            digits[i] = 0;
        }

        // If all digits were 9, we need to add a 1 at the beginning
        // Shift all digits to the right and set the first digit to 1
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

}
