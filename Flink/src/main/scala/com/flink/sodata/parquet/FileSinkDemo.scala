//package com.flink.sodata.parquet
//
//import org.apache.flink.api.common.serialization.SimpleStringEncoder
//import org.apache.flink.connector.file.sink.FileSink
//import org.apache.flink.core.fs.Path
//import org.apache.flink.runtime.state.filesystem.FsStateBackend
//import org.apache.flink.streaming.api.TimeCharacteristic
//import org.apache.flink.streaming.api.datastream.DataStreamSource
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
//import org.apache.flink.streaming.api.functions.sink.filesystem.OutputFileConfig
//import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.DateTimeBucketAssigner
//import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy
//
//import java.util.concurrent.TimeUnit
//
//
///**
// * Desc
// */
//object FileSinkDemo {
//  @throws[Exception]
//  def main(args: Array[String]): Unit = { //1.env
//    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
//    env.enableCheckpointing(TimeUnit.SECONDS.toMillis(10))
//    //env.setStateBackend(new FsStateBackend("Flink/src/main/scala/com/flink/sodata/parquet"))
//    //2.source
//    env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)
//    val lines: DataStreamSource[String] = env.socketTextStream("node1", 9999)
//    //3.sink
//    //设置sink的前缀和后缀
//    //文件的头和文件扩展名
//    //prefix-xxx-.txt
//
//    val config: OutputFileConfig = OutputFileConfig.builder.withPartPrefix("prefix").withPartSuffix(".txt").build
//    //设置sink的路径
//    val outputPath = "Flink/src/main/scala/com/flink/sodata/parquet"
//    val sink: FileSink[String] = FileSink
//      .forRowFormat(new Path(outputPath), new SimpleStringEncoder[String]("UTF-8"))
//      .withBucketAssigner(new DateTimeBucketAssigner[String])
//      .withRollingPolicy(
//        DefaultRollingPolicy.builder
//          .withRolloverInterval(TimeUnit.MINUTES.toMillis(15))
//          .withInactivityInterval(TimeUnit.MINUTES.toMillis(5))
//          .withMaxPartSize(1024 * 1024 * 1024)
//          .build)
//      .withOutputFileConfig(config)
//      .build
//    lines.sinkTo(sink).setParallelism(1)
//    env.execute
//  }
//}