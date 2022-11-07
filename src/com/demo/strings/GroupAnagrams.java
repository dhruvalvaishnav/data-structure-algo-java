package com.demo.Strings;

import java.util.*;
// Given a list of words,group them by anagrams
// Input:List of"cat","dog","god"
// Output:A Set of Sets of anagrams:{{‘cat'}, {‘dog', ‘god'}}

// Test Cases –
// Input:["cat","dog","god"]
// Output:[[“cat”],[“dog”,”god”]]
public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "dog", "god", "cat");
        //result in map - with duplicates
        getAnagramGroups(words);
        //result in set - without any duplicates
//        System.out.println(group(words));
    }

    private static Set<String> group(List<String> words) {
        Set<String> result = new HashSet<>();

        HashMap<String, List<String>> anagrams = new HashMap<>();

        if (words == null || words.size() == 0) return null;

        for (String word : words) {
            char[] chars = word.trim().toLowerCase().toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            if (anagrams.containsKey(sortedWord)) {
                List<String> newList = anagrams.get(sortedWord);
                newList.add(word);
                anagrams.put(sortedWord, newList);
            } else {
                List<String> newList2 = new ArrayList<>();
                newList2.add(word);
                anagrams.put(sortedWord, newList2);
            }
        }
        for (Map.Entry<String, List<String>> o : anagrams.entrySet()) {
            result.addAll(o.getValue());
        }
        return result;
    }

    private static void getAnagramGroups(List<String> list) {
        Map<String, List<String>> anagrams = new HashMap<>();

        //check the list is not null or empty
        if (list == null || list.size() == 0) return;

        //get the word from the list
        for (String word : list) {
            //convert it into the char array
            char[] chars = word.trim().toLowerCase().toCharArray();
            //sort it and save it to the new temp string
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            //check for the temp string(which is sorted) - key is present in map or not
            if (anagrams.containsKey(sortedWord)) {
                //if yes then make the new list and add their type of the strings in this list
                List<String> newList = anagrams.get(sortedWord);
                newList.add(word);
                anagrams.put(sortedWord, newList);
            } else {
                //if not then make another list and add the string into it
                List<String> newList2 = new ArrayList<>();
                newList2.add(word);
                anagrams.put(sortedWord, newList2);
            }
        }

        for (Map.Entry<String, List<String>> o : anagrams.entrySet()) {
            System.out.println(o.getValue());
        }
    }
}
