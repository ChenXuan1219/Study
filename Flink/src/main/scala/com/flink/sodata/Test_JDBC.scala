//package com.flink.sodata
//
//import com.flink.sodata.Test_JDBC.SensorReading
//import org.apache.flink.configuration.Configuration
//import org.apache.flink.streaming.api.functions.sink.{RichSinkFunction, SinkFunction}
//
//import java.sql.{Connection, DriverManager, PreparedStatement}
//
//object Test_JDBC{
//  case class SensorReading(user_id: String, action: String, time: String,item_id:String,item_name:String,item_cate:String)
//  def main(args: Array[String]): Unit = {
//
//  }
//}
//
//class MyJDBCSink() extends RichSinkFunction[SensorReading]{
//  var conn:Connection = _
//  var insertStmt:PreparedStatement = _
//  var updateStmt: PreparedStatement = _
//
//  override def open(parameters: Configuration): Unit = {
//
//    super.open(parameters)
//
//    conn = DriverManager.getConnection("jdbc:mysql://10.120.42.76:3305/test","root","hknDFqa9vz")
//
//    conn.prepareStatement("select * from event_test")
//  }
//
//  override def invoke(value: SensorReading, context: SinkFunction.Context): Unit = {
//
//    updateStmt.setString(1, value.user_id)
//    updateStmt.setString(2, value.action)
//    updateStmt.setString(3, value.time)
//    updateStmt.setString(4, value.item_id)
//    updateStmt.setString(5, value.item_name)
//    updateStmt.setString(6, value.item_cate)
//
//    updateStmt.execute()
//    }
//  if(updateStmt.getUpdateCount == 0){
//
//  }
//}
