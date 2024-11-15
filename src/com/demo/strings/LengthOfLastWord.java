package com.demo.strings;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * <p>
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 */
//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello world")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
    }

    public static int lengthOfLastWord(String s) {
        //1
//        int len = 0;
//        String[] arr = s.split(" ");
//        for (int i = arr.length - 1; i >= 0; i--) {
//            String last = arr[i];
//            len = last.length();
//            break;
//        }
//        return len;

        // 2.
        int i = s.length() - 1, len = 0;

        // Skip any trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }
}
