package com.demo.strings;

import java.util.*;

/*
     Given a string of letters and a dictionary, the function longestWord should find the longest word or words in the dictionary
     that can be made from the letters

     Input: letters = "oet", dictionary = {"to","toe","toes"}
     Output: {"toe"}

     Only lowercase letters will occur in the dictionary and the letters
     The length of letters will be between 1 and 10 characters, The solution should work well for a dictionary of over 100,000 words

 */
public class LongestWord {

    public static void main(String[] args) {
        //if only given the string array then use this method
        String[] array = new String[]{"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String input = "ogtdes";
        System.out.println(getLargestWordFromDictionary(array, input));

        String[] array2 = new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        String input2 = "toe";
        System.out.println(getLargestWordFromDictionary(array2, input2));

        String[] array3 = new String[]{"doe", "toe", "dog", "god"};
        String input3 = "oetdg";
        System.out.println(getLargestWordFromDictionary(array3, input3));


        // or else use this
        /*
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
        Dictionary dict2 = new Dictionary(new String[]{"doe", "toe", "dog", "god"});
//        Dictionary dict3 = new Dictionary(new String[]{"to", "banana", "toe", "dogs", "ababcd", "elephant"});

        System.out.println(longestWord("toe", dict));
        System.out.println(longestWord("oetdg", dict2));
//        System.out.println(longestWord("oet", dict3));
        */


    }

    private static String getLargestWordFromDictionary(String[] array, String input) {

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String resultString = "";

        // Create mapping for the characters in given input
        for (Character c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (String word : array) {
            int i = 0;

            HashMap<Character, Integer> frequencyMapClone = new HashMap<>(frequencyMap);

            while (i < word.length() && frequencyMapClone.getOrDefault(word.charAt(i), 0) > 0) {
                frequencyMapClone.put(word.charAt(i), frequencyMap.get(word.charAt(i)) - 1);
                i++;
            }

            if (i == word.length() && max < word.length()) {
                max = word.length();
                resultString = word;
            }
        }
        return resultString;
    }

    private static Set<String> longestWord(String letters, Dictionary dict) {
        Set<String> result = new HashSet<String>();
        if (dict.contains(letters)) {
            result.add(letters);
        }
        return result;
    }

}

class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}