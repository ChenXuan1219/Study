package com.cx.spark.core.temporary

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/04 15:05
 */

/**
 * 将同一个分区的数据直接转化为相同类型的内存数据进行处理。分区不变
 */
object Spark12_RDD_Operator_Transform_交集_并集_差集_拉链 {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子
     *    交集  intersection
     *    并集  union
     *    差集  subtract
     *    数据源的数据类型要一样
     *
     *
     *    拉链  zip
     *    数据可以不一致
     *
     *
     *
     */


    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
    val rdd2: RDD[Int] = sc.makeRDD(List(3, 4, 5, 6))

    //交集
    println(rdd1.intersection(rdd2).collect().mkString(","))

    //并集
    println(rdd1.union(rdd2).collect().mkString(","))

    //差集
    println(rdd1.subtract(rdd2).collect().mkString(","))

    //拉链
    println(rdd1.zip(rdd2).collect().mkString(","))

    sc.stop()

  }

}
