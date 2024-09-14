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
        // leftRotate(arr, 4);
//        leftRotate(arr, 5);
//        leftRotate(arr, 6);
        rightRotate(arr, 4);
    }

    /* Function to left rotate arr[] of size n by startIndex */
    private static void leftRotate(int[] arr, int startIndex) {
        int endIndex = arr.length;
        startIndex = startIndex % endIndex;
        int i, j, k, temp;
        int g_c_d = gcd(startIndex, endIndex);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + startIndex;
                if (k >= endIndex) k = k - endIndex;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        System.out.println("Left Rotated Array from Element " + startIndex + " is = " + Arrays.toString(arr));
    }

    /* Function to right rotate arr[] of size n by startIndex */
    private static void rightRotate(int[] arr, int startIndex) {
        int endIndex = arr.length;
        startIndex = startIndex % endIndex;
        int i, j, k, temp;
        int g_c_d = gcd(startIndex, endIndex);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + startIndex;
                if (k >= endIndex) k = k - endIndex;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        System.out.println("Right Rotated Array from Element " + startIndex + " is = " + Arrays.toString(arr));
    }

    /*Function to get gcd of a and b
     what is gcd? gcd is the greatest common divisor of two numbers eg. gcd(4, 6) = 2 and gcd(4, 7) = 1 */
    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
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

    /* Function to reverse arr[] from startIndex to endIndex */
    private static void reverse(int[] arr, int startIndex, int endIndex) {
        int temp;
        while (startIndex < endIndex) {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
