package com.demo.interviews;

import java.util.HashMap;
import java.util.Map;

public class Bhavna {

    public static void main(String[] args) {

        /*
        int[] arr = {100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89};

        int high = arr[0], secondHigh = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < high) {
                secondHigh = arr[i];
            } else {
                high = arr[i];
            }
        }

        System.out.println(secondHigh);
        */

        /*

        String str = "Bhavana";
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                count++;
            }
            map.put(c, count);
        }
        //B-1
        //h-1
        //a-3

        System.out.println(map);

        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            if(c.getValue() > ) {
                System.out.println("highest freq. char is : " + c.getKey());
            }
        }

        */

    }
}

//1. find second highest element from array in single iteration

//2. build map from list - Map<String, List<Employee>

//3. input  - String - find char frequency from the string

//        Map<Employee, Integer>

//        equals
//        hashcode
//        equals && hashcode
//        nothing has been override

//    arraylist linkedlist
//    execute and submit
//    callable
//    concurrent hashmap

//    disable auto config - @Configuration - Exclude
//        @profile @Configuration
//        @Bean @Component
//        @PropertySource

//      ms communicate
//