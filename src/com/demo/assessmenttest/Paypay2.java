package com.demo.assessmenttest;

import java.util.*;

public class Paypay2 {
    public static void main(String[] args) {

        String[] dateList1 = {"2023-01-01", "2022-01-15", "2023-02-20", "2023-01-01", "2023-02-28"};
        System.out.println(solution(dateList1)); // Output: "01"

        String[] dateList2 = {"2025-05-10"};
        System.out.println(solution(dateList2)); // Output: "05"

        String[] dateList3 = {"2023-01-05", "2023-01-10", "2023-02-10", "2023-05-25", "2023-05-30"};
        System.out.println(solution(dateList3)); // Output: "05"

    }

    private static String solution(String[] dateList) {
        Map<String, Integer> freqMonthMap = new HashMap<>();
        for (String str : dateList) {
            String[] split = str.split("-");
            String month = split[1];
            // you can also use substring here
            // String month = date.substring(5, 7);
            freqMonthMap.put(month, freqMonthMap.getOrDefault(month, 0) + 1);
        }

        // Find the month with the highest number of events
        Optional<Map.Entry<String, Integer>> highestMonthEntry = freqMonthMap.entrySet().stream().max((entry1, entry2) -> {
            int countComparison = entry1.getValue().compareTo(entry2.getValue());
            if (countComparison == 0) {
                return entry1.getKey().compareTo(entry2.getKey()); // prefer latest month in tie
            }
            return countComparison;
        });

        return highestMonthEntry.map(Map.Entry::getKey).orElse("");
    }
}


/*
You work for a busy office where employees schedule various events on their calendars.
Your task is to analyze the data to determine the busiest month over the course of the years, based on the number of events.

Given a non-empty array of strings dateList, where each string represents a date in the format "YYYY-MM-DD",
count the number of events for each month, ignoring the year.
Return the month with the highest number of events as a two-digit numerical string (e.g., return "07" for July).
In the event of a tie, return the latest month in the year.

Note that it is possible to have several events happening on the same date. We count those events as separate events.

Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than O(dateList.length2) will fit within the execution time limit.

Example

For dateList = ["2023-01-01", "2022-01-15", "2023-02-20", "2023-01-01", "2023-02-28"], the output should be solution(dateList) = "01".

Explanation:
The month of January ("01") has the highest number of events (three events in total: two events on January 1 and one event on January 15). February ("02") has two events.

For dateList = ["2025-05-10"], the output should be solution(dateList) = "05".

Explanation:
Here, there is only one date, and it is in May ("05"). Thus, May is the month with the highest number of events.

For dateList = ["2023-01-05", "2023-01-10", "2023-02-10", "2023-05-25", "2023-05-30"], the output should be solution(dateList) = "05".

Explanation:
January ("01") and May ("05") both have two events. Since there is a tie, we choose the latest month, which is May ("05").

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.string dateList

A non-empty array of strings where each string represents a valid date in the format "YYYY-MM-DD".

Guaranteed constraints:
1 ≤ dateList.length ≤ 1000.

[output] string

The month with the highest number of events, formatted as a two-digit numerical string. If there is a tie, return the latest month in the year.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

 */