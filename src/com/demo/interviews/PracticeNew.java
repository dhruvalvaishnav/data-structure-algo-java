package com.demo.interviews;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class PracticeNew {
    public static void main(String[] args) {

        //Find the first non-repeating character in a string.
        String str = "aabbccc";

        String s = str.chars().mapToObj(x -> Character.valueOf((char) x)).collect(Collectors.groupingBy(x -> Character.valueOf((char) x), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey()).findFirst().map(String::valueOf).orElse("$");

        System.out.println(s);

        // Rotate an array to the right by k steps.
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        int k = 3;
        k = k % arr.length;
        rotate(arr, 0, arr.length - 1);
        rotate(arr, 0, k - 1);
        rotate(arr, k, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        // Merge two sorted arrays into one sorted array.
        //Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
        // Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
        int[] arr1 = new int[]{1, 3, 4, 5}, arr2 = new int[]{2, 4, 6, 8};
        mergeTwoSortedArr(arr1, arr2);
        mergeWithoutDuplicates(arr1, arr2);



    }

    private static void mergeTwoSortedArr(int[] arr1, int[] arr2) {

        // 1 -
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int i = 0, j = 0, k = 0;
//        int[] arr3 = new int[n1+n2];
//
//        while (i < n1) {
//            arr3[k++] = arr1[i++];
//        }
//        while (j < n2) {
//            arr3[k++] = arr2[j++];
//        }
//
//        Arrays.sort(arr3);
//        System.out.println(Arrays.toString(arr3));
        // the total time complexity is O(n1 + n2) - The merging loop iterates through both arrays once
        // the total space complexity is O(n1 + n2) - due to the additional array arr3 created to hold the merged results.


        // 2 - java 8
        //int[] arr3 = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).sorted().distinct().mapToInt(Integer::intValue).toArray();
        //System.out.println(Arrays.toString(arr3));
        // Creating Streams: Creating the streams takes O(n1 + n2).
        // Sorting: The sorting operation has a time complexity of O((n1 + n2) log(n1 + n2)).
        //  the total time complexity is O((n1 + n2) log(n1 + n2)) due to the sorting step being the most significant factor.

        //Intermediate Arrays: The intermediate boxed array created during the stream operations requires O(n1 + n2) space.
        //Final Output: The conversion back to an int[] also requires O(n1 + n2).
        // Thus, the overall space complexity is O(n1 + n2).

        // 3 - To merge two sorted arrays in Java efficiently, you can use a two-pointer approach.
        // This allows you to traverse both arrays simultaneously,
        // comparing elements and building the merged array without requiring additional sorting.

        int n = arr1.length, m = arr1.length, i = 0, j = 0, k = 0;
        int[] mergedArr = new int[n + m];
        // Traverse both arrays
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1, if any
        while (i < n) {
            mergedArr[k++] = arr1[i++];
        }
        // Copy remaining elements of arr2, if any
        while (j < m) {
            mergedArr[k++] = arr2[j++];
        }

        System.out.println("mergeWithDuplicates : " + Arrays.toString(mergedArr));
    }


    public static void mergeWithoutDuplicates(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] tempMerged = new int[n + m];
        int k = 0, i = 0, j = 0;

        while (i < n || j < m) {
            int valueToAdd;
            if (i < n && (j >= m || arr1[i] < arr2[j])) {
                valueToAdd = arr1[i++];
            } else if (j < m) {
                valueToAdd = arr2[j++];
            } else {
                break;
            }

            // Add only if it's not a duplicate
            if (k == 0 || tempMerged[k - 1] != valueToAdd) {
                tempMerged[k++] = valueToAdd;
            }
        }

        Arrays.copyOf(tempMerged, k); // Resize to the actual number of unique elements
        System.out.println("mergeWithoutDuplicates : " + Arrays.toString(tempMerged));
    }


    private static void rotate(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


}
