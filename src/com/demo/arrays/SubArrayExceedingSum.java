package com.demo.arrays;

/*
    Your task is ultimately to implement a function that takes in an array and a integer.
    You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
    and -1 if no such sum exists.

    Test Cases:
      Input:[1,2,3,4,] , k=6
      Output :2

      Input:[1,2,3,4,] , k=-1
      Output :12

      Input: a = [2, 1, 4, 3, 2, 5], K = 7
      Output: 2
      Explanation: The smallest subarray with a sum greater than or equal to '7' is [4, 3]

 */
public class SubArrayExceedingSum {
    public static void main(String[] args) {

        System.out.println("length of shortest sub array = " + subArrayExceedsSum(new int[]{1, 2, 3, 4,}, 6));
        System.out.println("length of shortest sub array = " + subArrayExceedsSum(new int[]{2, 1, 4, 3, 2, 5,}, 7));
        System.out.println("length of shortest sub array = " + subArrayExceedsSum(new int[]{3, 4, 1, 1, 6,}, 8));
        System.out.println("length of shortest sub array = " + subArrayExceedsSum(new int[]{1, 2, 3, 4,}, 100));

    }

    public static int subArrayExceedsSum(int[] arr, int target) {

        int lengthOfShortestSubArray = Integer.MAX_VALUE;

        //sliding window
        int windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add the next element to the window

//            System.out.println("window sum " + windowSum);

            while (windowSum >= target) { // Shrink the window as small as possible until the 'windowSum' is smaller than 'target'
                lengthOfShortestSubArray = Math.min(lengthOfShortestSubArray, ((windowEnd - windowStart) + 1));
                windowSum -= arr[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }
        }

        //brute-force
//        for (int i = 0; i < arr.length; i++) {
//            int currentSubarraySum = 0;
//            for (int j = i; j < arr.length; j++) {
//                currentSubarraySum += arr[j];
//
//                if (currentSubarraySum >= target) {
//                    lengthOfShortestSubArray = Math.min(lengthOfShortestSubArray, j - i + 1);
//                    break;
//                }
//            }
//        }
        return lengthOfShortestSubArray == Integer.MAX_VALUE ? 0 : lengthOfShortestSubArray;
    }

}
