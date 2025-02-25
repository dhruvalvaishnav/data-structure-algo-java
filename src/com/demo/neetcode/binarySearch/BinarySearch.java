package com.demo.neetcode.binarySearch;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target,

write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

Constraints:
    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.

 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 12;
        System.out.println("Index of 12 in nums: " + searchElement(nums, target));
        // 2^31 elements scenario
        int[] largeArr = new int[10000];
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = i;
        }
        System.out.println("Index of 1000 in large array: " + searchElementInLargeArray(largeArr, 1000));
    }

    public static int searchElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    // what if the given array is -> 2^31 -> then finding the mid should be overflow
    // solution for that is to calculate the mid like : int mid = left + ((right - left) / 2);
    // give me the example of above scenario and write a different function for this
    public static int searchElementInLargeArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2); // to avoid overflow, this is the correct way to calculate mid-point in large array
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}


