package com.cx.spark.core.temporary

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
object Spark07_RDD_Operator_Transform_filter {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - groupBy
     *   会将数据源中的每一个数据进行分组判断，根据返回的分组key进行分组
     *   相同的key值数据会放置在一个组中
     *
     *   打乱原来分区
     *   一个组的数据在一个分区中，但一个区中不一定只有只有一个组
     */

    sc.makeRDD(List(1,2,3,4)).filter(num => num % 2 != 0).collect().foreach(println)



    sc.stop()


  }

}
