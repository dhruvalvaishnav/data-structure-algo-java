package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        String str = "MCMIV";
        System.out.println("Roman value '" + str + "' to int is :  " + convertRomanToInt(str));
        // by hashmap
        System.out.println("Roman value '" + str + "' to int is :  " + romanToInt(str));
    }

    private static int convertRomanToInt(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = intValue(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = intValue(str.charAt(i + 1));

                if (s1 >= s2) result += s1;
                else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
            }
        }
        return result;
    }

    private static int intValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return -1;
    }

    //using HashMap
    private static final Map<Character, Integer> roman = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // Get the current Roman numeral
            char current = s.charAt(i);
            // If we're not at the last character, check the next character
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                // If current is less than next, subtract current from next
                if (roman.get(current) < roman.get(next)) {
                    sum += roman.get(next) - roman.get(current);
                    i++; // Skip the next character since we already processed it
                } else {
                    sum += roman.get(current);
                }
            } else {
                // For the last character, just add it
                sum += roman.get(current);
            }
        }
        return sum;
    }
}
