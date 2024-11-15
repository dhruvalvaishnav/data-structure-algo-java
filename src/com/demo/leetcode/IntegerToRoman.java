package com.demo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a Roman numeral.
 * <p>
 * Symbol	Value
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * <p>
 * Example 1:
 * Input: num = 3749
 * Output: "MMMDCCXLIX"
 * Explanation:
 * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC as 500 (D) + 100 (C) + 100 (C)
 * 40 = XL as 10 (X) less of 50 (L)
 * 9 = IX as 1 (I) less of 10 (X)
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
 */

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {

    // Create a map with integer values as keys and their corresponding Roman numerals as values
    private static final Map<Integer, String> map = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");  // Subtractive notation should come before the next larger numeral
        put(500, "D");
        put(400, "CD");  // Subtractive notation should come before the next larger numeral
        put(100, "C");
        put(90, "XC");   // Subtractive notation should come before the next larger numeral
        put(50, "L");
        put(40, "XL");   // Subtractive notation should come before the next larger numeral
        put(10, "X");
        put(9, "IX");    // Subtractive notation should come before the next larger numeral
        put(5, "V");
        put(4, "IV");    // Subtractive notation should come before the next larger numeral
        put(1, "I");
    }};


    public static void main(String[] args) {
        System.out.println(intToRoman(3749)); //"MMMDCCXLIX"
        System.out.println(intToRoman(58)); //"LVIII"
        System.out.println(intToRoman(1994)); //"MCMXCIV"
    }

    public static String intToRoman(int num) {
        // StringBuilder to build the result Roman numeral
        StringBuilder roman = new StringBuilder();

        // Iterate over the map (from largest to smallest) and subtract the values from num
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            // While num is greater than or equal to the current value, append the symbol
            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }

            // Once the number becomes 0, we can stop
            if (num == 0) {
                break;
            }
        }

        return roman.toString();
    }

    /*
    public static String intToRoman1(int num) {

        // Roman numeral symbols for each place value
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


        // Build the Roman numeral string
        StringBuilder roman = new StringBuilder();

        // Thousands place
        roman.append(thousands[num / 1000]);

        // Hundreds place
        num %= 1000;
        roman.append(hundreds[num / 100]);

        // Tens place
        num %= 100;
        roman.append(tens[num / 10]);

        // Ones place
        num %= 10;
        roman.append(ones[num]);

        return roman.toString();
    }
     */
}
