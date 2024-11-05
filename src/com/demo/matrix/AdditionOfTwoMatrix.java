package com.demo.matrix;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 04-11-2024
 */
public class AdditionOfTwoMatrix {
    public static void main(String[] args) {
        int[][] firstMatrix = {{1, 2, 3}, {4, 5, 6}, {1, 4, 6}};
        int[][] secondMatrix = {{9, 8, 7}, {6, 5, 4}, {5, 8, 2}};
        // Adding Two matrices
        additionOfTwoMatrix(firstMatrix, secondMatrix);
        System.out.println("After Adding Two matrices, First Matrix is: " + Arrays.deepToString(firstMatrix));
        System.out.println("After Adding Two matrices, Second Matrix is: " + Arrays.deepToString(secondMatrix));
    }

    private static void additionOfTwoMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = firstMatrix[0].length;
        for (int i = 0; i < rows; i++) { // rows
            for (int j = 0; j < cols; j++) { // columns
                firstMatrix[i][j] += secondMatrix[i][j];
            }
        }
    }
}