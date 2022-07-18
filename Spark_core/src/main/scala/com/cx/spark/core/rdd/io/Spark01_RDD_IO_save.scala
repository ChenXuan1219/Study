package com.cx.spark.core.rdd.io

import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/14 14:44
 */
object Spark01_RDD_IO_save {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("WordCount"))

    sc.makeRDD(
      List  (
      ("a",1),
      ("b",2),
      ("c",3)
    ))
    sc.stop()
  }
}
