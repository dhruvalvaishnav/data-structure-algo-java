package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 26-10-2024
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that
 * each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums. More formally,
 * if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3}; // Output: 5, nums = [1,1,2,2,3,_]
        // Explanation: Your function should return k = 5,
        // with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
        //It does not matter what you leave beyond the returned k (hence they are underscores).
        System.out.println(removeDuplicates(nums) + " are left after removing duplicates");
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) + " are left after removing duplicates");
    }

    // Time Complexity: O(n), where n is the length of the array. The method iterates through the array once.
    // Space Complexity: O(1), since the solution modifies the input array in place and uses a fixed amount of extra space.
    private static int removeDuplicates(int[] nums) {
        // If the length of nums is 2 or less, it returns the length immediately since no duplicates can exceed the allowed limit.
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2;
        // Starts iterating from index 2 (the third element) to compare each element with the one two places back (nums[i - 2]).
        for (int index = 2; index < nums.length; index++) {
            // If the current element is not equal to the one two places back,
            // it assigns it to the i-th position (where the next unique element should go) and increments i.
            if (nums[index] != nums[i - 2]) {
                nums[i] = nums[index];
                i++;
            }
        }
        return i;
    }

}
