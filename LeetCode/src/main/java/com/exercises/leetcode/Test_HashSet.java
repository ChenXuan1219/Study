package com.exercises.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/09 15:47
 */
public class Test_HashSet {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("123");
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.capacity());


        StringBuilder builder = new StringBuilder("123").reverse();
        System.out.println(builder);




        HashSet<Object> hashSet = new HashSet<>();

        hashSet.add(1);

        boolean add = hashSet.add(2);


        System.out.println(hashSet);
    }
}
