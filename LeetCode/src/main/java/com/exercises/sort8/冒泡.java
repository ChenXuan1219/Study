package com.exercises.sort8;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/19 19:57
 */

public class 冒泡 {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        maoPao(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maoPao(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                flag = true;
            }
        }
    }
}