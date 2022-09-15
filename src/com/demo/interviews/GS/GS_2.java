package com.demo.interviews.GS;

import java.util.*;

// GS - client interview round - 1
public class GS_2 {
    public static void main(String[] args) {

        // find unique tuples from string with length
//        uniqueTuples("Java", 3);
        //Jav
        //ava

        String[][] scores = {{"Bob", "87"}, {"Mark", "64"}, {"Charles", "100"}, {"Charles", "22"}};
        System.out.println(bestAverageCalculator2(scores));
    }

    public static List<String> uniqueTuples(String input, int len) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (i + len <= input.length()) {
                result.add(input.substring(i, i + len));
            }
        }
        System.out.println(result);
        return result;
    }

    // Problem Statement: I have a 2D array of strings containing student names and respective marks as below

    // String[][] scores = {{"Bob","87"},{"Mark","64"},{"Charles","100"},{"Charles","22"}};
    // I want to calculate the best average among all the students available,
    // i.e with the above input the best average should be 87. (87 64 61((100+22)/2) -> max = 87)


    //space complexity of the program is more, and it can be achieved without using the List<Integer>
    public static int bestAverageCalculator(String[][] scores) {

        // This HashMap maps student name to their list of scores
        Map<String, List<Integer>> scoreMap = new HashMap<String, List<Integer>>();

        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            if (scoreMap.containsKey(name)) {
                List<Integer> scoreList = scoreMap.get(name);
                scoreList.add(currentScore);
                scoreMap.put(name, scoreList);
            } else {
                List<Integer> scoreList = new ArrayList<Integer>();
                scoreList.add(currentScore);
                scoreMap.put(name, scoreList);
            }
        }
        System.out.println(scoreMap);
        //scoreMap will be {Mark=[64], Bob=[85], Charles=[100, 22]}
        //After Map is formed I am iterating though all the values and finding the best average as below
        int bestAverage = 0;

        for (List<Integer> value : scoreMap.values()) {
            int sum = 0, count = 0;
            for (int i : value) {
                sum += i;
                count++;
            }
            System.out.println("sum " + sum);
            System.out.println("count " + count);
            int average = (int) Math.floor(sum / count);
            System.out.println("average " + average);

            System.out.println("bestAverage " + bestAverage);

            if (average > bestAverage) bestAverage = average;
        }

        return bestAverage;// returns 87
    }

    // code with a Map<String,int[]> with
    //key: student's name
    //value: an array of two elements [the sum of the scores, the number of scores]
    public static int bestAverageCalculator2(String[][] scores) {

        // This HashMap maps student name to their total scores and count in an int array format of [totalScores, count]
        Map<String, int[]> scoreMap = new HashMap<String, int[]>();

        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            if (scoreMap.containsKey(name)) {
                int[] scoreCount = scoreMap.get(name);
                scoreCount[0] += currentScore;
                scoreCount[1]++;
                scoreMap.put(name, scoreCount);
            } else {
                int[] scoreCount = new int[]{currentScore, 1};
                scoreMap.put(name, scoreCount);
            }
        }

//        for (Map.Entry<String, int[]> o:scoreMap.entrySet()){
//            System.out.print(o.getKey());
//            System.out.println(" = " + Arrays.toString(o.getValue()));
//        }

        //scoreMap will be {Mark=[64], Bob=[85], Charles=[100, 22]}
        //After Map is formed I am iterating though all the values and finding the best average as below
        int bestAverage = 0;

        for (int[] value : scoreMap.values()) {
            int average = (int) Math.floor(value[0] / value[1]);
            System.out.println("average " + average);

            if (average > bestAverage) {
                bestAverage = average;
            }
        }

        System.out.println("bestAverage " + bestAverage);
        return bestAverage;// returns 87
    }
}


/*
    here it is :
    Q.1 : find unique tuples from string with length

    public static List<String> uniqueTuples(String input, int len) {
    }

    Q.2 : I have a 2D array of strings containing student names and respective marks as below
        String[][] scores = {{"Bob","87"},{"Mark","64"},{"Charles","100"},{"Charles","22"}};
        I want to calculate the best average among all the students available,
        i.e with the above input the best average should be 87. (87 64 61((100+22)/2) -> max = 87)

    public static int bestAverageCalculator(String[][] scores) {
    }
*/