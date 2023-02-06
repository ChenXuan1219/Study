 package com.cx.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 *
 * @since 2022/07/26 15:51
 */
public class CustomProduceParameters {
    public static void main(String[] args) {

        Properties properties = new Properties();

        //连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "master:9092");

        //指定对应key和value的序列化类型
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //缓冲区大小
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        
        //批次大小
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        
        //linger.ms
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        
        //压缩
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        
        //创建生产者
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String,String>(properties);

        //发送数据
        for (int i = 0; i < 10; i++) {
            kafkaProducer.send(new ProducerRecord<>("first", "cx"+i));
        }

        //关闭资源
        kafkaProducer.close();

    }
}
