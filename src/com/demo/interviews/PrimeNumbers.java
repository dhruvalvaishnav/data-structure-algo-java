package com.demo.interviews;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeNumbers {
    public static void main(String[] args) {
//        [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
//         check the prime number
//        int number = 13;
        List<Integer> primeNumbers = new ArrayList<>();
        for (int number = 1; number <= 50; number++) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                primeNumbers.add(number);
//                System.out.println("Num : " + number + " is prime number");
            }
//            else {
//                System.out.println("Num : " + number + " is not prime number");
//            }
        }

        System.out.println(primeNumbers);

//        usingJava8();
    }

    // using Java 8
    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }

    private static void usingJava8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 23, 99, 4, 56, 21, 35, 47, 78, 65, 33, 1, 62, 40, 100);
        numbers.stream().filter(PrimeNumbers::isPrime).forEach(System.out::println);

    }
}


