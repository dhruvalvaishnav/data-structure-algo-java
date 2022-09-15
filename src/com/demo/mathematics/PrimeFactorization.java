package com.demo.mathematics;

import java.util.ArrayList;

/*
    Return an array containing prime numbers whose product is x
    Examples:
        primeFactorization( 6 ) == [2,3]
        primeFactorization( 5 ) == [5]
        primeFactorization( 12 ) == [2,2,3]

        Test Cases- Input: 6
                    Output:[2,3]

 */
public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(primeFactorization(6));
        System.out.println(primeFactorization(5));
        System.out.println(primeFactorization(12));
        System.out.println(primeFactorization(1440));
        System.out.println(primeFactorization(46));
    }

    public static ArrayList<Integer> primeFactorization(int n) {
        System.out.print("the prime factorization of " + n + " is = ");

        // if n <= 0 return;
        if (n <= 0) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int div = 2; div * div <= n; div++) {
            while (n % div == 0) {
                n /= div;
//                System.out.print(div + " ");
                result.add(div);
            }
        }
        if (n != 1) {
//            System.out.print(n);
            result.add(n);
        }
        return result;
    }
}
