package com.demo.interviews;

import java.util.*;

public class Virtusa {
    public static void main(String[] args) {
        SolutionVirtusa.printPattern();

        System.out.println("**********************************************");

        String str = "Dhruval Vaishnav";

        SolutionVirtusa.findFirstRepeated(str);
    }
}


// print pattern
/*
1
2 3
4 5 6
7 8 9 10
*/

class SolutionVirtusa {
    //real output (error in what i have written)
    // modified that after the interview
    public static void printPattern() {
        int k = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(" " + k++);
            }
            System.out.println();
        }
    }


    //find the first repeated char in given string
    public static void findFirstRepeated(String str) {

        char[] chars = str.toCharArray();

        Set<Character> set = new HashSet<>();

        for (char c : chars) {
            if (set.contains(c)) {
                System.out.println("first repeated char in string is :: " + c);
                break;
            }
            set.add(c);
        }
    }
}