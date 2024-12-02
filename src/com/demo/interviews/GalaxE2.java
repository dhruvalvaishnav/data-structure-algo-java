package com.demo.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
interface CalculationInterface {
    int add(Integer num1, Integer num2, Integer num3);
}

/**
 * @author Dhruval Vaishnav Created on 02-12-2024
 */
public class GalaxE2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = new LinkedList<>(); // this is allowed

        final List<String> list1 = new ArrayList<>();
        //list1 = new LinkedList<>(); // This would cause a compilation error (reassignment not allowed)
        //list1.add(new String("one")); // This is allowed (modifying the list content)

        // functional interfaces in java 8 are interfaces with only one abstract method
        // they can have multiple default methods and static methods for example: Runnable, Callable, ActionListener, etc.
        // @FunctionalInterface annotation is used to ensure that the interface is a functional interface
        CalculationInterface calculationInterface = new CalculationIntImpl();
        System.out.println(calculationInterface.add(10, 20, 30));
        System.out.println(calculationInterface.add(10, null, 30));
        System.out.println(calculationInterface.add(null, null, null));

    }
}

class CalculationIntImpl implements CalculationInterface {
    // Java 7 way of handling null values
    @Override
    public int add(Integer num1, Integer num2, Integer num3) {
        if (num1 == null) {
            num1 = 100;
        }
        if (num2 == null) {
            num2 = 100;
        }
        if (num3 == null) {
            num3 = 100;
        }
        return num1 + num2 + num3;
    }

// Java 8 way of handling null values
//    @Override
//    public int add(Integer num1, Integer num2, Integer num3) {
//        // Using Optional to handle null values, defaulting to 100 if null
//        return Optional.ofNullable(num1).orElse(100) +
//                Optional.ofNullable(num2).orElse(100) +
//                Optional.ofNullable(num3).orElse(100);
//    }

}
