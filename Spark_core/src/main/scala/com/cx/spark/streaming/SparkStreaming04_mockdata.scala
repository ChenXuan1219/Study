package com.cx.spark.streaming

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import java.util.Properties
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 21:53
 */
object SparkStreaming04_mockdata {

  def main(args: Array[String]): Unit = {

    //生成模拟数据
    //格式：timestamp area city userid adid
    //含义：时间戳     区域  城市 用户    广告
    // 创建配置对象
    val prop = new Properties()
    // 添加配置
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "47.100.170.101")
    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  //  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](prop)
    //Application =》 Kafka =》 SparkStreaming =》 Analysis
    while (true) {

      mockdata().foreach(
        data => {
          //向kafka生成数据
          //val record = new ProducerRecord[String,String]("PinkMan",data)
          //producer.send(record)
          println(data)
        }
      )

      Thread.sleep(2000)



    }
  }

  def mockdata() ={

    val list = ListBuffer[String]()
    val arealist = ListBuffer[String]("华东","华南","华北")
    val citylist = ListBuffer[String]("北京","上海","深圳")

    for (i <- 1 to 30) {
      val area = arealist(new Random().nextInt(3))
      val city = arealist(new Random().nextInt(3))
      val userid = new Random().nextInt(3)
      val adid = new Random().nextInt(3)
      list.append(s"${System.currentTimeMillis()} ${area} ${citylist} ${adid}")
    }
    list
  }
}
