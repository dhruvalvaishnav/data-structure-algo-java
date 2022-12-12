package com.demo.interviews;

import java.util.*;

public class JackAndJill {
    public static void main(String[] args) {
        System.out.println(playTheGame(new int[]{2, 3}));
        System.out.println(playTheGame(new int[]{16, 16, 16}));
    }

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)
    private static int playTheGame(int[] target) {
        // length of the array
        int n = target.length;

        int result = 0;

        // Keep looping while all elements of target don't become 0.
        while (true) {
            // To store count of zeroes in current target array
            int zero_count = 0;

            int i;  // To find first odd element
            for (i = 0; i < n; i++) {
                // If odd number found
                if (target[i] % 2 == 1)
                    break;

                    // If 0, then increment zero_count
                else if (target[i] == 0)
                    zero_count++;
            }

            // All numbers are 0
            if (zero_count == n)
                return result;

            // All numbers are even
            if (i == n) {
                // Divide the whole array by 2 and increment result
                for (int j = 0; j < n; j++)
                    target[j] = target[j] / 2;
                result++;
            }

            // Make all odd numbers even by subtracting one and increment result.
            for (int j = i; j < n; j++) {
                if (target[j] % 2 == 1) {
                    target[j]--;
                    result++;
                }
            }
        }
    }
}


/*
    Jack and Jill were going through a jungle to city. They encountered a monster who told they will only be allowed to escape when they solve a puzzle for him. They
    didn't have a choice so they agreed. He states problem like : I have n buckets having 0 fruits in each bucket initially.
    I will give you n numbers denoting fruits required at nth position. But you need to keep 2 simple rules:

    1) Either you can increment fruit count by 1 in each bucket i.e. Incremental Operation
    2) Or you can double the fruits in each bucket i.e. Doubling operation.

    Function Description:
    Provide implementation for method play_the_game(target).
    play_the_game has the following parameter(s):

    target: an integer list denoting numbers of fruits required at nth position.

    Example:
    Input: 23
    Output: 4
    Explanation:
    To get the target bucket from (0, 0), we first increment both elements by 1 (2 operations), then double the targetay (1 operation).
    Finally, increment second element (1 more operation)

    Input: 16 16 16
    Output: 7
    Explanation:
    To get the target bucket from (0, 0), we first increment all three elements by 1 (3 operations), then double the targetay (4 operations).

 */