package com.demo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthMaxMin {

    public static void main(String[] args) {
        Integer[] numbers = {95, 45, 12, 34, 22, 87, 64, 75};
        int k = 4;
        Arrays.sort(numbers);

        System.out.println("Sorted Array : " + Arrays.toString(numbers));
        System.out.println("-----------------------------");
        System.out.println("Kth (" + k + ") Maximum element in given array : " + kthLargestElement(numbers, k));
        System.out.println("-----------------------------");
        System.out.println("Kth (" + k + ") Minimum element in given array : " + kthSmallestElement(numbers, k));
    }

    //For Integer[]
    //Default PriorityQueue is min heap in Java
    private static int kthLargestElement(Integer[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(arr).subList(0, k));

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    private static int kthSmallestElement(Integer[] arr, int k) {
        //Make PriorityQueue max heap here by using Collections.reverseOrder() method
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.asList(arr).subList(0, k));

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }


}
