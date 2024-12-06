package com.demo.neetcode.arrayAndHashing;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 13;

        // System.out.println(Arrays.toString(findTwoSum(arr, target)));
        // System.out.println(Arrays.toString(findTwoSumUsingHashMap(arr, target)));
        System.out.println(Arrays.toString(findTwoSumOptimized(arr, target)));
    }

    // Time Complexity: O(N) and Space Complexity: O(1)
    private static int[] findTwoSumOptimized(int[] arr, int target) {
        int[] result = new int[2];
        //Arrays.sort(arr);  // Sorting the array to use the two-pointer technique if array is not sorted
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                result[0] = i;  // Store the indices where the solution is found
                result[1] = j;
                return result;
            } else if (sum < target) {
                i++;  // Move the left pointer to the right to increase the sum
            } else {
                j--;  // Move the right pointer to the left to decrease the sum
            }
        }
        return new int[0];
    }

    private static int[] findTwoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == target - arr[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
        // time complexity: O(n^2)
        // space complexity: O(1)
    }

    //	  Time Complexity: O(N) and Space Complexity: O(N)
    private static int[] findTwoSumUsingHashMap(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{map.get(arr[i]), i};
            }
            map.put(target - arr[i], i);
        }
        return new int[0];
    }
}
