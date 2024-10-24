package com.demo.interviews.interview2024;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dhruval Vaishnav Created on 24-10-2024
 */
public class Practice1 {
    public static void main(String[] args) {

        //freqOfCharsInString();
        //separateOddEven();

        // anagram -> race car, car race
        // find if two strings are anagram or not
//        String one = "listen", two = "silent";
//        if (isAnagram(one, two)) {
//            System.out.println("Given two strings are anagram");
//        } else {
//            System.out.println("Given two strings are not anagram");
//        }

    }


    private static void freqOfCharsInString() {
        // find frequency of characters in String
        String str = "Bilal";
        Map<Character, Long> collect = str.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void separateOddEven() {
        List<Integer> list = Arrays.asList(12, 45, 66, 87, 33, 44, 23, 67, 44);

        // Separate odd and even numbers from List<Integer> using java 8 function
        // way 1
        Map<String, Set<Integer>> map = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "EVEN" : "ODD", Collectors.toSet()));
        System.out.println(map);
        // way 2
        Map<Boolean, Set<Integer>> collect = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toSet()));
        System.out.println(collect);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // way 1
        // time complexity is O(n)
        // space complexity is O(n)
        Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : s.toCharArray()) {
            if (!sMap.get(c).equals(tMap.get(c))) {
                return false;
            }
        }
        return true;


        //way 2
        //time complexity is O(nlogn)
        //space complexity is O(n)
//        String collect1 = Stream.of(s.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
//        String collect2 = Stream.of(t.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
//        return collect1.equalsIgnoreCase(collect2);
    }


}
