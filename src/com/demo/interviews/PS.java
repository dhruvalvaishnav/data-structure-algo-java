package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class PS {
    public static void main(String[] args) {

        List<String> countries = new ArrayList<String>();
        countries.add(null);
        countries.add("Australia");
        countries.add("Singapore");
        countries.add("Albania");
        countries.add("India");
        countries.add("iran");
        countries.add("Peru");

        //List<String> output  = {"AustraliaAA","AlbaniaAA"};

        Solution.getListOfString(countries);
        Solution.getListOfStringWithJava8(countries);

    }
}

class Solution {
    //using java 7
    public static List<String> getListOfString(List<String> countries) {
        List<String> result = new ArrayList<String>();
        for (String str : countries) {
            if (str != null && str.startsWith("A")) {
                str += "AA";
                result.add(str);
            }
        }
        System.out.println(result);
        return result;
    }

    //using java 8
    public static List<String> getListOfStringWithJava8(List<String> countries) {
        List<String> result = countries.stream()
                .filter(s -> s != null && s.startsWith("A"))
                .map(s -> s.concat("AA"))
                .collect(Collectors.toList());
        System.out.println(result);
        return result;
    }

}