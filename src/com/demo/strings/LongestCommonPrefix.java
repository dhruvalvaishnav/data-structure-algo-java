package com.demo.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    // using  Divide and Conquer Approach
    // This approach splits the list of strings into two halves and recursively finds the longest common prefix for each half.
    // Then, it combines the results.
    // This approach reduces the number of comparisons and is more efficient than checking each character for every string.
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return longestCommonPrefixHelper(strs, 0, strs.length - 1);

    }

    // The longestCommonPrefixHelper method recursively divides the array into two halves
    // and computes the common prefix for each half. Then it merges the results using the commonPrefix helper method.
    private static String longestCommonPrefixHelper(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String leftPrefix = longestCommonPrefixHelper(strs, left, mid);
        String rightPrefix = longestCommonPrefixHelper(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLength);
    }

    // The time complexity of this solution is O(S), where S is the sum of all characters in all the strings.
    // This is because, in the worst case, we are examining each character of each string.
}
