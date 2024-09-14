package com.demo.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Dhruval Vaishnav Created on 02-05-2024
 * <p>
 * Each task now includes a call to Thread.sleep() to simulate some processing time.
 * Adjust the sleep durations to fit the actual processing time you want to simulate for each task.
 *
 */
public class MultiThreadWithSequence {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<?> task1 = executor.submit(() -> {
            System.out.println("Task 1 started");
            // Simulate work being done
            try {
                Thread.sleep(6000); // Simulating 2 seconds of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 completed");
        });

        try {
            // Wait for task 1 to complete
            task1.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Future<?> task2 = executor.submit(() -> {
            System.out.println("Task 2 started");
            // Simulate work being done
            try {
                Thread.sleep(9000); // Simulating 3 seconds of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 completed");
        });

        try {
            // Wait for task 2 to complete
            task2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Future<?> task3 = executor.submit(() -> {
            System.out.println("Task 3 started");
            // Simulate work being done
            try {
                Thread.sleep(10000); // Simulating 1 second of work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 3 completed");
        });

        try {
            // Wait for task 3 to complete
            task3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}