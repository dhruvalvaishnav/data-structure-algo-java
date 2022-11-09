package com.demo.interviews;

public class Orion {
    public static void main(String[] args) {

        System.out.println(closestElement(new int[]{5, 2, 9, 20, 15}, 10));
        System.out.println(closestElement(new int[]{2, 20, 15}, 10));
        System.out.println(closestElement(new int[]{8, 5}, 10));
        System.out.println(closestElement(new int[]{2}, 10));
        System.out.println(closestElement(new int[]{2, 101, 99, 65, 47, 54, 88}, 100));
        System.out.println(closestElement(new int[]{}, 10));

    }

    static int closestElement(int[] arr, int target) {

        if (arr.length < 1)
            throw new IllegalArgumentException("The values should be at least one element");
        if (arr.length == 1) {
            return arr[0];
        }

        int distance = Math.abs(arr[0] - target);
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            int idistance = Math.abs(arr[i] - target);
            if (idistance < distance) {
                idx = i;
                distance = idistance;
            }
        }
        return arr[idx];
    }
}

/*
SALARY - salary,e_id
EMPLOYEE - id,name,email

find emp with salary >= 'rita' salary

salary -> salary,e_id and
employee -> id,name,email

query : salary >= 'rita' salary

name salary

SELECT e.name, s.salary FROM employee INNER JOIN
employee e AND salary s ON e.id = s.e_id WHERE s.salary >= (SELECT s.salary FROM salary s WHERE e.name= 'rita');


 */