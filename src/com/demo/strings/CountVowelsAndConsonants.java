package com.demo.strings;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        // find count of vowels and consonants from the given string
        String str = "This is a really simple sentence";
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowels++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                consonants++;
            }
        }
        System.out.println("The given string : '" + str + "' is having no. of vowels : " + vowels);
        System.out.println("The given string : '" + str + "' is having no. of consonants : " + consonants);
    }


}
