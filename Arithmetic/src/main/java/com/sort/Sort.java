package com.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr1 = {12, 4, 16, 23, 9, 10};

        System.out.println("=========bubbleSort=========");
        System.out.println(Arrays.toString(bubbleSort(arr1)));

        int[] arr2 = {12, 4, 16, 23, 9, 10};

        System.out.println("=========selectionSort=========");
        System.out.println(Arrays.toString(selectionSort(arr2)));


        int[] arr3 = {12, 4, 16, 23, 9, 10};
        System.out.println("=========insertionSort=========");
        System.out.println(Arrays.toString(insertionSort(arr3)));

    }

    public static int[] bubbleSort(int[] arr){

        for (int j = 0; j < arr.length; j++) {
            boolean flag = true;
            for (int i = 0; i < arr.length - j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return arr;
    }



    public static int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }


    //  12, 4, 16, 23, 9, 10
    public static int[] insertionSort(int arr[]){

        return arr;

    }
}
