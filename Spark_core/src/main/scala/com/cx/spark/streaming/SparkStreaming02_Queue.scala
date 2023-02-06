package com.cx.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 15:32
 */
object SparkStreaming02_Queue {
  def main(args: Array[String]): Unit = {

    //创建环境对象
    //StreamingContext:创建时需要传递两个参数
    //第一个参数表示环境配置
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    //第二个参数表示批处理的周期（采集周期）
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //etl
    //获取端口数据

    val rddQueue: mutable.Queue[RDD[Int]] = new mutable.Queue[RDD[Int]]()

    val inputStream: InputDStream[Int] = ssc.queueStream(rddQueue, oneAtATime = false)

    inputStream.map((_,1)).reduceByKey(_ + _).print()



    //启动采集器
    ssc.start()

    for (i <- 1 to 5) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 300,10)
      Thread.sleep(2000)
    }


    //等待采集器的关闭
    ssc.awaitTermination()

  }
}
