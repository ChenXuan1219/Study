package com.cx.spark.core.rdd.io;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/14 17:16
 */
public class Test {
    public static void main(String[] args) {
        //15
        double before_count = 297.8d;
        double before_credit = 150;
        double before_gpa = before_count / before_credit;

        double count = 350.5;
        int credit = 167;
        double gpa = count / credit;

        double differ_gpa = gpa - before_gpa;

        double arrive_15_gpa = (before_gpa * 0.15 + before_gpa);

        int differ_15 = (int)((arrive_15_gpa - gpa) * credit);



        System.out.println("大四上gpa: " + before_gpa);
        System.out.println("毕业时gpa: " + gpa);
        System.out.println("差了: "+ differ_gpa + " 的gpa");
        System.out.println("还要： "+differ_15+" 分");











    }
}
