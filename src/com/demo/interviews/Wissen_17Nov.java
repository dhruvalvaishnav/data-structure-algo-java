package com.demo.interviews;

import java.util.*;
import java.util.stream.Stream;

public class Wissen_17Nov {
    public static void main(String[] args) throws Exception {
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
//        String s = Arrays.deepToString(array);
//
//        String[] b = s.replaceAll("[(\\[|\\])]", "").split(",");
//        System.out.println("b = " + Arrays.toString(b));


//        Integer[] flattenedArray = flatten1And2(array);

        Integer[] flattenedArray = flatten3(array);
//        Integer[] flattenedArray = flatten4(array);
//        Integer[] flattenedArray = flatten5(array);
        System.out.println(Arrays.toString(flattenedArray));
    }


    public static Integer[] flatten1And2(Object[] inputArray) {

        if (Objects.isNull(inputArray) || inputArray.length <= 0) {
            return new Integer[]{};
        }

        // s1
        Stream<?> stream = Arrays.stream(inputArray)
                .flatMap(o -> {
                    Stream<?> k = null;

                    if (o instanceof Object[]) {
                        try {
                            flatten1And2((Object[]) o);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        k = Stream.of(o);
                    }
                    return k;
                });



        System.out.println(Arrays.toString(stream.mapToInt(Integer.class::cast).toArray()));
        stream.forEach(System.out::println);

        return new Integer[]{};

        //s2
//        return (Integer[]) Arrays.stream(inputArray)
//                .flatMap(o -> {
//                    Stream<?> k = null;
//
//                    if (o instanceof Object[]) {
//                        try {
//                            flatten1And2((Object[]) o);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                    } else {
//                        k = Stream.of(o);
//                    }
//                    return k;
//                }).mapToInt(Integer.class::cast).toArray();


    }


    public static Integer[] flatten3(Object[] inputArray) {
        // s3
        if (Objects.isNull(inputArray) || inputArray.length <= 0) return new Integer[]{};

        List<Integer> flatList = new ArrayList<Integer>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten3((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }

    private static Integer[] flatten4(Object[] inputArray) {
        for (Object o : inputArray) {
            if (o instanceof Object[]) {
                flatten4((Object[]) o);
            } else {
                System.out.print(" " + (Integer) o);
            }
        }
        return new Integer[0];
    }

    public static Integer[] flatten5(Object[] inputArray) {

        List<Object> inputList = (List<Object>) Arrays.asList(inputArray);


        ArrayList<Integer> flatten = new ArrayList<Integer>();
        if (inputList.size() <= 0) {
            return new Integer[0];                          // if the inputList is empty, return an empty Integer[] array.
        }

        for (Object obj : inputList) {
            recursiveFlatten(flatten, obj);                 // otherwise we can recursively flatten the input list.
        }

        Integer[] flatArray = new Integer[flatten.size()];
        return flatArray = flatten.toArray(flatArray);
    }

    /**
     * Recursively flatten a nested array.
     *
     * @param flatten
     * @param o
     */
    private static void recursiveFlatten(ArrayList<Integer> flatten, Object o) {
        if (isInteger(o)) {                               // if the object is of type Integer, just add it into the list.
            flatten.add((Integer) o);
        } else if (o instanceof ArrayList) {              // otherwise, we need to call to recursively flatten the array
            for (Object obj : (ArrayList<Object>) o) {    // for the case where there are deeply nested arrays.
                recursiveFlatten(flatten, obj);
            }
        }
    }

    /**
     * Return true if object belongs to Integer class,
     * else return false.
     *
     * @param obj
     * @return
     */
    private static boolean isInteger(Object obj) {
        return obj instanceof Integer;
    }


}

//**************************

//        Employee-Table
//
//        -- Id
//        -- Name
//        -- Salary
//        -- Department id
//
//        Find one employee from each department who is getting the highest salary within his department.
//
//        Discuss further on server side pagination, boundary cases like 2 emp getting the same salary in the same department which is highest etc.
//
//        SELECT DEPT_ID,name, MAX(SALARY) FROM Employee GROUP BY DEPT_ID;