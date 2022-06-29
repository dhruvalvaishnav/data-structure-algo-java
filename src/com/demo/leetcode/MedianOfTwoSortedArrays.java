package com.demo.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        Arrays.sort(mergedArray);
//        {1, 2 , 3, 4};
        double med = 0.0;
        if ((mergedArray.length % 2) == 0) {
            int val = (mergedArray.length) / 2;
            med = (mergedArray[val] + mergedArray[val - 1]) / 2.0;
        } else {
            int val = (mergedArray.length) / 2;
            med = mergedArray[val];
        }
        String.format("%.5g%n", med);
        System.out.println("med " + med);
        return med;
    }
}