package com;

/**
 * @author Dhruval Vaishnav Created on 13-12-2024
 * Check if a string can be obtained by rotating another string 2 places
 */
// https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/
public class RotateStringByTwoPlaces {

    public static void main(String[] argh) {
        //String str1 = "amazon",str2 = "azonam";
        String str1 = "amazon", str2 = "onamaz";
        if (isRotate(str1, str2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isRotate(String str1, String str2) {
        int n = str1.length(); // length of String 1
        boolean clockwise = true, anticlockwise = true; // initialize both as true

        // Check if str2 can be obtained by rotating str1
        // clockwise by 2 places
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt((i + 2) % n)) { // check if ith character of str1 is equal to (i+2)th character of str2 and % n is used to get the remainder
                clockwise = false; // not rotated clockwise
                break;
            }
        }

        // Check if str2 can be obtained by rotating str1
        // anticlockwise by 2 places
        for (int i = 0; i < n; i++) {
            if (str1.charAt((i + 2) % n) != str2.charAt(i)) {
                anticlockwise = false; // not rotated anticlockwise
                break;
            }
        }

        // if any of both is true, return true
        return clockwise || anticlockwise;
    }

}

