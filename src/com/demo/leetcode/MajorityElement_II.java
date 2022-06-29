package com.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
    Input: nums = [3,2,3]
    Output: [3]
Example 2:
    Input: nums = [1]
    Output: [1]
Example 3:
    Input: nums = [1,2]
    Output: [1,2]

Constraints:
    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

Follow up: Could you solve the problem in linear time and in O(1) space?
 */

public class MajorityElement_II {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println("majority elements array is : " + majorityElementList(nums));
        System.out.println("majority elements array is : " + majorityElementListUsingBoyerMoore(nums));

    }

    /*
    There can be at most k - 1 major element in an array if the major element appears more than n / k times.

    1. The basic idea is based on Moore's Voting Algorithm, we need two candidates with top 2 frequency.

    2. Initialize 2 variable count1 and count2 to store the frequency, if count1 = 0 store the num(Array element) in variable(num1) and increment the count1

    3. While iterating if next num is equal to num1 then increment the count1 or else check if count2 = 0, if yes store the num in a variable(num2) and increment the count2

    4. Likewise iterate through array if you find num that is same to num1 or num2 simply increment count1 or count2 respectively
        or else if num != num1 or num2 then decrement num1 and num2

    5. Again if you find any count1 or count2 = 0 start the same process (store it and increment if same), at end you will be left with 2 nums,
        then iterate through the array and check if frequency(Count) of num1 and num2 is > n/3. if yes, YOU GOT YOUR OUTPUT
     */
    private static List<Integer> majorityElementListUsingBoyerMoore(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;

        for (int n : nums)
            if (n == num1) count1++;
            else if (n == num2) count2++;
            else if (count1 == 0) {
                num1 = n;
                count1++;
            } else if (count2 == 0) {
                num2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }

        count1 = 0;
        count2 = 0;

        //to check if num1 or num2 appears more than n/3 times
        for (int n : nums) {
            if (num1 == n) count1++;
            if (num2 == n) count2++;
        }
        if (count1 > nums.length / 3) {
            if (!result.contains(num1)) {
                result.add(num1);
            }
        }
        if (count2 > nums.length / 3) {
            if (!result.contains(num2)) {
                result.add(num2);
            }
        }

        return result;
    }

    private static List<Integer> majorityElementList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
            if (map.containsKey(num) && map.get(num) > (nums.length / 3)) {
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}
