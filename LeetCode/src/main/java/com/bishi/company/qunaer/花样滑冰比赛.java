package com.bishi.company.qunaer;

import java.util.Arrays;

public class 花样滑冰比赛 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,0,0,0,0,0,0,0},
                       {0,1,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,1,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,1,0,0,0,0,0,0,0,},
                       {0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,1,0,0,0},
                       {0,0,0,0,0,1,0,0,1,0,0}};
        System.out.println(maxScore(10,arr));
    }


    //10,[[1,1],[2,3],[3,5],[5,10],[7,9],[8,10]]

    public static int maxScore (int energy, int[][] actions) {
        // write code here
        int length = 0,count = 0 ;

        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < actions[0].length; j++) {
                if (actions[i][j] != 0){
                    count++;
                }
            }
        }

        int[] power = new int[count];
        int[] goal = new int[count];
        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < actions[0].length; j++) {
                if (actions[i][j] != 0){
                        goal[length] = i;
                        power[length] = j;
                        length = length + 1;
                }
            }
        }

        int[][] dp = new int[power.length+1][energy+1];
        for (int i = power[0]; i <= energy; i++) {
            dp[0][i] = goal[0];
        }

        for (int i = 1; i < power.length; i++) {
            for (int j = 0; j <= energy ; j++) {
                if (j < power[i]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i- 1][j - power[i]] + goal[i]);
                }
            }
        }

        return dp[power.length - 1][energy];
    }


}
