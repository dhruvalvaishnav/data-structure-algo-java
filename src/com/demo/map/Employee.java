package com.demo.map;

import java.util.*;

public class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class MyTest {

    public static void main(String[] args) {

        Employee e1 = new Employee("ABC", 30);
        Employee e2 = new Employee("ABC", 30);

        Map<Employee, Integer> map = new HashMap();
        map.put(e1, 1);
        map.put(e2, 2);

        System.out.println(map.size());
        // no equals and hashcode - 2
        // equals and hashcode - 1
        // no equals - 2
        // no hashcode - 2
    }

}