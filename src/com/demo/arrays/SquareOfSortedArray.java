package com.demo.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length, left = 0, right = n - 1, index = n - 1;
        int[] result = new int[n];
        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];
            if (leftSqr > rightSqr) {
                result[index] = leftSqr;
                left++;
            } else {
                result[index] = rightSqr;
                right--;
            }
            index--;
        }
        return result;
    }
}
