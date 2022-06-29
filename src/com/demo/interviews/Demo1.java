package com.demo.interviews;

import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {

    }
}

//    Write a program to generate the following output in java?
/*      *
        **
        ****
        *****
        ******
        int i;
        int count=1;
        for (i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println(" ");

        }
        */

//    Write a program to generate the following output.
 /*     ****
        ***
        **
        *
        int i;
        int count=1;
        for (i=5;i>=1;i--){
            for (int j=1;j<=i;j++)
                System.out.print("*");
            System.out.println(" ");
        }

//Write a program in java to remove all vowels from a string.
/*
    Scanner sc = new Scanner(System.in);
    String n = sc.nextLine();
    String n1 = n.replaceAll("[AEIOUaeiou]", "");
    System.out.println(n1);
  */

// Write a program in java to check for palindromes.
   /*
    String str, rev = "";
    Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
    str = sc.nextLine();

    int length = str.length();

        for (int i = length - 1; i >= 0; i--)
    rev = rev + str.charAt(i);

        if (str.equals(rev))
            System.out.println(str + " is a palindrome");
        else
                System.out.println(str + " is not a palindrome");
        */

