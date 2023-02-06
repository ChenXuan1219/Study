package com.exercises.leetcode;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/24 10:39
 */
public class 反转句子 {
    public static void main(String[] args) {
        solution("i am chen xuan.");
    }

    public static void solution(String s){
        String[] split = s.split(" ");
        for (int i = s.length() - 1; i >= 0 ; i--) {
            System.out.print(s.charAt(i));
        }

    }
}
