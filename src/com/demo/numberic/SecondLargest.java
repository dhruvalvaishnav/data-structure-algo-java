package com.demo.numberic;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {9, 8, 5, 6, 4, 7, 2, 1, 3};
//        int[] arr = {6575,57575,985989,980,34,3};
        //8 - second highest number
        findSecondLargest(arr);

        /*
        // Q.1 remove duplicates from two arrays + merge two arrays
        int[] arr1 = {1, 5, 3, 6, 8, 9, 4, 25, 11, 30, 15, 16};
        System.out.println("arr1 size : " + arr1.length);
        int[] arr2 = {21, 22, 32, 68, 88, 90, 47, 23, 7, 33, 45, 1, 5, 3, 46};
        System.out.println("arr2 size : " + arr2.length);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, 0);
        }
        for (int i : arr2) {
            map.put(i, 0);
        }
        System.out.println("map :: " + map.keySet().stream().sorted().collect(Collectors.toList()).size());
        System.out.println("map :: " + map.keySet().stream().sorted().collect(Collectors.toList()));

         */
    }

    //sort and find second largest
    private static void findSecondLargest(int[] arr) {
        //{9, 8, 5, 6, 4, 7, 2, 1, 3};
        // 8,9
        //5,8,9

//        using brute-force
//        int largest, temp = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(arr[arr.length - 2]);

        //using binary search
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j > secondLargest && j != largest) {
                secondLargest = j;
            }
        }
        System.out.println("Second Largest in given array : " + Arrays.toString(arr) + " is = " + secondLargest);
    }
}
