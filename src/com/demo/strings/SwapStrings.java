package com.demo.strings;

// Swap two Strings Without Using any Third Variable
public class SwapStrings {
    public static void main(String[] args) {

        // Declare two strings
        String a = "Hello";
        String b = "World";

        a = a + b;

        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());

        System.out.println(a);
        System.out.println(b);
    }
}
