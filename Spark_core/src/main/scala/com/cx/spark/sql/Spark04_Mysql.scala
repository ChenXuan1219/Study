package com.cx.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, SaveMode, SparkSession}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/29 16:19
 */
object Spark04_Mysql {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("SparkSQL")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import spark.implicits._
    val dataFrame: DataFrame = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://10.120.42.76:3305/metadata")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "work")
      .option("password", "hknDFqa9vz")
      .option("dbtable", "bookmark")
      .load()

    dataFrame.printSchema()


    dataFrame.createTempView("test")

    val frame: DataFrame = spark.sql("select * from test limit 1")

    frame.write
      .format("jdbc")
      .option("url", "jdbc:mysql://10.120.42.76:3305/metadata")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "work")
      .option("password", "hknDFqa9vz")
      .mode(SaveMode.ErrorIfExists)
      .option("dbtable", "bookmark002")
      .save()
  }
}
