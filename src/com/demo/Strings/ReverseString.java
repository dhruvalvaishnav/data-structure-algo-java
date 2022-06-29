package com.demo.Strings;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Dhruval";
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            result += c;
        }
        System.out.println(result);
    }
}

//StringBuffer
//StringBuilder
