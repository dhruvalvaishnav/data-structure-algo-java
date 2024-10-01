package com.demo.dynamicProgramming;

import java.util.*;

public class PalindromeCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();
        int count = countPalindromicSubstrings(s);
        System.out.println("Count of Palindromic Substrings: " + count);
        // now print those palindromic substrings
        printPalindromicSubstrings(s);
        sc.close();
    }

    private static int countPalindromicSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes
            count += countPalindromesAroundCenter(s, i, i);
            // Count even-length palindromes
            count += countPalindromesAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private static int countPalindromesAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    private static void printPalindromicSubstrings(String input) {
        List<String> res = new ArrayList<>(); // Use a Set to avoid duplicates
        for (int i = 0; i < input.length(); i++) {
            // Odd length palindromes
            collectPalindromicSubstrings(input, i, i, res);
            // Even length palindromes
            collectPalindromicSubstrings(input, i, i + 1, res);
        }
        System.out.println("Palindromic Substrings: " + res);
    }

    private static void collectPalindromicSubstrings(String input, int left, int right, List<String> res) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            res.add(input.substring(left, right + 1)); // Add the found palindrome
            left--;
            right++;
        }
    }
}
