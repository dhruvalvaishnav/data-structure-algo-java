package com.demo.interviews;

import java.util.Arrays;
import java.util.TreeSet;

public class Wissen {
    public static void main(String[] args) {

        int[] A = new int[]{2, 4, 5, 3, 1, 6};

        System.out.println(medianWithRange(A, 1, 6));
        System.out.println(medianWithRange(A, 2, 4));
        System.out.println(medianWithRange(A, 3, 3));

//        System.out.println(median(A));
//        System.out.println(median(new int[]{4,5,3}));
//        System.out.println(median(new int[]{5}));

        System.out.println("**************************************************************************************");
//        System.out.println(farthestFromZero(5, new int[]{1, 2, 3, 4, 5}));
//        System.out.println(farthestFromZero(4, new int[]{-10, 7, 5, 1}));
//        System.out.println(farthestFromZero(4, new int[]{-200, -10, 7, 7, 5, 1, 7, 5, 1}));
//        System.out.println(farthestFromZero(6, new int[]{-100, 90, -80, 500, -2, 50}));
//        System.out.println(farthestFromZero(6, new int[]{-100, 90, 80, 50, -200, 2}));

//        Parent p = new Child();
//        p.xyz();

//        Child c = (Child) new Parent();
//        c.xyz();


    }

    private static int medianWithRange(int[] A, int L, int R) {

        int[] B = Arrays.copyOfRange(A, L - 1, R);

        Arrays.sort(B);

        int median;
        int val = (B.length) / 2;

        if ((B.length % 2) == 0) {
            median = (int) ((B[val] + B[val - 1]) / 2.0);
        } else {
            median = B[val];
        }
        return median;
    }

    private static int median(int[] A) {
        Arrays.sort(A);

        int median;
        int val = (A.length) / 2;

        if ((A.length % 2) == 0) {
            median = (int) ((A[val] + A[val - 1]) / 2.0);
        } else {
            median = A[val];
        }
        return median;
    }

    private static int farthestFromZero(int N, int[] A) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            ts.add(A[i]);
        }
        int maxV = ts.last();
        int minV = ts.first();

        if (Math.abs(minV) >= maxV) {
            return minV;
        }
        return maxV;
    }
}

class Parent {
    Parent(){
        System.out.println("in parent");
    }

    void xyz(){
        System.out.println("in parent method");
    }
}

class Child extends Parent {
    Child(){
        System.out.println("in child");
    }

    void xyz(){
        System.out.println("in child method");
    }
}

/*

    1. median of subarray : find median of subarray

    int[] A = new int[]{1, 2, 3, 4, 5, 6};

    where N = length
    A = array
    L & R - integers (ranges)

    private static int median(int N, int[] A, int L, int R) {
    }

    make new array B = which is 1 indexed

    input :
    6
    1 2 3 4 5 6
    L=1,R=6 => array will be - {1, 2, 3, 4, 5, 6}
    L=2,R=4 => array will be - {3, 4, 5}
    L=3,R=3 => array will be - {5}

    output :
    3
    4
    5

2. farthest from zero
3. sql - child father mother

*/