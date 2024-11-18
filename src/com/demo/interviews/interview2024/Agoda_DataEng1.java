package com.demo.interviews.interview2024;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Agoda_DataEng1 {
    // Implement Thread-safe Stack
    // push - add in the stack
    // pop - get last element
    // remove - remove last element
    // getMin in constant time


    public static void main(String[] args) {
        ThreadSafeStack stack = new ThreadSafeStack();

        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);

        System.out.println("Min: " + stack.getMin());  // Should print 1

        stack.pop();  // Removes 8
        System.out.println("Min: " + stack.getMin());  // Should print 1

        stack.remove();  // Removes 1
        System.out.println("Min: " + stack.getMin());  // Should print 2
    }
}


class ThreadSafeStack {
    private LinkedList<Integer> dataStack;    // Holds actual stack elements
    private LinkedList<Integer> minStack;     // Holds the minimum values
    private Lock lock;                        // To ensure thread safety

    // Constructor to initialize the stacks and lock
    public ThreadSafeStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
        lock = new ReentrantLock();
    }

    // Push an element to the stack
    public void push(int value) {
        lock.lock();
        try {
            dataStack.addFirst(value);  // Add to the front of the list (top of the stack)

            // If minStack is empty or the current value is smaller or equal to the top of minStack, push it onto minStack
            if (minStack.isEmpty() || value <= minStack.getFirst()) {
                minStack.addFirst(value);
            }
        } finally {
            lock.unlock();
        }
    }


    // Pop an element from the stack
    public Integer pop() {
        lock.lock();
        try {
            if (dataStack.isEmpty()) {
                return null;  // or throw an exception, depending on your use case
            }

            int poppedValue = dataStack.removeFirst();  // Remove from the front of the list (top of the stack)

            // If the popped value is equal to the top of minStack, pop from minStack too
            if (poppedValue == minStack.getFirst()) {
                minStack.removeFirst();
            }

            return poppedValue;
        } finally {
            lock.unlock();
        }
    }

    // Remove the last element (just like pop, but return void or throw an exception for empty stack)
    public void remove() {
        lock.lock();
        try {
            if (!dataStack.isEmpty()) {
                int removedValue = dataStack.removeFirst();
                if (removedValue == minStack.getFirst()) {
                    minStack.removeFirst();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // Get the minimum element in constant time
    public Integer getMin() {
        lock.lock();
        try {
            if (minStack.isEmpty()) {
                return null;  // or throw an exception if needed
            }
            return minStack.getFirst();
        } finally {
            lock.unlock();
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        lock.lock();
        try {
            return dataStack.isEmpty();
        } finally {
            lock.unlock();
        }
    }


    // Get the size of the stack
    public int size() {
        lock.lock();
        try {
            return dataStack.size();
        } finally {
            lock.unlock();
        }
    }


}
