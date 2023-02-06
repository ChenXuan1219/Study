package com.hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * TODO
 * KEYIN ： map阶段输入key的类型：LongWritable  偏移量（对应java得Long）
 * VALUEIN ：map阶段输入value类型 ： Text 那一行的内容
 * KEYOUT  ：输出的key类型，单词为Text类型
 * VALUEOUT ： value类型： 单词个数
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/15 13:54
 */
public class MapperWC extends Mapper<LongWritable,Text,Text,IntWritable>{
    /**
     *
     * @param key
     * @param value
     * @param context :存储通用信息
     * @throws IOException
     * @throws InterruptedException
     */
    private Text text = new Text();
    private IntWritable intWritable = new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        String[] s = value.toString().split(" ");
        for (String word : s) {
            text.set(word);

            context.write(text, intWritable);
        }
    }
}
