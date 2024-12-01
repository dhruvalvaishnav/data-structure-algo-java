package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 26-11-2024
 */
public class GalaxE1 {
    public static void main(String[] args) {
        List<EmployeeG> list = Arrays.asList(new EmployeeG("dhruval", 500), new EmployeeG("kishan", 500), new EmployeeG("ketan", 600), new EmployeeG("ankit", 2500), new EmployeeG("dhaval", 1500));


        List<EmployeeG> collect = list.stream().sorted(Comparator.comparingDouble(EmployeeG::getSalary).thenComparing(Comparator.comparing(EmployeeG::getName))).collect(Collectors.toList());
        System.out.println(collect);
        //System.out.println("----------");
        //list.stream().sorted(Comparator.comparingDouble(EmployeeG::getSalary).thenComparing(Comparator.comparing(EmployeeG::getName))).forEach(x-> System.out.println(x));

        int[] array = new int[]{12, 52, 66, 33, 10, 8, 88,88,99,33, 99}; // 88
        // get second-highest number from array using java 8
        System.out.println(get2ndHigh(array)); // O(n)

    }

    private static int get2ndHigh(int[] array) {
        int second = Integer.MIN_VALUE, highest = Integer.MIN_VALUE;
        for (int currentEle : array) {
            if (currentEle > highest) {
                second = highest;
                highest = currentEle;
            } else if (currentEle > second && currentEle != highest) {
                second = currentEle;
            }
        }
        return second;
    }

}

class EmployeeG {
    private String name;
    private long salary;

    public EmployeeG(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeG{" + "name='" + name + '\'' + ", salary=" + salary + '}';
    }
}