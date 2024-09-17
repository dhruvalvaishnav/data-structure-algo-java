package com.demo.interviews;

import java.util.*;

public class BOA {

    public static void main(String[] args) {
  /*      List<Object> list = new ArrayList<>();
        list.add(100);
        list.add(4200000);
        list.add(10000000);
        list.add(999999999999L);
        list.add(99999999999999999L);

        for (Object obj : list) {
            if (obj instanceof Integer) System.out.println("so " + obj + " is an Integer type");
            if (obj instanceof Long) System.out.println("so " + obj + " is Long type");
        }
  */
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Lichy");
        fruits.add("PPLEA");
        fruits.add("MANOG");

        getAnagramGroups(fruits);
//        System.out.println(getAnagramGroups(fruits));
    }

    /*
     * get the string, check the string in the list with having same length and characters
     * if yes ++ counter
     * if not get another string
     */

//    private static void getAnagramGroups(List<String> list) {
//        Map<String, List<String>> anagrams = new HashMap<>();
//
//        //check the list is not null or empty
//        if (list == null || list.size() == 0) return;
//
//        //get the word from the list
//        for (String word : list) {
//            //convert it into the char array
//            char[] chars = word.trim().toLowerCase().toCharArray();
//            //sort it and save it to the new temp string
//            Arrays.sort(chars);
//            String sortedWord = String.valueOf(chars);
//
//            //check for the temp string(which is sorted) - key is present in map or not
//            if (anagrams.containsKey(sortedWord)) {
//                //if yes then make the new list and add their type of the strings in this list
//                List<String> newList = anagrams.get(sortedWord);
//                newList.add(word);
//                anagrams.put(sortedWord, newList);
//            } else {
//                //if not then make another list and add the string into it
//                List<String> newList2 = new ArrayList<>();
//                newList2.add(word);
//                anagrams.put(sortedWord, newList2);
//            }
//        }
//
//        for (Map.Entry<String, List<String>> o : anagrams.entrySet()) {
//            System.out.println(o.getValue());
//        }
//    }


    private static void getAnagramGroups(List<String> list) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        //check the list is not null or empty
        if (list == null || list.isEmpty()) {
            System.out.println("Provided list is empty or null");
            return;
        }

        for (String word : list) {
            // sort the word to create a key
            String sortedWord = sortWord(word);

            // Get the list of anagrams for this sorted key
            List<String> stringList = anagramsMap.getOrDefault(sortedWord, new ArrayList<>());
            // Add the original string to the list
            stringList.add(word);
            // Put the list back in the map
            anagramsMap.put(sortedWord, stringList);
        }
        //System.out.println("anagramsMap: " + anagramsMap);

        for (Map.Entry<String, List<String>> entry : anagramsMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static String sortWord(String word) {
        char[] chars = word.trim().toLowerCase().toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}


/*
    Jay and Amisha are playing a game called "MY NUMBER WIN". Jay and Amisha have set of numbers as favourite numbers but not known to each other
    it means that Jay doesn’t know Amisha's favourite numbers and vice versa.
    Jay and Amisha will declare a random number one by one.

    If the number is favourite of Jay and Amisha both then the person who declared a number will receive last number declared by their opponent in their reward balance.
    If the number is favourite of only the person who declared the number then that person will receive a loss in reward balance by 5.
    If the number is favourite of only the opponent then the opponent will receive last number declared by them in their reward balance.
    Whoever scores 25 in reward balance first will be declared as winner.
    Jay and Amisha both have total 100 numbers in their favourite list numbers.
    DEVELOP THIS GAME EFFICIENTLY.
* */