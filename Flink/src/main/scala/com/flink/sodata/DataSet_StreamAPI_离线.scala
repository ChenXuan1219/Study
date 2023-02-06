//package com.flink.sodata
//
//import org.apache.flink.api.scala.ExecutionEnvironment
//import org.apache.flink.api.scala._
//
//object DataSet_StreamAPI_离线 {
//
//  def main(args: Array[String]): Unit = {
//
//
//
//
//
//    val env = ExecutionEnvironment.getExecutionEnvironment // 从文件中读取数据
//    val inputPath = "Flink/src/main/scala/com/flink/sodata/data.txt"
//    val inputDS: DataSet[String] = env.readTextFile(inputPath)
//    inputDS.flatMap(_.split(" ")).map((_,1)).groupBy(0).sum(1).print()
//  }
//}
