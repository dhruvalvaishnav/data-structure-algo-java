package com.demo.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        //abc - 3
        //System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringSlidingWindow(s));
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
        // time complexity :
        //
    }

    //using sliding window
    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        int left = 0, maxLength = 0, n = s.length();
        Map<Character, Integer> seen = new HashMap<>(); // to store the position of the character

        for (int right = 0; right < n; right++) {
            // If the character has been seen and its position is greater than or equal to 'left', update 'left'
            if (seen.containsKey(s.charAt(right))) {
                // move left pointer to the right of the last occurrence of the character
                left = Math.max(left, seen.get(s.charAt(right)) + 1);
            }

            // Update the position of the current character
            seen.put(s.charAt(right), right);

            // Update maxLength with the size of the current window
            // (right - left + 1) + 1 because right is 0 based index, and we need to add 1 to get the length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
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