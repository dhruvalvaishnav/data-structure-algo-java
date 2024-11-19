package com.demo.strings;

import java.util.Stack;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and
 * removing them, causing the left and the right side of the deleted substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * <p>
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * <p>
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicates2 {
    public static void main(String[] args) {

        System.out.println("Answer 1 : " + removeDuplicates("caabbbacc", 3));
        System.out.println("Answer 2 : " + removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println("Answer 3 : " + removeDuplicates("pbbcggttciiippooaais", 2));
    }

    public static String removeDuplicates(String s, int k) {
        // Stack to store pairs of character and its count
        Stack<int[]> stack = new Stack<>();

        // Traverse through the string
        for (char c : s.toCharArray()) {
            // If the stack is empty or the current character is different, push to stack
            if (stack.isEmpty() || stack.peek()[0] != c) {
                stack.push(new int[]{c, 1});
            } else {
                // If the current character matches the stack top, increment count
                int[] top = stack.peek();
                top[1]++;

                // If count reaches k, pop from the stack (remove duplicates)
                if (top[1] == k) {
                    stack.pop();
                }
            }
        }

        // Rebuild the string from the stack
        StringBuilder result = new StringBuilder();
        for (int[] pair : stack) {
            result.append(String.valueOf((char) pair[0]).repeat(Math.max(0, pair[1])));
        }

        if (result.length() == 0) return "";
        return result.toString();
    }
}
