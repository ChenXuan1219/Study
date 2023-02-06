package com.exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/09 20:25
 */
public class Test_移动0 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 0, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList();
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            list.add(nums[i]);
        }
        for(int i = 0;i < nums.length;i++){
            if(i < list.size()) {
                nums[i] = list.get(i);
                continue;
            }
            nums[i] = 0;
        }


    }
}
