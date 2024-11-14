package com.demo.interviews.interview2024;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
//https://leettcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // Output: [1, 2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));              // Output: [1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 3, 4, 5, 6}, 1))); // Output: [1] or any other number
    }

    public static int[] topKFrequent(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[]{};
        }

        // Step 1: Calculate the frequency of each element in the array
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(freqMap);

        // Step 2: Create a bucket for each frequency
        Map<Long, List<Integer>> bucket = new HashMap<>();
        for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
            bucket.computeIfAbsent(entry.getValue(), v -> new ArrayList<>()).add(entry.getKey());
        }
        //System.out.println(bucket);

        // Step 3: Gather the k most frequent elements
        List<Integer> result = new ArrayList<>();
        // Sort the frequencies in descending order - reverse
        for (long i = arr.length; i > 0; i--) {
            if (bucket.containsKey(i)) {
                result.addAll(bucket.get(i));
                if (result.size() >= k) {
                    break;
                }
            }
        }
        // Step 4: Return the top k frequent elements
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}