package com.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

public class ListToString {
    public static void main(String[] args) {

//        List<String> request = new ArrayList<String>(
//                Arrays.asList("SIGN", "ACROBAT", "MARKETO-ENGAGE"));
//
//        List<String> response = new ArrayList<String>(
//                Arrays.asList("MARKETO-ENGAGE", "MARKETO-MAJOR", "MAGENTO"));
//
//        String str1 = response.stream().map(Objects::toString).collect(Collectors.joining(";"));
//        System.out.println(str1);
//
//        String str = String.join(";", response);
//        System.out.println(str);
//
//
//
//        List<String> list1 = new ArrayList<String>(
//                Arrays.asList("SIGN", "ACROBAT", "MARKETO-ENGAGE"));
//
//        List<String> list2 = new ArrayList<String>(
//                Arrays.asList("MARKETO-MAJOR", "MAGENTO"));
//
//        String req = "MARKETO-ENGAGE;MARKETO-MAJOR;MAGENTO";
//
//        System.out.println(isAtmOpgContainsListOfOPGsFromEnv(request, response));
//        System.out.println(isAtmOpgContainsListOfOPGsFromEnv(list1, list2));
//        System.out.println(isAtmOpgContainsListOfOPGsFromEnv1(req, list2));
//
//        List<String> atmListFinal=list1.stream().filter(x->isAtmOpgContainsListOfOPGsFromEnv(list1,list2)).collect(Collectors.toList());
//        List<String> atmListFinal1=list1.stream().filter(x->isAtmOpgContainsListOfOPGsFromEnv1(req,list2)).collect(Collectors.toList());

        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

        System.out.println(findFirst.get()); //Always print David
        System.out.println(fidnAny.get()); //Print Jack/Jill/Julia :behavior of this operation is explicitly nondeterministic
    }

    private static boolean isAtmOpgContainsListOfOPGsFromEnv(List<String> list1, List<String> list2) {
        return list2.stream().anyMatch(x->list1.contains(x));
    }

    private static boolean isAtmOpgContainsListOfOPGsFromEnv1(String str, List<String> list2) {
        String[] strings = str.split(";");
        List<String> stringList = Arrays.stream(strings).sequential().collect(Collectors.toList());
        return list2.stream().anyMatch(x->stringList.contains(x));
    }
}

