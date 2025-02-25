package com.demo.strings;

public class SwapCharsInStringWithoutChange {
    // Java program to demonstrate character swap using toCharArray().

    public static void main(String[] args) {
      //  String s = "geeksforgeeks";
        String s = "Dhruval";

        System.out.println(swap(s, 6, s.length() - 2));
        System.out.println(swap(s, 0, s.length() - 1));

        System.out.println(s);
    }

    private static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }
}
