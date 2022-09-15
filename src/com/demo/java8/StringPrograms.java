package com.demo.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPrograms {
    public static void main(String[] args) {

        //get the current date and time using Java 8 Date and Time API?
        System.out.println("current date and time is = " + LocalDateTime.now());
        System.out.println("current date is = " + LocalDate.now());
        System.out.println("current time is = " + LocalTime.now());

        //add prefix and suffix to the String?
//        StringJoiner

        // no of occurance of given string using java 8
        String str = "My name is with my favorite alphabet D and my favorite bird is peacock and my full name is Dhruval !";
        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .forEach((map -> {
                    System.out.print(", " + map.getKey() + " = " + map.getValue());
                }));


    }
}
