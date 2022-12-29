package com.demo.interviews;

/*
    Given a string s, return the longest palindromic substring in s.

    Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

    Example 2:
    Input: s = "cbbd"
    Output: "bb"

    Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letter

 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));

    }

    public static String longestPalindrome(String s) {
        // Expand from centre approach
        // Time - O(n^2)
        // Space - O(1)
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) { // O(n)
            int len1 = expandFromCenter(s, i, i + 1); // O(n)
            int len2 = expandFromCenter(s, i, i); // O(n)
            int len = Math.max(len1, len2);
            if (((end - start) + 1) < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}


/*
        String res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd - "babad"
            if (s.length() % 2 != 0) {
                int start = i, end = i;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    if ((end - start + 1) > resLen) {
                        res = s.substring(start, end + 1);
                        resLen = end - start + 1;
                    }
                    start--;
                    end++;
                }
            } else {
                // even - "cbbd"
                int start = i, end = i + 1;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    if ((end - start + 1) > resLen) {
                        res = s.substring(start, end + 1);
                        resLen = end - start + 1;
                    }
                    start--;
                    end++;
                }
            }
        }
        return res;

        */