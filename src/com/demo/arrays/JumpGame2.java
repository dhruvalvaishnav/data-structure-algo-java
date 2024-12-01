package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 25-11-2024
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println("MIN JUMPS: " + jump(new int[]{2, 3, 1, 1, 4})); // output: 2
        System.out.println("MIN JUMPS: " + jump(new int[]{2, 3, 0, 1, 4})); // output: 2
    }

    // greedy approach and BFS
    // time complexity: O(n) and space complexity: O(1)
    public static int jump(int[] nums) {
        int res = 0, left = 0, right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            // Traverse from 'left' to 'right' to find the farthest index we can reach
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            // Update left and right boundaries for the next jump
            left = right + 1;
            right = farthest;
            res++;
        }
        return res;
    }

}
