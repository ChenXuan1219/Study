package com.exercises.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/21 23:14
 */
public class 有效的括号 {
    public static void main(String[] args) {

        System.out.println(isValid("{[]}"));

    }

    public static boolean isValid(String s) {

        if(s.length() % 2 == 1)return false;

        HashMap<Character, Character> hashMap = new HashMap<Character,Character>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (hashMap.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != hashMap.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }
}
