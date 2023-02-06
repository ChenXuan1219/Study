package com.exercises.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/25 22:54
 */
public class 最大子数组和 {
    public static void main(String[] args) {

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int right = 0,left = 1;

        int sum = arr[right];

        while(sum != 0){
            if (sum + arr[right + 1] >= sum){
                sum = sum + arr[right+1];
                right++;
            } else {
                left++;
            }
        }



        return 1;
    }
}
