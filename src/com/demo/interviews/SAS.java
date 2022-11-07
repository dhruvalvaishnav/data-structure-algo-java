package com.demo.interviews;

public class SAS {
    public static void main(String[] args) {
//        System.out.println(fun());
//        System.out.println('j' + 'a' + 'v' + 'a');

        /*
            Given a binary array nums, return the maximum number of consecutive 1's in the array.
            Input: nums = [1,1,0,1,1,1]
            Output: 3
         */

        int[] nums = new int[]{1, 1, 0, 1, 1, 1};

        System.out.println(maxConsecutiveOnes(nums)); //3
        System.out.println(maxConsecutiveOnes(new int[]{1,1,1,1,1,1,0,0,0,1})); //6
        System.out.println(maxConsecutiveOnes(new int[]{0,1,1,0,0,0,0,0,1,1,1,1,0})); //4


    }

    private static int maxConsecutiveOnes(int[] nums) {
        // brute-force
        /*
        int max = 0, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == 1 && nums[j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        return max;

        */

        int max = 0, count = 0;
        for (int a : nums) {
            if (a == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;

    }

//    static int fun() {
//        return 20;
//    }
}


