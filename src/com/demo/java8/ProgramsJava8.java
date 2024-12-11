package com.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dhruval Vaishnav Created on 11-12-2024
 */
public class ProgramsJava8 {
    public static void main(String[] args) {

        // Sort strings in reverse alphabetical order using stream
        List<String> list = new java.util.ArrayList<>(List.of("Apple", "Banana", "Orange", "Grapes"));
        System.out.println(list);
        // time complexity - O(nlogn), space complexity - O(n)
        list  = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);

        // Generate the first 10 numbers of the Fibonacci sequence using java 8
        // time complexity - O(n), space complexity - O(n)
        Set<Integer> fib = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(10)
                .map(x -> x[0])
                .collect(Collectors.toSet());
        System.out.println(fib); // [0, 1, 2, 34, 3, 5, 21, 8, 13]

        // find palindrome strings from list
        List<String> words = Arrays.asList("madam", "level", "hello", "world", "radar");
        // time complexity - O(n), space complexity - O(1)
        words.stream().filter(x-> x.contentEquals(new StringBuilder(x).reverse())).forEach(x-> System.out.print(x+ ", "));
        System.out.println();

        // find numbers greater than the average in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // time complexity - O(n), space complexity - O(1)
        numbers.stream().filter(x-> x > numbers.stream().mapToInt(Integer::intValue).average().getAsDouble()).forEach(x-> System.out.print(x+ ", "));
        System.out.println();

    }
}
