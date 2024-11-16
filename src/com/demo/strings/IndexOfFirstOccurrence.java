package com.demo.strings;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * haystack and needle consist of only lowercase English characters.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static int strStr(String haystack, String needle) {
        // If needle is an empty string, return 0 as per the problem description
        if (needle.isEmpty()) return 0;
        // length of both strings
        int n = haystack.length(), m = needle.length();
        // Iterate through haystack, check if the substring starting from each index matches needle
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;  // Found the first occurrence
            }
        }
        // If no match was found, return -1
        return -1;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
