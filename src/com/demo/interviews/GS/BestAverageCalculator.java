package com.demo.interviews.GS;

import java.util.*;

/*
     Problem Statement: I have a 2D array of strings containing student names and respective marks as below

     String[][] scores = {{"Bob","87"},{"Mark","64"},{"Charles","100"},{"Charles","22"}};
     I want to calculate the best average among all the students available,
     i.e. with the above input the best average should be 87. (87 64 61((100+22)/2) -> max = 87)

 */
public class BestAverageCalculator {
    static String[][] scores = {{"Bob", "85"}, {"Charles", "100"}, {"Charles", "22"}, {"Mark", "64"}};

    public static void main(String[] args) {
        List<StudentForCode> students = new ArrayList<>();

        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            StudentForCode student = findStudentByName(name, students);
            if (student != null) {
                student.setNumberOfScores(student.getNumberOfScores() + 1);
                student.setSumOfScores(student.getSumOfScores() + currentScore);
            } else {
                student = new StudentForCode(name, 1, currentScore);
                students.add(student);
            }
        }
        findStudentWithBestAverage(students);
    }

    private static void findStudentWithBestAverage(List<StudentForCode> students) {
        StudentForCode bestStudent = null;
        int bestAverage = 0;
        for (StudentForCode student : students) {
            if ((student.getSumOfScores() / student.getNumberOfScores()) > bestAverage) {
                bestStudent = student;
                bestAverage = (student.getSumOfScores() / student.getNumberOfScores());
            }
        }
        System.out.println(bestStudent + " with average: " + bestAverage);
    }

    private static StudentForCode findStudentByName(String name, List<StudentForCode> students) {
        for (StudentForCode student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
