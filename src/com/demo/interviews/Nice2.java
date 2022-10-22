package com.demo.interviews;

public class Nice2 {
    public static void main(String[] args) {

        // convert string to symbolic
        // "minusPLusMInUSplUSMINUSminuSPlusplUs"
        // "-+-+--++"
        System.out.println(convertStringToSymbolic("minusPLusMInUSplUSMINUSminuSPlusplUs"));
        System.out.println(convertStringToSymbolic("divideMultiply"));

        // if a after b then invalid or else valid
        // "ayzapqrbxyzapqrbxyza"
    }

    private static String convertStringToSymbolic(String str) {

        StringBuilder result = new StringBuilder();
        str = str.toLowerCase().trim();

        if (str.contains("minus")) {
            result.append("-");
        } else {
            result.append("+");
        }
        return result.toString();
    }

    // ayzapqrbxyzapqrbxyza



}
