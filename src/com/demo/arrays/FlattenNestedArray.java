package com.demo.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlattenNestedArray {
    public static void main(String[] args) {
        Object[] arr = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
        System.out.println(Arrays.toString(flattenArr(arr)));

        // when you assume the leaf objects to be of a specific type:
        int[] flatInt = flatten(arr).mapToInt(Integer.class::cast).toArray();
        System.out.println("flat int: " + Arrays.toString(flatInt));

        // by using regex - if it's string array
        String a = "[[[1],2],[3]],4] ";
        a = a.replaceAll("[(\\[|\\])]", "");
        String[] b = a.split(",");
        System.out.println("b = " + Arrays.toString(b));
    }


    // Java 8’s Stream API offers a compact and flexible solution. Using the method
    private static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array).flatMap(o -> o instanceof Object[] ? flatten((Object[]) o) : Stream.of(o));
    }

    private static Object[] flattenArr(Object[] arr) {
        return new Object[]{Arrays.deepToString(arr)};
    }
}
