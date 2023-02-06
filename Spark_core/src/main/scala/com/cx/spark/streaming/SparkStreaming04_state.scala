package com.cx.spark.streaming

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 21:53
 */
object SparkStreaming04_state {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")

    val ssc = new StreamingContext(sparkConf,Seconds(3))

    ssc.checkpoint("cp")

    val state: DStream[(String, Int)] = ssc.socketTextStream("10.120.173.20", 9999).map((_,1)).updateStateByKey((seq: Seq[Int], buffer: Option[Int]) => {
      val newCount = buffer.getOrElse(0) + seq.sum
      Option(newCount)
    })

    state.print()



    //启动采集器
    ssc.start()

    //等待采集器的关闭
    ssc.awaitTermination()


  }

}
