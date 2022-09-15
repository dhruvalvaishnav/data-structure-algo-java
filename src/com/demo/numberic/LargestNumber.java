package com.demo.numberic;

import java.util.Arrays;

/*
    Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.

    Examples :

        Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
        Output: 500

        Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
        Output: 50

        Corner case (No decreasing part)
        Input: arr[] = {10, 20, 30, 40, 50}
        Output: 50

        Corner case (No increasing part)
        Input: arr[] = {120, 100, 80, 20, 0}
        Output: 120
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 50, 10, 9, 7, 6};
        System.out.println("Maximum in given array : " + Arrays.toString(arr1) + " is = " + findMax(arr1, 0, arr1.length - 1));

        int[] arr2 = new int[]{120, 100, 80, 20, 0};
        System.out.println("Maximum in given array : " + Arrays.toString(arr2) + " is = " + findMax(arr2, 0, arr2.length - 1));


        int[] arr3 = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println("Maximum in given array : " + Arrays.toString(arr3) + " is = " + findMax(arr3, 0, arr3.length - 1));


        int[] arr4 = new int[]{1, 2, 13, 55, 23, 29, 67, 69};
        System.out.println("Maximum in given array : " + Arrays.toString(arr4) + " is = " + findMax(arr4, 0, arr4.length - 1));


        int[] arr5 = new int[]{1203, 1630, 2810, 6720, 8920};
        System.out.println("Maximum in given array : " + Arrays.toString(arr5) + " is = " + findMax(arr5, 0, arr5.length - 1));

    }

    public static int findMax(int[] arr, int low, int high) {
        // ans :
        // Time Complexity: O(logN), using binary search + recursive
        // Auxiliary Space: O(logN)

//      Base Case: Only one element is present in arr[low..high]
        if (low == high) return arr[low];

//      If there are two elements and first is greater than the first element is maximum
        if ((high == low + 1) && arr[low] >= arr[high]) return arr[low];

//      If there are two elements and second is greater than the second element is maximum
        if ((high == low + 1) && arr[low] < arr[high]) return arr[high];

//      low + (high - low)/2;
        int mid = (low + high) / 2;

//      If we reach a point where arr[mid] is greater than both of
//      its adjacent elements' arr[mid-1] and arr[mid+1],
//      then arr[mid] is the maximum element
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return arr[mid];

//      If arr[mid] is greater than the next element and smaller than the previous
//      element then maximum lies on left side of mid
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) return findMax(arr, low, mid - 1);

        return findMax(arr, mid + 1, high);
    }

}
