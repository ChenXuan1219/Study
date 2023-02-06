package com.exercises.leetcode;

import java.util.Arrays;

public class findMedianSortedArrays_4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays_01(nums1,nums2));
    }


    //暴力1
    public static double findMedianSortedArrays_01(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < nums1.length){
                arr[i] = nums1[i];
            }else {
                arr[i] = nums2[i - nums1.length];
            }

        }

        Arrays.sort(arr);

        if (arr.length % 2 == 0){
            return (double) (arr[arr.length / 2 ] + arr[arr.length / 2 - 1])/2;
        }else return (double) arr[arr.length / 2];
    }

    public static double findMedianSortedArrays_02(int[] nums1, int[] nums2) {

        return 0;
    }

}
