package com.demo.interviews;

import java.io.Serializable;
import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class Altimetrik_EL {
    public static void main(String[] args) {
        Character character = "apple".chars()
                .mapToObj(s -> (Character.toLowerCase(Character.valueOf((char) s))))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1L).map(d -> d.getKey()).findFirst().get();

        System.out.println(character);

        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());
        System.out.println(SingletonAAA.getInstance());


        Thread t = new Thread(() -> {
            System.out.println(SingletonAAA.getInstance());
        });

        Thread t1 = new Thread(() -> {
            System.out.println(SingletonAAA.getInstance());
        });
        Thread t2 = new Thread(() -> {
            System.out.println(SingletonAAA.getInstance());
        });
        Thread t3 = new Thread(() -> {
            System.out.println(SingletonAAA.getInstance());
        });


    }
}


class SingletonAAA implements Serializable {

    private static volatile SingletonAAA singleton = null;

    private SingletonAAA() {
    }

    public static SingletonAAA getInstance() {
        if (singleton == null) {
            synchronized (SingletonAAA.class) {
                if (singleton == null) {
                    singleton = new SingletonAAA();
                    System.out.println("give obj");
                } else {
                    System.out.println("sorry it's the same obj inner");
                }
            }
        } else {
            System.out.println("sorry it's the same obj outer");
        }

        return singleton;
    }
}

// SQL - second-highest marks - student

// SELECT * FROM student group by marks order by marks desc limit 1,1;

// SELECT * FROM student
//      WHERE marks < (SELECT MAX(marks) FROM student
//                      WHERE marks < SELECT MAX(marks) FROM student);

//====================
// Other
// stuList -> name age section
// avg age of stud section wise
// op : map<String,Long> - section - avg age
// list.stream().collect(Collectors.groupingBy(x->x.getSection(), Collectors.averagingInt(Student::age)));

