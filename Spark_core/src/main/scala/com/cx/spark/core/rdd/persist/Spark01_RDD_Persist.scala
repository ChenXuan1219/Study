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
object Spark01_RDD_Persist {
  def main(args: Array[String]): Unit = {
    val rdd: RDD[(String, Int)] = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Persist"))
      .makeRDD(List("hello cx", "hello java", "hello scala"))
      .flatMap(_.split(" "))
      .map(word => {
        println("*****")
        (word, 1)
      }
      )

    /**
     * 默认保存内存
     * 放在JVM堆内存中，需要触发action后，rdd才会被缓存在计算节点内存中
     * 如果需要保存到磁盘中，需要更改存储级别(StorageLevel.DISK_ONLY)
     */
    rdd.cache()
    rdd.persist(StorageLevel.DISK_ONLY)

    rdd.reduceByKey(_ + _).collect().foreach(println)

    rdd.groupByKey().collect().foreach(println)

  }
}
