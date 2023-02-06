package com.exercises.leetcode;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/26 20:07
 */

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 */
public class 数据中两元素的最大乘积_1464 {
    public static void main(String[] args) {
        System.out.println(maxProduct1(new int[]{3,4,5,2}));
    }

    public static int maxProduct1(int[] nums) {
        if (nums.length == 1 || nums == null) return -1;
        if (nums.length == 2) return (nums[0] - 1) * (nums[1] -1 );
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static int maxProduct2(int[] nums) {
        int a = nums[0], b = nums[1];
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
