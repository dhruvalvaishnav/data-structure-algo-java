package com.demo.arrays;

import lombok.val;
import java.util.Arrays;

public class RemoveElement {

//    Input: nums = [3,2,2,3], val = 3
//    Output: 2, nums = [2,2,_,_]
//    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//    It does not matter what you leave beyond the returned k (hence they are underscores).

    public static void main(String[] args) {
        System.out.println("After removing an element : " + 3 + " from an array, the size of an array is : " + removeElement(new int[]{3, 2, 2, 3}, 3));

        System.out.println("After removing an element : " + 2 + " from an array, the size of an array is : " + removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));


    }

    // https://leetcode.com/problems/remove-element/
    public static int removeElement(int[] nums, int val) {
        // java 8
        // return (int) Arrays.stream(nums).filter(x -> x != val).count();

        // inplace
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num; // Modify the original array in-place
            }
        }
        return index; // Return the new length of the array
    }

}
