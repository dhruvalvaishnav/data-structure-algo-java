package com.demo.interviews;

public class IBM {

    public static void main(String[] args) {


    }


}

/*
//IBM

// WAP to create a random integer without using inbuild using range of integers

private static int generateRandom(){
    // 100
    return (System.getTime().getMillis() * 10) / 2;
}

// WAP to two strings, is those are anagram -

String str1 = "earth";
String str2 = "heart";

private static boolean isAnagram(String s, String t){
    if(s.length() != t.length() || s.isEmpty() || t.isEmpty()){
        return false;
    }

    Map<character, Integer> sMap = new Hashmap<>();
    Map<character, Integer> tMap = new Hashmap<>();

    for(char c : s.tocharArray()){
        sMap.put(c,sMap.getOrDefault(c,0) + 1);
    }
    for(char c : t.tocharArray()){
        tMap.put(c,tMap.getOrDefault(c,0) + 1);
    }

    for(char tchar : t.tocharArray()){
        if(!sMap.get(tchar).equalsIgnoreCase(tMap.get(tchar))){
            return false;
        }
    }
    return true;
}


POST - insert

PUT/PATCH - update


Student - sid name
one to many- listof Course

Course - cid, name
many to many- One Course can have list of Student

        Stat
factory


Employee table

Id
        Name
Age

return an Employee with second largest Id

select * from Employee order by Id desc limit(1,1);
select * from Employee where Id < (select * from Employee order by Id desc) limit 1;
*/