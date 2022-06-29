package com.demo.interviews;

import java.util.*;

public class DynamicArray {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();//Dynamic array
        Scanner input = new Scanner(System.in);
        System.out.println("Press 'y' to add a number to the array:");
        while (true) {
            char c = input.next().charAt(0);
            if (c == 'y') {
                System.out.println("Enter a number:");
                int i = input.nextInt();
                array.add(i);
                System.out.println("Press 'y' to continue :");
            }//End of if
            else {
                break;
            }//End of else
        }//End of while
        int len = array.size();
        System.out.println("The array is : " + array + " and its length is : " + len);
    }

}