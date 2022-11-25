package com.demo.Strings;

import java.util.*;

/*
    Given an array A of strings made only from lowercase letters,
    return a list of all characters that show up in all strings within the list (including duplicates).

    For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
    You may return the answer in any order.

    Example 1:
    Input: ["bella","label","roller"] Output: ["e","l","l"]

    Example 2:
    Input: ["cool","lock","cook"] Output: ["c","o"]

    Note:
    1 <= A.length <= 100
    1 <= A[i].length <= 100

    A[i][j] is a lowercase letter

 */
public class CommonCharBetweenString {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
    }

    private static List<String> commonChars(String[] A) {
        List<String> common_chars = new ArrayList<>();

        int[] min_frequencies = new int[26];
        Arrays.fill(min_frequencies, Integer.MAX_VALUE);

        for (String current_string : A) {
            int[] char_frequencies = new int[26];

            for (char c : current_string.toCharArray()) {
                char_frequencies[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                min_frequencies[i] = Math.min(min_frequencies[i], char_frequencies[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (min_frequencies[i] > 0) {
                common_chars.add("" + (char) (i + 'a'));
                min_frequencies[i]--;
            }
        }
        return common_chars;
    }
}
