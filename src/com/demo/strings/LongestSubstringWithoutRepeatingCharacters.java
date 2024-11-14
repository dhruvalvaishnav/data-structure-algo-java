package com.demo.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        //abc - 3
        //System.out.println(lengthOfLongestSubstringBruteForce(s));
        System.out.println(lengthOfLongestSubstringHashSet(s));
    }

    private static int lengthOfLongestSubstringHashSet(String input) {
        // Set to store the characters in the current window
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < input.length(); right++) {
            // If the character is in the set, move the left pointer to the right of the previous occurrence
            while (set.contains(input.charAt(right))) {
                set.remove(input.charAt(right));
                left++;
            }
            // Add the current character to the set
            set.add(input.charAt(right));
            // Update the maximum length of substring without repeating characters
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    public static int lengthOfLongestSubstringBruteForce(String str) {
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