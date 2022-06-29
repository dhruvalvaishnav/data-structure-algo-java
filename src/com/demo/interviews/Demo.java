package com.demo.interviews;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

//        System.out.println(countOfNumber(Arrays.asList(87, 6, 1, 2, 3, 745, 9, 2, 87, 6, 87)));
        System.out.println(reverseTheList(Arrays.asList(87, 6, 1, 2, 3, 745, 9, 2, 87, 6, 87, 110, 8565)));
    }

    private static List<Integer> reverseTheList(List<Integer> list) {
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    //    Map<Integer,Integer> : key = int , value = count
    public static Map<Integer, Integer> countOfNumber(List<Integer> integersList) {
        Map<Integer, Integer> integerCountMap = new HashMap<>();

        for (Integer i : integersList) {
            int count = 1;
            if (integerCountMap.containsKey(i)) {
                count++;
            }
            integerCountMap.put(i, count);
        }
        return integerCountMap;
    }
}


