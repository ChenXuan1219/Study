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
 * 将同一个分区的数据直接转化为相同类型的内存数组进行处理。分区不变
 */


/**
 * 计算所以分区最大值求和,（分区内取最大值，分区间最大值求和）
 */
object Spark05_RDD_Operator_Transform_glom_Test {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - glom
     */

    val sum = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8), 3)
      .glom()
      .map(array => {
        array.max
      })
      .collect().sum

    println(sum)

    sc.stop()


  }

}
