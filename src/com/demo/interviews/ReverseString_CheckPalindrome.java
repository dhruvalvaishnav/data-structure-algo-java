package com.demo.interviews;

public class ReverseString_CheckPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome(393));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("dhruv"));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(347833));
    }

    private static boolean isPalindrome(Object o) {

        if (o instanceof Integer) {
            if ((int) o > 0 && o.equals(reverse((Integer) o))) {
                return true;
            }
        }

        if (o instanceof String) {
            if (((String) o).equalsIgnoreCase(reverseString((String) o))) {
                return true;
            }
        }

        return false;
    }

    private static String reverseString(String str) {
        char[] charArray = str.trim().toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }

    private static int reverse(int num) {
        int reverse = 0, reminder = 0;
        do {
            reminder = num % 10;
            reverse = reverse * 10 + reminder;
            num = num / 10;
        } while (num > 0);
        return reverse;
    }
}
