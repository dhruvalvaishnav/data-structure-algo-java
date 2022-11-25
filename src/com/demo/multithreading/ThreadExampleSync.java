package com.demo.multithreading;

public class ThreadExampleSync extends Thread {
    public static void main(String[] args) throws InterruptedException {
        ThreadExampleSync o1 = new ThreadExampleSync();
        ThreadExampleSync o2 = new ThreadExampleSync();

        o1.start();
        o2.start();

        o1.join();
        o2.join();

    }

    public void run() {
        // Only one thread can call m1 at a time.
        synchronized (ThreadExampleSync.class) {
            m1();
        }
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " - m1 called !");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}