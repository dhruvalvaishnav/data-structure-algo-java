package com.demo.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TechnoCentra_I {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Karthik", "Ruhi", "Karan", "Pooja");

//        System.out.println(names);
//        names.stream().

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        int a = 5, b = 6;
        System.out.println("Sum of " + a + " and " + b + " is = " + sum.apply(a, b));
    }
}

// heap
// runtime data


