package com.hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 * KEYIN : Text
 * VALUEIN : IntWritable
 * KEYOUT : Text
 * VALUEOUT : IntWritable
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/15 15:51
 */
public class ReduceWC extends Reducer<Text, IntWritable,Text,IntWritable> {
    private IntWritable intWritable = new IntWritable();

    /**
     * reduce :ReduceTask进程对每一组相同k的，<k,v>组调用一次reduce()方法
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (IntWritable value : values) {
            System.out.println(value);
            sum += value.get();

        }

        intWritable.set(sum);

        context.write(key,intWritable );
    }
}
