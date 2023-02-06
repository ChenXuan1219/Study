//package com.flink.sodata
//
//import org.apache.flink.api.java.utils.ParameterTool
//import org.apache.flink.api.scala.{ExecutionEnvironment, _}
//import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
//
//object DataSet_StreamAPI_实时 {
//  def main(args: Array[String]): Unit = {
//
//
//    // 创建流处理环境
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    // 接收 socket 文本流
//    val textDstream: DataStream[String] = env.socketTextStream("localhost", 7777)
//
//    import org.apache.flink.api.scala._
//    val dataStream: DataStream[(String, Int)] = textDstream.flatMap(_.split(" ")).filter(_.nonEmpty).map((_, 1)).keyBy(0).sum(1)
//    dataStream.print().setParallelism(1)
//    env.execute("Socket stream word count")
//  }
//}
