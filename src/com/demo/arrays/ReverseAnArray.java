package com.demo.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ReverseAnArray {

    public static void main(String[] args) {

        Integer[] numbers = {95, 45, 12, 34, 22, 87, 64, 75};

        String[] strings = {"India", "USA", "Germany", "Australia"};

        System.out.println("--------------------------Integer Array----------------------------");
        System.out.println("Original Array : " + Arrays.toString(numbers));
        Collections.reverse(Arrays.asList(numbers));
        System.out.println("Reverse Array : " + Arrays.toString(numbers));

        System.out.println();
        System.out.println("--------------------------String Array----------------------------");
        System.out.println("Original Array : " + Arrays.toString(strings));
        Collections.reverse(Arrays.asList(strings));
        System.out.println("Reverse Array : " + Arrays.toString(strings));
    }
}