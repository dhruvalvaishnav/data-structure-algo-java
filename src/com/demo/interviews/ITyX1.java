package com.demo.interviews;

public class ITyX1 {
    public static void main(String[] args) {
        Employee.getInstance();
    }
}

//singleton class
class Employee {

    private static Employee emp = null;

    private Employee() {
    }

    public static Employee getInstance() {
        if (emp == null) {
            synchronized (Employee.class) {
                if (emp == null) {
                    return emp = new Employee();
                }
            }
        }
        return emp;
    }
}
//multithread
//lazy
//eager

/*
// another file
public class XYZ {
    public static void processEmployee() {
        Employee.getInstance();
    }
}

*/
