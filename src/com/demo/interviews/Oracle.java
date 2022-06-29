package com.demo.interviews;

import java.util.*;

public class Oracle {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int arrlength = scanner.nextInt();
//
//        int[] inArr = new int[arrlength];
//
//        for (int i = 0; i < arrlength; i++) {
//            inArr[i] = scanner.nextInt();
//        }
//
//        System.out.println(Arrays.toString(inArr));
//        scanner.close();

//        printMajorityEle(inArr);
        int[] arr = new int[]{9, 1, 1, 6, 5, 6, 6, 5, 6, 6};
        printMajorityEle(arr);
        System.out.println(majorityElement1(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr));

    }

    private static void printMajorityEle(int[] inArr) {
//        System.out.println("halfSizeOfArr :: " + inArr.length / 2);

        //key -element, value -counter
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int num : inArr) {
            if (intMap.containsKey(num)) {
                int count = intMap.get(num) + 1;
                if (count >= inArr.length / 2) {
                    System.out.println("Majority found :- " + num);
                    return;
                } else {
                    intMap.put(num, count);
                }
            } else {
                intMap.put(num, 1);
//                System.out.println("No Majority element");
            }
        }
    }

    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((map.containsKey(num))) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.containsKey(num) && map.get(num) >= nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement3(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                majority = num;
            if (num == majority)
                count++;
            else
                count--;
        }
        return majority;
    }
}

/*
Given an array print the majority element (if it exists), otherwise print “No Majority Element”. A majority element in an
array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

Input Syntax :
Input a number N from stdin
Input N such elements from stdin

Input : 9 1 1 6 5 6 6 5 6 6 -> n/2 = 5
6 - 5times
Output : 6

Explanation: The frequency of 6 is 5 which is greater than the half of the size of the
array size.

Input :8 1 2 4 2 4 2 3 4 -> n/2 = 4
2 - 3times
4 - 3times
Output : No Majority Element

Explanation: There is no element whose frequency is greater than the half of the size
of the array size.



 */

/*
three solutions :

1.
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
            if (map.containsKey(num) && map.get(num) > nums.length/2)
                return num;
        }
        return -1;
    }

2.
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

3.
    public int majorityElement(int[] nums) {
        int majority = 0, count = 0;
        for (int num: nums) {
            if (count == 0)
                majority = num;
            if (num == majority)
                count ++;
            else
                count--;
        }
        return majority;
    }

 */