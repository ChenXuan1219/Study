package com.exercises.dp;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/23 16:43
 */
public class 打家劫舍198 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
