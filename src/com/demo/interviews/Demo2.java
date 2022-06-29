package com.demo.interviews;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(method());
    }

    public static String method() {
        try {
            return "in try";
        } catch (Exception e) {
            return "in catch";
        } finally {
            return "in finally";
        }
    }
}
