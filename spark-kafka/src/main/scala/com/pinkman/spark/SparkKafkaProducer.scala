package com.pinkman.spark

import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

import java.util.Properties

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/01 15:33
 */
object SparkKafkaProducer {
  def main(args: Array[String]): Unit = {

    val properties: Properties = new Properties()
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092")
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,classOf[StringSerializer])
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,classOf[StringSerializer])


    //1 创建生产者

    val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)

    //2 发送数据

    for (i <- 1 to  5){
      producer.send(new ProducerRecord[String,String]("first","pinkMan" + i))
    }

    //3 关闭资源
    producer.close()

  }
}
