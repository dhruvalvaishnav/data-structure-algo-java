package com.demo.neetcode.arrayAndHashing;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int num : nums) {
            if (numbers.contains(num)) return true;
            numbers.add(num);
        }
        return false;
    }
}
