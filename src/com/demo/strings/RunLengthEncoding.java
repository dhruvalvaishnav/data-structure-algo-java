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
        System.out.println(rle1("aaabbbaad"));
        System.out.println(rle1("a"));
        System.out.println(rle1("aa"));
        System.out.println(rle1("aabbb"));
        System.out.println(rle1("aabbbaa"));
        System.out.println(rle2("ZZaaDDDA"));
        System.out.println(rle2("XXXTTsUUUUUUFFF"));
    }

    private static String rle1(String input) {
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

    private static String rle2(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int countOfChars = 1;

        for (int i = 1; i <= input.length(); i++) {
            if (i < input.length() && input.charAt(i) == currentChar) { // if currentChar is same as next character
                countOfChars++;
            } else {
                result.append(currentChar).append(countOfChars); // append the character and its count
                if (i < input.length()) { // if i < input.length() then only update the currentChar and countOfChars
                    currentChar = input.charAt(i);
                    countOfChars = 1;
                }
            }
        }
        return result.toString();
    }
}
