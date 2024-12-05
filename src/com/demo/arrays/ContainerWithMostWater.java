package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 05-12-2024
 * <p>
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Max Area: " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int maxArea(int[] height) {
        // two pointer approach to find the max area
        int left = 0, right = height.length - 1, maxArea = 0;
        // loop until left and right pointer are not same
        while (left < right) {
            // find the minimum height between left and right
            int minValue = Math.min(height[left], height[right]);
            // calculate the current area by multiplying minimum height with the difference between right and left pointer
            int currentArea = minValue * (right - left);
            // update the maxArea if currentArea is greater than maxArea
            maxArea = Math.max(maxArea, currentArea);
            // move the pointer which has minimum height to find the next maximum area for eg. if left height is less than right height then move left pointer to right
            if (height[left] < height[right]) {
                left++;
            } else {
                // if right height is less than left height then move right pointer to left
                right--;
            }
        }
        // return the maxArea
        return maxArea;

    }
}
