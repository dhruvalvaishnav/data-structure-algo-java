package com.demo.Strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Dhruval";
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            result += c;
        }
        System.out.println(result);

        // using utility methods
        System.out.println(reverseUsingSBuilder("Virat"));
        System.out.println(reverseUsingSBuffer("Yuvraj"));

        //using pointers
        System.out.println(reverseUsingPointers("Sachin"));

    }

    private static String reverseUsingPointers(String input) {
        char[] charArray = input.toCharArray();
        int l = 0, r = charArray.length - 1;
        while (l < r) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(charArray);
    }

    //StringBuilder
    private static String reverseUsingSBuilder(String input) {
        StringBuilder reverse = new StringBuilder(input);
        return String.valueOf(reverse.reverse());
    }

    //StringBuffer
    private static String reverseUsingSBuffer(String input) {
        StringBuffer reverse = new StringBuffer(input);
        return String.valueOf(reverse.reverse());
    }
}