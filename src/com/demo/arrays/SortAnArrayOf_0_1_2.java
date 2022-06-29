package com.demo.arrays;

import java.util.Arrays;

//Sort the array without using any sorting algorithm
public class SortAnArrayOf_0_1_2 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        System.out.println("Original Array : " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
