package com.demo.arrays;

import java.util.*;

/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2

    Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
