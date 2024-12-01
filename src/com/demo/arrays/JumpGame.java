package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 25-11-2024
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        System.out.println("CAN JUMP: " + canJump(new int[]{2, 3, 1, 1, 4})); // output: true
        System.out.println("CAN JUMP: " + canJump(new int[]{3, 2, 1, 0, 4})); // output: false
    }

    // greedy approach
    // time complexity: O(n) and space complexity: O(1)
    public static boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;
        for (int i = goalPost; i >= 0; i--) {
            if (i + nums[i] >= goalPost) {
                goalPost = i;
            }
        }
        return goalPost == 0;
    }
}
