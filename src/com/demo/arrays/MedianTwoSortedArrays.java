package com.demo.arrays;

import java.util.Arrays;

/*
    Find the median of the two sorted arrays

    Test Cases:
    Input:
        Arr1= [1,3];
        Arr2 = [2,4];
    Output:
        2.5

 */
public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Median of two sorted arrays = " + findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
        System.out.println("Median of two sorted arrays = " + findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);

        double median;

        int val = (mergedArray.length / 2);
        if (mergedArray.length % 2 == 0) {
            median = (mergedArray[val] + mergedArray[val - 1]) / 2.0;
        } else {
            median = mergedArray[val];
        }
        return median;
    }

}
