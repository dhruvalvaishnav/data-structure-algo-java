package com.demo.Strings;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-palindrome/

    Given a string s which consists of lowercase or uppercase letters, return the length of the
    longest palindrome that can be built with those letters.

    Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.

    Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

    Example 2:
    Input: s = "a"
    Output: 1
    Explanation: The longest palindrome that can be built is "a", whose length is 1.

    Constraints:
    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("Aa"));
        System.out.println(longestPalindrome("abccccdd"));

    }

    public static int longestPalindrome(String s) {
        System.out.print("The longest palindrome from the given string '" + s + "' is = ");
        // form a map of each char occurrences java 8
//        LinkedHashMap<Character, Long> map = s.chars().mapToObj(x -> Character.toLowerCase(Character.valueOf((char) x)))
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//        System.out.println(map);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int result = 0;
        boolean odd_found = false;

        for (int val : map.values()) {
            // even chars
            if (val % 2 == 0) result += val;
            else { // odd chars
                odd_found = true;
                result += val - 1;
            }
        }
        // add one odd char in center
        if (odd_found) result++;
        return result;
    }
}
