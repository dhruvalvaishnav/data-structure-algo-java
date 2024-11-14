package com.demo.strings;


/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 */
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeAllAdjacentDuplicates("azxxzy"));
        System.out.println(removeAllAdjacentDuplicates("abbaca"));

    }

    // using stack and checking the top and current chars
    private static String removeAllAdjacentDuplicates(String input) {
        if (input == null || input.isEmpty()) return input;

        char[] stack = new char[input.length()];
        int i = 0; // stack index

        for (char c : input.toCharArray()) {
            if (i > 0 && stack[i - 1] == c) {
                i--; // decrement the stack index
            } else {
                stack[i] = c;
                i++;
            }
        }

        return new String(stack, 0, i);
    }
}
