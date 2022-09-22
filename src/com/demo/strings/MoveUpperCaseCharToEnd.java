package com.demo.strings;

public class MoveUpperCaseCharToEnd {
    public static void main(String[] args) {

        Character[] chars = {'W', 'e', 'L', 'c', 'o', 'M', 'e'};

        //using two string
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                lower.append(c).append(",");
            } else {
                upper.append(c).append(",");
            }
        }
        String out = lower.toString().concat(upper.toString());
        System.out.println(out);
        char[] output = out.toCharArray();
        System.out.println(output);


        //using reg-ex
//        return s.replaceAll("[A-Z]+", "") + s.replaceAll("[^A-Z]+", "");

    }
}
