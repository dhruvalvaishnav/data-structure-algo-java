package com.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/isomorphic-strings/

    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.

    Example 1:
    Input: s = "egg", t = "add"
    Output: true

    Example 2:
    Input: s = "foo", t = "bar"
    Output: false

    Example 3:
    Input: s = "paper", t = "title"
    Output: true

    Constraints:
    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("ab", "aa"));
        System.out.println(isIsomorphicWithOneMap("egg", "add"));
        System.out.println(isIsomorphicWithOneMap("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        System.out.print("The given string s : '" + s + "' and t : '" + t + "' isIsomorphic of each other ? : ");
        // two pointer approach with two maps

        // if both strings size are diff then false
        if (s.length() != t.length()) return false;

        // create two maps for both sides mapping
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if ((mapST.containsKey(c1) && mapST.get(c1) != c2)
                    || (mapTS.containsKey(c2) && mapTS.get(c2) != c1)) {
                return false;
            }
            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }
        return true;
        // Time complexity : O(n)
        // Space complexity : O(n)
    }

    public static boolean isIsomorphicWithOneMap(String s, String t) {
        System.out.print("The given string s : '" + s + "' and t : '" + t + "' isIsomorphic of each other ? : ");
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                // If c2 is already mapped to some other char, it's not isomorphic
                if (map.containsValue(c2)) return false;
                map.put(c1, c2);
            }
        }
        return true;
        // Time complexity : O(n)
        // Space complexity : O(n)
    }
}
