package Test2

import scala.io.StdIn

object Test05_StdIn {
  def main(args: Array[String]): Unit = {
    println("请输入名字")
    val name: String = StdIn.readLine()
    println(name)
  }

}
