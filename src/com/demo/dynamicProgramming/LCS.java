package com.demo.dynamicProgramming;

// Longest Common Subsequence : https://leetcode.com/problems/longest-common-subsequence/
/*
    Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
    changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.

    Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

    Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

    Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.

    Constraints:
    1 <= text1.length, text2.length <= 1000
    text1 and text2 consist of only lowercase English characters.
 */

public class LCS {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
        System.out.println();
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
        System.out.println(longestCommonSubsequence2("abc", "abc"));
        System.out.println(longestCommonSubsequence2("abc", "def"));
    }

    // Iterative version
    public static int longestCommonSubsequence(String text1, String text2) {
        System.out.print("longest common subsequence between '" + text1 + "' and '" + text2 + "' is = ");

        //O(n*m)/O(n*m)  time/memory
        if (text1.isEmpty() || text2.isEmpty()) return 0;

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    //memoized version
    public static int longestCommonSubsequence2(String text1, String text2) {
        System.out.print("longest common subsequence between '" + text1 + "' and '" + text2 + "' is = ");

        int[][] dp = new int[text1.length()][text2.length()];
        return LCSImpl(text1, text2, 0, 0, dp);
    }

    public static int LCSImpl(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        else if (dp[i][j] != 0) return dp[i][j];
        else if (s1.charAt(i) == s2.charAt(j)) return (1 + LCSImpl(s1, s2, i + 1, j + 1, dp));
        else {
            dp[i][j] = Math.max(LCSImpl(s1, s2, i + 1, j, dp), LCSImpl(s1, s2, i, j + 1, dp));
            return dp[i][j];
        }
    }

}