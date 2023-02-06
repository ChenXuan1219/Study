package com.exercises.dfs;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/25 10:41
 */
public class 岛屿的最大面积 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().filter(data -> data != 2).forEach(System.out::println);




    }


}
