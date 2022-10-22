package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class ValueLabs {

    static List<StudentDummy> list = new ArrayList<>();

    static {
        list.add(new StudentDummy(12, "Abhi", 56, "C"));
        list.add(new StudentDummy(35, "Ashish", 76, "B"));
        list.add(new StudentDummy(44, "Nikul", 86, "B"));
        list.add(new StudentDummy(10, "Manvi", 98, "A"));
        list.add(new StudentDummy(14, "Dhaval", 90, "A"));
        list.add(new StudentDummy(65, "Nistha", 93, "A"));
    }

    public static void main(String[] args) {
//        String a = new String("a");
//        String b = "a";
//
//        System.out.println(a == b);
//        System.out.println(a.equals(b));
//
//        System.out.println();
//
//        // grade == A -> mark*2 -> list
//        List<StudentDummy> collect = list.stream().filter(s -> s.getGrade() == "A")
//                .peek(x -> x.setMarks(x.getMarks() * 2)).collect(Collectors.toList());
//        System.out.println(collect);

        System.out.println(method());

    }

    private static String method() {
        try {
            String a = new String("a");
            String b = "a";

            System.out.println(a == b);
            System.out.println(a.equals(b));

            System.out.println();
            return "try";
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return "out";
    }
}

class StudentDummy {
    private int rollno;
    private String name;
    private int marks;
    private String grade;

    public StudentDummy(int rollno, String name, int marks, String grade) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
        this.grade = grade;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentDummy{" + "rollno=" + rollno + ", name='" + name + '\'' + ", marks=" + marks + ", grade='" + grade + '\'' + '}';
    }
}

/*
// try - catch - finally with return
// String -

        String a = new String("a");
        String b = "a";

        a==b -> false
        a.equals(b); -> true

        no
        name
        marks
        grade

        grade == A -> mark*2 -> list

        List<Student> result = list.stream().filter(s->s.getGrade()=="A").map(x->x.getMarks()*2)
        .collect(Collectors.toList());

        what is kubernetes?
*/

/*
    UNIFY TECH

    List<Employee> empList

    id
    name
    salary

    map -> <Salary,Employee>

    empList.stream().collect(Collectors.toMap(Employee::getSalary,e->e);

    serialize and deserialize singleton object in java

    json - object

    how do you configure eureka?

    how do you configure kafka stream?

    what is your approach to convert json to object or json to map from the kafka producer and consumer

    Diff. environments(dev,test,etc.) having their diff databases (sql,mongodb,oracle).
    how do you make changes in application so that it can have diff queries for associated environment.
    what is your approach to solve this?

 */