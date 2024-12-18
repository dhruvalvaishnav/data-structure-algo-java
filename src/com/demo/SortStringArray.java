package com.demo;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 18-12-2024
 */
public class SortStringArray {
    public static void main(String[] args) {
        String[] input = new String[]{"programming", "java", "c", "dotnet"};
        String[] output = sort(input);
        System.out.println(Arrays.toString(output));
    }

    private static String[] sort(String[] array) {
        int n = array.length;
        if (n < 2) {
            return new String[]{array[0]};
        }
        int mid = n / 2;
        String[] left = new String[mid];
        String[] right = new String[n - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);

        sort(left);
        sort(right);
        return merge(array, left, right);
    }

    private static String[] merge(String[] array, String[] leftArr, String[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            array[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
        return array;
    }
}
