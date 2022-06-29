package com.demo.Strings;

import java.util.HashMap;
import java.util.Map;

public class CharOccuranceFromString {
    public static void main(String[] args) {
//        find character occurrences from a given string.
//        String str = "BACANCY";
        String str = "ababaddddddd";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println("map::  " + map);
    }
}