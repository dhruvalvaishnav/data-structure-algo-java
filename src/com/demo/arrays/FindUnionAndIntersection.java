package com.demo.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class FindUnionAndIntersection {
    public static void main(String[] args) {
        Integer[] a1 = {85, 25, 1, 32, 54, 6, 2};
        Integer[] a2 = {85, 2,65};

        doUnion(a1, a2);
//        doIntersection(a1, a2);
    }

    private static void doIntersection(Integer[] a1, Integer[] a2) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(a1));
        hashSet.addAll(Arrays.asList(a2));
        hashSet.retainAll(Arrays.asList(a2));
        System.out.println("Intersection of given two arrays : " + hashSet);
    }

    private static void doUnion(Integer[] a1, Integer[] a2) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(a1));
        hashSet.addAll(Arrays.asList(a2));

        System.out.println("Union of given two arrays : " + hashSet);
    }
}
