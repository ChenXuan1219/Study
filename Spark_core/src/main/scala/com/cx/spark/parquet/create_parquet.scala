package com.cx.spark.parquet

import org.apache.spark.sql._
import org.apache.spark._

object create_parquet {
  def main(args: Array[String]): Unit = {


    val session: SparkSession = SparkSession
      .builder()
      .config(new SparkConf().setMaster("local").setAppName("SparkSQL"))
      .getOrCreate()

    import session.implicits._
    session
      .read
      .format("csv")
      .option("header","true")
      .csv("Spark_core/src/main/scala/com/cx/spark/parquet/data.txt")
      .as[Per]
//      .write
//      .parquet("Spark_core/src/main/scala/com/cx/spark/parquet/data")
  }
  case class Per(distinct_id:String,user_tag_001:String)
}
