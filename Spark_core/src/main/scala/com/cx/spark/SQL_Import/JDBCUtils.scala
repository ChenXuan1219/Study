package com.cx.spark.SQL_Import

import java.sql.{Connection, DriverManager, PreparedStatement}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/31 17:32
 */
object JDBCUtils {
  val user = "root"
  val password = "123456"
  val url = "jdbc:mysql://10.10.118.46:3306/test"
  Class.forName("com.mysql.jdbc.Driver")

  // 获取连接
  def getConnection() = {
    DriverManager.getConnection(url, user, password)
  }

  // 释放连接
  def closeConnection(connection: Connection, pstmt: PreparedStatement): Unit = {
    try {
      if (pstmt != null) {
        pstmt.close()
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (connection != null) {
        connection.close()
      }
    }
  }
}
