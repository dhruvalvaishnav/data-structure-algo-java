package com.demo.interviews;

import java.util.*;

public class ImmutableClassDemo {

    private final String FirstName;
    private final String LastName;
    private final Date DOB;
    private final List<String> Hobbies;

    ImmutableClassDemo(String FirstName, String LastName, Date DOB, List<String> Hobbies) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = new Date();
        this.Hobbies = Hobbies;
    }

    public String getFirstname() {
        return this.FirstName;
    }

    public String getLastname() {
        return this.LastName;
    }

    public Date getDOB() {
        return this.DOB;
    }

    public List<String> getHobbies() {
        return this.Hobbies;
    }

    @Override
    public String toString() {
        return "ImmutableClassDemo{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DOB=" + DOB +
                ", Hobbies=" + Hobbies +
                '}';
    }

    public static void main(String[] args) {

        List<String> myHobbies = Arrays.asList("Cricket", "Hockey");
        // to make list immutable
        Collections.unmodifiableList(myHobbies);

        ImmutableClassDemo p = new ImmutableClassDemo("testFirstname", "testLastname", new Date(), myHobbies);
        ImmutableClassDemo p1 = new ImmutableClassDemo("t", "testLastname", new Date(), myHobbies);
        System.out.println("object of ImmutableClassDemo: " + p);
        System.out.println("object of ImmutableClassDemo: " + p1);
    }
}
