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
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement_I {
    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("majority element in given array is : " + majorityElement(nums));
        System.out.println("majority element in given array is : " + majorityElementUsingBoyerMoore(nums));
        System.out.println("majority element in given array is : " + majorityElementUsingStreams(nums));
    }

    private static String majorityElementUsingStreams(int[] nums) {
        // find the majority element using java 8 streams
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> x.getValue() > nums.length / 2).map(Map.Entry::getKey).findFirst().get().toString();
        // time complexity : O(n) because of stream operations
        // space complexity : O(n) because of groupingBy and counting
    }

    //  space : O(1) because of constant space used as result and count variables
    //  time : O(n) because of single pass through the array
    // which algorithm is used here : Boyer-Moore Voting Algorithm
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    // what is the intuition behind this algorithm :
    // 1. If we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
    // 2. If we find two elements that are different, then we can remove them from the list.
    // 3. This approach will ensure that the majority element is always left over as the last element.
    private static int majorityElementUsingBoyerMoore(int[] nums) {
        int result = 0, count = 0;
        for (int currentElement : nums) {
            // if the count is 0, set the current element as the majority element candidate
            if (count == 0) {
                result = currentElement;
            }
            // if the current element is the majority element candidate, increment the count
            count += (result == currentElement) ? 1 : -1;
        }
        return result;
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
    /*
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
     */

}
