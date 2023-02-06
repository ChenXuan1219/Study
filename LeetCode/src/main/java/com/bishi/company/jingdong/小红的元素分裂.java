package com.bishi.company.jingdong;

import java.util.Scanner;

public class 小红的元素分裂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String length = sc.nextLine();
        String str = sc.nextLine();
        String[] str_table = str.split(" ");
        int[] arr = new int[Integer.parseInt(length)];
        for(int j = 0; j < arr.length;j++) {
            arr[j] = Integer.parseInt(str_table[j]);
        }
        System.out.println(solution(arr));

    }

    public static int solution(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count + find_1(arr[i]);
        }
        return count;
    }

    public static int find_1(int i){
        int count = 0;
        while (i != 1) {
            if (i % 2 == 0) {
                i = i / 2;
                count = count + 1;
            } else {
                i = i - 1;
                count = count + 1;
            }
        }
        return count;
    }
}
