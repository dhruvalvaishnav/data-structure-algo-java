package com.demo.interviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Nice1 {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function<Integer, Integer> twiceX = (x) -> x * 2;

        System.out.println(sum.apply(5, 6));
        System.out.println(twiceX.apply(5));

        List<String> countries = new ArrayList<>(2);
        countries.add("INDIA");
        countries.add("CANADA");
        countries.add("USA");
        System.out.println(countries);

        System.out.println(printFibo(10));
    }

    // 0 1 1 2
    private static String printFibo(int inputs) {
        int n1 = 0, n2 = 1, n3;
        StringBuilder result = new StringBuilder();

        result.append(n1).append(" ").append(n2);
        for (int i = 2; i < inputs; i++) {
            n3 = n1 + n2;
            result.append(" ").append(n3);
            n1 = n2;
            n2 = n3;
        }

        return result.toString();
    }

}
/*
[04:11 PM] Arpit Dhar


Emp_ID
Emp_Name
Emp_Profile
Emp_Country
ManagerId


101
Ashish Kaktan
Content Writer
Germany
104

104
Raj Choudhary
Data Analyst
India
108

105
Vivek Oberoi
Software Engineer
India
101

108
Shantanu Khandelwal
Development Executive
Europe
101

109
Khanak Desai
Marketing Manager
Mexico


​[04:11 PM] Arpit Dhar
    Using the table display EmpID, EmpName and ManagerName.


SELECT E.Emp_ID AS EmpID, E.Emp_Name AS EmpName, EA.Emp_Name AS ManagerName FROM Employee E, Employee EA WHERE E.ManagerId = EA.Emp_ID ORDER BY E.Emp_ID;
 */