package com.demo.multithreading;

/**
 * @author Dhruval Vaishnav Created on 12-12-2024
 */
public class AccoliteThreading {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new Thread1());
//        Thread t2 = new Thread(new Thread1());
//        t1.start();
//        t2.start();
        System.out.println("--------------------");
        //yield() method causes the currently executing thread object to temporarily pause and allow other threads to execute.
        Thread t3 = new Thread(new Thread2());
        t3.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        System.out.print("A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do nothing
        }
        System.out.print("B");
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.print("A");
        Thread.yield(); // yield() method causes the currently executing thread object to temporarily pause and allow other threads
        System.out.print("B");
    }
}