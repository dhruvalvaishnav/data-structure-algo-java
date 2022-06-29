package com.demo.interviews;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Nagarro {
    public static void main(String[] args) {
        String s = "abDDDD";
        findLongestSubstring(s);
    }

    private static void findLongestSubstring(String s) {
         /*StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            for (int j = i + 1; j < s.toCharArray().length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    stringBuilder.append(s.charAt(j));
                }
            }
        }
        System.out.println(count);
        String chars = stringBuilder.toString();
        System.out.println(chars);
        Longest longest = new Longest(count, chars);
        System.out.println(longest);
        */

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println("map::  " + map);

        Longest longest = null;

        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<Character, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                longest = new Longest(maxValueInMap, entry.getKey().toString());
            }
        }
        System.out.println(longest);
    }
}

class Longest {
    int size;
    String chars;

    public Longest(int size, String chars) {
        this.size = size;
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Longest{" +
                "size=" + size +
                ", chars='" + chars + '\'' +
                '}';
    }
}