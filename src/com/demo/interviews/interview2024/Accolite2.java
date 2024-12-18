package com.demo.interviews.interview2024;


/**
 * @author Dhruval Vaishnav Created on 13-12-2024
 * Given String s = "I Work At Accolite Digital"
 * Convert the lowercase character to uppercase and vice versa
 * Output - i wORK aT aCCOLITE dIGITAL
 */
public class Accolite2 {
    public static void main(String[] args) {
        System.out.println("Converted : " + changeLetter("I Work At Accolite Digital"));
        System.out.println("Converted : " + changeLetter("i Work at accolIte digiTal"));
        System.out.println("Converted : " + changeLetter("Dhruval Vaishnav"));
        System.out.println("Converted : " + changeLetter("biLal suRiya"));
    }

    private static String changeLetter(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = input.length();
        while (i < n) {
            char curr = input.charAt(i);
            if (curr != ' ' && Character.isLowerCase(curr)) {
                sb.append(Character.toUpperCase(curr));
            } else if ((curr != ' ' && Character.isUpperCase(curr))) {
                sb.append(Character.toLowerCase(curr));
            } else if (curr == ' ') {
                sb.append(" ");
            }
            i++;
        }
        return sb.toString();
    }
}