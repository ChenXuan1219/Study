package com.bishi.直通;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_002 {
    public static void main(String[] args) {
        int[] line_1 = new int[3];
        int[] line_2 = new int[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < line_1.length; i++) {
            line_1[i] = sc.nextInt();
        }

//        if (line_1[0] != 0 || line_1[1] != 0 || line_1[2] != 0) {
//            for (int i = 0; i < line_1[0]; i++) {
//                line_2[i] = sc.nextInt();
//            }
//            System.out.println(solution(line_1,line_2));
//        }else {
//            System.out.println(0);
//        }

        try {
            for (int i = 0; i < line_1[0]; i++) {
                line_2[i] = sc.nextInt();
            }

        } catch (ArrayIndexOutOfBoundsException e){

        }finally {
            System.out.println(solution(line_1, line_2));
        }

    }

    // 3         2        5
    //3个桃子     2天后     v >= 5


    // 3 4 6
    public static int solution(int[] arr_1,int[] arr_2){
        if (arr_1[2] == 0) return 0;
        int count_V = 0;
        for (int i = 0; i < arr_1[1]; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr_2.length; j++) {
                if (arr_2[j] >= arr_1[2]){
                    count_V = count_V + arr_2[j];
                } else {
                    list.add(arr_2[j]);
                }
            }
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                ints[j] = list.get(j) + 1;
            }

            arr_2 = ints;
        }

        return count_V;
    }
}
