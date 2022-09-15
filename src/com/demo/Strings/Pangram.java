package com.demo.Strings;

// The sentence "The quick brown fox jumps over the lazy dog" contains every single letter in the alphabet. Such sentences are called pangrams.
// write a function findMissingLetters, which takes a String sentence,
// and returns all the letters it is missing (which prevent it from being a pangram).
// You should ignore the case of the letters in sentence, and your return should be all lower case letters, in alphabetical order.
// you should also ignore all non US-ASCII characters.
// Test Cases:
// Input: The slow purple oryx meanders past the quiescent canine
// Output: bfgjkvz

import java.util.Arrays;

public class Pangram {

    public static void main(String[] args) {
        String input = "The slow purple oryx meanders past the quiescent canine";
//        Output: bfgjkvz
        System.out.println(findMissingLetters(input));

        // check if the given string is panagram or not :
        String str = "The quick brown fox jumps over the lazy dog";

        System.out.println(findMissingLetters(str));

        if (isPanagram(str)) {
            System.out.println("The given string is panagram!");
        } else {
            System.out.println("The given string is not panagram!");
        }

    }

    private static boolean isPanagram(String input) {
        input = input.trim().toLowerCase();

        if (input.length() < 26) return false;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (input.indexOf(ch) < 0) return false;
        }
        return true;
    }

    private static String findMissingLetters(String sentence) {
        System.out.print("Missing letters for panagram in given string : '" + sentence + "' => ");

        final int MAX_CHARS = 26;

        char[] charArray = sentence.trim().toLowerCase().toCharArray();
        int[] alphabeticChars = new int[26];

        for (char c : charArray) {
            if (c != ' ') alphabeticChars[c - 'a']++;
        }

//        System.out.println(Arrays.toString(alphabeticChars));

        String output = "";
        for (int i = 0; i < MAX_CHARS; i++) {
            if (alphabeticChars[i] == 0) {
                output += (char) (i + 'a');
            }
        }
        return output;
//        return output.length() > 0 ? output : "NO MISSING LETTERS, IT'S PANAGRAM!";
    }

}
