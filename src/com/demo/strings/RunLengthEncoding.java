package com.demo.strings;

/*
    Run Length Encoding :

    For a string input the function returns output encoded as follows:

     "a" -> "a1"
     "aa" -> "a2"
     "aabbb" -> "a2b3"
     "aabbbaa" -> "a2b3a2"

*/
public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println(rle("aaabbbaad"));
        System.out.println(rle("a"));
        System.out.println(rle("aa"));
        System.out.println(rle("aabbb"));
        System.out.println(rle("aabbbaa"));
        System.out.println(rle("ZZaaDDDA"));
    }

    private static String rle(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int countOfChars = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                countOfChars++;
                i++;
            }
            result.append(input.charAt(i)).append(countOfChars);
        }
        return result.toString();
    }
}
