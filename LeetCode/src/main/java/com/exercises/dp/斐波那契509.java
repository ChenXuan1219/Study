package com.exercises.dp;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/23 17:07
 */
public class 斐波那契509 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if(n<2)return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }
}
