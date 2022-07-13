package com.cx.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/07 15:33
 */
object Spark03_RDD_Operator_Action_count_first {
  def main(args: Array[String]): Unit = {
    /**
     * 行动算子：出发作业执行的方法
     * 底层调用的是runJob方法
     */
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Action"))

    /**
     * count
     * 数据源中数据的个数
     */
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))

    println(rdd.count())

    /**
     * first：获取数据源中第一个数据
     */
    println(rdd.first())

    /**
     * take：获取前n个数据
     */

    println(rdd.take(3).mkString(","))


    /**
     * takeOrdered:数据排序后，取N个数据
     */

    println(sc.makeRDD(List(3, 4, 1, 2)).takeOrdered(3).mkString(","))



    sc.stop()


  }

}
