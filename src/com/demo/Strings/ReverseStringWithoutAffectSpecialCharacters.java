package com.demo.Strings;

public class ReverseStringWithoutAffectSpecialCharacters {
    public static void main(String[] args) {
//        String str = "a!!!b.c.d,e'f,ghi";
        String str = "B!!A$C,A@N,CY";
        char[] charArray = str.toCharArray();

        System.out.println("Input string: " + str);
        reverse(charArray);
        String revStr = new String(charArray);

        System.out.println("Output string: " + revStr);
    }

    private static void reverse(char[] charArray) {
        int l = 0, r = charArray.length - 1;

        while (l < r) {
            if (!Character.isAlphabetic(charArray[l])) {
                l++;
            } else if (!Character.isAlphabetic(charArray[r])) {
                r--;
            } else {
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            }
        }
    }
}
