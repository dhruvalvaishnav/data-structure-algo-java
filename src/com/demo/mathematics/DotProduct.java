package com.demo.mathematics;

import java.util.Arrays;

/* Given two arrays of integers, returns the dot product of the arrays.

    Test Cases:

        INPUT:
              array1 = [1, 2];
              array2 = [2, 3];
        OUTPUT: hint {1*2+2*3}
              Result =[8]

 */
public class DotProduct {
    public static void main(String[] args) {
        System.out.println(dotProduct(new int[]{1, 2}, new int[]{2, 3}));
        System.out.println(dotProduct(new int[]{1, 3}, new int[]{4, 5}));
        System.out.println(dotProduct(new int[]{4, 1}, new int[]{1, 5}));
    }

    private static long dotProduct(int[] array1, int[] array2) {
        System.out.print("The dot product of the given array : " + Arrays.toString(array1)
                + " and " + Arrays.toString(array2) + " is = ");

        if (array1.length != array2.length) return 0L;

        long result = 0L;
        for (int i = 0; i < array1.length; i++) {
            result += (long) array1[i] * array2[i];
        }
        return result;
    }

}
