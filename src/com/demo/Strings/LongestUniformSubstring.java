package com.demo.Strings;

import java.util.Arrays;

/*
    This method should return an integer array with two elements that correctly identifies the location of the longest
    uniform substring within the input string.
    The first element of the array should be the starting index of the longest
    substring and the second element should be the length.

    input: "abbbccda" the longest uniform substring is “bbb” (which starts at index 1 and is 3 characters long.

    Test Cases –
    Input : aabbbbbCdAA
    Output – [2,5]

    Input : 10000111
    Output – [1, 4]

 */
public class LongestUniformSubstring {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestUniformSubstring("abbbccda")));
        System.out.println(Arrays.toString(longestUniformSubstring("aabbbbbCdAA")));
        System.out.println(Arrays.toString(longestUniformSubstring("10000111")));
        System.out.println(Arrays.toString(longestUniformSubstring("")));
        System.out.println(Arrays.toString(longestUniformSubstring("a")));
    }

    private static int[] longestUniformSubstring(String input) {
        //The first element of the array should be the starting index of the longest substring
        // The second element should be the length.

        System.out.print("Indexes for the string : '" + input + "' - the longest uniform substring is = ");

        if (input.length() == 0) return new int[]{-1, 0};
        if (input.length() == 1) return new int[]{0, 1};

        int idx = -1, count = 1, maxCount = 0, i;

        // loop starts from i = 1 to < length()
        for (i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    idx = i - maxCount;
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            idx = i - maxCount;
        }
        return new int[]{idx, maxCount};
    }
}