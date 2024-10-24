package com.demo.interviews.interview2024;

import java.util.*;

/**
 * @author Dhruval Vaishnav Created on 24-10-2024
 */
public class Cognizant2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 23, 45, 67, 89, 89, 33, 11, 40, 65, 77);

        // find third-highest integer from the above list
        Integer i = list.stream().sorted(Collections.reverseOrder()).distinct().skip(2).findFirst().get();
        Integer j = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        Integer k = list.stream().sorted(Collections.reverseOrder()).distinct().skip(0).findFirst().get();
        System.out.println("Third highest integer: " + i);
        System.out.println("Second highest integer: " + j);
        System.out.println("First highest integer: " + k);


    }
}
