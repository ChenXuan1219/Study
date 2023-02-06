package com.bishi.company;

import java.util.HashMap;
import java.util.Scanner;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/09/01 19:26
 */
public class bilibili {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(solution(num));
    }

    public static int solution(int num ){
        if (isPrime(num)) return num;
        int sum = 0;
        int index = 2;
        double sqrt=Math.sqrt(num);
        while (true)
        {
            if (index > sqrt)
                break;
            if (num % index ==0)
            {
                sum += index;
                num /= index;
                sqrt = Math.sqrt(num);
            }
            else
                index++;
        }
        return sum+num;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <num ; i++) {
            if (num % i == 0) {

                return false;
            }
        }

        return true;
    }


}

