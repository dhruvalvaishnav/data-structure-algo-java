package com.demo.arrays;

import java.util.Arrays;
import java.util.Collections;

public class FindMaxMin {
    public static void main(String[] args) {
        Integer[] numbers = {95, 45, 12, 34, 22, 87, 64, 75};
        System.out.println("Maximum element in given array : " + Collections.max(Arrays.asList(numbers)));
        System.out.println("------------------------------------");
        System.out.println("Minimum element in given array : " + Collections.min(Arrays.asList(numbers)));
    }
}
