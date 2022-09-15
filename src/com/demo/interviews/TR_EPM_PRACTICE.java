package com.demo.interviews;

import sun.security.util.ArrayUtil;

import java.util.*;

public class TR_EPM_PRACTICE {
    public static void main(String[] args) {
        /*
        //fibo
        int n1 = 0, n2 = 1, n3 = 0;
        System.out.print(n1 + " " + n2);
        for (int i = 2; i < 10; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        */

        /*
        //extract prime numbers from the list
        List<Integer> numbs = Arrays.asList(12, 345, 678, 993, 489, 87, 43, 2, 78, 97, 47);
        for (int i = 0; i < numbs.size(); i++) {
            boolean isPrime = true;
            for (int j = 2; i < j; j++) {
                if (numbs.get(i) % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(numbs.get(i) + " is a prime number!!");
            }
        }
        */

        /*
        // print the prime numbers in between 1 and 50.
        for (int number = 1; number <= 50; number++) {
            int count = 0;
            //get the number and check if for the modulo if it is 0 then count++
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            //whenever count is 2 prime the number - which is prime
            if (count == 2) {
                System.out.println(number + " is a prime number");
            }
        }
        */

//        reversenum(111);

        /*
        //generate random between 1 to 100
        for (int i = 0; i < 5; i++) {
            int num = (int) (Math.random() * (100 - 1 + 1) + 1);
            System.out.println(num);
        }
        */

        /*
        for (int i = 1; i <= 5; i++) {
            System.out.println("factorial of number : " + i + " is " + findFactorial(i));
        }
        */

        int[] arr = new int[]{5, 2, 8, 7, 1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("ASC SORT : " + Arrays.toString(arr));

        //use Java 8 Stream to first box the array to sort in reverse order:
        arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println("DESC SORT : " + Arrays.toString(arr));

        //remove duplicates from an array
//        Integer[] nums = {10, 70, 30, 90, 20, 20, 30, 40, 70, 50};
//        Set<Integer> set = new HashSet<>(Arrays.asList(nums));
//        System.out.print(set);
//        if you want to sort it
//        set.stream().sorted().forEach(System.out::print);

        int[] nums2 = {10, 70, 30, 90, 20, 20, 30, 40, 70, 50};
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int j : nums2) set.add(j);
        System.out.println("After removing duplicate elements from an array :: " + set);

        int[] b = {44, 66, 99, 77, 33, 22, 55};
        findNthLargest(b);

        int[] arrayOfInt = new int[]{25, 11, 7, 75, 56};
        findSmallest(arrayOfInt);
        findLargest(arrayOfInt);

        int[] arrOfDuplicates = new int[]{1, 2, 3, 4, 2, 7, 8, 8, 3};
        findDuplicates(arrOfDuplicates);

        int[] newArr = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
        System.out.println("Copied array : " + Arrays.toString(newArr));
    }

    private static void findDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i : array) {
            if (!set.add(i)) {
                duplicates.add(i);
            }
            set.add(i);
        }
        System.out.println("Duplicate elements in given array: " + duplicates);
    }

    private static void findSmallest(int[] array) {
        int min = array[0];
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
        System.out.println("Smallest element present in given array: " + min);
    }

    private static void findLargest(int[] array) {
        int max = array[0];
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Largest element present in given array: " + max);
    }

    private static void findNthLargest(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
//        another trick is to use the sorting of the given collection
//        Arrays.sort(array);
        System.out.println("Third Largest Number in an Array : " + array[array.length - 3]);
    }


    //find a factorial number
    private static int findFactorial(int number) {
        if (number <= 0) return 1;
        return number * findFactorial(number - 1);
    }

    //reverse a number
    private static void reversenum(int number) {
        int reverse = 0, reminder = 0;
        do {
            reminder = number % 10;
            reverse = reverse * 10 + reminder;
            number = number / 10;
        } while (number > 0);
        System.out.println(reverse);
    }
}
