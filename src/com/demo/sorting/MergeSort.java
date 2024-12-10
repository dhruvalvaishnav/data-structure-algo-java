package com.demo.sorting;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 10-12-2024
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(sort(new int[]{8, 65, 4, 32, 2, 10, 0})));
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    private static int[] sort(int[] arr) {
        if (arr.length < 2) return new int[]{-1};

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        sort(left);
        sort(right);

        return merge(arr, left, right);
    }


    private static int[] merge(int[] arr, int[] left, int[] right) {

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr;

    }
}
