package com.demo.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]

    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

    Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 0, 0, 13, 20, 23, 45, 65, 75, 80, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{1})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
    }

    public static int[] moveZeroes(int[] nums) {
        // Quick Sort
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        return nums;
    }
}
