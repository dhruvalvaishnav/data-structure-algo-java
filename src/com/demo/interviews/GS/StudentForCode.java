package com.demo.interviews.GS;

import java.util.Objects;

public class StudentForCode {
    private String name;
    private int numberOfScores;
    private int sumOfScores;

    public StudentForCode(String name, int numberOfScores, int sumOfScores) {
        this.name = name;
        this.numberOfScores = numberOfScores;
        this.sumOfScores = sumOfScores;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfScores() {
        return numberOfScores;
    }

    public void setNumberOfScores(int numberOfScores) {
        this.numberOfScores = numberOfScores;
    }

    public int getSumOfScores() {
        return sumOfScores;
    }

    public void setSumOfScores(int sumOfScores) {
        this.sumOfScores = sumOfScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentForCode student = (StudentForCode) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "StudentForCode{" + "name='" + name + '\'' + ", numberOfScores=" + numberOfScores + ", sumOfScores=" + sumOfScores + '}';
    }
}
