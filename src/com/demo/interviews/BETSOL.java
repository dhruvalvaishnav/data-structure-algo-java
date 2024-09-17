package com.demo.interviews;

import java.util.*;

public class BETSOL {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfIndex(new int[]{2, 11, 7, 15, 3}, 9)));
        System.out.println(Arrays.toString(sumOfIndex(new int[]{11, 45, 67, 22, 99, 33, 67, 55, 34, 3}, 70)));
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

        // using Set
//        Set<Integer> unique = new HashSet<Integer>()
//        for (int a : arr) {
//            int b = target - a;
//            if (unique.contains(b)) {
////                System.out.println(a + " " + b);
//                return new int[]{b, a};
//            }
//            unique.add(a);
//        }
//        System.err.println("not found");
//        return new int[]{0, 0};

        // using Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // Check if the complement is in the map
            if (map.containsKey(complement)) {
                // Return the elements that sum up to the target
                return new int[]{arr[map.get(complement)], arr[i]};
            }
            // Store the index of the current element
            map.put(arr[i], i);
        }
        // If no such pair is found, return an empty array
        return new int[]{};
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

// employee - 100 - 51st to 100th
// SELECT * FROM employee limit 50,100;
/*
here : For LIMIT 50, 100:
        50 is the offset, meaning you skip the first 50 rows.
        100 is the number of rows to return after the offset.
        Thus, this query will return rows 51 through 150 (inclusive),
        assuming the data is ordered in some way. If there are fewer than 150 rows,
        it will return only the remaining rows after the 50th row.

 */
