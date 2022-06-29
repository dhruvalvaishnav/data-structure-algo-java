package com.demo.multithreading;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    //it passes data synchronously to other threads;
    // it waits for the other party to take the data instead of just putting data and returning (asynchronous operation).

    public static void main(String[] args) {

        final SynchronousQueue<String> queue = new SynchronousQueue<String>();

        Thread producer = new Thread("PRODUCER") {
            @Override
            public void run() {
                String event = "FOUR";
                try {
                    queue.put(event); // thread will block here
                    System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        producer.start(); // starting publisher thread

        Thread consumer = new Thread("CONSUMER") {
            @Override
            public void run() {
                try {
                    String event = queue.take(); // thread will block here
                    System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        consumer.start(); // starting consumer thread }

    }
}

/*    Things to remember about SynchronousQueue in Java

        Here are some of the important properties of this special blocking queue in Java.
        It's very useful to transfer data from one thread to another thread synchronously.
        It doesn't have any capacity and blocks until there is a thread on the other end.

        1. SynchronousQueue blocks until another thread is ready to take the element, one thread is trying to put.

        2. SynchronousQueue has zero capacity.

        3. SynchronousQueue is used to implement the queuing strategy of direct hand-off, where thread hands-off to waiting thread, else creates a new one is allowed, else task rejected.

        4. This queue does not permit null elements, adding null elements will result in NullPointerException.

        5. For purposes of other Collection methods (for example contains), a SynchronousQueue acts as an empty collection.

        6. You cannot peek at a synchronous queue because an element is only present when you try to remove it; Similarly, you cannot insert an element (using any method) unless another thread is trying to remove it.

        7. You cannot iterate over SynchronousQueue as there is nothing to iterate.

        8. A SynchronousQueue constructed with fairness policy set to true grants threads access in FIFO order.

*/