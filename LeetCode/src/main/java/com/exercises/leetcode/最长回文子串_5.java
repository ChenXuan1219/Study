package com.exercises.leetcode;

import java.util.Scanner;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/30 10:25
 */
public class 最长回文子串_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int a = sc.nextInt();
        System.out.println(a + b);
    }

    //动态规划
    public static String solution_01(String s){


       if (s.length() > 2){
           return s;
       }

       int maxLen = Integer.MIN_VALUE;
       char[] c = s.toCharArray();
       for (int i = 1; i < s.length(); i++) {

       }
       return "";
    }
}