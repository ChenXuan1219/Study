package com.cx.spark.core.rdd.operator.transform

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
object Spark07_RDD_Operator_Transform_sample {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - sample
     *   根据指定的规则从数据集中抽取数据
     *   3个参数
     *
     *   第一个表示抽取数据后，是否将数据放回true，丢弃false
     *
     *   第二个表示数据源中每条数据被抽取的概率
     *                如果抽取不放回的场合，数据源中每条数据被抽取的概率，
     *                如果抽取放回的场合，表示数据源中的每条数据被抽取的可能次数
     *
     *   第三个表示，抽取数据时随机算法的种子
     *
     *
     *   可以用于数据倾斜
     *
     */


    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    println(rdd.sample(
      true,
      0.8,
      5
    ).collect().mkString(","))

    sc.stop()


  }

}
