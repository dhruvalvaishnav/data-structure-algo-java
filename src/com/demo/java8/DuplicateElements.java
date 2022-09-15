package com.demo.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        //Find duplicate elements in a Stream
        List<Integer> list = Arrays.asList(1, 2, 2, 4, 5, 5);
        System.out.println(findDuplicateBySetAdd(list));
    }

    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
//      The Set.add() returns false if the element was already in the set.
//      In Java 8 Stream, filter with Set.Add() is the fastest algorithm to find duplicate elements, because it loops only one time.
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());
    }
}
