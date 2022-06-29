package com.demo.interviews;

import java.util.Objects;

public class hashCodeEqualsTest {
    public static void main(String[] args) {

        Student s1 = new Student("DHRUVAL");
        Student s2 = new Student("DHRUVAL");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    private static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        //if no hashcode method or hashcode method
        // equals method will give - true and == give false (== checks memory allocation/address and equals methods checks objects and it's value)

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
