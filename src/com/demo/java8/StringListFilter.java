package com.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StringListFilter {
    public static void main(String[] args) {

        // Add AA
        List<String> countries = new ArrayList<String>();
        countries.add(null);
        countries.add("Australia");
        countries.add("Singapore");
        countries.add("Albania");
        countries.add("India");
        countries.add("iran");
        countries.add("Peru");
        getListOfStringWithJava8(countries);
    }

    public static List<String> getListOfStringWithJava8(List<String> countries) {
        List<String> result = countries.stream()
                .filter(s -> s != null)
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("i"))
                .map(s -> s.concat("AA"))
                .collect(Collectors.toList());
        System.out.println(result);
        return result;
    }
}