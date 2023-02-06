package com.exercises.dp;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/23 17:13
 */
public class coinChange_322 {
    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{4}, 3));

    }
    public static int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
