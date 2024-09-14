package com.demo.interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 05-01-2024
 */
public class ContainsAllVsAllMatch {
    public static void main(String[] args) {

        String[] array = {"value1", "value2", "value3"};
        String[] array1 = {"value1", "value4", "value5"};
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(array));
        hashSet.addAll(Arrays.asList(array1));
//        hashSet.add("value2");
//        hashSet.add("value1");
//        hashSet.add("value3");
//
//        // Using streams and allMatch
//        boolean allMatch = Set.of(array).stream().allMatch(hashSet::contains);
//        boolean containsAll = hashSet.containsAll(Arrays.asList(array));
//
//        // Print the result
//        System.out.println("All match: " + allMatch);
//        System.out.println("containsAll : " + containsAll);

        //System.out.println(hashSet);
        String str1 = "MAGENTO";
        String[] arr = str1.split(";");
        System.out.println(Arrays.toString(arr));
        String s = Arrays.stream(arr).sorted().map(x -> x.concat(";")).collect(Collectors.joining());
        System.out.println(s);
        //System.out.println(sortOutlookProductGroup("ASSETS;SIGN;"));

    }

    public static String sortOutlookProductGroup(String outlookProductGroup) {
        if (outlookProductGroup != null && !outlookProductGroup.isEmpty()) {
            String[] arr = outlookProductGroup.split(";");
            Arrays.sort(arr);
            String opgroup = Arrays.toString(arr).replaceAll(",", ";").replace("[", "").replace("]", "");
            return opgroup;
        }
        return outlookProductGroup;
    }

}
