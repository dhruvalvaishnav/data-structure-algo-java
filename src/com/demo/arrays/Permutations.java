package com.demo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dhruval Vaishnav Created on 11-12-2024
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
// https://leetcode.com/problems/permutations/
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process with an empty list and the whole nums array
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // If the tempList size matches nums.length, a complete permutation is formed
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Add a copy of the current permutation
        } else {
            for (int num : nums) {
                // Skip duplicates to avoid generating the same permutation
                //if (tempList.contains(num)) continue;

                // Add current element to the tempList
                tempList.add(num);

                // Recurse with the updated tempList
                backtrack(result, tempList, nums);

                // Backtrack: remove the last element added
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
