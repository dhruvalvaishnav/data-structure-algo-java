package com.demo.arrays;

import java.util.Arrays;

//Move all negative numbers to beginning and positive to end with constant extra space
//        Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
//        Output: -12 -13 -5 -7 -3 -6 11 6 5
//        Sorted Array : [-12, -13, -5, -7, -3, -6, 5, 6, 11]

public class MoveAllNegativeEleOneSide {

    public static void main(String[] args) {

//        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6, -999, -856, -145, 785, 654, 142, 753, -6};
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println("Original Array : " + Arrays.toString(arr));

        rearrangeArray(arr);
    }

    private static void rearrangeArray(int[] arr) {
        int j = 0, temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        System.out.println("Sorted Array : " + Arrays.toString(arr));

    }
}
