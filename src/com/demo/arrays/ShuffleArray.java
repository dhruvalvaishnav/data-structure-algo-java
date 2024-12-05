package com.demo.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Dhruval Vaishnav Created on 05-12-2024
 */
public class ShuffleArray {
    public static void main(String[] args) {
        System.out.println("Shuffled Array: " + Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 5})));
    }

    private static int[] shuffle(int[] arr) {
        // Creating a object for Random class to generate random index for swapping
        Random r = new Random();

        // Start from the last element and swap one by one
        for (int i = arr.length - 1; i > 0; i--) {
            // Generate a random index j such that 0 <= j <= i
            int j = r.nextInt(i + 1);
            // Swap arr[i] with the element at random index j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Return the shuffled array
        return arr;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }

}
