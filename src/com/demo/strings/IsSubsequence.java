package com.demo.strings;

/* https://leetcode.com/problems/is-subsequence/

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by
    deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false

 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); //true
        System.out.println(isSubsequence("axc", "ahbgdc")); //false
        System.out.println(isSubsequence("dhr", "aghgjgjdiuilkjuhouour9uiy")); // true
    }

    public static boolean isSubsequence(String s, String t) {
        System.out.print("The given string s : '" + s + "' and t : '" + t + "' isSubsequence of each other ? : ");
        // two pointer approach
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            // if character matches move subsequent pointer
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // always move main pointer
            j++;
        }
        // if we have all chars in s, it's subsequent
        return (i == s.length());
    }
}
