package com.demo.arrays.stringArrays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

/*
    Problem Statement: Given a start date and an end date in the format "YYYY-MM-DD",
    count how many Mondays, Tuesdays, etc., fall within that range. Return the weekday with the highest count as a string (e.g., "Monday").

    Example:

    Input: startDate = "2023-01-01", endDate = "2023-01-31"
    Output: "Monday" (assuming Mondays are the most frequent in that range)

    Constraints:
    The dates are guaranteed to be valid and the start date is before or equal to the end date.

    Implementation Steps:
    Parse the start and end dates.
    Iterate through each date in the range.
    Count the occurrences of each weekday.
    Determine which weekday has the highest count and return it.
 */
public class CountWeekdays {
    public static void main(String[] args) {
        System.out.println(countWeekdaysInRange("2023-01-01", "2023-01-31"));
        System.out.println(countWeekdaysInRange("2022-01-01", "2022-02-28"));
        System.out.println(countWeekdaysInRange("2024-05-01", "2024-05-31"));
        System.out.println(countWeekdaysInRange("2024-10-01", "2024-10-31"));
    }

    private static String countWeekdaysInRange(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        // Initialize a map to count occurrences of each weekday
        Map<DayOfWeek, Integer> weekdayCount = new HashMap<>();

        // this is how iterate through date ranges
        for (LocalDate i = start; !i.isAfter(end); i = i.plusDays(1)) {
            weekdayCount.put(i.getDayOfWeek(), weekdayCount.getOrDefault(i.getDayOfWeek(), 0) + 1);
        }

        Optional<Map.Entry<DayOfWeek, Integer>> max = weekdayCount.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

        String weekdayWithHighestCount = null;
        if (max.isPresent()) {
            Map.Entry<DayOfWeek, Integer> day = max.get();
            System.out.println("Day : " + day.getKey() + " with : " + day.getValue() + " highest count in the given date range.");
            weekdayWithHighestCount = String.valueOf(day.getKey());
        }

        return weekdayWithHighestCount;

        // Find the weekday with the highest count
//        DayOfWeek maxDay = null;
//        int maxCount = 0;
//
//        for (Map.Entry<DayOfWeek, Integer> entry : weekdayCount.entrySet()) {
//            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && (maxDay == null || entry.getKey().getValue() > maxDay.getValue()))) {
//                maxDay = entry.getKey();
//                maxCount = entry.getValue();
//            }
//        }
//
//        // Return the name of the weekday with the highest count
//        return maxDay != null ? maxDay.name() : "";
    }
}


/*

Here are some practice questions similar to the one you worked on, focused on date processing, counting occurrences, and similar logic:

Count Weekdays in Date Range:
Given a start date and an end date, count how many Mondays, Tuesdays, etc., fall within that range. Return the weekday with the highest count.

Events by Quarter:
Given a list of dates, count how many events occurred in each quarter (Q1, Q2, Q3, Q4) of the year. Return the quarter with the most events.

Frequency of Dates:
Given a list of dates, return the date that occurs most frequently. If there’s a tie, return the latest date.

Most Active Year:
Given a list of dates, determine which year has the highest number of events. Return that year as a string in "YYYY" format.

Monthly Average Events:
Given a list of dates, calculate the average number of events per month across all years. Return the month with the highest average.

Seasonal Events:
Given a list of dates, determine how many events occur in each season (spring, summer, fall, winter). Return the season with the most events.

Count Unique Dates:
Given a list of dates, return the number of unique dates that appear in the list.

Most Frequent Day of the Month:
Given a list of dates, find which day of the month (1-31) appears most frequently. Return it as a string (e.g., "01" for the 1st).

Find Events on Specific Day:
Given a list of dates and a specific day (e.g., "15"), count how many events occurred on that day of the month across all years.

Monthly Events Trend:
Given a list of dates, determine if the number of events is increasing, decreasing, or stable month-over-month.
Return a summary of the trend (e.g., "increasing", "decreasing", "stable").

 */