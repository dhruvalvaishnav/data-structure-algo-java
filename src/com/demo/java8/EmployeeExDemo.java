package com.demo.java8;

import com.demo.java8.models.Address;
import com.demo.java8.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeExDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, 3208, 21, "Nikita R", "IT", "Female", new Address("Street 101", 9901)));
        employeeList.add(new Employee(2, 1209, 28, "Nikita M", "HR", "Female", new Address("Street 657", 1651)));
        employeeList.add(new Employee(3, 1200, 32, "Mehul Y", "IT", "Male", new Address("Street 686", 8322)));
        employeeList.add(new Employee(4, 9011, 25, "Pinal V", "Sales", "Female", new Address("Street 572", 9982)));
        employeeList.add(new Employee(5, 6711, 28, "Mayank Z", "IT", "Male", new Address("Street 462", 8808)));
        employeeList.add(new Employee(6, 2378, 31, "Prasant R", "HR", "Male", new Address("Street 442", 9844)));
        employeeList.add(new Employee(7, 5500, 30, "Krishna P", "IT", "Female", new Address("Street 778", 1919)));
        employeeList.add(new Employee(8, 4309, 25, "Sagar P", "HR", "Male", new Address("Street 799", 5757)));
        employeeList.add(new Employee(9, 9879, 26, "Priyanka R", "IT", "Female", new Address("Street 446", 9898)));
        employeeList.add(new Employee(10, 5670, 25, "Ankita S", "Sales", "Female", new Address("Street 424", 2341)));
        employeeList.add(new Employee(11, 8750, 28, "Ramya A", "IT", "Female", new Address("Street 123", 7611)));
        employeeList.add(new Employee(12, 4500, 21, "Gargi V", "Marketing", "Female", new Address("Street 121", 1098)));
        employeeList.add(new Employee(13, 9810, 30, "Rahul T", "IT", "Male", new Address("Street 101", 2001)));
        employeeList.add(new Employee(14, 7600, 29, "Sanket K", "Sales", "Male", new Address("Street 671", 2301)));
        employeeList.add(new Employee(15, 4100, 22, "Sahil M", "IT", "Male", new Address("Street 810", 2001)));
        employeeList.add(new Employee(16, 6000, 21, "Dhruv J", "Sales", "Male", new Address("Street 791", 9601)));
        employeeList.add(new Employee(17, 8000, 24, "Aditi R", "IT", "Female", new Address("Street 571", 8001)));
        employeeList.add(new Employee(18, 9790, 31, "Samir T", "Marketing", "Male", new Address("Street 911", 3232)));
        employeeList.add(new Employee(19, 6700, 27, "Mansi B", "Sales", "Female", new Address("Street 691", 2536)));

        //find employees in IT department whose salary is > 5000
        System.out.println("Employees in IT department whose salary is > 5000 : ");
        employeeList.stream().filter(s -> Objects.equals(s.getDepartment(), "IT") && s.getSalary() > 5000)
                .collect(Collectors.toList()).forEach(e -> System.out.println(e.getName() + " with salary = " + e.getSalary()));

        System.out.println("**********************************************************");
        //sort employees based on their salary desc order
        System.out.println("Sort employees based on their salary desc order : ");
        employeeList.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("**********************************************************");
        //top three salaried employees
        System.out.println("Top three salaried employees : ");
        employeeList.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).limit(3).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("**********************************************************");
        //fetch all employees having salary less than 3rd highest salary
        System.out.println("All employees having salary less than 3rd highest salary");
        employeeList.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).skip(3).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("**********************************************************");
        //write a comparator in java to compare two employees based upon name, age and address?
        //Age Comparator
        System.out.println("Age Comparator :");
        Collections.sort(employeeList, ((o1, o2) -> o1.getAge() - o2.getAge()));
        employeeList.stream().forEach(System.out::println);

        //Name Comparator
        System.out.println("Name Comparator :");
        Collections.sort(employeeList, ((o1, o2) -> o1.getName().compareTo(o2.getName())));
        employeeList.stream().forEach(System.out::println);

        //Address Comparator - with Street Name
        System.out.println("Address Comparator 1:");
        Collections.sort(employeeList, ((o1, o2) -> o1.getAddress().getStreetName().compareTo(o2.getAddress().getStreetName())));
        employeeList.stream().forEach(System.out::println);

        //Address Comparator - with Pincode
        System.out.println("Address Comparator 2:");
        Collections.sort(employeeList, ((o1, o2) -> o1.getAddress().getPincode() - o2.getAddress().getPincode()));
        employeeList.stream().forEach(System.out::println);

        System.out.println("**********************************************************");
        // java 8 statistics :: get count min max sum and average for the numbers
        List<Integer> ages = employeeList.stream().map(e -> e.getAge()).collect(Collectors.toList());

        int maxAge = ages.stream().mapToInt(x -> x).summaryStatistics().getMax();
        int minAge = ages.stream().mapToInt(x -> x).summaryStatistics().getMin();
        double avgAge = ages.stream().mapToInt(x -> x).summaryStatistics().getAverage();
        double sumAge = ages.stream().mapToInt(x -> x).summaryStatistics().getSum();

        System.out.println("Ages statistics - min age = " + minAge +
                " , max age = " + maxAge + " , sum of all the ages = " + sumAge + " , average of ages = " + avgAge);

        //second-youngest and third-youngest employee - ages - use skip and limit functions

        System.out.println("**********************************************************");
        //fetch all the names, convert it into uppercase and join them with coma
        String names = employeeList.stream().map(x -> x.getName().toUpperCase()).collect(Collectors.joining(",  "));
        System.out.println("Names of all the employees are : " + names);

        System.out.println("**********************************************************");
        //How many employees are male and female
        Map<String, Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("How many employees are male and female : " + genderCount);

        System.out.println("**********************************************************");
        //print the name of all the departments
        List<String> departmentList = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("The name of all the departments : " + departmentList);

        System.out.println("**********************************************************");
        //What is average age of male and female employees
        Map<String, Double> avgAgePerGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("What is average age of male and female employees = " + avgAgePerGender);

        System.out.println("**********************************************************");
        //Get the details of highest paid employee
        Optional<Employee> highestPaid = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Get the details of highest paid employee = " + highestPaid.get().getName());

        System.out.println("**********************************************************");
        //Count the number of employees in each department
        Map<String, Long> empDepartmentWiseCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count the number of employees in each department => " + empDepartmentWiseCount);

        System.out.println("**********************************************************");
        //Average salary of each department
        Map<String, Double> averageSalaryDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary of each department = " + averageSalaryDepartment);

        System.out.println("**********************************************************");
        //Get the details of youngest male employee
        Employee youngestMaleEmp = employeeList.stream().filter(e -> e.getGender().equals("Male")).min(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("Youngest male employee = " + youngestMaleEmp);

        System.out.println("**********************************************************");
        //What is average salary of male and female employees
        Map<String, Double> avgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary)));
        System.out.println("What is average salary of male and female employees = " + avgSalary);

        System.out.println("**********************************************************");
        //List down the names of employees in each department
        Map<String, List<Employee>> empListInEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> empSet = empListInEachDepartment.entrySet();
        for (Map.Entry<String, List<Employee>> employees : empSet) {
            System.out.println("----------------------------------------------");
            System.out.println("Employees in " + employees.getKey() + " department :");
            employees.getValue().stream().map(Employee::getName).forEach(System.out::println);
        }

        System.out.println("**********************************************************");
        //what is the average salary and total salary of the whole organization
        DoubleSummaryStatistics salaries = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("The average salary = $" + salaries.getAverage() + " and total salary of the whole organization = $" + salaries.getSum());

        System.out.println("**********************************************************");
        //Separate the employees who are younger or equal to 25 years from the employees who are older than 25 years
        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        Set<Map.Entry<Boolean, List<Employee>>> ageWiseEmpSet = collect.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : ageWiseEmpSet) {
            System.out.println("----------------------------------------------");
            if (entry.getKey()) {
                System.out.println("Employees older than 25 years :");
            } else {
                System.out.println("Employees younger or equals to 25 years :");
            }
            entry.getValue().stream().map(Employee::getName).forEach(System.out::println);
        }

        System.out.println("**********************************************************");
        //who is the oldest employee in the organization? what is his age? which department he belongs to?
        Employee oldestEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("The oldest employee in the organization = " + oldestEmp.getName() + " and His age = " + oldestEmp.getAge()
                + " and the  department he belongs to = " + oldestEmp.getDepartment());
    }
}
