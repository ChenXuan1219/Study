//package com.cx.spark.SQL_Import
//
//import org.apache.spark.SparkConf
//import org.apache.spark.sql.{DataFrame, SparkSession}
//import org.apache.spark.storage.StorageLevel
//
//import java.sql.{Connection, PreparedStatement}
//import java.util.Properties
//import scala.collection.mutable.ListBuffer
//
//
//
///**
// * TODO
// *
// * @author chenxuan
// * @version 1.0.0
// * @since 2022/08/31 17:25
// */
//object Batch {
//  case class Person(name: String, age: Int)
//  def main(args: Array[String]): Unit = {
//
//    // 创建sparkSession对象
//    val conf = new SparkConf()
//      .setAppName("BatchInsertMySQL")
//    val spark: SparkSession =  SparkSession.builder()
//      .config(conf)
//      .getOrCreate()
//    import spark.implicits._
//    // MySQL连接参数
//    val url = JDBCUtils.url
//    val user = JDBCUtils.user
//    val pwd = JDBCUtils.password
//
//    // 创建Properties对象，设置连接mysql的用户名和密码
//    val properties: Properties = new Properties()
//
//    properties.setProperty("user", user) // 用户名
//    properties.setProperty("password", pwd) // 密码
//    properties.setProperty("driver", "com.mysql.jdbc.Driver")
//    properties.setProperty("numPartitions","10")
//
//    // 读取mysql中的表数据
//    val testDF: DataFrame = spark.read.jdbc(url, "test", properties)
//    println("testDF的分区数：  " + testDF.rdd.partitions.size)
//    testDF.createOrReplaceTempView("test")
//    testDF.persist(StorageLevel.MEMORY_AND_DISK)
//    testDF.printSchema()
//
//    val result =
//      s"""-- SQL代码
//               """.stripMargin
//
//    val resultBatch = spark.sql(result).as[Person]
//    println("resultBatch的分区数： " + resultBatch.rdd.partitions.size)
//
//    // 批量写入MySQL
//    // 此处最好对处理的结果进行一次重分区
//    // 由于数据量特别大，会造成每个分区数据特别多
//    resultBatch.repartition(500).foreachPartition(record => {
//
//      val list = new ListBuffer[Person]
//      record.foreach(person => {
//        val name = Person.name
//        val age = Person.age
//        list.append(Person(name,age))
//      })
//      upsertDateMatch(list) //执行批量插入数据
//    })
//    // 批量插入MySQL的方法
//    def upsertPerson(list: ListBuffer[Person]): Unit = {
//
//      var connect: Connection = null
//      var pstmt: PreparedStatement = null
//
//      try {
//        connect = JDBCUtils.getConnection()
//        // 禁用自动提交
//        connect.setAutoCommit(false)
//
//        val sql = "REPLACE INTO `person`(name, age)" +
//          " VALUES(?, ?)"
//
//        pstmt = connect.prepareStatement(sql)
//
//        var batchIndex = 0
//        for (person <- list) {
//          pstmt.setString(1, person.name)
//          pstmt.setString(2, person.age)
//          // 加入批次
//          pstmt.addBatch()
//          batchIndex +=1
//          // 控制提交的数量,
//          // MySQL的批量写入尽量限制提交批次的数据量，否则会把MySQL写挂！！！
//          if(batchIndex % 1000 == 0 && batchIndex !=0){
//            pstmt.executeBatch()
//            pstmt.clearBatch()
//          }
//
//        }
//        // 提交批次
//        pstmt.executeBatch()
//        connect.commit()
//      } catch {
//        case e: Exception =>
//          e.printStackTrace()
//      } finally {
//        JDBCUtils.closeConnection(connect, pstmt)
//      }
//    }
//
//    spark.close()
//  }
//}
//
//
//
