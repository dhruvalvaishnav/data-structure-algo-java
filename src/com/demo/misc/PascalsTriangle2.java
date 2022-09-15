package com.demo.misc;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Statement:
        Pascals Triangle exhibits the following behaviour:

         The first and last numbers of each row in the triangle are 1
         Each number in the triangle is the sum of the two numbers above it.

         Example:

                 1
                1 1
               1 2 1
              1 3 3 1
             1 4 6 4 1
            1 5 10 10 5 1
          1 6 15 20 15 6 1

         Please Complete the ‘pascal’ function below so that given a
         col and a row it will return the value in that position.

         Example, pascal(1,2) should return 2

         Test Cases:

            Input : 0,0
            Output:1

            Input : 1,2
            Output:2

            Input : 4,8
            Output:70

 */
public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(pascalRow(3));
//        pascal(0, 0);
//        pascal(1, 2);
//        pascal(4, 8);
    }

    public static int pascal(int col, int row) {
        List<List<Integer>> list = PascalsTriangleImpl.generate(row);
        int sum = 0;
        if (!list.isEmpty()) {
            sum = list.get(row).stream().reduce(Integer::sum).get();
            System.out.println(sum);
        }
        return sum;
    }

    public static ArrayList<Integer> pascalRow(int i) {
        System.out.print("Get the pascal row for = " + i + " => \t");
        // here, row = i
        List<Integer> res = new ArrayList<>();
        int icj = 1;
        for (int j = 0; j <= i; j++) {
            res.add(icj);
            icj = icj * (i - j) / (j + 1);
        }
        return (ArrayList<Integer>) res;
    }

}
