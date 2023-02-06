package com.exercises.leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/19 19:23
 */
public class 在既定时间做作业的学生人数 {
    public static void main(String[] args) {
        int[] startTime = {9,8,7,6,5,4,3,2,1};
        int[] endTime = {10,10,10,10,10,10,10,10,10};
        System.out.println(busyStudent(startTime, endTime, 5));


    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime){
                count++;
            }
        }
        return count;

    }

}
