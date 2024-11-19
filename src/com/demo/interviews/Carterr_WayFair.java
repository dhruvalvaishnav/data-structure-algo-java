package com.demo.interviews;

import java.math.BigInteger;

/**
 * @author Dhruval Vaishnav Created on 19-11-2024
 */
public class Carterr_WayFair {
    public static void main(String[] args) {
        System.out.println(getSumofTwoLargeNumbersInString("123", "456"));
        System.out.println(getSumofTwoLargeNumbersInString("896", "104523120000"));
        System.out.println(getSumofTwoLargeNumbersInString("1234567881", "9876543210"));
        System.out.println(getSumUsingBigInteger("1234567881", "9876543210"));
    }

    private static String getSumofTwoLargeNumbersInString(String a1, String a2) {
        int l1 = a1.length(); // length of first string
        int l2 = a2.length(); // length of second string
        int maxLen = Math.max(l1, l2); // maximum length from both strings
        StringBuilder result = new StringBuilder();
        int carry = 0; // carry to store the sum of two digits

        // iterate over the maximum length of both strings
        for (int i = 0; i < maxLen; i++) {
            /* (here l1-1-i is used to get the digit from the end of the string
             and -'0' is used to convert the character to integer, so '1' will be converted to 1) */

            // get the digit from the end of the string and convert it to integer
            int digit1 = i < l1 ? a1.charAt(l1 - 1 - i) - '0' : 0;
            // get the digit from the end of the string and convert it to integer
            int digit2 = i < l2 ? a2.charAt(l2 - 1 - i) - '0' : 0;

            // sum of two digits and carry from the previous sum
            int sum = digit1 + digit2 + carry;
            // append the sum of two digits to the result, so if sum is 12, then append 2 to the result
            result.append(sum % 10);
            // calculate the carry if sum is greater than 10, so carry will be 1
            carry = sum / 10;
        }

        // if carry is not zero, append it to the result
        // for example, if the sum of two digits is 9+9=18, then 8 will be appended to the result and carry will be 1
        if (carry != 0) {
            result.append(carry);
        }

        // return the result after reversing it
        return result.reverse().toString();
    }

    private static BigInteger getSumUsingBigInteger(String a1, String a2) {
        return new BigInteger(a1).add(new BigInteger(a2));
    }
}
