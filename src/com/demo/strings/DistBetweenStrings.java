package com.demo.strings;

// Given two words returns the shortest distance between their two midpoints in number of characters,
// words can appear multiple times in any order and should be case in-sensitive.
public class DistBetweenStrings {
    public static void main(String[] args) {
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        System.out.println("Shortest distance between strings are : " + shortestDistance(document, "is", "a"));
    }

    public static double shortestDistance(String document, String word1, String word2) {
        final String[] words = document.split("[,. ]");

        int wordCount = 0;
        double wordOneCount = 0, wordTwoCount = 0, shortestDistance = Double.MAX_VALUE;

        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) wordOneCount = wordCount + (word.length() / 2d);
            else if (word.equalsIgnoreCase(word2)) wordTwoCount = wordCount + (word.length() / 2d);

            if (wordOneCount > 0 && wordTwoCount > 0) {
                shortestDistance = Math.min(shortestDistance, Math.abs(wordTwoCount - wordOneCount));
            }

            wordCount += word.length() + 1;
        }
        System.out.printf("Word1 : %s, word2: %s, distance: %s%n", word1, word2, shortestDistance);

        return shortestDistance;
    }

}

// eg :
// String document = “In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements”.
// shortestDistance(document, "is", "a"); == 2.5