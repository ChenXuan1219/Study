package com.exercises.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/09 21:35
 */
public class 消失的数字 {
    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(ints));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (hashSet.add(i)) list.add(i);
        }
        return list;


    }

}
