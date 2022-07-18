package com.cx.spark.core.rdd.part

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/14 14:20
 */
object Spark01_RDD_part{
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("WordCount"))

    val rdd: RDD[(String, String)] = sc.makeRDD(List(
      ("nba", "xxxxx"),
      ("cba", "xxxxx"),
      ("nbl", "xxxxx")
    ),3)
    val partRDD: RDD[(String, String)] = rdd.partitionBy(new MyPartitioner)

    partRDD.saveAsTextFile("output")

    sc.stop()
  }

  class MyPartitioner extends Partitioner {
    //分区数量
    override def numPartitions: Int = 3

    //根据数据的key值返回所在的分区索引（从0开始）
    override def getPartition(key: Any): Int = {
      key match {
        case "nba" => 0
        case "cba" => 1
        case _ => 2
      }
    }

  }
}
