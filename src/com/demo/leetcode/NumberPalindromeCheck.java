package com.demo.leetcode;

public class NumberPalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome(393));
    }

    public static boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        if (x >= 0 && x == reverse(x)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    public static int reverse(int num) {
        //39
        int reverse = 0, remainder = 0;
        do {
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }
        while (num > 0);
        return reverse;
    }
}