package com.demo.neetcode.twoPointers;

/*  A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
    it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static void main(String[] args) {

        String phrase = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(phrase));
    }

    public static boolean isPalindrome(String input) {
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < input.toLowerCase().toCharArray().length; i++) {
            if (Character.isLetterOrDigit(input.charAt(i))) {
                reverse.append(input.charAt(i));
            }
        }
        reverse = new StringBuilder(reverse.toString().toLowerCase());
        String val = reverse.toString();
        return val.equals(reverse.reverse().toString());
    }

}