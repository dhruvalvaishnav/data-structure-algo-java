package com.demo.interviews;

public class Volkswagen2 {
    public static void main(String[] args) {
        int rows = 6, i, j;
        for (i = 1; i < rows; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();

        getPerm("ABC", 0);
    }

    private static void getPerm(String str, int start) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
