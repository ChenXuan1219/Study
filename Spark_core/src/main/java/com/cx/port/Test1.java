package com.cx.port;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/29 10:54
 */
public class Test1 {
    public static void main(String[] args) {






        int[] arr = new int[]{6,2,1,0,0,0,1,0,0,0};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("     ");

        int[] arr2 = solve(arr);

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
    
    public static int[] solve(int[] arr){


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i],1);
            }
        }
        int[] ints = new int[hashMap.size()];

        for (int i = 0; i < arr.length; i++) {
           ints[i] = hashMap.get(arr[i]);
        }

        return ints;
    }
}
