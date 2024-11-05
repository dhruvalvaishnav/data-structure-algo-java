package com.demo.matrix;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dhruval Vaishnav Created on 04-11-2024
 */
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public static void main(String[] args) {
        //Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        //Output: 4
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println("Maximal Square: " + maximalSquareRecursive(matrix));
        System.out.println("Maximal Square: " + maximalSquareDP(matrix));
    }

    // 1. dynamic programming - bottom up approach
    private static int maximalSquareDP(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxLength = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols]; // Create a dp array to store the size of the square

        // Fill the dp array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is '0', it can't be part of a square
                if (matrix[i][j] == '1') {
                    // If it's the first row or first column, it can only be a square of size 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // First row or column
                    } else {
                        // The cell is not on the first row or first column
                        int top = dp[i - 1][j]; // Top
                        int left = dp[i][j - 1]; // Left
                        int diagonal = dp[i - 1][j - 1]; // Diagonal
                        // The cell is part of a square if all the cells in this "mini-square" are '1's
                        dp[i][j] = Math.min(Math.min(top, left), diagonal) + 1;
                    }
                    // Update the maxLength
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength; // Area of the square
        // time complexity is O(m*n) and space complexity is O(m*n)
    }

    // 2. recursive - top-down approach
    public static int maximalSquareRecursive(char[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        // Create a memoization table or cache to store the results of sub problems
        // we can use hashmap also
        Map<String, Integer> map = new HashMap<>();
        // Initialize the memoization table with -1
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                map.put(r + "," + c, -1);
            }
        }
        // Find the maximum length of the square
        int maxLength = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // Recursively find the size of the square ending at (r, c)
                maxLength = Math.max(maxLength, helper(r, c, matrix, map));
            }
        }
        return maxLength * maxLength; // Area of the square
        // time complexity is O(m*n) and space complexity is O(m*n)
//        int[][] memo = new int[ROWS][COLS];
//        for (int r = 0; r < ROWS; r++) { // Initialize the memoization table with -1
//            for (int c = 0; c < COLS; c++) {
//                memo[r][c] = -1;
//            }
//        }
//        // Find the maximum length of the square
//        int maxLength = 0;
//        for (int r = 0; r < ROWS; r++) {
//            for (int c = 0; c < COLS; c++) {
//                // Recursively find the size of the square ending at (r, c)
//                maxLength = Math.max(maxLength, helper(r, c, matrix, memo));
//            }
//        }
//        return maxLength * maxLength;
        // time complexity is O(m*n) and space complexity is O(m*n)
    }

    private static int helper(int r, int c, char[][] matrix, int[][] memo) {
        // Check boundaries
        if (r >= matrix.length || c >= matrix[0].length || matrix[r][c] == '0') {
            return 0;
        }
        // Return the cached result if it exists
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        // Recursively find the size of the square
        int right = helper(r, c + 1, matrix, memo);
        int down = helper(r + 1, c, matrix, memo);
        int diag = helper(r + 1, c + 1, matrix, memo);

        // The size of the largest square ending at (r, c)
        memo[r][c] = Math.min(Math.min(right, down), diag) + 1;
        return memo[r][c];
    }

    private static int helper(int r, int c, char[][] matrix, Map<String, Integer> map) {
        // Check boundaries
        if (r >= matrix.length || c >= matrix[0].length || matrix[r][c] == '0') {
            return 0;
        }
        // Return the cached result if it exists
        String key = r + "," + c;
        if (map.containsKey(key) && map.get(key) != -1) {
            return map.get(key);
        }
        // Recursively find the size of the square
        int down = helper(r + 1, c, matrix, map);
        int right = helper(r, c + 1, matrix, map);
        int diag = helper(r + 1, c + 1, matrix, map);

        // The size of the largest square ending at (r, c) is the minimum of the sizes of the squares
        // here we are adding 1 because we are considering the current cell also
        map.put(key, Math.min(Math.min(right, down), diag) + 1);
        return map.get(key);
    }
}
