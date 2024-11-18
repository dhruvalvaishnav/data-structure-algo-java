package com.demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDivisibleByK {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 7, 5, 3};
        System.out.println(countHowManyPairsDivByK(arr, 4));
        // print pairs
        List<String> pairs = getPairsDivByK(arr, 4);
        System.out.println("Pairs whose sums are divisible by 4:");
        for (String pair : pairs) {
            System.out.println(pair);
        }
    }

    public static long countHowManyPairsDivByK(int[] arr, int k) {
        // Initialize count to 0 to keep track of valid pairs
        long count = 0L;

        // Create a frequency array to track how many numbers have each remainder
        // when divided by k. The array size is k, corresponding to remainders from 0 to k-1.
        int[] frequency = new int[k];

        // Iterate through each number in the array
        for (int num : arr) {
            // Compute the remainder of the current number when divided by k
            int remainder = num % k;

            // The complement remainder that would make the sum divisible by k
            int complement = (k - remainder) % k;

            // If remainder is 0, we need to pair it with another number with remainder 0
            // If remainder is not 0, we need to find how many numbers with complement remainder have appeared before
            count += remainder == 0 ? frequency[0] : frequency[complement];

            // After considering the current number, increment the frequency of its remainder
            frequency[remainder]++;
        }

        // Return the total number of valid pairs
        return count;
    }


    public static List<String> getPairsDivByK(int[] arr, int k) {
        List<String> pairs = new ArrayList<>();

        // Store the indices of elements in a map for quick access
        List<Integer>[] indices = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            indices[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int reminder = arr[i] % k;
            int complement = (k - reminder) % k; // Handle case when reminder is 0

            // Pair current element with previous elements having the complementary remainder
            for (int idx : indices[complement]) {
                pairs.add("(" + arr[idx] + ", " + arr[i] + ")");
            }

            // Add current element index to the list for its remainder
            indices[reminder].add(i);
        }

        return pairs;
    }
}