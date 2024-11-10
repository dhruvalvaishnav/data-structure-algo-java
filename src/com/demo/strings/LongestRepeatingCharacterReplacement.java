package com.demo.strings;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.

Constraints:
    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
 */

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(printLengthOfLongestSubstringWithKChange(s, k));
    }

    private static int printLengthOfLongestSubstringWithKChange(String s, int k) {
        // HashMap to store the frequency of each character in the window
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Left pointer for the sliding window
        int left = 0;
        // Variable to store the maximum frequency of a single character in the current window
        int maxFreq = 0;
        // Variable to store the length of the longest valid substring
        int maxLength = 0;

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Update the maximum frequency of a character in the current window
            maxFreq = Math.max(maxFreq, freqMap.get(rightChar));

            // If the current window size minus the max frequency is greater than k, shrink the window
            if (right - left + 1 - maxFreq > k) {
                // Shrink the window from the left
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            // Calculate the length of the current valid window and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
