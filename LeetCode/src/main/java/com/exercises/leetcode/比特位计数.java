package com.exercises.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/09 21:45
 */
public class 比特位计数 {
    public static void main(String[] args) {
        System.out.println(count(55));
    }
    public  static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = countOnes(i);
        }

        return arr;
    }

    static int count(int num){
        int count = 0;
        if (num == 0) return 0;
        while (num / 2 != 0) {
            if (num % 2 != 0) {
                count++;
            }
            num = num / 2;
        }

        return count + 1;
    }

    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }


}
