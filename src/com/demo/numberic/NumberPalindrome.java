package com.demo.numberic;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(checkIntegerPalindrome(100));    //false
        System.out.println(checkIntegerPalindrome(101));    //true
        System.out.println(checkIntegerPalindrome(500045));   //false
        System.out.println(checkIntegerPalindrome(50005));  //true
        System.out.println(checkIntegerPalindrome(20002));  //true
    }

    private static boolean checkIntegerPalindrome(int number) {
        boolean isPalindrome = false;
        if (number == reverse(number)) {
            return true;
        }
        return false;
    }

    private static int reverse(int number) {
        int reverse = 0, remainder = 0;
        do {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        } while (number > 0);
        return reverse;
    }
}
