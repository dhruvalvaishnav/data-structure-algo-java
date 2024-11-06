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


    /*
         What is PriorityQueue?
         PriorityQueue is a queue data structure that retrieves elements based on their priority.
         In a priority queue, an element with high priority is served before an element with low priority.
         In Java, PriorityQueue is a class that extends AbstractQueue and implements the Queue interface.
         PriorityQueue is not resizable. The size of the priority queue is fixed.
         PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at the time of creation of the queue.
         The head of the priority queue is the least element based on the natural ordering or comparator based ordering.
         The element with the least value is removed first from the priority queue.
         If multiple elements are present with the same value, then the order is not guaranteed.
         PriorityQueue does not allow null values. PriorityQueue is not thread-safe. You can use PriorityBlockingQueue in a concurrent environment.
         PriorityQueue is not synchronized. You can use PriorityQueue with Collections.synchronizedList() method.
        */


    //For Integer[]
    //Default PriorityQueue is min heap in Java
    private static int kthLargestElement(Integer[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(arr).subList(0, k));
        System.out.println("PriorityQueue : " + pq);

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll(); // poll() method removes the head of the queue, here it removes the smallest element
                pq.add(arr[i]);
            }
        }
        return pq.peek(); // peek() method retrieves the head of the queue
        // time complexity of this solution is O(nlogk)
        // space complexity of this solution is O(k)
    }

    private static int kthSmallestElement(Integer[] arr, int k) {
        //Make PriorityQueue max heap here by using Collections.reverseOrder() method
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.asList(arr).subList(0, k));
        System.out.println("PriorityQueue in reverse order : " + pq);

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.poll(); // poll() method removes the head of the queue, here it removes the largest element
                pq.add(arr[i]);
            }
        }
        return pq.peek(); // peek() method retrieves the head of the queue
    }


}
