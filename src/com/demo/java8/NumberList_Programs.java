package com.demo.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberList_Programs {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

        //find odd and even numbers
        Set<Integer> odd = myList.stream().filter(num -> num % 2 != 0).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> even = myList.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(odd);
        System.out.println(even);

        // print the number starts with 1
        myList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);

        //find the first element from the list
        myList.stream().findFirst().ifPresent(System.out::println);

        //find the total number of elements present in the list
        long count = myList.stream().count();
        System.out.println("total number of elements present in the list = " + count);

        //find the maximum value element present in the list
        Integer max = myList.stream().max(Integer::compare).get();
        System.out.println("maximum value element present in the list = " + max);

        //sort all the values present in the list
        List<Integer> myList2 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> sorted = myList2.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted list in ASC = " + sorted);

        //sort all the values present in it in descending order
        List<Integer> descSorted = myList2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted list in DESC = " + descSorted);

        //print 5 random numbers with and without sorted order using forEach in Java 8
//        Random random = new Random();
//        random.ints().limit(5).forEach(System.out::println);
//        random.ints().limit(5).sorted().forEach(System.out::println);

        //get the sum of all numbers present in a list?
        int sum = myList.stream().mapToInt(i -> i).sum();
        System.out.println(myList + " => sum of all numbers present in the first list = " + sum);

        // square the list of numbers and then filter out the numbers greater than 100 and then find the average of the remaining numbers?
        Stream.of(new Integer[]{100, 100, 9, 8, 200})
                .mapToInt(i -> i * i)
                .filter(num -> num > 100)
                .average()
                .ifPresent(System.out::println);

        //find min and max
        Stream.of(1, 2, 3, 77, 6, 5).min(Comparator.comparing(Integer::intValue)).ifPresent(System.out::println);
        Stream.of(1, 2, 3, 77, 6, 5).max(Comparator.comparing(Integer::intValue)).ifPresent(System.out::println);

        //multiply two no.s using functional interface
//        Finterface total = (a, b) -> a * b;
//        System.out.println("multiply two no's using functional interface = " + total.multiply(6, 7));

        //limit
        Stream.of(1, 2, 3, 77, 6, 5, 23, 24, 67, 89, 23, 222).limit(5).forEach(s -> System.out.print(" " + s));
        System.out.println();
        //skip
        Stream.of(1, 2, 3, 77, 6, 5, 23, 24, 67, 89, 23, 222).skip(5).forEach(s -> System.out.print(" " + s));


    }
}
