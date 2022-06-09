package com.cx.Test9

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/08 10:15
 */
object Test01_ToList {
  def main(args: Array[String]): Unit = {
    //获取集合长度
    //获取集合大小
    //循环遍历
    //迭代器
    //生成字符串
    //是否包含

    val list: List[Int] = List(0,1,2,3)

    println(list.length)
    println(list.size)
    list.foreach(println)
    for (elem <- list) print(elem+" ")
    println(list.contains(0))



  }
}
