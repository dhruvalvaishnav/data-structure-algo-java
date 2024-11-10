package com.demo.strings;

import java.util.Arrays;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {

        System.out.println(removeConsecutiveDuplicates("aaaaabbbbbb"));
        System.out.println(removeConsecutiveDuplicates("geeksforgeeks"));
        System.out.println(removeConsecutiveDuplicates("aabccba"));
        System.out.println(removeConsecutiveDuplicates("test"));
        System.out.println(removeConsecutiveDuplicates("testttttttttinngggg"));
        System.out.println(removeConsecutiveDuplicates("unnecessary"));


    }

    private static String removeConsecutiveDuplicates1(String input) {
        if (input == null || input.isEmpty()) return input; // Return input as is, if it's null or empty.

        StringBuilder sb = new StringBuilder();
        char lastChar = input.charAt(0);
        sb.append(lastChar);
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != lastChar) {
                sb.append(current);
            }
        }
        return sb.toString();
    }

    private static String removeConsecutiveDuplicates(String input) {
        if (input == null || input.isEmpty()) return input; // Return input as is, if it's null or empty.
        char[] charArray = input.toCharArray();
        int n = charArray.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (charArray[i] != charArray[j]) {
                j++;
                charArray[j] = charArray[i];
            }
        }
        char[] out = Arrays.copyOfRange(charArray, 0, j + 1);
        return String.valueOf(out);
    }


}



