package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dhruval Vaishnav Created on 11-12-2024
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
// https://leetcode.com/problems/permutations-ii/
public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);  // Sort the array to handle duplicates easily
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // If the tempList size matches nums.length, a complete permutation is formed
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Add a copy of the current permutation
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Skip the element if it is already used or if it is a duplicate and the previous duplicate was not used
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }

                // Mark the current element as used and add it to the current permutation
                used[i] = true;
                tempList.add(nums[i]);

                // Recurse with the updated tempList and used array
                backtrack(result, tempList, nums, used);

                // Backtrack: remove the last element added and mark it as unused
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
