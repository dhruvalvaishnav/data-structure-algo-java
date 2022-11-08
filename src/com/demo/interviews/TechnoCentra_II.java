package com.demo.interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TechnoCentra_II {
    public static void main(String[] args) {

        List<Integer> num1 = Arrays.asList(new Integer[]{2, 3, 7, 9, 8, 6, 5, 4});
        List<Integer> num2 = Arrays.asList(new Integer[]{4, 6, 3, 1, 5, 2, 8, 3});

        Collections.sort(num1);
        Collections.sort(num2);

        System.out.println("ASC of num1 : " + num1);
        System.out.println("ASC of num2 : " + num2);

        System.out.println(compareLists(num1, num2));
        System.out.println(compareLists(num2, Arrays.asList(new Integer[]{2, 2, 4, 5, 6, 7, 8, 9, 8})));

        List<String> strings = Arrays.asList(new String[]{"1", "12", "13", "14", "97", "78", "40", "978", "809"});
        String str = "12697809";

        System.out.println(minimizedString(strings, str));
    }



    private static boolean compareLists(List<Integer> num1, List<Integer> num2) {
        boolean out = false;

        // check for the lengths
        if (num1.size() != num2.size()) return out;

        for (int i = 0; i < num1.size() - 1; i++) {
            if (num1.get(i) > num2.get(i)) {
                out = true;
            } else {
                break;
            }
        }
        return out;
    }

    private static String minimizedString(List<String> list, String str) {
        for (String s : list) {

        }
        return null;
    }


}

/*
    1. list of numbers - 2 3 7 9 8 6 5 4
       list of numbers - 4 6 3 1 5 2 8 3
       - ASC
       - Compare both the arrays with the same index
        2
        1

        true

    2. list of strings - "1", "12", "13", "14", "97", "78", "40", "978", "809"
       String s = "12697809";
       minimum s = "6"
 */