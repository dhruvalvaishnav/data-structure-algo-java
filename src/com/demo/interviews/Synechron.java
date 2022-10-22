package com.demo.interviews;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Synechron {
    public static void main(String[] args) {
        /*

        List<String> names = Arrays.asList("Apple", "Banana","Grapes","Banana","Apple");

        LinkedHashMap<String, Long> collect = names.stream().filter(x -> Collections.frequency(names, x) > 1).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(collect);

        */
    }
}

// 1. List of String - names - find duplicate elements - using stream
//    ans: {"Apple" : 2,...}

// 2. “ == “ and “ === “ and ">>" and ">>>" operators

// 3. PUT vs PATCH and PUT vs POST

// 4. @controller & @restcontroller

// 5. GROUP BY

// 6. git fetch all or get the all the branches from remote and local

// 7. criteria query vs update - hibernate

// 8. fetch or fetchMode - hibernate

