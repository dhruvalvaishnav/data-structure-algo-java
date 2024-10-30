package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 26-10-2024
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
