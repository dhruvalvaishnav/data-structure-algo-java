package com.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * Example 2:
 * Input: n = 2
 * Output: false
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        if (isHappy(n)) {
            System.out.println("The number " + n + " is a happy number.");
        } else {
            System.out.println("The number " + n + " is not a happy number.");
        }
    }

    public static boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = sumOfSquare(n);

            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private static int sumOfSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // Extract the last digit
            sum += digit * digit; // Add its square to the sum
            n /= 10; // remove the last digit
        }
        return sum;
    }
}
