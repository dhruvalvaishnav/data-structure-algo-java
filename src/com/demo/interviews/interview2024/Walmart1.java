package com.demo.interviews.interview2024;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Walmart1 {

    public static void main(String[] args) {

        int[][] matrix1 = {{0, 1, 1, 1, 0}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {0, 1, 1, 1, 0}};
        System.out.println("Number of islands: " + getNumbersOfIslands(matrix1)); // Expected output: 2

        int[][] matrix2 = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println("Number of islands: " + getNumbersOfIslands(matrix2));  // Expected output: 2

        List<Integer> integers = Arrays.asList(1, 2, 3, 2, 1, 4, 1, 5, 4, 2, 3);
        //System.out.println(integers);
        int n = 2;
        // 3, 4 ,5 ,4  3
        integers = integers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> !(x.getValue() > n))
//                .map(x->x.getKey())
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream()) // Replicate elements based on their count
                .collect(Collectors.toList());

        System.out.println(integers);
    }

    // Method to count the number of islands
    private static int getNumbersOfIslands(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0; // Edge case: empty grid
        int cols = matrix[0].length;

        int islandCount = 0;

        // Loop through every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is land (1), we start a DFS to mark the entire island
                if (matrix[i][j] == 1) {
                    islandCount++; // We found a new island
                    dfs(matrix, i, j); // Mark all cells on the current island as visited
                }
            }
        }

        return islandCount;
    }

    // Helper method to perform DFS and mark connected land cells
    private static void dfs(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if out of bounds or the cell is water (0)
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 0) {
            return;
        }

        // Mark the current land cell as visited by setting it to water (0)
        // breaking condition, or we can say by which checking will be stop in dfs
        matrix[i][j] = 0;

        // Explore in all four directions (down, up, right, left)
        dfs(matrix, i, j + 1); // Move right
        dfs(matrix, i + 1, j); // Move down
        dfs(matrix, i, j - 1); // Move left
        dfs(matrix, i - 1, j); // Move up
    }

}

/*
Q - 1
    Given an m x n 2D binary grid(matrix) grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    0 1 1 1 0
    1 0 1 0 1
    1 0 1 1 1
    0 1 1 1 0
    //2

    0 1 0
    0 0 0
    0 1 0
    //2

Q - 2
    Write a small function to remove all elements in a list of integers having frequency greater than n using Java Streams.

 */