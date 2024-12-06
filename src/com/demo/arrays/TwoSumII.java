package com.demo.arrays;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 06-12-2024
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Constraints:
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumII {
    public static void main(String[] args) {
        System.out.println("Output is at index : " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
        System.out.println("Output is at index : " + Arrays.toString(twoSum(new int[]{2, 3, 4}, 6))); // [1, 3]
        System.out.println("Output is at index : " + Arrays.toString(twoSum(new int[]{-1, 0}, -1))); // [1, 2]
    }

    // Time Complexity : O(n) and Space Complexity : O(1)
    private static int[] twoSum(int[] arr, int target) {
        // two pointer approach
        int n = arr.length, left = 0, right = n - 1;
        int[] result = new int[2]; // result array
        // loop until left is less than right
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                result[0] = left + 1; // 1-indexed array and we have taken left = 0
                result[1] = right + 1; // 1-indexed array and we have taken right = n - 1
                return result;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
