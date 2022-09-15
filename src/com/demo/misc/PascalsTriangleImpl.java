package com.demo.misc;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Statement:
        Create a Pascals Triangle

        Example:

                 1
                1 1
               1 2 1
              1 3 3 1
             1 4 6 4 1
            1 5 10 10 5 1
          1 6 15 20 15 6 1

 */
public class PascalsTriangleImpl {
    public static void main(String[] args) {
        generate();
        System.out.println();
        System.out.println(generate(5));
    }

    public static void generate() {
        for (int i = 0; i < 5; i++) {
            int icj = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(icj + "\t");
                int icjp1 = icj * (i - j) / (j + 1);
                icj = icjp1;
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        if (numRows == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 2).get(j) + result.get(i - 2).get(j - 1));
                }
            }
            result.add(row);
        }
        return result;
    }
}
