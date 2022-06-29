package com.demo.interviews;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemoWithEquals {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "A");
        Employee e2 = new Employee(1, "B");
        Employee e3 = new Employee(1, "A");

        HashSet<Employee> set = new HashSet<Employee>();

        set.add(e1); // Employee A added
        set.add(e2); // Employee B added
        set.add(e3); // Employee A added

        System.out.println(set.size());
        //Employee doesn't override equals() - prints 3
        //Employee override equals() - prints 2
    }

    private static class Employee {
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
