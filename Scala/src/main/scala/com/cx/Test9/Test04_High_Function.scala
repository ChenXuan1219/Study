package com.cx.Test9

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/08 11:49
 */
object Test04_High_Function {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val wordList: List[String] = List("hello world", "hello cx", "hello scala")
    //1.过滤
    println(list.filter(x => x % 2 == 0))
    //2.转化/映射
    //3.扁平化
    //4.扁平化+映射
    //5.分组
    //6.简约
    //7.折叠
  }
}
