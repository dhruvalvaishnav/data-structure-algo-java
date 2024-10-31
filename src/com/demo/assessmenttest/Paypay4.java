package com.demo.assessmenttest;

import java.util.*;

public class Paypay4 {
    public static void main(String[] args) {

        int[] a = new int[]{3, 4}, b = new int[]{1, 2, 3};
        int[][] queries = new int[][]{{1, 5}, {0, 0, 1}, {1, 5}};

        int[] solution = solution(a, b, queries);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] a, int[] b, int[][] queries) {
        // Count frequencies of elements in b
        Map<Integer, Integer> bCount = new HashMap<>();
        for (int num : b) {
            bCount.put(num, bCount.getOrDefault(num, 0) + 1);
        }

        List<Integer> results = new ArrayList<>();

        // Process each query
        for (int[] query : queries) {
            if (query[0] == 0) {
                // Update query [0, i, x]
                int i = query[1];
                int x = query[2];
                a[i] = x; // Update a[i] to x
            } else if (query[0] == 1) {
                // Count query [1, x]
                int x = query[1];
                int count = 0;

                for (int numA : a) {
                    int needed = x - numA;
                    count += bCount.getOrDefault(needed, 0);
                }

                results.add(count);
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }
}

/*
You are given two arrays of integers a and b, and an array queries, the elements of which are queries you are required to process. Every queries[i] can have one of the following two forms:

[0, i, x]. In this case, you need to assign a[i] the value of x (a[i] = x).
[1, x]. In this case, you need to find the total number of pairs of indices i and j such that a[i] + b[j] = x.
Perform the given queries in order and return an array containing the results of the queries of the type [1, x].

Example

For a = [3, 4], b = [1, 2, 3], and queries = [[1, 5], [0, 0, 1], [1, 5]], the output should be solution(a, b, queries) = [2, 1].

The arrays look like this initially:
a = [3, 4] and b = [1, 2, 3]

For the query [1, 5], there are two ways to form a sum of 5 using an element from each array: 5 = 3 + 2 = a[0] + b[1] and 5 = 4 + 1 = a[1] + b[0]. So the result is 2.

The query [0, 0, 1] re-assigns the value of a[0] to 1, so the arrays now look like this:
a = [1, 4] and b = [1, 2, 3]

For the final [1, 5] query, there's now only one way to form a sum of 5 using an element from each array: 5 = 4 + 1 = a[1] + b[0]. So the result is 1.

Since the two queries of type [1, x] gave results of 2 and 1 respectively, the answer is [2, 1].

For a = [2, 3], b = [1, 2, 2], and queries = [[1, 4], [0, 0, 3], [1, 5]], the output should be solution(a, b, queries) = [3, 4].

The arrays look like this initially:
a = [2, 3] and b = [1, 2, 2]

For the query [1, 4], there are three ways to form a sum of 4 using an element from each array: 4 = 2 + 2 = a[0] + b[1], 4 = 2 + 2 = a[0] + b[2], and 4 = 3 + 1 = a[1] + b[0]. So the result is 3.

The query [0, 0, 3] re-assigns the value of a[0] to 3, so the arrays now look like this:
a = [3, 3] and b = [1, 2, 2]

For the query [1, 5], there are now 4 ways to form a sum of 5 using an element from each array: 5 = 3 + 2 = a[0] + b[1], 5 = 3 + 2 = a[0] + b[2], 5 = 3 + 2 = a[1] + b[1], and 5 = 3 + 2 = a[1] + b[2]. So the result is 4.

Since the two queries of type [1, x] gave results of 3 and 4 respectively, the answer is [3, 4].

[input] array.integer a = An array of integers.

Guaranteed constraints:
1 ≤ a.length ≤ 5 · 104,
0 ≤ a[i] ≤ 109.

[input] array.integer b = An array of integers.

Guaranteed constraints:
1 ≤ b.length ≤ 103,
0 ≤ b[i] ≤ 109.

[input] array.array.integer queries

An array of queries, where queries[i][0] represents the type of query, and the other elements represent the parameters of the query (i and x for type 0, and just x for type 1).

For queries of the type [0, i, x], it is guaranteed that 0 ≤ i < a.length and 0 ≤ x ≤ 109.
For queries of the type [1, x], it is guaranteed that 0 ≤ x ≤ 2 · 109

Guaranteed constraints:
1 ≤ queries.length ≤ 103.

[output] array.integer

The output of the queries of the type [1, x], in the order that they are given in the input.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

 */

