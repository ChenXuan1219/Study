//package com.flink.sodata
//
//
//import com.flink.sodata.Test_Environment.SensorReading
//import org.apache.flink.streaming.api.functions.source.SourceFunction
//import org.apache.flink.streaming.api.scala._
//
//import scala.util.Random
//
//object Test_Environment {
//  case class SensorReading(str: String, i: Long, d: Double)
//  def main(args: Array[String]): Unit = {
//
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//
//    val stream1 = env.fromCollection(
//      List(
//        SensorReading("sensor_1", 1547718199, 35.8),
//        SensorReading("sensor_6", 1547718201, 15.4),
//        SensorReading("sensor_7", 1547718202, 6.7),
//        SensorReading("sensor_10", 1547718205, 38.1) ))
//
//    //stream1.print("stream1:").setParallelism(5)
//
//    val value: DataStream[String] = env.readTextFile("Flink/src/main/scala/com/flink/sodata/tagdata")
//
//    //value.print("stream2").setParallelism(1)
//
//
//    env.addSource(new MySensorSource).print()
//
//
//
//
//    env.execute()
//
//  }
//}
//
//class MySensorSource extends SourceFunction[SensorReading]{
//  var running:Boolean = true
//
//  override def cancel(): Unit = {
//    running = false
//  }
//
//  override def run(sourceContext: SourceFunction.SourceContext[SensorReading]): Unit = {
//    val rand = new Random()
//
//    var curTemp = 1.to(10).map(
//      i => ("sensor_" + i,65 + rand.nextGaussian() * 20)
//
//    )
//
//    while (running){
//      curTemp = curTemp.map(
//        t => (t._1,t._2 + rand.nextGaussian())
//      )
//      val curTime = System.currentTimeMillis()
//      curTemp.foreach(
//        t => sourceContext.collect(SensorReading(t._1,curTime,t._2))
//      )
//      Thread.sleep(100)
//    }
//  }
//}