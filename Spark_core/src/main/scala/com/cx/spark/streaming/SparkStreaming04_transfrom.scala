package com.cx.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 21:53
 */
object SparkStreaming04_transfrom {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")

    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //将底层的rdd获取到进行操作
    val newDS1: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

    val newDS2: DStream[String] = newDS1.transform(rdd => rdd)

    //启动采集器
    ssc.start()

    //等待采集器的关闭
    ssc.awaitTermination()


  }

}
