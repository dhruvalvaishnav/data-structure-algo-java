package com.demo.interviews.interview2024;

import com.demo.java8.models.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dhruval Vaishnav Created on 24-10-2024
 */
public class Practice1 {
    public static void main(String[] args) {

        int k = 2;
        int[] nums = {3, 2, 1, 5, 6, 4};
        List<Employee> list = Arrays.asList(
                new Employee(5, 6000, 25, "Vedant", "HR", "M", null),
                new Employee(1, 3000, 25, "Bilal", "IT", "M", null),
                new Employee(3, 4000, 25, "Brijesh", "Sales", "M", null),
                new Employee(4, 5000, 25, "Dhruv", "HR", "M", null),
                new Employee(2, 3000, 25, "Mukesh", "IT", "M", null),
                new Employee(6, 4000, 25, "Ankit", "HR", "M", null));
        //findKthLargest(nums, k);

        // if Salary same then based on the name filter java 8
        List<Employee> collected = list.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(collected);


        //freqOfCharsInString();
        //separateOddEven();

        // anagram -> race car, car race
        // find if two strings are anagram or not
//        String one = "listen", two = "silent";
//        if (isAnagram(one, two)) {
//            System.out.println("Given two strings are anagram");
//        } else {
//            System.out.println("Given two strings are not anagram");
//        }

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            // keep size of priority queue to k because we need kth largest element
            if (pq.size() > k) {
                pq.poll(); // remove smallest element
            }
        }
        System.out.println(pq);
        return pq != null ? pq.peek() : -1;
    }

    private static void freqOfCharsInString() {
        // find frequency of characters in String
        String str = "Bilal";
        Map<Character, Long> collect = str.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    private static void separateOddEven() {
        List<Integer> list = Arrays.asList(12, 45, 66, 87, 33, 44, 23, 67, 44);

        // Separate odd and even numbers from List<Integer> using java 8 function
        // way 1
        Map<String, Set<Integer>> map = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "EVEN" : "ODD", Collectors.toSet()));
        System.out.println(map);
        // way 2
        Map<Boolean, Set<Integer>> collect = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toSet()));
        System.out.println(collect);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // way 1
        // time complexity is O(n)
        // space complexity is O(n)
        Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : s.toCharArray()) {
            if (!sMap.get(c).equals(tMap.get(c))) {
                return false;
            }
        }
        return true;


        //way 2
        //time complexity is O(nlogn)
        //space complexity is O(n)
//        String collect1 = Stream.of(s.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
//        String collect2 = Stream.of(t.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
//        return collect1.equalsIgnoreCase(collect2);
    }


    /*
    // WAP to segregate employees based on their department and sort them as per their salary
        employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.departmentName))
                .forEach((department, employeeList) -> {
                    System.out.println("Department: " + department);
                    employeeList.stream()
                            .sorted(Comparator.comparingInt(employee -> employee.salary))
                            .forEach(employee -> System.out.println(employee.name + " " + employee.salary));
                });
     */

}
