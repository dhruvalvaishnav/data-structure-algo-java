package com.demo.arrays;

import java.util.Arrays;

//Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
public class FindSumofKEle {
    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400, 1200};
        int k = 2;
        System.out.println("Maximum sum of " + k + " consecutive elements = " + findMaxSumofK(arr, k) + " with brute-force");
        System.out.println("Maximum sum of " + k + " consecutive elements = " + findMaxSumofKWindowSlide(arr, k) + " with window-slide.");
    }

    // brute-force
    private static int findMaxSumofK(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Invalid");
            return -1;
        }
        // initialize variable
        int max_sum = Integer.MIN_VALUE;
        // loop through the array until k elements from the end of the array are reached
        for (int i = 0; i < arr.length - k + 1; i++) { // here we are using arr.length - k + 1 because we are calculating the sum of k elements
            int current_sum = 0;
            for (int j = 0; j < k; j++) {
                current_sum += arr[i + j];
                max_sum = Math.max(current_sum, max_sum);
            }
        }
        return max_sum;
    }

    //window-slide
    private static int findMaxSumofKWindowSlide(int[] arr, int k) {
        // if length of arr must be greater
        if (arr.length < k) {
            System.out.println("Invalid");
            return -1;
        }
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }
//        System.out.println("max_sum = " + max_sum);
        int window_sum = max_sum;
        for (int i = k; i < arr.length; i++) { // loop through the array from k to end of the array
            window_sum += arr[i] - arr[i - k]; // add the next element and subtract the first element of the window
            max_sum = Math.max(window_sum, max_sum); // find the maximum of the window sum and max sum
        }
        return max_sum;
    }

    /* What is Window-Slide Technique?
    Window-Slide Technique is a technique used to solve problems where we need to find the maximum or minimum value of a function over a contiguous sub-array of elements of a given array.
    The technique works by maintaining a window of elements in the array and sliding the window to the right one element at a time.
    The window is defined by two pointers, left and right, which define the start and end of the window.
    The window is updated by moving the right pointer to the right one element at a time and updating the window sum accordingly.
    The window sum is then used to calculate the maximum or minimum value of the function over the window.
     */

    /* Time Complexity:
    The time complexity of the Window-Slide Technique is O(n), where n is the number of elements in the array.
    This is because the technique involves iterating through the array once to calculate the window sum and update the maximum or minimum value of the function.
     */

    /* Space Complexity:
    The space complexity of the Window-Slide Technique is O(1),
    as it only requires a constant amount of extra space to store the window sum and the maximum or minimum value of the function.
     */
}