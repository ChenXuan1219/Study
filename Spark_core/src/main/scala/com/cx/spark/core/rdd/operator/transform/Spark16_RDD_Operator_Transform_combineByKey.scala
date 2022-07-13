package com.cx.spark.core.rdd.operator.transform

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
object Spark16_RDD_Operator_Transform_combineByKey {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - foldByKey
     *  分区间和分区内计算规则相同
     *    第一个参数表示：将相同key的前一个数据进行结构转化，实现操作
     *    第二个参数表示：分区内的计算规则
     *    第三个参数表示：分区间的计算规则
     */





 
    sc.stop()


  }

}
