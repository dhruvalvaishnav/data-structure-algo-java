package com.demo.numberic;

import java.util.*;

public class HCTNumber {
    public static void main(String[] args) {

        //HCT number or not
        int number = 12345;
        int sum = findSum(number);
        System.out.println("sum 1 : " + sum);
        if (sum % 10 >= 0) {
            sum = findSum(sum);
            System.out.println("sum 2 : " + sum);
        }
        if (sum == findFirstCharacter(number)) {
            System.out.println("Here " + sum + " == " + findFirstCharacter(number));
            System.out.println("Therefore " + number + " is a HCT Number");
        } else {
            System.out.println("Here " + sum + " != " + findFirstCharacter(number));
            System.out.println("Therefore " + number + " is not a HCT Number");
        }

   /*     using while loop
   int digit, sum = 0;
   while (number > 0) {
//          finds the last digit of the given number
            digit = number % 10;
//          adds last digit to the variable sum
            sum = sum + digit;
//          removes the last digit from the number
            number = number / 10;
        } */

        /* using for loop
//executes until the condition number!=0 becomes false
        for (sum = 0; number != 0; number = number / 10) {
//finds the last digit and add it to the variable sum
            sum = sum + number % 10;
        }
        System.out.println(sum);
*/

//        12345 is not a HCT Number
//        1234 is a HCT Number


    }

    //function that finds the sum of digits of a number
    private static int findSum(int number) {
        int sum = 0;
        while (number != 0) {
            //finds the last digit from the number and add it to the variable sum
            sum = sum + number % 10;
            //removes the last digit
            number = number / 10;
        }
        //returns the sum
        return sum;
    }

    private static int findFirstCharacter(int number) {
        int first = 0;
        while (number != 0) {
            //finds the last digit from the number and add it to the variable sum
            first = number % 10;
            number = number / 10;
        }
//        System.out.println("first int : " + first);
        return first;
    }
};



