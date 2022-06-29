package com.demo.interviews;

import java.util.Arrays;

public class ShiftingZeros {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0, 1, 0, 2, 0, 1, 4479, 4564, 0, 5445454, 465, 4, 654, 3, 0, 0, 7874654, 0, 564, 654, 4, 4, 44, 6000000, 0};
//        output : 1 2 1 1 1 2 1 0 0 0 0
        System.out.println(arr.length);

        //shifting zeros to right end of array
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != 0)
//                arr[count++] = arr[i];
//        }
//        //counter should be non-zero ele here
//        System.out.println(count);
//        while (count < arr.length)
//            arr[count++] = 0;
//        System.out.println(Arrays.toString(arr));

        //shifting zeros to left end of array
        int count = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0)
                arr[count--] = arr[i];
        }
        while (count >= 0)
            arr[count--] = 0;
        System.out.println(Arrays.toString(arr));
    }
}
