package com.cx.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/18 21:24
 */
object Spark02_UDF {

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("SparkSQL")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val df: DataFrame = spark.read.json("datas/user.json")

    df.createOrReplaceTempView("user")

    //自定义函数
    spark.udf.register("prefixName",(name:String)=>{
      "Name: " + name
    })

    spark.sql("select age,prefixName(username) from user").show()

    spark.close()
  }

}
