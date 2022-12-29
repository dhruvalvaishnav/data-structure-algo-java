package com.demo.interviews;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Areteminds_2 {
    public static void main(String[] args) {

        int[] arr = new int[]{0, 2, 1, 0, 2, 1, 2, 0, 1, 2, 0, 1, 2, 0};
        System.out.println(Arrays.toString(sortedArray(arr)));

        int[] arr1 = new int[]{87, 96, 41, 32, 52};
        System.out.println(findAnELe(arr1, 40));
        System.out.println(findAnELe(arr1, 32));
        System.out.println(findAnELe(arr1, 87));

    }

    //    Time Complexity: O(N)
//    Auxiliary Space: O(1)
    private static boolean findAnELe(int[] arr, int target) {
//        Using Stream.anyMatch() method
        return IntStream.of(arr).anyMatch(x -> x == target);

//        Using List.contains() method
//         2. Arrays.asList(arr).contains(toCheckValue);

//        Using the Binary Search method
//         3. sort given array
//        Arrays.sort(arr);
//         check if the specified element is present in the array or not using Binary Search method
//        int res = Arrays.binarySearch(arr, target);
//        boolean test = res > 0 ? true : false;

//        4. Using the Linear Search method
//        boolean test = false;
//        for (int i : arr) {
//            if (i == target) {
//                test = true;
//                break;
//            }
//        }
//        return test;
    }

    // Counting Approach: Merge Sort
    //    // time - O(n)
    //    // space - O(n)
    // O(N)
    private static int[] sortedArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i : arr) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else if (i == 2) {
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
}


/*
There are 8 balls , heavy and lighter in weights , How will you find which one is heaviest ?

Palindrome Number ?
String Palindrome ?
Core Java Basic –
How garbage collector works?
Memory Management ?
@primary @qualifier , What does it mean ?

sorting of the map reverse order, by key
threads, thread pool executor framework
buffered memory - file io operation

Solid Principles
 */

