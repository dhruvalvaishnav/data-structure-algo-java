package com.demo.numberic;

/*
    Returns second-smallest element in array x. If x has fewer than 2 elements returns 0.

    Test Cases:
        Input:[ -1, 0, 1, -2, 2]
        Output: -1

        Input:[ 0, 1]
        Output: 1


 */
public class SecondSmallest {
    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{-1, 0, 1, -2, 2}));
        System.out.println(secondSmallest(new int[]{-1, 0}));
        System.out.println(secondSmallest(new int[]{-1, -10}));
        System.out.println(secondSmallest(new int[]{0, -1, 902, 58, -24, 23, 99}));
        System.out.println(secondSmallest(new int[]{90, -77, -8, 0, 13, 89, 32}));
        System.out.println(secondSmallest(new int[]{100, 699, 757, 40, 313, 99, 45}));
    }

    private static int secondSmallest(int[] arr) {
        // If x has fewer than 2 elements returns 0.
        if (arr.length < 2) return 0;

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MAX_VALUE) System.out.println("There is no second" + "smallest element");
        else System.out.println("The smallest element is " + first + " and second Smallest" + " element is " + second);

        return second;
    }
}

/*
    Algorithm:

    1) Initialize both first and second smallest as INT_MAX
       first = second = INT_MAX
    2) Loop through all the elements.
       a) If the current element is smaller than first, then update first
           and second.
       b) Else if the current element is smaller than second then update
        second
 */

