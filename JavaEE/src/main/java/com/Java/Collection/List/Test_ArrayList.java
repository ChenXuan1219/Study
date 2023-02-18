package com.Java.Collection.List;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println(list.add(1));
        
        // 增
        // 删
        // 改
        // 查
    }


    @Test
    public void cate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入加数1");
        int i = scanner.nextInt();
        System.out.println("请输入加数2");
        int j = scanner.nextInt();

        System.out.println(i + j);
    }


}
