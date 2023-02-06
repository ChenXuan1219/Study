package com.exercises.leetcode;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/26 20:19
 */

import java.util.HashMap;
import java.util.Random;

/**
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 */
public class Easy_1374_生成每种字符都是奇数个的字符串 {

    public static void main(String[] args) {
        System.out.println(generateTheString(27));
    }

    public static String generateTheString(int n) {

        String str = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char c = Dictionaries();
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Character c : map.keySet()){
            if (map.get(c) % 2 == 1){
                for (int i = 0; i < map.get(c); i++) {
                    str = str + c;
                }
            }else {
                map.put(c, map.get(c) + 1);
                for (int i = 0; i < map.get(c); i++) {
                    str = str + c;
                }
            }
        }
        return str;
    }

    public static char Dictionaries(){
        return (char) (new Random().nextInt(122 - 97 + 1) + 97);
    }



    public static boolean Is_odd(char c,HashMap<Character,Integer> map){
        if (map.get(c) % 2 == 1) return false;
        return true;
    }


}

class New_char extends Thread{

    static int i = 1;

    @Override

    public synchronized void run() {

        while (i <= 100){

            System.out.println(i + ": " + Thread.currentThread().getName());

            i = i + 1;

        }
    }
}
