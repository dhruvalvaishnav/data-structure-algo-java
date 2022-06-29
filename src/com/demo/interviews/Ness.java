package com.demo.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ness {
    public static void main(String[] args) {

        Character[] chars = {'W', 'e', 'L', 'c', 'o', 'M', 'e'};

        //A-Z - 0 to 50
        //a-z - 51 to 100

        SolutionNess.shiftingOfChars(chars);
    }
}

class SolutionNess {
//    public static char[] shiftingOfChars(Character[] chars) {
//       /*
//        Character[] output = new Character[chars.length];
//
//        //chars length > 0 or not null
//        if (chars.length <= 0) {
//            return null;
//        }
//
//        char temp;
//
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = i; j < chars.length; j++) {
//                //all lowercase chars
//                if (Character.isLowerCase(chars[i])) {
//                    output[i] = chars[i];
//                } else {
//                    temp = chars[i];
//                    chars[i] = chars[j];
//                    chars[j] = temp;
//                    output[i] = chars[j];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(output));
//        return output;
//        */
//    }

    public static char[] shiftingOfChars(Character[] chars) {

        //using two string
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                lower.append(c).append(",");
            } else {
                upper.append(c).append(",");
            }
        }
        String out = lower.toString().concat(upper.toString());
        System.out.println(out);
        char[] output = out.toCharArray();
        System.out.println(output);
        return output;


        //using reg-ex
//        return s.replaceAll("[A-Z]+", "") + s.replaceAll("[^A-Z]+", "");
    }
}

// Character array
// Input: 'W', 'e', 'L', 'c', 'o', 'M', 'e'
// Output: 'e', 'c', 'o', 'e', 'W','L','M'

