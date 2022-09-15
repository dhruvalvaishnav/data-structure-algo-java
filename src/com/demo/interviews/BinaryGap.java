package com.demo.interviews;

public class BinaryGap {
    public static void main(String[] args) {

        String str = "100100011";
        //101010101

        //Binary Gap -- number of zero's between 1's
        //input -- 100100011
        //output -- 3

        System.out.println(getBinaryGap(str));
    }

    private static int getBinaryGap(String str) {
        // PENDING CODE

        int result = 0;
        //check for the null or 0 length string
        if (str.length() == 0) {
            return 0;
        }

        //loop for the given string
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(i) == 0) {
                result++;
            }
        }
        return result;
    }
}

// e, 1
// 1x1x1 -> 0
// map.put() -> hashCode() -> hash(); ->

// Kris, Valency
//