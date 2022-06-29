package com.demo.interviews;

public class PrintPairsOfSum {

    public static void main(String[] arg) {
        int[] arr = {1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;
        printPairs(arr, sum);
    }

    private static void printPairs(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == sum)
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
    }
}
