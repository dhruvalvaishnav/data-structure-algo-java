package com.demo.arrays;

/**
 * @author Dhruval Vaishnav Created on 18-09-2024
 *
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 *
 */
public class EquilibriumIndexOfArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 2, 2};
        int[] arr2 = {-7, 1, 5, 2, -4, 3, 0};
        getEquilibriumIndex(arr1);
        getEquilibriumIndex(arr2);
        getEquilibriumIndexOptimized(arr1);
        getEquilibriumIndexOptimized(arr2);
    }


    // how to improve?
    // we can reduce the space complexity to O(1) by using two variables
    // we can reduce the time complexity to O(n) by using two variables
    // write another method with improvements

    /*
     What is equilibrium index?
     The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to
     the sum of elements at higher indexes.

     For example, in an array A: {-7, 1, 5, 2, -4, 3, 0};
     A[0] = -7,A[1] = 1,A[2] = 5,A[3] = 2,A[4] = -4,A[5] = 3,A[6] = 0
     3 is an equilibrium index, because:
        A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     3 also is an equilibrium index, because:
        A[0] + A[1] + A[2] + A[3] + A[4] + A[5] = A[6]
     (The sum of zero elements is zero)
    */
    // Write a function that, given an array A consisting of N integers, returns any of its equilibrium indices.
    private static void getEquilibriumIndex(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (n == 1) {
            System.out.println("Equilibrium index is: 0 and the element is: " + arr[0]);
            return;
        }

        // Arrays to store prefix and suffix sums
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];

        // fill the prefix sum array
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // fill the suffix sum array
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        // find the equilibrium index
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                System.out.println("Equilibrium index is: " + (i + 1) + " and the element is: " + arr[i]);
                return;
            }
        }
        // this can be solved using prefix sum and suffix sum - time complexity is O(n) and space complexity is O(n)
    }


    private static void getEquilibriumIndexOptimized(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (n == 1) {
            System.out.println("Equilibrium index is: 0 and the element is: " + arr[0]);
            return;
        }

        long prefixSum = 0, suffixSum = 0;

        // fill the suffix sum
        for (int j : arr) {
            suffixSum += j;
        }

        // find the equilibrium index
        for (int i = 0; i < n; i++) {
            suffixSum -= arr[i];
            if (prefixSum == suffixSum) {
                System.out.println("Equilibrium index is: " + (i + 1) + " and the element is: " + arr[i]);
                return;
            }
            prefixSum += arr[i];
        }
    }


}
