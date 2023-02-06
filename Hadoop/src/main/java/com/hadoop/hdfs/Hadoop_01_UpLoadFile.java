package com.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/29 17:24
 */
public class Hadoop_01_UpLoadFile {
    public static void main(String[] args) throws Exception {
        // 1 获取文件系统
        Configuration configuration = new Configuration();

        // FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:8020"), configuration);
        FileSystem fs = FileSystem.get(new URI("hdfs://150.158.173.202:9000"), configuration,"pinkman");

        // 2 创建目录
        fs.mkdirs(new Path("/pinkMan_Test01"));


        // 3 关闭资源
        fs.close();

    }
}
