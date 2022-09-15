package com.demo.mathematics;

import java.util.Arrays;

/*
     Given two fractions passed in as int arrays,
     returns the fraction which is result of adding the two input fractions
     Fraction is represented as a two-element array - [ numerator, denominator ]
     The returned fraction has to be in its simplest form.

Test Cases:

     INPUT:
        fraction1 - [2, 3];
        fraction2 - [1, 2];

     OUTPUT: Hint-  {2/3 +1/2}
        result = [7,6]

 */
public class AddFraction {
    public static void main(String[] args) {
        int[] fraction1 = {2, 3};
        int[] fraction2 = {1, 2};
//        System.out.println(Arrays.toString(addFractions(fraction1, fraction2)));
        System.out.println(Arrays.toString(addFractions(fraction1[0], fraction1[1], fraction2[0], fraction2[1])));
    }

    private static int[] addFractions(int num1, int den1, int num2, int den2) {

        // Finding gcd of den1 and den2
        int den3 = gcd(den1, den2);

        // Denominator of final fraction obtained
        // finding LCM of den1 and den2
        // LCM * GCD = a * b
        den3 = (den1 * den2) / den3;

        // Changing the fractions to have same denominator
        // Numerator of the final fraction obtained
        int num3 = (num1) * (den3 / den1) + (num2) * (den3 / den2);

        // Calling function to convert final fraction
        // into it's simplest form
        lowest(den3, num3);

        return new int[]{num3, den3};
    }

    private static void lowest(int den3, int num3) {

        // Finding gcd of both terms
        int common_factor = gcd(num3, den3);

        // Converting both terms into simpler terms by dividing them by common factor
        den3 = den3 / common_factor;
        num3 = num3 / common_factor;

        System.out.println(num3 + "/" + den3);
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
