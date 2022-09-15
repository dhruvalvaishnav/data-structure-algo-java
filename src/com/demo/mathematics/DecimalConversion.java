package com.demo.mathematics;

import java.util.HashMap;
import java.util.Map;

/*
    Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
    Some fractions in decimal form have cyclic decimal points.

    Test Cases:
         vulgarToDecimal(1l, 2l).equals("0.5");
         vulgarToDecimal(1l, 3l).equals("0.(3)");
         vulgarToDecimal(1l, 30l).equals("0.0(3)");
         vulgarToDecimal(1l, 75l).equals("0.01(3)");
         vulgarToDecimal(4l, 7l).equals("0.(571428)");

 */
public class DecimalConversion {
    public static void main(String[] args) {
        System.out.println(vulgarToDecimal(1L, 2L).equals("0.5"));
        System.out.println(vulgarToDecimal(1L, 3L).equals("0.(3)"));
        System.out.println(vulgarToDecimal(1L, 30L).equals("0.0(3)"));
        System.out.println(vulgarToDecimal(1L, 75L).equals(("0.01(3)")));
        System.out.println(vulgarToDecimal(4L, 7L).equals("0.(571428)"));
        System.out.println(vulgarToDecimal(-1L, 2L).equals("-0.5"));
    }

    public static String vulgarToDecimal(Long numerator, Long denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();

        // if any one of them < 0 - append '-'
        if (((numerator < 0) && (denominator > 0))
                || ((numerator > 0) && (denominator < 0))) {
            sb.append("-");
        }

        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        long remainder = divisor % dividend; // modulo will give u remainder

        sb.append(divisor / dividend);

        // remainder = 0 return the string
        if (remainder == 0) return sb.toString();
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();

        // remainder != 0 => logic to add fraction values
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder %= dividend;
        }
//        System.out.println(sb);
        return sb.toString();

    }

}
