package com.demo.interviews;

import java.io.Serializable;
import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class Altimetrik_EL {
    public static void main(String[] args) {
        // Find the first non-repeating character from the given String.
        String str = "apple";
        Character character = str.chars().mapToObj(i -> (Character.valueOf((char) i))).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(x -> x.getValue() == 1L).findFirst().get().getKey();

        /*
        // Convert to lowercase and count character occurrences
        Map<Character, Long> charCount = input.toLowerCase().chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Find the first character with a count of 1
        Optional<Character> firstNonRepeatingChar = charCount.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst();

        // Print the result or a message if no non-repeating character is found
        char result = firstNonRepeatingChar.orElseThrow(() -> new RuntimeException("No non-repeating character found"));
        System.out.println(result);
         */

        System.out.println("First non-repeating character is : " + character + " from the given String : " + str);

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
    /*
    private static: The singleton variable is static, meaning it is shared among all instances of the class.
    It's also private to prevent external access.

    volatile: This keyword ensures that changes to the singleton variable are visible to all threads immediately,
    which helps to prevent issues in a multithreaded environment.
    */

    private SingletonAAA() {
    }
    /*
     * The constructor is private, which prevents external instantiation of the class.
     * This ensures that only one instance of the class can be created.
     * */

    public static SingletonAAA getInstance() {
        if (singleton == null) { // Checks if the instance has already been created. If not, it proceeds to the synchronized block.
            // This block ensures that only one thread can execute the code inside it at a time.
            // This is where the "Double-Checked Locking" pattern comes into play.
            synchronized (SingletonAAA.class) {
                /*
                    A second check is performed to ensure that no other thread has created an instance
                     while the current thread was waiting to enter the synchronized block.
                     If the instance is still null, a new instance is created.
                 */
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

