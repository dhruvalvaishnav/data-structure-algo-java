package com.demo.arrays;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 30-10-2024
 */
//https://leetcode.com/problems/rotate-array/
public class RotateArray {

    // Given an integer array nums,
    // rotate the array to the right by k steps, where k is non-negative.
    public static void main(String[] args) {
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]

        // it is a cyclic rotation
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr, 3);
        System.out.println("After rotating array: " + Arrays.toString(arr));
    }

    public static void rotateArray(int[] nums, int k) {
    }


}
