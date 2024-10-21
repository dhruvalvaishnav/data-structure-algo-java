package com.demo.strings;

import java.util.*;

/**
 * @author Dhruval Vaishnav Created on 21-10-2024
 * <p>
 * Hierarchy print based on a string. There are some employee manager relationship and based on input string,
 * we have to print complete hierarchy.
 * For e.g.
 * Ajay-> Ramesh
 * Deepesh-> Animesh
 * Mohan->Ajay
 * Rahul-> Mohan
 * </p>
 * Input: Rahul
 * Output: Rahul->Mohan->Ajay->Ramesh
 */
public class PrintEmployeeHierarchy {
    public static void main(String[] args) {
        List<String> relationships = Arrays.asList("Ajay->Ramesh", "Deepesh->Animesh", "Mohan->Ajay", "Rahul->Mohan");

        String inputEmployee = "Rahul";
        printHierarchy(relationships, inputEmployee);
    }

    private static void printHierarchy(List<String> relationships, String employeeName) {
        // Create a map to hold the employee-manager relationships
        Map<String, String> empManagerMap = new HashMap<>();

        // Populate the managerMap from the input relationships
        for (String relationship : relationships) {
            String[] parts = relationship.split("->");
            String employee = parts[0].trim();
            String manager = parts[1].trim();
            empManagerMap.put(employee, manager);
        }

        // List to hold the hierarchy path
        List<String> hierarchy = new ArrayList<>();

        // Traverse the hierarchy starting from the given employee
        String currentEmployee = employeeName;
        while (empManagerMap.containsKey(currentEmployee)) {
            hierarchy.add(currentEmployee);
            currentEmployee = empManagerMap.get(currentEmployee);
        }

        // Add the top-level employee (who has no manager)
        hierarchy.add(currentEmployee); // This is the top-most employee

        // Print the hierarchy in the required format
        //Collections.reverse(hierarchy);
        System.out.println(String.join("->", hierarchy));
    }
}


//Time Complexity: 𝑂(𝑛)
//Space Complexity: 𝑂(𝑛)
