package com.cx.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Spark05_DataFrame {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("SparkSQL")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    spark.read.parquet("Spark_core/src/main/scala/com/cx/spark/parquet/data").show()

  }
}
