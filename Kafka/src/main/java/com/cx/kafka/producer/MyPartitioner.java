package com.cx.kafka.producer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/26 15:10
 */
public class MyPartitioner implements Partitioner{
    @Override
    public int partition(String topic, Object key, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {

        //获取数据
        String msgValues = value.toString();

        int partition;

        if (msgValues.contains("cx")){
            partition = 1;
        } else {
            partition = 0;
        }


        return partition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
