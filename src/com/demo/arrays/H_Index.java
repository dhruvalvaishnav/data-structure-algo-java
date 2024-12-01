package com.demo.arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
 * return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that
 * the given researcher has published at least h papers that have each been cited at least h times.
 * *
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * <p>
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 * <p>
 * Constraints:
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
// https://leetcode.com/problems/h-index/
public class H_Index {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[]{1, 3, 1}));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;

        // Step 1: Initialize the count array
        int[] count = new int[n + 1]; // count[i] represents how many papers have exactly i citations

        // Step 2: Fill the count array
        for (int c : citations) {
            if (c > n) {
                count[n]++; // Papers with citations greater than n are counted in the last bin
            } else {
                count[c]++;
            }
        }

        // Step 3: Calculate the prefix sum array - count[i] will represent the number of papers with at least i citations
        for (int i = n - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Step 4: Find the largest h such that count[h] >= h
        for (int h = n; h >= 0; h--) {
            if (count[h] >= h) {
                return h; // The h-index is h
            }
        }

        return 0; // If no valid h-index found, return 0
    }


}
