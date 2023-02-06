package com.bishi.直通;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(solution(str1,str2));

    }

    public static int solution(String str1,String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        HashSet<String> set = new HashSet<>();
        HashSet<String> set1 = new HashSet<>();

        int count = 0;
        for(int i = 0; i < c1.length ; i++) {
            for(int j = i+1; j < c1.length+1 ; j++) {
                set.add(str1.substring(i,j));
            }
        }

        for(int i = 0; i < c2.length ; i++) {
            for(int j = i+1; j < c2.length+1 ; j++) {
                if (set.contains(str2.substring(i,j))) {
                    set1.add(str2.substring(i,j));
                }
            }
        }

        return set1.size();





    }
}
