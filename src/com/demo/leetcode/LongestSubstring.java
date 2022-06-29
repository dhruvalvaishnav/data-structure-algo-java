package com.demo.leetcode;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        //abc - 3
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            // there are 256 ASCII characters. This includes standard ASCII characters(0-127)
            boolean[] visited = new boolean[256];
            for (int j = i; j < str.length(); j++) {
                if (visited[str.charAt(j)]) break;
                else {
                    result = Math.max(result, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return result;
    }
}

/*
        Longest Substring Without Repeating Characters
        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

* */