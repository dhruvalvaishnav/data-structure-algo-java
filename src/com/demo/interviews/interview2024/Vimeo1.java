package com.demo.interviews.interview2024;

import java.util.*;

public class Vimeo1 {
    public static void main(String[] args) {

        findLargest(new int[]{3, 5, 1, 2, 8, 9}, 3);
        findLargest(new int[]{15, 14, 1, 8, 67, 3, 10, 11, 45}, 4);
        findLargest(new int[]{17, 11, 12, 13, 19, 8, 9, 20}, 2);


        findCommon1(new int[]{1, 50, 6, 10, 16, 78, 4}, new int[]{100, 51, 10, 4, 89});
        findCommon2(Arrays.asList(1, 50, 6, 10, 16, 78, 4), Arrays.asList(100, 51, 10, 4, 89));


    }

    private static void findCommon1(int[] arr1, int[] arr2) {
        int a = arr1.length, b = arr2.length, k = 0;
        int[] res = new int[a];
        Arrays.sort(arr2);
        for (int i : arr1) {
            int found = Arrays.binarySearch(arr2, i);
            if (found >= 0) {
                res[k] = arr2[found];
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(res[i] + " ");
        }
        //System.out.print(Arrays.toString(Arrays.copyOf(res, k))); // Output the common elements
    }

    private static void findCommon2(List<Integer> list1, List<Integer> list2) {
        // Fix: If you need to use the list version, it's better to use a HashSet for list2 to reduce the time complexity to O(n + m) using hash-based lookups.
        Set<Integer> set = new HashSet<>(list2); // Use a Set for O(1) lookup
        List<Integer> list3 = new ArrayList<>();
        for (int num : list1) {
//            if (list2.contains(num)) { // This is inefficient because for each element of list1, it searches the entire list2 list.
//                list3.add(num);
//            }
            if (set.contains(num)) {
                list3.add(num);
            }
        }
        System.out.println(list3);
        //System.out.println(set);
        // Time Complexity: This results in O(n * m) time complexity where n is the length of list1 and m is the length of list2.
    }

    private static void findLargest(int[] arr, int k) {
        // The PriorityQueue is a min-heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
    }


}


/*

    1. Find the k-largest numbers in an array without using sort function or manually implementing sort function, use of any other technique is acceptable. Sample input and output:
        findLargest([3, 5, 1, 2, 8, 9], 3) => [9, 8, 5]
        findLargest([15, 14, 1, 8, 67, 3, 10, 11, 45], 4) => [15, 14, 67, 45]
        findLargest([17, 11, 12, 13, 19, 8, 9, 20], 2) => [19,20]

    2. Find the common elements between two lists A, B without using extra auxiliary space (for intermediate computation)
       and without using methods like array_intersect in PHP. There can be more than one common element. Sample input and output:
       [1, 50, 6, 10, 16, 78, 4], [100, 51, 10, 4, 89] -> [10, 4]


 */