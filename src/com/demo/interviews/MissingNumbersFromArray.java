package com.demo.interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MissingNumbersFromArray {
    public static void main(String[] args) {

        /*
        * Write program to display numbers which are not in array suppose array size is 10; ?????????????????
            for example a = {3,6,8,9};
            output a = {1,2,4,5,7,10};
        * */
        int[] nums = {1, 3, 6, 8, 9, 10};
        int n = 10;

        printMissingElements(nums, nums.length);
        /**
         * Given a sorted array arr[] of N integers, The task is to find the multiple missing elements in the array between the ranges [arr[0], arr[N-1]].
         *
         * Examples:
         *
         * Input: arr[] = {6, 7, 10, 11, 13}
         * Output: 8 9 12
         * Explanation:
         * The elements of the array are present in the range of the maximum and minimum array element [6, 13]. Therefore, the total values will be {6, 7, 8, 9, 10, 11, 12, 13}.
         * The elements from the above range which are missing from the array are {8, 9, 12}.
         *
         *
         */
    }

    // Function to find the missing elements
    static void printMissingElements(int arr[],
                                     int N) {

        // Initialize an array with zero
        // of size equals to the maximum
        // element in the array
        int[] b = new int[arr[N - 1] + 1];

        // Make b[i]=1 if i is present
        // in the array
        for (int i = 0; i < N; i++) {

            // If the element is present
            // make b[arr[i]]=1
            b[arr[i]] = 1;
        }

        // Print the indices where b[i]=0
        for (int i = arr[0]; i <= arr[N - 1]; i++) {
            if (b[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}