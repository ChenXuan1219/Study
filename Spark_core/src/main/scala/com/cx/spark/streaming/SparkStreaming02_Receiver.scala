package com.cx.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Random

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 15:32
 */
object SparkStreaming02_Receiver {
  def main(args: Array[String]): Unit = {

    //创建环境对象
    //StreamingContext:创建时需要传递两个参数
    //第一个参数表示环境配置
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    //第二个参数表示批处理的周期（采集周期）
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //etl
    val messageDS: ReceiverInputDStream[String] = ssc.receiverStream(new MyReceiver())

    messageDS.print()


    //启动采集器
    ssc.start()

    //等待采集器的关闭
    ssc.awaitTermination()

  }

  class MyReceiver extends Receiver[String](StorageLevel.MEMORY_ONLY){
    private var flag = true
    override def onStart(): Unit = {

      new Thread(new Runnable {
        override def run(): Unit = {
          while (flag) {
            val message = "采集的数据为" + new Random().nextInt(10).toString
            store(message)
            Thread.sleep(500)
          }
        }
      }).start()

    }

    override def onStop(): Unit = {

      flag = false

    }
  }
}
