package com.demo.interviews;

import java.util.Arrays;

public class EnumToString {
    public static void main(String[] args) {

        // the enum type provides a valueOf() method that takes a String as an argument, and returns the corresponding enum object:

        // It's important to remember that the valueOf() method does a case-sensitive
        // match of the argument supplied to it, so passing a value that doesn't match the case of
        // the original enum‘s values will lead to an IllegalArgumentException:

        Size size = Size.valueOf(String.valueOf(Size.LARGE));
        System.out.println(size);

        // The toString() method returns the string representation of the enum constants.
        System.out.println(Size.SMALL.toString());

        // The valueOf() method takes a string and returns an enum constant having the same string name.
        System.out.println(Size.valueOf("EXTRALARGE"));

        // The values() method returns an array of enum type containing all the enum constants.
        Size[] enumArray = Size.values();
        System.out.println(Arrays.toString(enumArray));
    }
}

enum Size {
    SMALL, MEDIUM, LARGE, EXTRALARGE;

    public String getSize() {

        // this will refer to the object SMALL
        switch (this) {
            case SMALL:
                return "small";

            case MEDIUM:
                return "medium";

            case LARGE:
                return "large";

            case EXTRALARGE:
                return "extra large";

            default:
                return null;
        }
    }

}