package com.demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dhruval Vaishnav Created on 06-12-2024
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println("Three Sum : " + threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println("Three Sum : " + threeSum(new int[]{0, 1, 1})); // []
        System.out.println("Three Sum : " + threeSum(new int[]{0, 0, 0})); // [[0,0,0]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // Create a list to store the result
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Sort the array to make sure we can easily skip duplicates
        Arrays.sort(nums);

        // Iterate through the array with the first element
        // nums.length - 2 because We need at least 3 elements to continue so we stop at the third last element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip the same element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;  // Left pointer
            int right = nums.length - 1;  // Right pointer

            // Find two numbers such that their sum with nums[i] equals 0
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Found a triplet, add it to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move the pointers inward after processing this pair
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // We need a larger sum, so move the left pointer to the right
                } else {
                    right--;  // We need a smaller sum, so move the right pointer to the left
                }
            }
        }
        return result;
    }
}
