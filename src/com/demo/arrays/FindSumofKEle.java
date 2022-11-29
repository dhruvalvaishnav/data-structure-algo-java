package com.demo.arrays;

import java.util.Arrays;

//Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
public class FindSumofKEle {
    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400, 1200};
        int k = 2;
        System.out.println(findMaxSumofK(arr, k));
        System.out.println(findMaxSumofKWindowSlide(arr, k));
    }

    // brute-force
    private static int findMaxSumofK(int[] arr, int k) {
        // initialize variable
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++) {
                current_sum += arr[i + j];
                max_sum = Math.max(current_sum, max_sum);
            }
        }
        return max_sum;
    }

    //window-slide
    private static int findMaxSumofKWindowSlide(int[] arr, int k) {

        // if length of arr must be greater
        if (arr.length < k) {
            System.out.println("Invalid");
            return -1;
        }
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }
//        System.out.println("max_sum = " + max_sum);
        int window_sum = max_sum;
        for (int i = k; i < arr.length; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(window_sum, max_sum);
        }
        return max_sum;
    }
}