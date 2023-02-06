package com.exercises.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/24 17:41
 */
public class 反转子数组使两个数组相等 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 2, 1, 4};
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map2.put(arr[i],arr[i] + 1);
            System.out.println(map2);
        }
    }
    public static boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
    public static boolean canBeEqual2(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map1.put(target[i],target[i]++);
        }

        return true;
    }

}
