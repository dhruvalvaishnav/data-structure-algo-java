package com.demo.java8.interfaces;

@FunctionalInterface
public interface Finterface {
    int multiply(int a, int b);

    /*
    default void print() {
        System.out.println("print FI");
    }

    default void print1() {
        System.out.println("print FI 1");
    }
    static void print2(){
        System.out.println("in FI");
    }

    static void print3(){
        System.out.println("in FI 2");
    }
    */
}
