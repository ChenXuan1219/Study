package com.bishi.company.jingdong;

import java.util.Arrays;
import java.util.Scanner;

public class 赝品 {
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
        if (arr.length <= 1) return 0;
        Arrays.sort(arr);
        int real = arr[arr.length - 1];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == real){
                count = count + 1;
            }else {
                break;
            }
        }
        return arr.length - count;

    }
}
