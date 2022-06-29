package com.demo.leetcode;

/*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
    Input: nums = [3,2,3]
    Output: 3
Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.*;

public class MajorityElement_I {
    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("majority element in given array is : " + majorityElement(nums));
        System.out.println("majority element in given array is : " + majorityElementUsingBoyerMoore(nums));
    }

    //  space : O(1) , time : O(n)
    private static int majorityElementUsingBoyerMoore(int[] nums) {
        int res = 0, count = 0;
        for (int n : nums) {
            if (count == 0) res = n;
            count += n == res ? 1 : -1;
        }
        return res;
    }

    //  space : O(n) , time : O(n)
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
            if (map.containsKey(num) && map.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }

}
