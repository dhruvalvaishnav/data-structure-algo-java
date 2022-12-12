package com.demo.interviews;

import java.util.function.Function;
import java.util.stream.*;
import java.util.*;

public class RSystems {
    public static void main(String[] args) {
        System.out.println(nonRepeating("prepinsta"));
        System.out.println(reverseTheString("prepinsta"));
    }

    private static char nonRepeating(String str) {
        Character character = str.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(x -> x.getValue() == 1L).map(s -> s.getKey()).findFirst().get();

        return character;
    }

    private static String reverseTheString(String str) {
        char[] cArr = str.trim().toCharArray();

        int left = 0, right = str.length() - 1;
        while (left < right) {
            char temp = cArr[left];
            cArr[left] = cArr[right];
            cArr[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(cArr);
    }


// "prepinsta" - find first non repeating char
// flatMap
// doesn't contain duplicate and insertion order -> SET -> LINKEDHASHSET
// reverse a string
}

