package com.cx.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 15:32
 */
object SparkStreaming01_WordCount {
  def main(args: Array[String]): Unit = {

    //创建环境对象
    //StreamingContext:创建时需要传递两个参数
    //第一个参数表示环境配置
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    //第二个参数表示批处理的周期（采集周期）
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //etl
    //获取端口数据
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("47.100.170.101",9999)

    val words: DStream[(String, Int)] = lines.flatMap(_.split(" ")).map((_, 1))

    val wc: DStream[(String, Int)] = words.reduceByKey(_ + _)

    wc.print()

    //启动采集器
    ssc.start()
    //关闭
    //ssc.stop()

    //等待采集器的关闭
    ssc.awaitTermination()

  }
}
