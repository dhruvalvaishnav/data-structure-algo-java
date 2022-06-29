package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Programs {
    public static void main(String[] args) {

        //Find duplicate elements in a Stream
        List<Integer> list = Arrays.asList(1, 2, 2, 4, 5, 5);
        System.out.println(SolutionJava8.findDuplicateBySetAdd(list));

        // Add AA
        List<String> countries = new ArrayList<String>();
        countries.add(null);
        countries.add("Australia");
        countries.add("Singapore");
        countries.add("Albania");
        countries.add("India");
        countries.add("iran");
        countries.add("Peru");
        SolutionJava8.getListOfStringWithJava8(countries);
    }
}

class SolutionJava8 {

    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
//      The Set.add() returns false if the element was already in the set.
//      In Java 8 Stream, filter with Set.Add() is the fastest algorithm to find duplicate elements, because it loops only one time.
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());
    }

    public static List<String> getListOfStringWithJava8(List<String> countries) {
        List<String> result = countries.stream()
                .filter(s -> s != null)
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("i"))
                .map(s -> s.concat("AA"))
                .collect(Collectors.toList());
        System.out.println(result);
        return result;
    }

}