package com.demo.interviews;

import java.util.Arrays;

public class Adobe1_TekSystem {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortAnArrayUsingCountingApproach(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
//        System.out.println(Arrays.toString(sortAnArrayUsingBucketApproach(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1})));
        System.out.println(Arrays.toString(sortAnArrayUsingBucketApproach(new int[]{2, 0, 2, 1, 1, 0})));
        System.out.println();
        System.out.println(atoi("512"));
        System.out.println(atoi("1000"));
    }

    // Counting Approach: Merge Sort
    // time - O(n)
    // space - O(n)
    private static int[] sortAnArrayUsingCountingApproach(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int n : arr) {
            if (n == 0) {
                count0++;
            } else if (n == 1) {
                count1++;
            } else if (n == 2) {
                count2++;
            }
        }

        int i = 0;
        while (count0 > 0) {
            arr[i++] = 0;
            count0--;
        }

        while (count1 > 0) {
            arr[i++] = 1;
            count1--;
        }

        while (count2 > 0) {
            arr[i++] = 2;
            count2--;
        }

        return arr;
    }

    // Bucket Sort + Quick Sort (for partition - 0s 1s 2s)
    // time - O(n)
    // space - O(1)
    private static int[] sortAnArrayUsingBucketApproach(int[] arr) {
        // three pointers
        int left = 0, right = arr.length - 1, i = 0;

        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, left, i);
                left++;
            } else if (arr[i] == 2) {
                swap(arr, i, right);
                right--;
                i--;
            }
            i++;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int atoi(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + str.charAt(i) - '0'; // ['5'-'0' => 5]
        }
        return res;
    }

}
