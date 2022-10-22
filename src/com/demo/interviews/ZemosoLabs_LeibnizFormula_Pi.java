package com.demo.interviews;

/*
    https://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80

    https://stackoverflow.com/questions/19121438/leibniz-formula-for-pi-java

    The Leibniz Formula for PI is:
       1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13 - 1/15 ... = pi/4

    Question:
    How do you write the Leibniz Formula for PI with java?

    Here is a java example that implements the Gregory Leibniz Series:

 */
public class ZemosoLabs_LeibnizFormula_Pi {
    public static void main(String[] args) {
        System.out.println(calculatePi(10000));
    }

    private static double calculatePi(int count) {
        double pi = 0, denominator = 1;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                pi = pi + (1 / denominator);
            } else {
                pi = pi - (1 / denominator);
            }
            denominator = denominator + 2;
        }
        pi = pi * 4;
        return pi;
    }
}
