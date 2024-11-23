package com.demo.strings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String str) {
        // Split the string by one or more spaces, collapsing multiple spaces into a single delimiter
        String[] split = str.split("\\s+");

        // Use StringBuilder to build the reversed string
        StringBuilder sb = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        return sb.toString().trim();
    }
}