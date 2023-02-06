package com.exercises.leetcode;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/11 20:22
 */
public class 最多水的容器 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = V(i, j, j - i ,height) > max ? V(i, j, j - i ,height) : max;
            }
        }
        return max;
    }

    public static int V(int i,int j,int length,int[] arr){
        return arr[i] <= arr[j] ? arr[i] * length : arr[j] * length;
    }
}
