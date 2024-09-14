package com.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 20-05-2024
 */
// java 8
public class CollectionsHiddenMethods {
    public static void main(String[] args) {
        System.out.println("Hello World");

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list); // [1,2,3,4,5,6,7,8,9,10]

        // Collections.rotate(list,3); // It will rotate the list by 3 positions
        // System.out.println(list); // [8,9,10,1,2,3,4,5,6,7]

        // Collections.rotate(list,-15);
        // System.out.println(list); // [6,7,8,9,10,1,2,3,4,5]

        Collections.rotate(list, list.size()); // It will not change the list
        System.out.println(list); // [1,2,3,4,5,6,7,8,9,10]


        // Collections.frequency() - It returns the number of elements in the specified collection equal to the specified object.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 1, 1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 1, 4, 5, 9, 6, 3, 4, 4, 2, 3, 1);
        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect); // {1=6, 2=4, 3=5, 4=5, 5=3, 6=3, 7=1, 8=2, 9=1, 10=2}
        Map<Integer, Long> collect1 = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);


        // Collections.disjoint() - it compares two lists and returns true if they have no elements in common.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(77, 88, 99, 66, 33, 44);
        boolean isDisjoint = Collections.disjoint(list1, list2);
        System.out.println(isDisjoint);

    }
}
