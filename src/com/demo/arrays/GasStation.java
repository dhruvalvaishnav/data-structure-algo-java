package com.demo.arrays;

import java.sql.Time;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * <p>
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * <p>
 * <p>
 * Constraints:
 * n == gas.length == cost.length
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
//https://leetcode.com/problems/gas-station/
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{3, 0, 0}, new int[]{1, 1, 1})); // 0
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})); // -1
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})); // 3
    }

    //    Time Complexity: O(n), where n is the number of stations.
//    Space Complexity: O(1), as we use only a few extra variables for tracking gas and current station.
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, currentGas = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            // If currentGas becomes negative, reset the start to the next station
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }

        // If totalGas is less than 0, there's not enough gas to complete the circuit
        return totalGas >= 0 ? start : -1;
    }

    // Time complexity is O(n) for the solution. The sum() method you have is O(n), so calling it twice results in a time complexity of O(n) + O(n), which is still O(n).
    // Space Complexity: O(1),
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) return -1;

        int total = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }


}
