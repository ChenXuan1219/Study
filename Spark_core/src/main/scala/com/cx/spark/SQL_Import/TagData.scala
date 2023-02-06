package com.cx.spark.SQL_Import

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}


case class Stu(distinct_id: String, user_tag_isMan: String)
object TagData {
  def main(args: Array[String]): Unit = {
    // 创建sparkSession对象

    val rdd: RDD[String] = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("test")).makeRDD(List("20220922", "true"))

    rdd.collect().foreach(print)


  }
}
