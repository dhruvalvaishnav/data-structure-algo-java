package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class CitirusTech {
    public static void main(String[] args) {
        EmployeeDummyForCTS rahul = new EmployeeDummyForCTS("Rahul", 15000.00, "Mumbai", Arrays.asList("9221243912", "846429236823"));
        EmployeeDummyForCTS vivek = new EmployeeDummyForCTS("Vivek", 18000.00, "Pune", Arrays.asList("822323912", "84634976823"));
        EmployeeDummyForCTS vaibhav = new EmployeeDummyForCTS("Vaibhav", 13000.00, "Delhi", Arrays.asList("7434343912", "347989436823"));
        EmployeeDummyForCTS sunil = new EmployeeDummyForCTS("Sunil", 25000.00, "Chennai", Arrays.asList("9346443912", "78849236823"));

        List<EmployeeDummyForCTS> emplList = new ArrayList<>();
        emplList.add(rahul);
        emplList.add(vivek);
        emplList.add(vaibhav);
        emplList.add(sunil);

        // map - get the all contacts
        List<String> employeeContacts = emplList.stream().map(EmployeeDummyForCTS::getContactList).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("All employees contacts = " + employeeContacts);

        HashMap<Object, String> employeeMap = new HashMap<>();

        employeeMap.put(new EmployeeDummyForCTS("Yash"), "IT");
        employeeMap.put(new EmployeeDummyForCTS("Pranay"), "Marketing");
        employeeMap.put(new EmployeeDummyForCTS("Vipul"), "HR");
        employeeMap.put(new EmployeeDummyForCTS("Yash"), "Sales");

        System.out.println("Size of map : " + employeeMap.size());

        HashSet<EmployeeDummyForCTS> employeeSet = new HashSet<>();

        employeeSet.add(new EmployeeDummyForCTS("Yash"));
        employeeSet.add(new EmployeeDummyForCTS("Pranay"));
        employeeSet.add(new EmployeeDummyForCTS("Vipul"));
        employeeSet.add(new EmployeeDummyForCTS("Yash"));

        System.out.println("Size of set : " + employeeSet.size());


    }
}


/*
    HashMap<Object, String> employeeMap = new HashMap<>();

    employeeMap.put(new Employee("Yash") ,"IT");
    employeeMap.put(new Employee("Pranay"),"Marketing");
    employeeMap.put(new Employee("Vipul"),"HR");
    employeeMap.put(new Employee("Yash"),"Sales");

 */

class EmployeeDummyForCTS {

    private String name;
    private double salary;
    private String department;
    private String city;
    private List<String> contactList;


    public EmployeeDummyForCTS(String name, double salary, String city, List<String> contactList) {
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.contactList = contactList;
    }

    public EmployeeDummyForCTS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public List<String> getContactList() {
        return contactList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDummyForCTS employeeDummyForCTS = (EmployeeDummyForCTS) o;
        return Double.compare(employeeDummyForCTS.salary, salary) == 0 && Objects.equals(name, employeeDummyForCTS.name) && Objects.equals(department, employeeDummyForCTS.department) && Objects.equals(city, employeeDummyForCTS.city) && Objects.equals(contactList, employeeDummyForCTS.contactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, department, city, contactList);
    }
}