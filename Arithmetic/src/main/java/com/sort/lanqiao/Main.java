package com.sort.lanqiao;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        System.out.println(main.change(50));
    }


    /**
     * 九进制2022 转 十进制
     */
    public String change(int num){
        return Integer.toBinaryString(num);
    }
}
