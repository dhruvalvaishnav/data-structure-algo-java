package com.demo;

import com.demo.map.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 22-06-2024
 */
public class ListReferences {
    public static void main(String[] args) {

        List<Employee> dbList = new ArrayList<>();
        dbList.add(new Employee(1, "Dhruval", 22));
        dbList.add(new Employee(2, "Kishan", 21));
        dbList.add(new Employee(3, "Gaurav", 32));
        dbList.add(new Employee(4, "Alex", 26));
        dbList.add(new Employee(5, "Polly", 12));
        System.out.println("dbList : " + dbList);

        // publish on router topic and audit history save in batch
        if (!dbList.isEmpty()) {
            int batchSize = 50;
            int numberOfBatches = (int) Math.ceil((double) dbList.size() / batchSize);

            for (int i = 0; i < numberOfBatches; i++) {
                int fromIndex = i * batchSize;
                int toIndex = Math.min((i + 1) * batchSize, dbList.size());
                List<Employee> dbBatch = dbList.subList(fromIndex, toIndex);
                List<Employee> batchForAuditing = Collections.unmodifiableList(dbBatch.stream().collect(Collectors.toList()));
                System.out.println("Existing Db value of oli dbBatch -" + dbBatch);
                if (!batchForAuditing.isEmpty()) {
                    method3(batchForAuditing, dbList);
                }
                if (!dbBatch.isEmpty()) {
                    method2(dbBatch);
                }
            }
        }

    }


    private static void method2(List<Employee> list) {
        System.out.println("inside method2 list : " + list);
        Employee employee = list.get(0);
        employee.setName("Dhruval Vaishnav");
        employee.setAge(26);
        list.set(0, employee);
    }

    private static void method3(List<Employee> batchForAuditing, List<Employee> employees) {
        System.out.println("inside method3 batchForAuditing : " + batchForAuditing + " and  employees : " + employees);
    }

}


