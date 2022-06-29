package com.demo.neetcode.stack;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
    Input: s = "()"
    Output: true
Example 2:
    Input: s = "()[]{}"
    Output: true
Example 3:
    Input: s = "(]"
    Output: false

space : O(n)
time : O(n)

 */

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "()[]{}";
        if (isValidParentheses(s))
            System.out.println("Given string has Valid Parentheses!!");
        else
            System.out.println("Given string has Invalid Parentheses!!");
    }

    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

//        System.out.println("closeToOpen Map is : " + closeToOpen);

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
