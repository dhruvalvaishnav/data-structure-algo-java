package com.demo.interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestImmutable {
    public static void main(String[] args) {
        List<String> myHobbies = Arrays.asList("Cricket", "Hockey");

        Person p = new Person("test1", myHobbies);

        // will throw an exception - java.lang.UnsupportedOperationException
//        myHobbies.add("Music");

        Person p1 = new Person("test2", myHobbies);

        System.out.println("object of Person: " + p);
        System.out.println("object of Person: " + p1);
    }
}


class Person {
    private final String name;
    private final List<String> degrees;

    public Person(String name, List<String> degrees) {
        this.name = name;
        this.degrees = Collections.unmodifiableList(degrees);
    }

    public String getName() {
        return name;
    }

    public List<String> getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", degrees=" + degrees + '}';
    }
}