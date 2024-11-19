package com.demo.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Dhruval Vaishnav Created on 19-11-2024
 */
public class Xpheno {
    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatingChar("swiss"));

    }

    private static Character getFirstNonRepeatingChar(String input) {
        // freq map for each char
        // key - char, value - integer

        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Optional<Character> c =map
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1L)
                .map(x->x.getKey())
                .findFirst();

        System.out.println(map);


        if (c.isPresent()) {
            return c.get();
        } else {
            return null;
        }

    }

}
