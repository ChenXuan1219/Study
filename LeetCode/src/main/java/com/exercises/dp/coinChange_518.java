package com.exercises.dp;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/24 15:16
 */
public class coinChange_518 {

    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {

            }
        }

        return dp[amount];
    }
}
