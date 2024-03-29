package com.demo.arrays;

public class SecondLargestInArray {
    public static int getSecondLargestBruteForce(int[] a, int total) {
        int temp;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[total - 2];
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 5, 6, 3, 2};
        int[] b = {44, 66, 99, 77, 33, 22, 55};
        System.out.println("Second Largest: " + getSecondLargestBruteForce(a, a.length));
        System.out.println("Second Largest: " + getSecondLargestBruteForce(b, b.length));
        System.out.println();
        System.out.println("Second Largest: " + getSecondLargestBinarySearch(a));
        System.out.println("Second Largest: " + getSecondLargestBinarySearch(b));

    }

    private static int getSecondLargestBinarySearch(int[] arr) {
        int highest = Integer.MIN_VALUE, secHighest = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > highest) {
                secHighest = highest;
                highest = j;
            } else if (j > secHighest) {
                secHighest = j;
            }
        }
        return secHighest;
    }
}

//you can also do using
//Arrays.sort
//Collections.sort

/*
        int[] arr = {-1, 0, 7, 4, 8, 5, 9, 6, 1, 2, 3, 100, 99};

        int highest = Integer.MIN_VALUE,secHighest = Integer.MIN_VALUE;

        for (int j : arr) {

        if (j > highest) {
        secHighest = highest;
        highest = j;
        } else if (j > secHighest) {
        secHighest = j;
        }
        }
        System.out.println(secHighest);

*/