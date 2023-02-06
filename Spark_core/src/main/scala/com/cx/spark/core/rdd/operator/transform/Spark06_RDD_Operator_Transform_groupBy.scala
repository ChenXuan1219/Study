package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/04 15:05
 */

/**
 * 将同一个分区的数据直接转化为相同类型的内存数据进行处理。分区不变
 */
object Spark06_RDD_Operator_Transform_groupBy {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     * TODO算子 - filter
     */

    sc.makeRDD(List(1,2,3,4,5,6,7)).groupBy(_ % 2).collect().foreach(println)
    println("===========")

    sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"),2).saveAsTextFile("Spark_core/src/main/scala/com/cx/spark/core/rdd/operator/transform/data1")
    sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop","abc"),2).groupBy(_.charAt(0) != 'a').saveAsTextFile("Spark_core/src/main/scala/com/cx/spark/core/rdd/operator/transform/data2")


    sc.stop()


  }
}

