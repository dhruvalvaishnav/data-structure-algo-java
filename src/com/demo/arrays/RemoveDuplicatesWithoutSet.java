package com.demo.arrays;

import java.util.*;

public class RemoveDuplicatesWithoutSet {

    public static void main(String[] args) {
        // we consider the array is already sorted.
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 5};

        //if not then we have to sort the array first and then remove the duplicates from it.
//        int[] arr = {44, 66, 99, 77, 33, 22, 55, 55, 44, 99};
//        Arrays.sort(arr);

        arr = removeDuplicates(arr);
        System.out.println("length of unique array => " + arr.length +" => and the array is => " + Arrays.toString(arr));
    }

    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2) {
            return A;
        }

        int j = 0, i = 1;
        while (i < A.length) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
            i++;
        }

        int[] B = Arrays.copyOf(A, j + 1);
//        System.out.println(Arrays.toString(B));
        return B;
    }
}