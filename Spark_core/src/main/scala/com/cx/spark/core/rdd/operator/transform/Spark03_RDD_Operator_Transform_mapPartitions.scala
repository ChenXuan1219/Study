package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/16 17:36
 */
object Spark03_RDD_Operator_Transform_mapPartitions {
  def main(args: Array[String]): Unit = {

    val rdd: RDD[Int] = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("cx"))
      .makeRDD(List(1, 2, 3, 4, 5,6,7,8),2)


    rdd.mapPartitions(data => {
      data.map(_*2)
    })

    rdd.mapPartitionsWithIndex(
      (index , data ) => {
        data.map(num => (index, num))
      }
    ).collect().foreach(println)

  }
}
