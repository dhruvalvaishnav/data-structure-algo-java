package com.demo.arrays;

public class ArrayDivisibleByK {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 7, 5, 3};
        System.out.println(countKdivPairs(arr, arr.length, 4));
    }

    public static long countKdivPairs(int[] arr, int n, int k) {
        long count = 0L;
        int[] frequency = new int[k];
        for (int i = 0; i < n; i++) {
            int reminder = arr[i] % k;
            int complement = k - reminder;
            count += reminder == 0 ? frequency[0] : frequency[complement];
            frequency[reminder]++;
        }
        return count;
    }
}