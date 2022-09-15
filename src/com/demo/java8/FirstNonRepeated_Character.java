package com.demo.java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeated_Character {
    public static void main(String[] args) {
        // find the first non-repeated character in the given string
        String input = "Java Hungry Blog Alive is Awesome";

        Character firstNonRepeated = input.chars() // Stream of String
                // First convert to Character object and then to lowercase
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                //Store the chars in map with count
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("the first non-repeated character = " + firstNonRepeated);

        // find the first repeated character in the given string
        Character firstRepeated = input.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(m -> m.getKey())
                .findFirst()
                .get();
        System.out.println("the first repeated character = " + firstRepeated);
    }
}