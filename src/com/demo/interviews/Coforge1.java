package com.demo.interviews;

import java.util.*;

@FunctionalInterface
interface DemoIf {
    public abstract int sum(int a, int b);
}

@FunctionalInterface
interface Sayable{
    public abstract void say(String msg);   // abstract method
}


public class Coforge1 {
    public static void main(String[] args) {
        // find second-largest element in array with the duplicate elements

        List<Integer> numbers = Arrays.asList(12, 12, 85, 99, 41, 33, 63, 41, 22, 33, 1079, 31);
        int[] nums = numbers.stream().mapToInt(number -> number).toArray();
        System.out.println(find2ndLargestWithDuplicates(nums));

        Sayable sayable = (msg) -> System.out.println(msg); // System.out::println
        sayable.say("Hello there");

        DemoIf add3and5 = (a, b) -> a+b; // Integer::sum
        System.out.println(add3and5.sum(3,5));
    }

    private static int find2ndLargestWithDuplicates(int[] nums) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int temp;
        for (int num : nums) {
            if (num > max) {
                temp = max;
                max = num;
                secondMax = temp;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax;

//        Collections.sort(nums);
//        return nums.get(nums.size() - 2);

    }
}

/*

can abstract class have constructor in java?

class Demo {

public static void greetings(){
	System.out.println("Hello");
}
}

(Demo::greetings).

@FunctionalInterface
public interface DemoIf {

public abstract void sum(int a, int b);

}

Main (){

DemoIf<Integer,Integer,Integer> add3and5 = (a,b) -> return a+b;

System.out.println(add3and5.sum(3,5));

}

// Comparable Comparator

// equals and hashcode

// second largest
 */