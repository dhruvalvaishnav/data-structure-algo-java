package com.demo.interviews;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XebiaI {
    public static void main(String[] args) {
        String str = "hi    hello hi";
        LinkedHashMap<String, Long> result = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<String, Long> o : result.entrySet()) {
            System.out.println(o.getKey() + " - " + o.getValue());
        }
    }
}

/*
    Q1:
    class Parent {
        public Parent() {
            System.out.println("Parent");
        }
    }

    class Child extends Parent {
        public Child() {
            System.out.println("Child");
        }
    }

    class Main{
        public static void main(String[] args) {
            Parent child = new Child();
        }
    }

    Prints => Parent, Child

   Q2:
    Input
    "this_is_a_program"
    Output
    This Is A Program

    Ans :

        String str = "this_is_a_program";
        String[] strArr = str.split("_");
        StringBuilder result = new StringBuilder();
        for (String s : strArr) {
            result.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1,s.length())).append(" ");
        }
        System.out.println(result.toString());

    Q3:
        try {
            System.exit(-1);
            int i = 10 / 0;
        } catch (Exception e) {
            throw new RuntimeException("Arithmetic Exception");
        } finally {
            System.out.println("finally");
        }

        ans : will not print anything - in case put System.exit(0) , System.exit(1) or System.exit(-1) whatever it is

    Q4:

    find an occurrence of the substrings using Java 8?

    String str = "hi    hello hi"

    expected output :
    hi - 2
    hello - 1

    HINT ::

    -----------------------------------------------------------------------------------------------------------

    str.split("\\s+") would work.
    The + at the end of the regular-expression, would treat multiple spaces the same as a single space.

    You can use Quantifiers to specify the number of spaces you want to split on: -

        `+` - Represents 1 or more
        `*` - Represents 0 or more
        `?` - Represents 0 or 1
    `{n,m}` - Represents n to m

    So, \\s+ will split your string on one or more spaces

    String[] words = yourString.split("\\s+");
    Also, if you want to specify some specific numbers you can give your range between {}:

    yourString.split("\\s{3,6}"); // Split String on 3 to 6 spaces

    -----------------------------------------------------------------------------------------------------------
    String str = "hi    hello hi";
    LinkedHashMap<String, Long> result = Arrays.stream(str.split("\\s+"))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

    for (Map.Entry<String, Long> o : result.entrySet()) {
        System.out.println(o.getKey() + " - " + o.getValue());
    }

    @Qualifier
    GET vs POST
    idempotent vs non-idempotent
    payload in to GET api? -> ans : Yes via header
 */