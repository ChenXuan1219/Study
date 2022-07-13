package com.cx.spark.core.rdd.serial

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/07 17:59
 */
object Spark01_RDD_serial_持久化 {
  def main(args: Array[String]): Unit = {

    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Serial"))

    val rdd: RDD[String] = sc.makeRDD(Array("hello cx", "hello java", "hello spark"))

    val search: Search = new Search("cx")

    search.getMatch1(rdd).collect().foreach(println)

    sc.stop()

  }

  case class Search(query:String){

    def isMatch(s: String): Boolean = {
      s.contains(query)
    }

    def getMatch1(rdd: RDD[String]): RDD[String] = {
      rdd.filter(isMatch)
    }

    def getMatch2(rdd: RDD[String]): RDD[String] = {
      rdd.filter(x => x.contains(query))
    }
  }
}
