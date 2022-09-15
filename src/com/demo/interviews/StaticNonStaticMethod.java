package com.demo.interviews;

public class StaticNonStaticMethod {
    public static void main(String[] args) {
//        you can not call non-static method from static method
//        method1("Dhruval");
        /*
        if you want to call than by creating object you can call non-static method
        StaticNonStaticMethod s = new StaticNonStaticMethod();
        s.method1("Dhruval");
        */
        method2("Dhruval");
    }

    public void method1(String name) {
        System.out.println(name);
        // you can call static method from non-static method
        method2("Dhruval");
    }

    public static void method2(String name) {
        System.out.println(name);
        // you can not call non-static method from static method
        // method1("Dhruval");
    }
}

/**
 * https://www.geeksforgeeks.org/difference-between-static-and-non-static-method-in-java/
 */
