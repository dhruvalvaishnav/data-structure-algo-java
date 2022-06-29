package com.demo.interviews;

import java.util.*;

public class TreeMapPut {
    public static void main(String[] args) {

        Map map = new TreeMap();
        map.put("test key 1", "test value 1");
        map.put("test key 2", "test value 2");
        map.put("test key 3", "test value 3");

        System.out.println(map.put("test key 3", "test value 3"));
        System.out.println(map.put("test key 4", "test value 4"));
//        System.out.println(map.put("test key 4", "test value 4"));

        /*
        * If you look at Map.put() operation, it returns the value if key is already present in map.
            After adding key “test key 3”, when again try to add it, it returns the value “test value 3”.
            When you add “test key 4” first time, it is no present in map, so map return’s it’s value is null.
            Next time when you store “test key 4”, this time entry is already present so value is returned as “test value 4”
         */
    }
}