package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/04 14:14
 */
object Spark04_RDD_Operator_Transform_flatMap {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    val rdd = sc.makeRDD(List(List(1, 2), 5 ,List(3, 4)))



    val rdd1 = rdd.flatMap(
      data => {
        data match {
          case list: List[_] => list
          case data => List(data)
        }
      }
    )
    rdd1.collect().foreach(println)

    sc
      .makeRDD(List("hello cx","hello lyr"))
      .flatMap(s => s.split(" "))
      .collect().foreach(println)

    sc.stop()


  }

}
