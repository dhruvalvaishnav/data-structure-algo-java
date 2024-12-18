package com.demo.interviews.interview2024;

import java.util.*;

/**
 * @author Dhruval Vaishnav Created on 12-12-2024
 */
public class Accolite {
    public static void main(String[] args) {
        System.out.println(waysToReachNthStair(3)); // 3 -> output : 3
        System.out.println(waysToReachNthStair(5)); // 5 -> output : 13
        System.out.println(waysToReachNthStair(2)); // 2 -> output : 2

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        boolean b = integers.removeIf(i -> i == 2); // remove element if it is 2
        System.out.println(b);

        Deque<Integer> deque = new java.util.LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.pollLast()); // remove and return last element

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        System.out.println(set.size()); // 2

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println(map.computeIfAbsent("D", k -> 0)); // computeIfAbsent will add key if not present



    }

    // There are n stairs, a person standing at the bottom wants to reach the top.
    // The person can climb either 1 stair or 2 stairs at a time.
    // Count the number of ways, the person can reach the top.
    private static int waysToReachNthStair(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return waysToReachNthStair(n - 1) + waysToReachNthStair(n - 2);
    }
}