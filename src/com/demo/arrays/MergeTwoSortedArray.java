package com.demo.arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {

    static int[] arr1 = {1, 5, 9, 10, 15, 20};
    static int[] arr2 = {2, 3, 8, 13};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println();

        merge(arr1.length, arr2.length);

        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));

        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));

        System.out.println("===========================================================================");
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        // two integers m and n, representing the number of elements in nums1 and nums2 respectively.
        int m = (int) Arrays.stream(nums1).filter(x -> x != 0).count();
        int n = (int) Arrays.stream(nums2).filter(x -> x != 0).count();
        merge(nums1, m, nums2, n);
    }

    //Merge Sorted Array : https://leetcode.com/problems/merge-sorted-array/
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;  // If nums2 is empty, no need to do anything
        if (m == 0) { // If nums1 is empty, copy nums2 into nums1
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        // Pointers for nums1, nums2 and the last index of merged array
        int i = m - 1; // Last element of nums1
        int j = n - 1; // Last element of nums2
        int k = m + n - 1; // Last index of merged array

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        // If there are remaining elements in nums2, copy them
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }

    private static void merge(int n, int m) {
        int i = 0, temp;

        // While loop till last element of array 1(sorted)
        // is greater than first element of array 2(sorted)
        while (arr1[n - 1] > arr2[0]) {
            if (arr1[i] > arr2[0]) {

                // Swap arr1[i] with first element of arr2
                // and sorting the updated arr2(arr1 is already sorted)
                // swap(arr1[i],arr2[0]);
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }
}


