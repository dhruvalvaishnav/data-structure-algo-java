package com.demo.numberic;

import java.util.Arrays;

/*
    Returns the smallest number in array that has been rotated
    For example - Array {3,4,5,6,1,2} returns 1
    Input array was originally sorted in increasing orders
    FindMinInArray must have O(log n) runtime
    Input array does not have any duplicates

    Test Cases:
        Input: [3, 4, 5, 6, 1, 2]
        Output: 1

        Input: [2, 1]
        Output:1

 */
public class SmallestNumber {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println("Minimum in given array : " + Arrays.toString(arr1) + " is = " + findMin(arr1, 0, arr1.length - 1));

        int[] arr2 = new int[]{2, 1};
        System.out.println("Minimum in given array : " + Arrays.toString(arr2) + " is = " + findMin(arr2, 0, arr2.length - 1));

        int[] arr3 = new int[]{5, 6, 1, 2, 3, 4};
        System.out.println("Minimum in given array : " + Arrays.toString(arr3) + " is = " + findMin(arr3, 0, arr3.length - 1));

        int[] arr4 = new int[]{15, 18, 2, 3, 6, 12};
        System.out.println("Minimum in given array : " + Arrays.toString(arr4) + " is = " + findMin(arr4, 0, arr4.length - 1));
    }

    public static int findMin(int[] arr, int low, int high) {
        // ans :
        // Time Complexity: O(logN), using binary search
        // Auxiliary Space: O(1)

        // This condition is needed to handle the case when array is not rotated at all
        if (high < low) return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // find mid
        int mid = low + (high - low) / 2;

        // Check if element (mid+1) is minimum element. - Consider the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid]) return arr[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1]) return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid]) return findMin(arr, low, mid - 1);

        return findMin(arr, mid + 1, high);
    }


}
