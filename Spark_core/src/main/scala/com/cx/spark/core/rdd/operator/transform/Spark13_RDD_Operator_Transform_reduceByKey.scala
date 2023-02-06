package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
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
object Spark13_RDD_Operator_Transform_reduceByKey {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - educeByKey
     *
     *    相同的key的数据进行value数据的聚合操作
     */

    val rdd = sc.makeRDD(List(
      ("a",2),
      ("b",1),
      ("c",1),
      ("d",1),
      ("a",3),
      ("b",1),
      ("c",1),
      ("d",1)),2)

    //rdd.saveAsTextFile("Spark_core/src/main/scala/com/cx/spark/core/rdd/operator/transform/data1")
    //rdd.reduceByKey(_ + _).saveAsTextFile("Spark_core/src/main/scala/com/cx/spark/core/rdd/operator/transform/data2")

   println("_________")

    //sc.makeRDD(List(("a","a"),("b","b"),("c","c"),("d","d"),("a","a"),("b","b"),("c","c"),("d","d")),2).saveAsTextFile("o1")
    //rdd.reduceByKey((x:Int,y:Int) => {x + y}).collect().foreach(println)


    sc.stop()


  }

}
