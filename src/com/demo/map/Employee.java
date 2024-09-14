package com.demo.map;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Employee {

    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Copy constructor for deep copying
    public Employee(Employee other) {
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}

class MyTest {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "ABC", 30);
        Employee e2 = new Employee(2, "ABC", 30);

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