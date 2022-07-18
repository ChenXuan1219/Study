package com.cx.spark.core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/12 16:22
 */
object Spark01_RDD_checkpoint {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Persist"))
    sc.setCheckpointDir("data")

    val rdd: RDD[(String, Int)] = sc.makeRDD(List("hello cx", "hello java", "hello scala"),2)
      .flatMap(_.split(" "))
      .map(word => {
        (word, 1)
      }
      )

    /**
     * checkpoint 需要落盘，需要指定检查点保存路径
     * job执行完后，不会被删除
     * 一般保存路径都是在分布式存储系统中：HDFS
     */

    rdd.checkpoint()

    rdd.reduceByKey(_ + _).collect().foreach(println)
    println("***************")
    rdd.groupByKey().collect().foreach(println)

  }
}
