package com.demo.arrays;

import java.util.Arrays;

public class CyclicallyRotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Given Array is = " + Arrays.toString(arr));

        rotate(arr);

        System.out.println("Rotated Array is = " + Arrays.toString(arr));

        System.out.println("*************************************************");

        System.out.println("Given Array is = " + Arrays.toString(new int[]{1, 2, 3, 4, 5, 6, 7}));
        leftRotate(arr, 4, 7);
        System.out.println("Left Rotated Array from Element " + 4 + " is = " + Arrays.toString(arr));

    }

    /*Function to left rotate arr[] of siz n by d To handle if d >= n */
    private static void leftRotate(int[] arr, int d, int n) {
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*Function to get gcd of a and b*/
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static void rotate(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }
}
