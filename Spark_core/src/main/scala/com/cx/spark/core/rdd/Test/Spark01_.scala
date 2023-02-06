package com.cx.spark.core.rdd.Test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/18 10:52
 */
object Spark01_ {
  def main(args: Array[String]): Unit = {

    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Test"))

    val actionRDD: RDD[String] = sc.textFile("datas/user_visit_action.txt")

    val clickActionRDD = actionRDD.filter(
      action => {
        val datas = action.split(" ")
        datas(6) != "-1"
      }
    )

    val clickCountRDD: RDD[(String, Int)] = clickActionRDD.map(
      action => {
        val datas: Array[String] = action.split(" ")
        (datas(6), 1)
      }
    ).reduceByKey(_ + _)

  }
}
