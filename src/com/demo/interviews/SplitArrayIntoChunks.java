package com.demo.interviews;

import java.util.Arrays;
import java.util.stream.IntStream;

//•	Split an array into chunks with a specified size.
public class SplitArrayIntoChunks {
    public static void main(String[] args) {
//        splitArrayIntoChunks(new int[]{1, 2, 3, 4, 5}, 2);
        splitArrayIntoChunks(new int[]{1, 2, 3, 4, 5}, 3);

        // by another solution
//        System.out.println(Arrays.deepToString(splitArray(new int[]{1, 2, 3, 4, 5}, 3)));
//        System.out.println(Arrays.deepToString(splitArray(new int[]{1, 2, 3, 4, 5}, 2)));

//        System.out.println(Arrays.deepToString(chunk(new int[]{1, 2, 3, 4, 5}, 2)));

    }

    private static void splitArrayIntoChunks(int[] arr, int chunkSize) {
        for (int i = 0; i < arr.length; i += chunkSize) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, Math.min(arr.length, i + chunkSize))));
        }
    }

    private static int[][] splitArray(int[] arrayToSplit, int chunkSize) {
        if (chunkSize <= 0) {
            return null;  // just in case :)
        }
        // first we have to check if the array can be split in multiple arrays of equal 'chunk' size
        int rest = arrayToSplit.length % chunkSize;  // if rest>0 then our last array will have less elements than the others

        // then we check in how many arrays we can split our input array
        int chunks = arrayToSplit.length / chunkSize + (rest > 0 ? 1 : 0); // we may have to add an additional array for the 'rest'

        // now we know how many arrays we need and create our result array
        int[][] arrays = new int[chunks][];

        // we create our resulting arrays by copying the corresponding part from the input array. If we have a rest (rest>0), then
        // the last array will have less elements than the others. This needs to be handled separately, so we iterate 1 times less.
        for (int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++) {
            // this copies 'chunk' times 'chunkSize' elements into a new array
            arrays[i] = Arrays.copyOfRange(arrayToSplit, i * chunkSize, i * chunkSize + chunkSize);
        }
        if (rest > 0) { // only when we have a rest
            // we copy the remaining elements into the last chunk
            arrays[chunks - 1] = Arrays.copyOfRange(arrayToSplit, (chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
        }
        return arrays; // that's it
    }

    // using pure java8
    public static int[][] chunk(int[] input, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize)
                .limit((long) Math.ceil((double) input.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(input, j, Math.min(j + chunkSize, input.length)))
                .toArray(int[][]::new);
    }
}
