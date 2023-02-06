package com.bishi.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        ArrayList<String > list = new ArrayList();

        while (0<1) {
            Scanner s = new Scanner(System.in);
            String str = null;
            str = s.next();
            if (!"end".equals(str)) {
                list.add(str);
            } else {
                break;
            }
        }

        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        int[][] ints = new int[nextInt][2];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                switch (ints[i][0]){
                    case 1 :
                        System.out.println(add_annotation(list.get(ints[i][1]), "chen"));
                        break;
                    case 2 :
                        System.out.println(delete_end_annotation(list.get(ints[i][1])));
                        break;
                    case 3 :
                        System.out.println(context_annotation(list.get(ints[i][1])));
                        break;
                    case 4 :
                        System.out.println(delete_begin_annotation(list.get(ints[i][1])));
                        break;
                    case 5 :
                        System.out.println(select_annotation(list.get(ints[i][1])));
                        break;

                }

            }

        }

    }

    static String ann = "//";
    //在一行代码后添加注释
    public static String add_annotation(String context,String annotation){
        if (context.charAt(context.length() - 2) == '/' && context.charAt(context.length() - 1) == '/' ){
            return context + annotation;
        } else {
            return context + "//" + annotation;
        }
    }

    //删除一行代码结尾的注释
    // -1 开头有注释  0 结尾无注释  1结尾有注释
    public static String  delete_end_annotation(String context) {
        if (context.charAt(0) == '/' && context.charAt(1) == '/') {
            return null;
        }
        for (int i = 2; i < context.length(); i++) {
            if (context.charAt(i) == '/' && context.charAt(i+1) == '/'){
                return context.substring(i + 2);
            }
        }
        return null;

    }


    //将某行代码整行注释掉
    public static String context_annotation(String context){
        if (context.charAt(0) == '/' && context.charAt(1) == '/'){
            return context;
        } else {
            return ann + context;
        }
    }

    //取消某行代码的整行注释
    public static String delete_begin_annotation(String context){
        if(context.charAt(context.length() - 2) == '/' && context.charAt(context.length() - 1) == '/'){
            return context.substring(2);
        }else {
            return null;
        }
    }

    //查询某行的全部注释内容
    public static String select_annotation(String context){
        if (context.charAt(0) == '/' || context.charAt(1) == '/'){
            return context.substring(  2);
        }
        for (int i = 0; i < context.length(); i++) {
            if (context.charAt(i) == '/' || context.charAt(i+1) == '/'){
                return context.substring(i + 3);
            }
        }
        return null;
    }

}
