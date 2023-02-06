package com.exercises.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/29 00:34
 */
public class 重新排列数组_1470 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(shuffle(arr, 3)));


    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                arr[i] = nums[first];
                first++;
            } else {
                arr[i] = nums[n];
                n++;
            }
        }
        return arr;
    }
}
