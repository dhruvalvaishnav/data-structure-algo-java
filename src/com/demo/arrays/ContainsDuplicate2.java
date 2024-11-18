package com.demo.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    // use sliding window
    // T = O(n) and S = O(k)
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //This is used to store unique elements within the current "window" or subarray being considered.
        // The HashSet ensures that there are no duplicate elements within the window.
        Set<Integer> window = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Step 1: Shrink the window if the current window size is greater than k
            if (right - left > k) {
                window.remove(nums[left]);
                left++;
            }
            // Step 2: Check if the current element is already in the window (i.e., a duplicate)
            if (window.contains(nums[right])) {
                return true;  // Duplicate found, return true
            }
            // Step 3: Add the current element to the window
            window.add(nums[right]);
        }
        return false; // No duplicates found in any subarray of size k or less
    }
}
