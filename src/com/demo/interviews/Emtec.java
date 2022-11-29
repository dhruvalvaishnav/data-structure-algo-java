package com.demo.interviews;

import java.util.*;

public class Emtec {

    static List<EmployeeEmtec> employeeList = new ArrayList<>();
    static Set<EmployeeEmtec> employeeSet = new HashSet<>();

    public static void main(String[] args) {

        EmployeeEmtec e1 = new EmployeeEmtec(1, "Rahul", "Singh");
        EmployeeEmtec e2 = new EmployeeEmtec(2, "Rohit", "Singh");

        addEmployee(e1); //unique employee object
        addEmployee(e1);
        addEmployee(e2);

        System.out.println(employeeList.size());
        System.out.println(employeeSet.size());
    }

    private static void addEmployee(EmployeeEmtec e) {
        // duplicate added - list size = 3
//        employeeList.add(e);

        // to prevent duplicate in list - list size = 2
//        if (!employeeList.contains(e)) {
//            employeeList.add(e);
//        }

        // set size = 2
        employeeSet.add(e);
    }
}

class EmployeeEmtec {

    private int id;
    private String firstName;
    private String lastName;

    public EmployeeEmtec(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEmtec employee = (EmployeeEmtec) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
}



