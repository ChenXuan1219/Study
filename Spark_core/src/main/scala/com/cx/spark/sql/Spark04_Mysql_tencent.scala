package com.cx.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/29 16:19
 */
object Spark04_Mysql_tencent {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("SparkSQL")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    val df =spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://150.158.173.202:3306/pinkman_test01")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "root")
      .option("dbtable", "runoob_tbl")
      .load()


    df.write
      .format("jdbc")
      .option("url", "jdbc:mysql://150.158.173.202:3306/pinkman_test01")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "root")
      .mode(SaveMode.ErrorIfExists)
      .option("dbtable", "runoob_tbl001")
      .save()

  }
}
