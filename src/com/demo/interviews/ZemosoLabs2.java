package com.demo.interviews;

public class ZemosoLabs2 {
    public static void main(String[] args) {
        System.out.println(getTheContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(getTheContainer(new int[]{1, 24, 25, 6, 1}));
    }

    private static int getTheContainer(int[] nums) {
        System.out.print("The max area of water the container can contain is : ");
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int distance = j - i;
                int y = Math.min(nums[i], nums[j]);
                int area = distance * y;
                output = Math.max(area, output);
            }
        }
        return output;
    }
}

/*
    DS ALGO - ROUND 2 -

    You are given an integer array 'height' of length n. There are n vertical lines drawn such that the two
    endpoints of the ith line are (i,0) and (i, height[i]).

    Find two lines the together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Example :
        Input : height = [1,8,6,2,5,4,8,3,7]
        Output : 49
        Explanation : The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
                      the max area of water the container can contain is 49.
 */