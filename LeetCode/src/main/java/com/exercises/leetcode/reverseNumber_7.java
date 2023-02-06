package com.exercises.leetcode;

import java.util.ArrayList;

public class reverseNumber_7 {
    public static void main(String[] args) {
        System.out.println(5321 / 10);
    }
    public static int reverse(int x) {
        int rev = 0;


        while (x != 0){
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
