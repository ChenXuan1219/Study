package com.bishi.tengcentyinyue;

import java.util.ArrayList;

public class 修改01串 {
    //"1001101"

    //[5,2,3,50,4],2

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(2);
        l.add(3);
        l.add(50);
        l.add(4);
        l.add(12);
        System.out.println(max0(l,2));
    }


//        public static int maxSubArray(int[] nums) {
//            int res = nums[0];
//            for(int i = 1; i < nums.length; i++) {
//                nums[i] += Math.max(nums[i - 1], 0);
//                res = Math.max(res, nums[i]);
//            }
//            return res;
//        }
// 5,2,3,50,4
    public static int max0(ArrayList<Integer> a, int x){
        ArrayList<Integer> arr_list = new ArrayList<>();
        int[] nums = new int[a.size()];
        for(int i = 0;i<a.size();i++){
            nums[i] = a.get(i);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = 1;
            for (int j = i; j < nums.length; j++) {
                num *= nums[j];
                arr_list.add(num);
            }
        }

        for (Integer integer : arr_list) {
            int temp = integer;
            int count_0 = 0;
            while (temp % 10 == 0){
                count_0++;
                temp = temp / 10;
            }
            if (count_0 >= x) {
                count++;
            }
        }
        return count;
    }


}
