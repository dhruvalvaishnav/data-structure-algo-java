package com.demo.linkedlist;

import java.util.*;

public class LinkedListDemo1 {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            integers.add(i);
        }
        System.out.println("LinkedList:: " + Arrays.toString(integers.toArray()));

//      Print last 500 integers from LinkedList - 1000 elements
        ListIterator<Integer> iterator = integers.listIterator(500);
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
    }
}
