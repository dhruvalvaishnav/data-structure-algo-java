package com.demo.Strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Finds the first character that does not repeat anywhere in the input string
//If all characters are repeated, return 0
//Given “apple”, the answer is “a”
//Given “racecars”, the answer is “e"
public class FirstFirstNonRepeatingCharacter {
    public static void main(String[] args) {

        //java8
        System.out.println("racecars : " + "racecars".chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey()).findFirst().get());

        System.out.println("SSSSSSSSSSSDHRUVAL : " + "SSSSSSSSSSSDHRUVAL".chars()
                .mapToObj(value -> Character.toLowerCase(Character.valueOf((char) value)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey()).findFirst().get());


        System.out.println("AAAAAAAAABBBBBDhruval : " + "AAAAAAAAABBBBBDhruval"
                .chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 1L)
                .map(s -> s.getKey())
                .findFirst()
                .get());


        System.out.println("apple : " + findFirstFirstNonRepeatingCharacter("apple"));
        System.out.println("xxyyzz : " + findFirstFirstNonRepeatingCharacter("xxyyzz"));
        System.out.println("racecars : " + findFirstFirstNonRepeatingCharacter("racecars"));
    }

    private static char findFirstFirstNonRepeatingCharacter(String input) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        char result = 0;
        for (Character c : input.toLowerCase().toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> o : map.entrySet()) {
            if (o.getValue() == 1) {
                result = o.getKey() != null ? o.getKey() : 0;
                break;
            }
        }

        return result;
    }

}
