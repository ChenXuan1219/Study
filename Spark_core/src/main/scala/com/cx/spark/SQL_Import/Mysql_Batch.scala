package com.cx.spark.SQL_Import

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

import java.util.Properties

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/31 17:39
 */
object Mysql_Batch {
  def main(args: Array[String]): Unit = {

    // 创建sparkSession对象
    val conf = new SparkConf()
      .setAppName("BatchInsertMySQL")
      .setMaster("local[*]")
    val spark: SparkSession =  SparkSession.builder()
      .config(conf)
      .getOrCreate()
    import spark.implicits._
    // MySQL连接参数
    val url = JDBCUtils.url
    val user = JDBCUtils.user
    val pwd = JDBCUtils.password

    // 创建Properties对象，设置连接mysql的用户名和密码
    val properties: Properties = new Properties()

    properties.setProperty("user", user) // 用户名
    properties.setProperty("password", pwd) //
    properties.setProperty("driver", "com.mysql.jdbc.Driver")
    properties.setProperty("numPartitions","10")


    val dataFrame: DataFrame = spark.read.jdbc(url, "bookmark", properties)


    //val ds: Dataset[bookmark] = dataFrame.as[bookmark]






  }
  case class bookmark(id:Int,user_id:Int,data:String,is_widget:Boolean,time:String,update_time:String)
}
