package com.demo.mathematics;

/**
 * @author Dhruval Vaishnav Created on 10-12-2024
 */
public class MathOperations {
    public static void main(String[] args) {
        System.out.println(sum(123)); // 1 + 2 + 3 = 6
        System.out.println(subtract(121)); // 1-2-1 = -2
        System.out.println(subtract(67)); // 6-7 = -1
        System.out.println(subtract(99)); // 9-9 = 0
        System.out.println(mul(54)); // 5 * 4 = 20
        System.out.println(divide(36)); // 3 / 6 = 0.5
    }

    private static int sum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Get last digit
            sum += digit;
            num /= 10; // Remove last digit
        }
        return sum;
    }

    private static int mul(int num) {
        int mul = 1;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {  // Prevent multiplication by 0
                mul *= digit;
            }
            num /= 10;
        }
        return mul;
    }

    private static double divide(int num) {
        double div = 1.0;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {  // Prevent division by 0
                div /= digit;
            } else {
                System.out.println("Division by 0 is not allowed");
            }
            num /= 10;
        }
        return div;
    }

    private static int subtract(int num) {
        String numStr = String.valueOf(num); // Convert number to string
        int result = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i)); // Get digit at index i
            if (i == 0) {
                result = digit;
            } else {
                result -= digit;
            }
        }
        return result;
    }
}
