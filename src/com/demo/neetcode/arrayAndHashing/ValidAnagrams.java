package com.demo.neetcode.arrayAndHashing;

import java.util.*;

/*
*   Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.
 */
public class ValidAnagrams {
    public static void main(String[] args) {

        String s1 = "rat";
        String s2 = "car";

//        String s1 = "anagram";
//        String s2 = "nagaram";

       // System.out.println(isAnagramUsingArray(s1, s2));

        if (isAnagramUsingHashMap(s1, s2)) {
            if ((isAnagramUsingArray(s1, s2))) {
                System.out.println("Given two strings are anagrams");
            }
        } else {
            System.out.println("Given two strings are not anagrams");
        }
    }

    private static boolean isAnagramUsingHashMap(String s, String t) {
        // These are basically frequency maps for each character in the strings
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            // If the character is already in the map, increment the frequency
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }
            sMap.put(s.charAt(i), 1);
            tMap.put(t.charAt(i), 1);
        }

        for (Character c : sMap.keySet()) {
            // Check if the frequency of each character in s matches the frequency in t
            if (!sMap.get(c).equals(tMap.get(c))) {
                return false;
            }
        }
        return true;
        // Time complexity: O(n)
        // Space complexity: O(n)
    }

    public static boolean isAnagramUsingArray(String s, String t) {
        //if both length are not equal then false
        if (s.length() != t.length()) return false;

        //make int array to store the alphabetic chars - 26 - a to z
        final int[] store = new int[26];

        // loop on the first string and add the chars in the both array
        // s --> and <-- t
        for (int i = 0; i < s.length(); i++) {
            // increment the value of the char in the array, if it is in s, decrement if it is in t
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(store));

        for (int n : store) {
            // check of integer in array not equals, why not equals because we have incremented and decremented the values
            if (n != 0) return false;
        }
        return true;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
}
