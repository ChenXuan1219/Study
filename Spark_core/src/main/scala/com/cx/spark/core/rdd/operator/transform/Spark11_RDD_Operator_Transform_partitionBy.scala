package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
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
object Spark11_RDD_Operator_Transform_partitionBy {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - key-value类型
     *
     *    重分区
     */


    val rdd = sc.makeRDD(List(1,2,3,4),2)

    rdd.map((_,1)).partitionBy(new HashPartitioner(3)).saveAsTextFile("Spark_core/src/main/scala/com/cx/spark/core/rdd/operator/transform/data")


    sc.stop()


  }

}
