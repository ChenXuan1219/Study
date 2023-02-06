package com.cx.spark.streaming;

import java.lang.reflect.Array;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 22:51
 */
public class T {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        T.twoSum(arr, 6);


    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0;i < nums.length ;i++){

            for(int j = nums.length - 1; j > 0 - i;j--){

                if(nums[i] + nums[j] == target){
                    System.out.println(i);
                    System.out.println(j);
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
