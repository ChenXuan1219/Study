package com.exercises.leetcode;

import java.util.ArrayList;

public class convert_6 {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        ArrayList<StringBuilder> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(new StringBuilder());
        }

        int i = 0,flag = -1;
        for (char c : s.toCharArray()){
            row.get(i).append(c);
            if (i == 0 || i == numRows - 1)flag = - flag;
            i += flag;
        }

        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : row) {
            builder.append(stringBuilder);
        }

        return builder.toString();

    }
}
