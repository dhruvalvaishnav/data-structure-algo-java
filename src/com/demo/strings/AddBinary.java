package com.demo.strings;

/**
 * @author Dhruval Vaishnav Created on 10-12-2024
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
//https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("1010", "1011")); // 10101
        System.out.println(addBinary("11", "11")); // 110
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        //reverse the strings
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        // loop until max length of a or b
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int digitA = i < a.length() ? a.charAt(i) - '0' : 0;
            int digitB = i < b.length() ? b.charAt(i) - '0' : 0;

            int total = digitA + digitB + carry;
            sb.append(total % 2); // because we are adding binary numbers
            carry = total / 2; // carry will be 1 if total is 2 or more
        }
        // if carry is still left
        if (carry > 0) {
            sb.append(carry);
        }
        // reverse the string and return
        return sb.reverse().toString();
    }
}
