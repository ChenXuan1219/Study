package com.exercises.leetcode;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/15 15:10
 */
public class threeSum {
    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        System.out.println(solution(ints));
    }
    static ArrayList solution(int[] nums){
        ArrayList listNode = new ArrayList<ArrayList>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList list = new ArrayList<ArrayList>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listNode.add(list);
                    }
                }

            }
        }
        return listNode;
    }
}
