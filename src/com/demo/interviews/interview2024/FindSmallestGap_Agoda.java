package com.demo.interviews.interview2024;

import java.util.*;

/**
 * Problem: Next Smaller Element (Find Smallest Gap)
 * Given an integer list nums, for each element nums[i],
 * find the index of the next smaller element to the right. If no such element exists, set the result to 0.
 * <p>
 * You need to return an array result where result[i] contains the index of the next smaller element after nums[i].
 * If no such element exists, set result[i] to 0.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [73, 74, 75, 71, 69, 72, 76, 77]
 * Output: [3, 2, 1, 1, -1, -1, -1, -1]
 * <p>
 * Example 2:
 * Input: nums = [10, 30, 20]
 * Output: [-1, 2, -1]
 * <p>
 * Example 3:
 * Input: nums = [60, 30, 20]
 * Output: [1, 2, -1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * <p>
 * Follow-up:
 * You can solve this problem in O(n) time using a stack.
 */

public class FindSmallestGap_Agoda {

    public static void main(String[] args) {
        System.out.println(findSmallestGapStack(List.of(73, 74, 75, 71, 69, 72, 76, 77)));  // Expected output: [3, 2, 1, 1, 0, 0, 0, 0]
        System.out.println(findSmallestGapStack(List.of(73, 74, 75, 71, 100, 99, 69, 72, 76, 77)));  // Expected output: [3, 2, 1, 3, 1, 1, 0, 0, 0, 0]
        System.out.println(findSmallestGapStack(List.of(10, 30, 20)));  // Expected output: [0, 1, 0]
        System.out.println(findSmallestGapStack(List.of(60, 30, 20)));  // Expected output: [1, 1, 0]
    }

    // Time Complexity: O(n²)
    // Space Complexity: O(n) for the result list, which stores the gaps.
    private static List<Integer> findSmallestGapBruteForce(List<Integer> nums) {
        int n = nums.size();
        List<Integer> result = new ArrayList<>(n);
        // Loop over each element
        for (int i = 0; i < n; i++) {
            int j = i + 1;  // Look ahead to the next elements
            boolean foundSmaller = false;  // Flag to check if we find a smaller element
            // Look for the first smaller element after nums[i]
            while (j < n) {
                if (nums.get(j) < nums.get(i)) {
                    result.add(j - i);  // Add the gap (index difference)
                    foundSmaller = true;
                    break;  // Stop after the first smaller element
                }
                j++;
            }
            // If no smaller element was found, add 0
            if (!foundSmaller) {
                result.add(0);
            }
        }
        return result;
    }


    // Time Complexity: O(n)
    // Space Complexity: O(n) for the result list, which stores the gaps.
    private static List<Integer> findSmallestGapStack(List<Integer> nums) {
        // Step 1: Check if the list has fewer than two elements
        // If the list is null or has fewer than two elements, it is invalid for this problem.
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements.");
        }

        // Step 2: Initialize the result list and the stack.
        // `result` will store the answer for each element.
        // `stack` will help track the indices of the elements as we look for the next smaller element.
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // Step 3: Store the size of the input list for easier reference
        int n = nums.size();

        // Step 4: Traverse the list from right to left
        // This is because we want to find the "next smaller element" for each item.
        // Traversing from right to left ensures we always have processed the elements to the right of the current element.
        for (int i = n - 1; i >= 0; i--) {
            // Get the current element (value at index i)
            int current = nums.get(i);

            // Step 5: Pop elements from the stack while they are greater than or equal to the current element.
            // This ensures that the stack only contains indices of elements that are smaller than the current element.
            while (!stack.isEmpty() && nums.get(stack.peek()) >= current) {
                stack.pop();
            }

            // Step 6: Check if the stack is empty.
            // If the stack is empty, it means there is no smaller element to the right of the current element.
            if (stack.isEmpty()) {
                result.add(0); // No smaller element found, so add 0 (gap is 0).
            } else {
                // Step 7: If the stack is not empty, the top of the stack contains the index of the first smaller element.
                // We calculate the gap as the difference between the indices.
                int smallestGapIndex = stack.peek(); // Get the index of the smallest element to the right.
                result.add(smallestGapIndex - i);    // The gap is the difference in indices.
            }

            // Step 8: Push the current index onto the stack.
            // This is because the current element might be the "next smaller" element for the elements to the left.
            stack.push(i);
        }

        // Step 9: Reverse the result list.
        // We have been adding results in reverse order (right to left), so we need to reverse the result list.
        List<Integer> reversedResult = new ArrayList<>(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i)); // Reverse the result list to match the correct order.
        }

        // Step 10: Return the final result list.
        return reversedResult; // This list now contains the gaps for each element in the correct order.
    }

    /*
    If you were to process the list from left to right, you would need to look ahead for the nearest smaller element (to the right),
    which requires keeping track of the entire right-side part of the list at every step.
    This would make it harder to use a stack in an efficient way.
    The right-to-left traversal naturally allows you to handle each element after the elements to its right have been processed and
    are already available in the stack. This way, you can efficiently calculate the smallest gap using the stack.
     */
}

