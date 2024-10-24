package com.demo.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dhruval Vaishnav Created on 21-10-2024
 */
/*
There is one string, separated by space and you have to reverse the word of the String based on the Fibonacci Series.
If is there any duplicated number in Fibonacci series then you don’t have to reverse that words.
For Ex.
Input : zero one one two three four five six seven eight nine ten
Output : oerz one one owt eerht four evif six seven thgie nine ten

LOGIC:
Generate Fibonacci Numbers: Create a list of Fibonacci numbers until you reach a certain limit,
                            ensuring you track duplicates.
Reverse Words: For each word in the string, check if its position matches a Fibonacci number.
               If it does, reverse the word unless the Fibonacci number is a duplicate.
Construct the Output: Combine the words back into a single string.
 */

public class FibonacciWordReversal {
    public static void main(String[] args) {
        String input = "zero one one two three four five six seven eight nine ten";
        System.out.println("Input: " + input);
        String output = reverseWordsFibonacci(input);
        System.out.println("Output: " + output);
        if (output.equals("oerz one one owt eerht four evif six seven thgie nine ten")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    private static String reverseWordsFibonacci(String input) {
        String[] words = input.split(" ");
        List<Integer> fibList = generateFibonacciUntil(words.length);
        System.out.println("Fibonacci Series until " + words.length + " : " + fibList);
        // Identify duplicates in the Fibonacci list
        Set<Integer> duplicates = findDuplicates(fibList);
        System.out.println("Duplicates in Fibonacci Series: " + duplicates);
        Set<Integer> fibSet = new HashSet<>(fibList);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int position = i + 1; // 1-based index
            if (fibSet.contains(position) && !duplicates.contains(position)) {
                result.append(reverseString(words[i])).append(" ");
            } else {
                result.append(words[i]).append(" ");
            }
        }

        return result.toString().trim();
    }

    private static List<Integer> generateFibonacciUntil(int limit) {
        List<Integer> fibList = new ArrayList<>();
        int a = 0, b = 1;
        fibList.add(1); // Adding the first Fibonacci number
        while (b <= limit) {
            fibList.add(b);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibList;
    }

    private static Set<Integer> findDuplicates(List<Integer> fibList) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : fibList) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}


