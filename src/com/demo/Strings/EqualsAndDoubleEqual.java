package com.demo.Strings;

public class EqualsAndDoubleEqual {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = new String("abc");
        String a = s1;

        // true coz same obj value
        System.out.println(s1.equals(a));
        // true coz at same memory location
        System.out.println(s1 == a);
        // true coz same obj value
        System.out.println(s2.equals(a));
        // false coz different memory location
        System.out.println(s2 == a);
        // true coz same obj value
        System.out.println(s1.equals(s2));
        // false coz different memory location
        System.out.println(s1 == s2);

    }
}