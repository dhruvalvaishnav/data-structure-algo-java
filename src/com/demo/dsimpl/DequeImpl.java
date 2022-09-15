package com.demo.dsimpl;

import java.util.Arrays;

/*
        Implement a double-ended queue (abbreviated to deque) that stores strings.
        A deque is a data structure that has characteristics of both a queue and a stack.
        Elements can be added or removed from either the front or back.

Signature:
             Create Class Deque
 */
public class DequeImpl {
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        System.out.println("Insert an element at rear end : 5 ");
        deque.insertRear(5);

        System.out.println("Insert an element at rear end : 10 ");
        deque.insertRear(10);

        System.out.println("Insert an element at front end : 15 ");
        deque.insertFront(15);

        System.out.println("Elements in deque : " + Arrays.toString(deque.arr));

        System.out.println("Get the rear element : " + deque.getRear());

        deque.deleteRear();
        System.out.println("After removing the rear element the new rear element is : " + deque.getRear());

        System.out.println("Insert an element at front end : 15 ");
        deque.insertFront(15);

        System.out.println("Elements in deque : " + Arrays.toString(deque.arr));

        System.out.println("Get the front element : " + deque.getFront());

        deque.deleteFront();
        System.out.println("After removing the front element the new front element is : " + deque.getFront());


    }
}

class Deque {
    static final int MAX = 5;
    int[] arr;
    int front;
    int rear;
    int size;

    public Deque(int size) {
        this.arr = new int[MAX];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    // check if deque is full or not
    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    // check if deque is empty or not
    boolean isEmpty() {
        return (front == -1);
    }

    // returns front element from the deque
    int getFront() {
        // check weather deque is empty or not
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        // check weather deque is empty or not
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    // insert an element at front
    void insertFront(int key) {
        // check weather deque is full or not
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        // If queue is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        // front is at first position of queue
        else if (front == 0) {
            front = size - 1;
        }
        //decrement front by '1'
        else {
            front = front - 1;
        }
        // insert current element into deque
        arr[front] = key;
    }

    // insert an element from the rear-end
    void insertRear(int key) {
        // check weather deque is full or not
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        // If queue is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        }

        // rear is at last position of queue
        else if (rear == size - 1) {
            rear = 0;
        }
        //increment rear by '1'
        else {
            rear = rear + 1;
        }
        // insert current element into deque
        arr[rear] = key;
    }

    // Deletes element at front end of deque
    void deleteFront() {
        // check weather deque is empty or not
        if (isEmpty()) {
            System.out.println(" Queue Underflow \n");
            return;
        }
        // deque has only one element
        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            // back to initial position
            if (front == size - 1) front = 0;
            else // increment front by '1' to remove current front value from deque
                front = front + 1;
        }
    }

    // Deletes element at rear end of deque
    void deleteRear() {
        // check weather deque is empty or not
        if (isEmpty()) {
            System.out.println(" Underflow \n");
            return;
        }
        // deque has only one element
        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            // back to initial position
            if (rear == 0) rear = size - 1;
            else // decrement rear by '1' to remove current rear value from deque
                rear = rear - 1;
        }
    }
}