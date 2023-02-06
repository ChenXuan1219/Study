package com.cx.kafka.producer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/26 11:30
 */
public class CustomProducerSync {
    public static void main(String[] args) throws Exception{

        //配置
        Properties properties = new Properties();

        //连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092");

        //指定对应key和value的序列化类型
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //1.创建kafka生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        //2.发送数据

        kafkaProducer.send(new ProducerRecord<>("first", "Callback")).get();



        //3.关闭资源
        kafkaProducer.close();
    }
}

