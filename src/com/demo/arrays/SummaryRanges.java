package com.demo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and
 * there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }


    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];

            // Move the index while the next number is consecutive
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // If the start and current number are different, it's a range
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                // If it's a single number, just add it
                result.add(String.valueOf(start));
            }
            // Move to the next number
            i++;
        }
        return result;
    }
}
