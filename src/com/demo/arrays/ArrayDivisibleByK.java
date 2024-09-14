package com.demo.arrays;

import java.util.ArrayList;
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
        long count = 0L;
        int[] frequency = new int[k];
        for (int num : arr) {
            int remainder = num % k;
            int complement = k - remainder;
            count += remainder == 0 ? frequency[0] : frequency[complement];
            frequency[remainder]++;
        }
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