package com.demo.interviews.interview2024;

public class PS1 {
    public static void main(String[] args) {

        //2nd smallest element in unsorted array
        int[] arr = new int[]{85, 67, 85, 23, 12, 10, 5, 22, 46, 35};
        System.out.println("2nd smallest element : " + secondSmallest(arr));
        System.out.println("3rd smallest element : " + thirdSmallest(arr));
        System.out.println("2rd largest element : " + secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    private static int secondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            }
            if (num < secondSmallest && num > smallest) {
                secondSmallest = num;
            }
        }
        return secondSmallest;
    }

    private static int thirdSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallest) {
                // Update third, second, and smallest in the right order
                thirdSmallest = secondSmallest;
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                // Update third and second
                thirdSmallest = secondSmallest;
                secondSmallest = num;
            } else if (num > secondSmallest && num < thirdSmallest) {
                // Update third
                thirdSmallest = num;
            }
        }
        // If thirdSmallest is still Integer.MAX_VALUE, it means there's no third-smallest element
        if (thirdSmallest == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Array does not contain a third smallest element.");
        }
        return thirdSmallest;
    }

}





