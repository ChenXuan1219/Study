package com.exercises.leetcode;

public class maximumSwap_670 {
    public static void main(String[] args) {
        System.out.println(maximumSwap(1234));
    }

    static void swap(char[] arr,int i,int j){
        char ch  = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    //暴力
    public static int maximumSwap(int num) {
        int max = Integer.MIN_VALUE;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - 1; j++) {
                swap(chars,i,j);
                max = Math.max(max,Integer.parseInt(new String(chars)));
                swap(chars,i,j);
            }
        }

        return max;
    }


    //贪心



}
