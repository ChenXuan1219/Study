package com.cx.spark.sql

import org.apache.spark.{Aggregator, SparkConf}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction, UserDefinedFunction}
import org.apache.spark.sql.types.{DataType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/18 22:32
 */
class Spark03_SparkSQL_UDAF {
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

  /**
   * 自定义聚合函数类：计算年龄的平均值
   * 1.继承UserDefinedAggregateFunction类
   * 2.重写方法
   */
}
