package com.demo.interviews;

import java.util.*;

public class BETSOL {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfIndex(new int[]{2, 11, 7, 15, 3}, 9)));
    }

    private static int[] sumOfIndex(int[] arr, int target) {
        // brute-force
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (target - arr[j] == arr[i]) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{0, 0};

        //
        Set<Integer> unique = new HashSet<>();

        for (int a : arr) {
            int b = target - a;

            if (unique.contains(b)) {
//                System.out.println(a + " " + b);
                return new int[]{b, a};
            }

            unique.add(a);
        }

        System.err.println("not found");
        return new int[]{0, 0};
    }

    //   Employee{id, name, salary, address}
    //   Input: List<Employee>
    //   O/P-> Salary > 20000, Map<Integer, Employee> - <id,employee obj> i.e. [1={Employee}, 3={Employee}]

//    list.stream().filter(e->e.getSalary() > 20000).collect(Collectors.groupingBy(val -> val.getId(),Employee::Collectors.toMap()));

    // name and age -> emp

}


// Input: nums = [2,11,7,15,3], sum = 9
// Output: [0,2]
// Explanation: Because nums[0] + nums[2] == 9, we return [0, 2].

// employee - 100 - 51th to 100th
// SELECT * FROM employee limit 50,100;

